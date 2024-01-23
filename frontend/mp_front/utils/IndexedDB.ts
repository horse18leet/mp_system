class IndexedDB {
    constructor(
        private name: string, 
        private version: number,
        private db?: any,     
    ) {}

    private getStore(storeName: string, transactionType: string): IDBObjectStore {
        const transaction = this.db.transaction(storeName, transactionType);
        const store = transaction.objectStore(storeName);
        return store;
    }
  
    async init(): Promise<void> {
        if (!("indexedDB" in window)) {
            console.error("Браузер не поддерживает IndexedDB");
            return;
        }
  
        const request = window.indexedDB.open(this.name, this.version);
  
        request.onerror = () => {
            console.error("Ошибка IndexedDB:", request.error);
        };
  
        request.onsuccess = () => {
            const db = request.result;
            console.log("IndexedDB запущена");
        };
  
        request.onupgradeneeded = (event) => {
            const db = (event.target as IDBRequest).result;
            console.log("IndexedDB обновлена");
        };
    }
  
    async createRecord(storeName: string, record: any): Promise<void> {
        const store = this.getStore(storeName, "readwrite");
        const addRequest = store.add(record);
  
        addRequest.onsuccess = () => {
            console.log('Запись успешно добавлена');
        };
    }
  
    async readRecords(storeName: string, key: any): Promise<any> {
        const store = this.getStore(storeName, "readonly");
        const getRequest = store.get(key);
  
        getRequest.onsuccess = () => {
            console.log("Запись:", getRequest.result);
        };
    }

    asyncupdateRecord(storeName: string, key: any, newRecord: any): void {
        const store = this.getStore(storeName, "readwrite");
        const updateRequest = store.put(newRecord, key);
      
        updateRequest.onsuccess = () => {
            console.log("Запись успешно обновлена");
        };
    }

    deleteRecord(storeName: string, key: any): void {
        const store = this.getStore(storeName, "readwrite");
        const deleteRequest = store.delete(key);
      
        deleteRequest.onsuccess = () => {
            console.log("Запись успешно удалена");
        };

        deleteRequest.onerror = () => {
            console.error("Ошибка при удалении записи:", deleteRequest.error);
        };
    }

    createIndex(storeName: string, indexName: string, field: string): void {
        const store = this.getStore(storeName, "readwrite");
        store.createIndex(indexName, field, { unique: false });
        
        store.transaction.oncomplete = () => {
            console.log("Индекс успешно создан");
        };
    }
}

const indexedDB = new IndexedDB('mpDatabase', 1);

export default indexedDB;