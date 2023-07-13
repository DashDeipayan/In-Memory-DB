package controllers;

import models.DataRecord;
import services.Quering;

public class ErrorHandling {
    private final ConcurrencyController concurrencyController;
    public ErrorHandling(ConcurrencyController concurrencyController) {
        this.concurrencyController = concurrencyController;
    }

    public void insertRecord(DataRecord record) throws Exception {
        if (record.getKey() == null || record.getValue() == null) {
            throw new Exception("Invalid record: Missing key or value.");
        }

        if (concurrencyController.retrieveRecord(record.getKey()) != null) {
            throw new Exception("Record with the same key already exists.");
        }

        concurrencyController.insertRecord(record);
    }
}
