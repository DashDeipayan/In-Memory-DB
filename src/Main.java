import controllers.ConcurrencyControl;
import controllers.ErrorHandling;
import models.DataRecord;
import repository.DataIndexRepository;
import repository.DataStorageRepository;
import services.Quering;

public class Main {
    public static void main(String[] args) throws Exception {
        DataStorageRepository dataStorage = new DataStorageRepository();
        DataIndexRepository indexing = new DataIndexRepository();
        Quering querying = new Quering(dataStorage, indexing);
        ErrorHandling errorHandling = new ErrorHandling(querying);
        ConcurrencyControl concurrencyControl = new ConcurrencyControl(querying);

        try {
            // INSERTED TWO RECORDS
            DataRecord record1 = new DataRecord("key1", "value1");
            DataRecord record2 = new DataRecord("key2", "value2");
            errorHandling.insertRecord(record1);
            errorHandling.insertRecord(record2);

            // RETRIEVED TWO RECORDS
            DataRecord retrievedRecord1 = concurrencyControl.retrieveRecord("key1");
            DataRecord retrievedRecord2 = concurrencyControl.retrieveRecord("key2");
            System.out.println("--------RETRIEVING TWO RECORDS--------");
            System.out.println(retrievedRecord1.toString());
            System.out.println(retrievedRecord2.toString());

            // UPDATED TWO RECORDS
            retrievedRecord1.setValue("newValue1");
            retrievedRecord2.setValue("newValue2");
            concurrencyControl.updateRecord(retrievedRecord1);
            concurrencyControl.updateRecord(retrievedRecord2);
            System.out.println("--------UPDATING TWO RECORDS--------");
            System.out.println(retrievedRecord1);
            System.out.println(retrievedRecord2);

            // DELETED ONE RECORD
            concurrencyControl.deleteRecord("key1");
            DataRecord hasRecord = concurrencyControl.retrieveRecord("key1");
            System.out.println("--------DELETED ONE RECORDS--------");
            System.out.println(hasRecord);
            System.out.println(concurrencyControl.retrieveRecord("key2"));

            // INDEXING
            indexing.createIndex("field1");

            querying.insertDataRecord(record1);
            querying.insertDataRecord(record2);

            DataStorageRepository index = querying.getDataIndex("field1");
            DataRecord indexedRecord = index.getRecord("key2");
            System.out.println("--------RETRIEVE VIA INDEXING--------");
            System.out.println(indexedRecord);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}