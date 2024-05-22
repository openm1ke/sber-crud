package org.example;

/**
 * Класс, описывающий элемент списка
 */
public class ShoppingItem {
    /**
     * Уникальный идентификатор
     */
    private final long id;

    /**
     * Название товара
     */
    private final String name;

    /**
     * Цена за единицу
     */
    private final double price;

    /**
     * Количество
     */
    private int quantity;

    /**
     * Конструктор
     * @param name название
     * @param price цена
     * @param quantity количество
     */
    public ShoppingItem(String name, double price, int quantity) {
        this.id = ItemIdGenerator.getInstance().getNextId();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Возвращает уникальный идентификатор
     * @return идентификатор
     */
    public long getId() {
        return id;
    }

    /**
     * Возвращает название товара
     * @return название
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает цену за единицу
     * @return цена
     */
    public double getPrice() {
        return price;
    }

    /**
     * Возвращает количество
     * @return количество
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Возвращает строковое представление
     * @return строковое представление
     */
    @Override
    public String toString() {
        return "ShoppingItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    /**
     * Сравнивает два объекта
     * @param o другой объект
     * @return true, если идентификаторы равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingItem that = (ShoppingItem) o;
        return id == that.id;
    }

    /**
     * Возвращает хэш-код
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    /**
     * Увеличивает количество на единицу
     */
    public void incrementQuantity() {
        quantity++;
    }

    /**
     * Уменьшает количество на единицу
     */
    public void decrementQuantity() {
        if(quantity > 1) {
            quantity--;
        } else {
            quantity = 1;
        }
    }
}
