package org.example.models;

import java.util.*;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose option: (0 - Exit, 1 - Add Items, 2 - Remove Items)");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0 -> running = false;
                case 1 -> {
                    System.out.println("Enter items to add (comma-separated or single):");
                    addItems(scanner.nextLine());
                }
                case 2 -> {
                    System.out.println("Enter items to remove (comma-separated or single):");
                    removeItems(scanner.nextLine());
                }
                default -> System.out.println("Invalid option.");
            }
            printSorted();
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim().toLowerCase();
            if (!groceryList.contains(item)) {
                groceryList.add(item);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim().toLowerCase();
            groceryList.remove(item);
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.trim().toLowerCase());
    }

    public static void printSorted() {
        Collections.sort(groceryList); // Bu satır TEST için eklendi
        System.out.println("Grocery List: " + groceryList);
    }
}
