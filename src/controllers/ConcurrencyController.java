package controllers;

import models.DataRecord;
import services.Quering;

public class ConcurrencyController {
    private final Quering quering;

    public ConcurrencyController(Quering quering) {
        this.quering = quering;
    }
    public synchronized DataRecord retrieveRecord(String key) {
        return quering.retrieveDataRecord(key);
    }
    public synchronized void insertRecord(DataRecord record) {
        quering.insertDataRecord(record);
    }
    public synchronized void updateRecord(DataRecord record) {
        quering.updateDataRecord(record);
    }
    public synchronized void deleteRecord(String key) {
        quering.deleteDataRecord(key);
    }
}
