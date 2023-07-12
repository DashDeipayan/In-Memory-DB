package implementation;

import models.DataRecord;
import repository.DataStorageRepository;

public interface IQuering {
    public DataRecord retrieveDataRecord(String key);
    public void insertDataRecord(DataRecord record);
    public void updateDataRecord(DataRecord record);
    public void deleteDataRecord(String key);
    public DataStorageRepository getDataIndex(String field);
}
