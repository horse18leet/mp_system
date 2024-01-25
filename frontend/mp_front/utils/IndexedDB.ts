import { openDB } from "idb";

export async function createTable(dbName: string, dbVersion: number, tableName: string, fields: string[]) {
  
    const request = await openDB(dbName, dbVersion, {
      upgrade(db) {
        const store = db.createObjectStore(tableName, { keyPath: "id" });
        fields.forEach((field) => {
          store.createIndex(field, field, { unique: false });
        });
      },
    });
  
    if (request) {
      console.log(`Таблица ${tableName} успешно создана`);
    }
}

export async function saveDataToTable(dbName: string, tableName: string, data: Record<string, any>) {
    const db = await openDB(dbName);
    const transaction = db.transaction(tableName, "readwrite");
    const store = transaction.objectStore(tableName);
  
    const request = store.add(data);
  
    const result = await request;
    if (result) {
        console.log(`Данные успешно добавлены в таблицу ${tableName}`);
    }
}
  
