# In-Memory-DB
An in-memory database built purely using Java. This supports error handling, concurrency and indexing.

### OUTPUT OF MAIN:
```
--------RETRIEVING TWO RECORDS--------
Record [key=key1, value=value1]
Record [key=key2, value=value2]
--------UPDATING TWO RECORDS--------
Record [key=key1, value=newValue1]
Record [key=key2, value=newValue2]
--------DELETED ONE RECORDS--------
null
Record [key=key2, value=newValue2]
--------RETRIEVE VIA INDEXING--------
Record [key=key2, value=newValue2]

Process finished with exit code 0
```
