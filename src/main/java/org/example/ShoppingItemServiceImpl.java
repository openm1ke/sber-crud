package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса ShoppingItemService
 */
public class ShoppingItemServiceImpl implements ShoppingItemService {

    /**
     * Список элементов
     */
    private final List<ShoppingItem> items = new ArrayList<>(); // <ShoppingItem>

    /**
     * Метод создает новый элемент
     * @param item
     */
    @Override
    public void create(ShoppingItem item) {
        items.add(item);
    }

    /**
     * Метод возвращает элемент по его уникальному идентификатору
     * @param id @return ShoppingItem @throws ItemNotFoundException
     */
    @Override
    public ShoppingItem read(long id) throws ItemNotFoundException {
        for(ShoppingItem item : items) {
            if(item.getId() == id) {
                return item;
            }
        }
        throw new ItemNotFoundException("Item with id " + id + " not found");
    }

    /**
     * Метод обновляет элемент
     * @param item @throws ItemNotFoundException
     */
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

    /**
     * Метод удаляет элемент
     * @param id @throws ItemNotFoundException
     */
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

    /**
     * Возвращает количество элементов в списке
     * @return int
     */
    public int size() {
        return items.size();
    }

    /**
     * Возвращает список элементов
     * @return List<ShoppingItem>
     */
    public List<ShoppingItem> list() {
        return items;
    }
}
