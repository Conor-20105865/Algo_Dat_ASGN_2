package com.example.algo_dat_asgn_2;

public class HashTable {

   private static final int defaultCapacity = 50;

   //Arrays
    private String[] keys;
    private String[] values;
    private int size;

    public HashTable() {
        keys = new String[defaultCapacity]; // initialize keys
        values = new String[defaultCapacity]; //initialize values
        size = 0;
    }
}
