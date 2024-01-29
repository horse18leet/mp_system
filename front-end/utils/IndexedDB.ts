import { openDB } from "idb";

export async function createTable(dbName: string, dbVersion: number, storeName: string, fields: string[]) {
  const request = await openDB(dbName, dbVersion, {
    upgrade(db) {
        if (!db.objectStoreNames.contains(storeName)) {
            const store = db.createObjectStore(storeName, { keyPath: "id" });
            fields.forEach((field) => {
              store.createIndex(field, field, { unique: false });
            });
        }
        else {
          console.log("такая таблица уже существует");
        }
    },
  });

  if (request) {
    console.log(`Таблица ${storeName} успешно создана`);
  }
}

export async function saveDataToTable(dbName: string, storeName: string, data: { firstName: string, lastName: string, email: string }, key: string) {
  const db = await openDB(dbName);
  const transaction = db.transaction(storeName, "readwrite");
  const store = transaction.objectStore(storeName);

  const request = store.add({ user: { firstName: data.firstName, lastName: data.lastName, email: data.email }, id: key });

  const result = await request;
  if (result) {
    console.log(`Данные успешно добавлены в таблицу ${storeName}`);
  }
  else {
    console.log("Не удалось добавить данные в таблицу");
  }
}

export async function getDataFromDB(dbName: string, storeName: string, key: string) {
  const db = await openDB(dbName);
  const transaction = db.transaction(storeName);
  const store = transaction.objectStore(storeName);

  const index = await store.get(key);
  return index;
}