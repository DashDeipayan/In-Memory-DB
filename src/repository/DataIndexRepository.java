package repository;

import implementation.IDataIndexRepository;

import java.util.HashMap;
import java.util.Map;

public class DataIndexRepository implements IDataIndexRepository {
    Map<String, DataStorageRepository> indexes = new HashMap<>();

    public DataIndexRepository(Map<String, DataStorageRepository> indexes) {
        this.indexes = indexes;
    }

    public DataIndexRepository() {
        indexes=new HashMap<>();
    }

    @Override
    public void createIndex(String field) {
        indexes.put(field, new DataStorageRepository());
    }

    @Override
    public DataStorageRepository getIndex(String field) {
        return indexes.get(field);
    }
    @Override
    public Map<String, DataStorageRepository> getIndexes() {
        return new HashMap<>(indexes);
    }
}
