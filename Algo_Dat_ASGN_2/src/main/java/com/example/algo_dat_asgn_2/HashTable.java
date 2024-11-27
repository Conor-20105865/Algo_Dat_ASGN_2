package com.example.algo_dat_asgn_2;

import java.io.Serializable;

//K generic is for keys and V generic is for values
public class HashTable<K, V> implements Serializable {
    private static final long serialVersionUID = 10;
    //Set Initial Capacity
    private static final int INITIAL_CAPACITY = 32;
    //Set Load Factor to 75%
    private static final double LOAD_FACTOR = .75;

    private Entry<K, V>[] table;
    private int size;

    public HashTable() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    //Entry class to be used within Hash table
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(K key) {
        return (key.hashCode() % table.length);
    }

    //Put a new key and value into the hashtable
    public void put(K key, V value) {

        //Resize the hash table if the table is close to full
        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }

        int index = hash(key);

        for (int i = 0; i < table.length; i++) {
            if (table[index] == null) {
                table[index] = new Entry<>(key, value);
                size += 1;
                return;
            }

            if (table[index].key.equals(key)) {
                table[index].value = value;
                return;
            }
            index = (index + 1) % table.length;
        }

    }


    //Retrieve Values from Keys
    public V get(K key) {
        int index = hash(key);

        for(int i = 0; i < table.length; i++) {
            if (table[index] == null) {
                return null;
            }

            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % table.length; // Linear probing
        }
        return null;
    }

    //Resize The Indexes within the hashtable
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry<K, V> entry: oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    //Redistribute keys within the hash table
    private void rehash(int startIndex) {
        int index = (startIndex + 1) % table.length;
        for (int i = 0; table[index] != null; i++) {
            Entry<K,V> entry = table[index];
            table[index] = null;
            size --;
            put(entry.key, entry.value);
            index = (index + 1) % table.length;
        }

    }
    //no idea what this does :(
    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    //Have a guess what it does
    public boolean remove(K key) {
        int index = hash(key);

        for (int i = 0; table[index] != null; i ++) {
            if (table[index].key.equals(key)) {
                table[index] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTable<>();

        hashTable.put(1, "apple");
        hashTable.put(2, "banana");
        hashTable.put(3, "cherry");

        System.out.println("Value for 'apple': " + hashTable.get(1)); // Output: 1
        System.out.println("Value for 'banana': " + hashTable.get(2)); // Output: 2

        hashTable.remove(2);
        System.out.println("Value for 'banana' after removal: " + hashTable.get(2)); // Output: null

        hashTable.put(4, "date");
        System.out.println("Value for 'date': " + hashTable.get(4)); // Output: 4
    }

    //TODO Start sorting dat shit out bruh.

    //TODO: Quick sort, random,

}

