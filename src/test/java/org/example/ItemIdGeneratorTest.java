package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemIdGeneratorTest {

    ItemIdGenerator generator = ItemIdGenerator.getInstance();
    @Test
    void getNextId() {
        assertEquals(1, generator.getNextId());
        assertEquals(2, generator.getNextId());
        assertEquals(3, generator.getNextId());
    }
}