package com.example.algo_dat_asgn_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class HashTableTest {

    private HashTable<String, Integer> hashTable;
    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>();
    }

    @Test
    void putAndGet() {
        hashTable.put("A", 10);
        hashTable.put("B", 20);

        assertEquals(10, hashTable.get("A"));
        assertEquals(20, hashTable.get("B"));
    }



    @Test
    void resize() {
        hashTable.put("A", 10);
        hashTable.put("B", 20);
        hashTable.put("C", 30);

        // Test if resizing works by checking if the values are still accessible
        assertEquals(10, hashTable.get("A"));
        assertEquals(20, hashTable.get("B"));
        assertEquals(30, hashTable.get("C"));
    }

    @Test
    void remove() {
        hashTable.put("A", 10);
        hashTable.put("B", 20);

        // Test removing an existing key
        assertTrue(hashTable.remove("A"));
        assertNull(hashTable.get("A"));

        // Test removing a non-existing key
        assertFalse(hashTable.remove("C"));
    }
}