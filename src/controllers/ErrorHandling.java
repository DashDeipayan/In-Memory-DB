package controllers;

import models.DataRecord;
import services.Quering;

public class ErrorHandling {
    private final Quering querying;

    public ErrorHandling(Quering querying) {
        this.querying = querying;
    }

    public void insertRecord(DataRecord record) throws Exception {
        if (record.getKey() == null || record.getValue() == null) {
            throw new Exception("Invalid record: Missing key or value.");
        }

        if (querying.retrieveDataRecord(record.getKey()) != null) {
            throw new Exception("Record with the same key already exists.");
        }

        querying.insertDataRecord(record);
    }
}
