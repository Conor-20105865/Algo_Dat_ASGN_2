package com.example.algo_dat_asgn_2;

public class HashTable {

    int[] hashTable;

    public int hash(String k, int hashTableSize) {
        int total = 0;
        for (int i = 0; i < k.length(); i++)
            total += k.charAt(i);
        return total % hashTableSize;
    }

    public HashTable(int size) {
        hashTable = new int[size];
    }

    public int add(int item) {
           return add(item);
    }
}
