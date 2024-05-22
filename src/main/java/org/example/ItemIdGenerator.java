package org.example;

public class ItemIdGenerator {
    /**
     * Экземпляр объекта ItemIdGenerator для генерации уникальных идентификаторов
     */
    private static final ItemIdGenerator instance = new ItemIdGenerator();

    /**
     * Последний сгенерированный идентификатор
     */
    private long lastId = 1;

    private ItemIdGenerator() {
    }

    /**
     * Метод для получения экземпляра ItemIdGenerator
     *
     * @return экземпляр ItemIdGenerator
     */
    public static ItemIdGenerator getInstance() {
        return instance;
    }

    /**
     * Метод для генерации уникального идентификатора
     *
     * @return уникальный идентификатор
     */
    public long getNextId() {
        return lastId++;
    }

    /**
     * Метод для сброса последнего сгенерированного идентификатора
     */
    public void reset() {
        lastId = 1;
    }
}
