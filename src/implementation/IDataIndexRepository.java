package implementation;

import repository.DataStorageRepository;

import java.util.Map;

public interface IDataIndexRepository {
    public void createIndex(String field);
    public DataStorageRepository getIndex(String field);
    public Map<String, DataStorageRepository> getIndexes();
}
