package ru.geekBrains.l02.lesson_03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PhoneBook {
    private Map<String, PhoneBookValue> phoneBook;

    public Map<String, PhoneBookValue> getPhoneBook() {
        return this.phoneBook;
    }

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public PhoneBook(Map<String, PhoneBookValue> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public Map<String, PhoneBookValue> getPhoneList(String surname) {
////  -- via Key Iterator
//        Iterator <String> itPBKeys = phoneBook.getPhoneBook().keySet().iterator();
//        while (itPBKeys.hasNext() ){
//            String entryKey = itPBKeys.next();      // Key
//            System.out.printf( entryKey + "\n");
//        }
////  -- via Value Iterator (return type is class:PhoneBookValue)
//        Iterator <PhoneBookValue> itPBValues = phoneBook.getPhoneBook().values().iterator();
//        while (itPBValues.hasNext() ){
//            PhoneBookValue entryValue = itPBValues.next();    // Value
//            System.out.printf( entryValue + "\n");
//        }
////  -- via Entry iterator  (return type is <Key: String, Value: class=PhoneBookValue>)
//        Iterator <Map.Entry<String, PhoneBookValue>> itPBEntry = phoneBook.getPhoneBook().entrySet().iterator();
//        while (itPBEntry.hasNext() ){
//            Map.Entry<String,PhoneBookValue> entry = itPBEntry.next(); // key + value
//            System.out.printf( entry + "\n");
//        }

        Map<String, PhoneBookValue> retEntries = new HashMap<>();
        Iterator<Map.Entry<String, PhoneBookValue>> itPBEntry = this.getPhoneBook().entrySet().iterator();
        while (itPBEntry.hasNext() ){
            Map.Entry<String,PhoneBookValue> entry = itPBEntry.next();
            if (entry.getValue().getSurame() == surname ) {
                retEntries.put(entry.getKey(), entry.getValue());
            }
        }
        return retEntries;
    }

    public void add(String key, PhoneBookValue value) {
        if (!phoneBook.containsKey(key)) phoneBook.putIfAbsent(key, value); // Add new entry
        else {
//            PhoneBookValue pbKey$ = pbCat.get(key);                       // n/a: Get Map's Value by Key
            phoneBook.replace(key, value);                                  // Update entry if exist
        }
    }

    @Override
    public String toString() {
//        return super.toString();
        String retString = "";
        for (String key : phoneBook.keySet()) {
            retString = retString + "{ " +
                    "Key: " +  key.toString() + "; " +
                    "Value: " +  phoneBook.get(key).toString() +
                    " }"+ "\n";
        }
        return retString;
    }
}
