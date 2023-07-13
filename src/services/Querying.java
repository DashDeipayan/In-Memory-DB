package services;

import implementation.IQuering;
import models.DataRecord;
import repository.DataIndexRepository;
import repository.DataStorageRepository;

public class Querying implements IQuering {
    private final DataStorageRepository dataStorageRepository;
    private final DataIndexRepository dataIndexRepository;

    public Querying(DataStorageRepository dataStorageRepository, DataIndexRepository dataIndexRepository) {
        this.dataStorageRepository = dataStorageRepository;
        this.dataIndexRepository = dataIndexRepository;
    }

    @Override
    public DataRecord retrieveDataRecord(String key) {
        return dataStorageRepository.getRecord(key);
    }

    @Override
    public void insertDataRecord(DataRecord record) {
        dataStorageRepository.insertRecord(record);
        for (DataStorageRepository index : dataIndexRepository.getIndexes().values()) {
            index.insertRecord(record);
        }
    }

    @Override
    public void updateDataRecord(DataRecord record) {
        dataStorageRepository.updateRecord(record);
    }

    @Override
    public void deleteDataRecord(String key) {
        dataStorageRepository.deleteRecord(key);
    }

    @Override
    public DataStorageRepository getDataIndex(String field) {
        return dataIndexRepository.getIndex(field);
    }
}
