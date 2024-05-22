package org.example;

public interface ShoppingItemService {
    void create(ShoppingItem item);
    ShoppingItem read(long id) throws ItemNotFoundException;
    void update(ShoppingItem item) throws ItemNotFoundException;
    void delete(long id) throws ItemNotFoundException;
}
