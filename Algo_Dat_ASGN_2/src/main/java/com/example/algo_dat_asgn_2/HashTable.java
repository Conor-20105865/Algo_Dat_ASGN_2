package com.example.algo_dat_asgn_2;

public class HashTable<K, V> {
    private static final int INITIAL_CAPACITY = 32;
    private static final double LOAD_FACTOR = .25;

    private Entry<K, V>[] table;
    private int size;

    public HashTable() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

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


    public V get(K key) {
        int index = hash(key);

        for(int i = 0; i < table.length; i++) {
            if (table[index] == null) {
                return null;
            }

            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % table.length;
        }
        return null;
    }

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

    private void rehash(int startIndex) {
        int index = (startIndex + 1) % table.length;
        for (int i = 0; table[index] != null; i++) {
            Entry<K,V> entry = table[index];
            table[index] = null;
            size --;
            put(entry.key, entry.value);
        }

    }

    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTable<>();

        hashTable.put(1, "apple");
        hashTable.put(2, "banana");
        hashTable.put(3, "cherry");

        System.out.println("Value for 'apple': " + hashTable.get(1)); // Output: 1
        System.out.println("Value for 'banana': " + hashTable.get(2)); // Output: 2

    }

}