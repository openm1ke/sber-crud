package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingItemServiceImplTest {

    ShoppingItemServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new ShoppingItemServiceImpl();
        ItemIdGenerator.getInstance().reset();
    }

    @Test
    void create() {
        service.create(new ShoppingItem("Milk", 1.99, 2));
        assertEquals(1, service.size());
    }

    @Test
    void createAndRead() {
        service.create(new ShoppingItem("Milk", 1.99, 2));
        assertEquals(1.99, service.read(1).getPrice());
    }

    @Test
    void createAndReadException() {
        service.create(new ShoppingItem("Milk", 1.99, 2));
        assertThrows(ItemNotFoundException.class, () -> service.read(2));
    }

    @Test
    void update() {
        ShoppingItem item = new ShoppingItem("Milk", 1.99, 2);
        service.create(item);
        item.incrementQuantity();
        service.update(item);
        assertEquals(3, service.read(1).getQuantity());
    }

    @Test
    void delete() {
        service.create(new ShoppingItem("Milk", 1.99, 2));
        service.delete(1);
        assertEquals(0, service.size());
    }
}