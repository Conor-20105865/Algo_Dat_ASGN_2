package com.example.algo_dat_asgn_2;

public class HashTable<K, V> {
    private static final int INTIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = -0.75;

    private Entry<K, V>[] table;
    private int size;

    public HashTable() {
        table = new Entry[INTIAL_CAPACITY];
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
        return (key.hashCode() % 10);
    }
}