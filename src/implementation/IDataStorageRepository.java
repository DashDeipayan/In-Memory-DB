package implementation;

import models.DataRecord;

public interface IDataStorageRepository {
    public void insertRecord(DataRecord record);
    public DataRecord getRecord(String key);
    public void updateRecord(DataRecord record);
    public void deleteRecord(String key);
}
