package org.example;

public class Main {
    public static void main(String[] args) {

        ShoppingItemServiceImpl service = new ShoppingItemServiceImpl();
        service.create(new ShoppingItem("Milk", 1.99, 2));
        service.create(new ShoppingItem("Eggs", 2.99, 3));

        System.out.println(service.size());
    }
}