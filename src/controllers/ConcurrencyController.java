package controllers;

import models.DataRecord;
import services.Querying;

public class ConcurrencyController {
    private final Querying querying;

    public ConcurrencyController(Querying querying) {
        this.querying = querying;
    }
    public synchronized DataRecord retrieveRecord(String key) {
        return querying.retrieveDataRecord(key);
    }
    public synchronized void insertRecord(DataRecord record) {
        querying.insertDataRecord(record);
    }
    public synchronized void updateRecord(DataRecord record) {
        querying.updateDataRecord(record);
    }
    public synchronized void deleteRecord(String key) {
        querying.deleteDataRecord(key);
    }
}
