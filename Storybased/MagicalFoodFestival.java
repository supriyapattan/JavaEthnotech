package Storybased;

import java.util.*;

class FestivalManager {

    ArrayList<String> foodStalls = new ArrayList<>();
    Vector<String> dishes = new Vector<>();
    Queue<String> customers = new LinkedList<>();
    Stack<String> visitedStalls = new Stack<>();
    LinkedList<String> history = new LinkedList<>();

    Scanner sc = new Scanner(System.in);

    void addFoodStall() {
        System.out.print("Enter stall name: ");
        String stall = sc.nextLine();
        foodStalls.add(stall);
        System.out.println("Stall added successfully!");
    }

    void updateDish() {
        System.out.print("Enter dish name: ");
        String dish = sc.nextLine();
        dishes.add(dish);
        System.out.println("Dish updated!");
    }

    void addCustomer() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        customers.add(name);
        System.out.println("Customer added to queue!");
    }

    void serveCustomer() {
        if (customers.isEmpty()) {
            System.out.println("No customers in queue.");
        } else {
            String served = customers.poll();
            System.out.println(served + " is served.");

            System.out.print("Enter stall visited: ");
            String stall = sc.nextLine();

            visitedStalls.push(stall);
            history.add(served + " visited " + stall);
        }
    }

    void showLastVisited() {
        if (visitedStalls.isEmpty()) {
            System.out.println("No visited stalls yet.");
        } else {
            System.out.println("Last visited stall: " + visitedStalls.peek());
        }
    }

    void showHistory() {
        System.out.println("\nDaily Festival History:");
        for (String record : history) {
            System.out.println(record);
        }
    }
}

public class MagicalFoodFestival {

    public static void main(String[] args) {

        FestivalManager fm = new FestivalManager();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== Magical Food Festival Menu =====");
            System.out.println("1. Add Food Stall");
            System.out.println("2. Update Dish");
            System.out.println("3. Add Customer to Queue");
            System.out.println("4. Serve Customer");
            System.out.println("5. Show Last Visited Stall");
            System.out.println("6. Show Daily History");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    fm.addFoodStall();
                    break;
                case 2:
                    fm.updateDish();
                    break;
                case 3:
                    fm.addCustomer();
                    break;
                case 4:
                    fm.serveCustomer();
                    break;
                case 5:
                    fm.showLastVisited();
                    break;
                case 6:
                    fm.showHistory();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
        sc.close();
    }
    
}
