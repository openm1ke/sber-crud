package org.example;

import java.util.List;

public interface ShoppingItemService {
    void create(ShoppingItem item);
    ShoppingItem read(long id) throws ItemNotFoundException;
    void update(ShoppingItem item) throws ItemNotFoundException;
    void delete(long id) throws ItemNotFoundException;

    int size();
    List<ShoppingItem> list();
}
