Q. You have a consumer which is consuming the data from a data stream(for implementation purpose i was expected to assume it as a list)
we have to read the data one by one. How to do it

you misght have seen paginated apis
we give a limit and offset
Ex: limt as 10 and offset as 0 - first 10 records
offset as 10 limit 10 - next 10records

psuedo implementation of paginated apis
think about extendability
