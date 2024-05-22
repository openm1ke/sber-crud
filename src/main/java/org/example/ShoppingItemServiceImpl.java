package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingItemServiceImpl implements ShoppingItemService {

    private final List<ShoppingItem> items = new ArrayList<>(); // <ShoppingItem>

    @Override
    public void create(ShoppingItem item) {
        items.add(item);
    }

    @Override
    public ShoppingItem read(long id) throws ItemNotFoundException {
        for(ShoppingItem item : items) {
            if(item.getId() == id) {
                return item;
            }
        }
        throw new ItemNotFoundException("Item with id " + id + " not found");
    }

    @Override
    public void update(ShoppingItem item) throws ItemNotFoundException {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getId() == item.getId()) {
                items.set(i, item);
                return;
            }
        }
        throw new ItemNotFoundException("Item with id " + item.getId() + " not found");
    }

    @Override
    public void delete(long id) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getId() == id) {
                items.remove(i);
                return;
            }
        }
        throw new ItemNotFoundException("Item with id " + id + " not found");
    }

    public int size() {
        return items.size();
    }
}
