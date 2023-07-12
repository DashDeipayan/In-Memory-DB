package repository;

import implementation.IDataStorageRepository;
import models.DataRecord;

import java.util.HashMap;
import java.util.Map;

public class DataStorageRepository implements IDataStorageRepository {
    private Map<String, DataRecord> DataRecords = new HashMap<>();

    public DataStorageRepository(Map<String, DataRecord> dataRecords) {
        DataRecords = dataRecords;
    }

    public DataStorageRepository() {
        DataRecords = new HashMap<>();
    }

    @Override
    public void insertRecord(DataRecord record) {
        DataRecords.put(record.getKey(), record);
    }

    @Override
    public DataRecord getRecord(String key) {
        return DataRecords.get(key);
    }

    @Override
    public void updateRecord(DataRecord record) {
        DataRecords.put(record.getKey(), record);
    }

    @Override
    public void deleteRecord(String key) {
        DataRecords.remove(key);
    }
}
