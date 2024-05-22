package org.example;

/**
 * Исключение, выбрасываемое при отсутствии элемента в списке
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
