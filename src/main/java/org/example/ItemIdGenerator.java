package org.example;

public class ItemIdGenerator {
    private static final ItemIdGenerator instance = new ItemIdGenerator();
    private long lastId = 1;

    private ItemIdGenerator() {
    }

    public static ItemIdGenerator getInstance() {
        return instance;
    }

    public long getNextId() {
        return lastId++;
    }

    public void reset() {
        lastId = 1;
    }
}
