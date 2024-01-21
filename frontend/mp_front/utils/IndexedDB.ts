class IndexedDB {
    constructor(
        private name: string, 
        private version: number,
        private db: any,     
    ) {}
  
    async init(): Promise<void> {
        if (!('indexedDB' in window)) {
            console.error('Браузер не поддерживает IndexedDB');
            return;
        }
  
        const request = window.indexedDB.open(this.name, this.version);
  
        request.onerror = () => {
            console.error('Ошибка IndexedDB:', request.error);
        };
  
        request.onsuccess = () => {
            this.db = request.result;
            console.log('IndexedDB запущена');
        };
  
        request.onupgradeneeded = (event) => {
            const db = (event.target as IDBRequest).result;
        };
    }
  
    async createRecord(storeName: string, record: any): Promise<void> {
        const transaction = this.db.transaction(storeName, 'readwrite');
        const store = transaction.objectStore(storeName);
        const addRequest = store.add(record);
  
        addRequest.onsuccess = () => {
            console.log('Запись успешно добавлена');
        };
    }
  
    async readRecords(storeName: string, key: any): Promise<any> {
        const transaction = this.db.transaction(storeName, 'readonly');
        const store = transaction.objectStore(storeName);
        const getRequest = store.get(key);
  
        getRequest.onsuccess = () => {
            console.log('Запись:', getRequest.result);
        };
    }

    asyncupdateRecord(storeName: string, key: any, newRecord: any): void {
        const transaction = this.db.transaction(storeName, 'readwrite');
        const store = transaction.objectStore(storeName);
        const updateRequest = store.put(newRecord, key);
      
        updateRequest.onsuccess = () => {
            console.log('Запись успешно обновлена');
        };
    }

    deleteRecord(storeName: string, key: any): void {
        const transaction = this.db.transaction(storeName, 'readwrite');
        const store = transaction.objectStore(storeName);
        const deleteRequest = store.delete(key);
      
        deleteRequest.onsuccess = () => {
            console.log('Запись успешно удалена');
        };
    }

    createIndex(storeName: string, indexName: string, field: string): void {
        const transaction = this.db.transaction(storeName, 'readwrite');
        const store = transaction.objectStore(storeName);
        store.createIndex(indexName, field, { unique: false });
      
        transaction.oncomplete = () => {
            console.log('Индекс успешно создан');
        };
      }
}

export default IndexedDB;