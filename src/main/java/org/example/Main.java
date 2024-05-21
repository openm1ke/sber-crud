package org.example;

public class Main {
    public static void main(String[] args) {

        ShoppingItem item = new ShoppingItem("Milk", 1.99, 2);
        System.out.println(item);
        ShoppingItem item2 = new ShoppingItem("Salt", 0.15, 1);
        System.out.println(item2);
    }
}