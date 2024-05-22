package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class ShoppingApp {
    private static final ShoppingItemService service = new ShoppingItemServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LoggerFactory.getLogger(ShoppingApp.class);
    public static void main(String[] args) {
        boolean running = true;
        logger.info("Start application");
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    listItems();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void printMenu() {
        logger.info("Print menu");
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. List");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void listItems() {
        logger.info("List items");
        List<ShoppingItem> items = service.list();
        if(items.isEmpty()) {
            System.out.println("Items list empty");
        } else {
            for(ShoppingItem item : items) {
                System.out.println(item);
            }
        }
    }

    public static void create() {
        logger.info("Create item");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        service.create(new ShoppingItem(name, price, quantity));
    }

    public static void read() {
        logger.info("Read item");
        System.out.print("Enter id: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        try {
            ShoppingItem item = service.read(id);
            System.out.println(item);
        } catch (ItemNotFoundException e) {
            logger.error("Item not found", e);
            System.out.println("Item not found");
        }
    }

    public static void printQuantityMenu() {
        logger.info("Print quantity menu");
        System.out.println("Enter quantity increase or decrease: ");
        System.out.println("1. Increase");
        System.out.println("2. Decrease");
    }


    public static void update() {
        logger.info("Update item");
        System.out.print("Enter id: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        try {
            ShoppingItem item = service.read(id);
            printQuantityMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    item.incrementQuantity();
                    break;
                case 2:
                    item.decrementQuantity();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            service.update(item);
        } catch (ItemNotFoundException e) {
            logger.error("Item not found", e);
            System.out.println("Item not found");
        }

    }

    public static void delete() {
        logger.info("Delete item");
        System.out.print("Enter id: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        try {
            service.delete(id);
        } catch (ItemNotFoundException e) {
            logger.error("Item not found", e);
            System.out.println("Item not found");
        }
    }
}
