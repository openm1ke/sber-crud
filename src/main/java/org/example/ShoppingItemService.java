package org.example;

import java.util.List;

/**
 * Интерфейс, описывающий методы сервиса
 */
public interface ShoppingItemService {
    /**
     * Создает новый элемент
     * @param item
     */
    void create(ShoppingItem item);

    /**
     * Возвращает элемент по его уникальному идентификатору
     * @param id @return ShoppingItem @throws ItemNotFoundException
     */
    ShoppingItem read(long id) throws ItemNotFoundException;

    /**
     * Обновляет элемент
     * @param item @throws ItemNotFoundException
     */
    void update(ShoppingItem item) throws ItemNotFoundException;

    /**
     * Удаляет элемент
     * @param id @throws ItemNotFoundException
     */
    void delete(long id) throws ItemNotFoundException;

    /**
     * Возвращает количество элементов в списке
     * @return int
     */
    int size();

    /**
     * Возвращает список элементов
     * @return List<ShoppingItem>
     */
    List<ShoppingItem> list();
}
