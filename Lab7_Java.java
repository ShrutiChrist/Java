import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class InsufficientInventoryException extends Exception {
    public InsufficientInventoryException(String message) {
        super(message);
    }
}

class OrderCancellationException extends Exception {
    public OrderCancellationException(String message) {
        super(message);
    }
}

class OrderStatus {
    private String message;

    public OrderStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class Item {
    private String name;
    private int stockQuantity;

    public Item(String name, int stockQuantity) {
        this.name = name;
        this.stockQuantity = stockQuantity;
    }

    public String getName() {
        return name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}

class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private String itemName;
    private int quantity;

    public Order(String itemName, int quantity) {
        this.orderId = nextOrderId++;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Inventory {
    private Map<String, Item> items;
    private Map<Integer, Order> orders;

    public Inventory() {
        items = new HashMap<>();
        items.put("Phone", new Item("Phone", 10));
        items.put("Television", new Item("Television", 15));

        orders = new HashMap<>();
    }

    public void displayAvailableItems() {
        System.out.println("Available items in the inventory:");
        int itemNumber = 1;
        for (String itemName : items.keySet()) {
            System.out.println(itemNumber + ". " + itemName);
            itemNumber++;
        }
    }

    public Set<String> getItemNames() {
        return items.keySet();
    }

    public Item getItemByName(String itemName) {
        return items.get(itemName);
    }

    public boolean checkAvailability(Item item, int quantity) {
        return item.getStockQuantity() >= quantity;
    }

    public void updateStock(Item item, int quantity) {
        int updatedQuantity = item.getStockQuantity() - quantity;
        item.setStockQuantity(updatedQuantity);
    }

    public void placeOrder(Order order) throws InsufficientInventoryException {
        if (checkAvailability(getItemByName(order.getItemName()), order.getQuantity())) {
            System.out.println("Order placed successfully. Your order ID is: " + order.getOrderId());
            updateStock(getItemByName(order.getItemName()), order.getQuantity());
            orders.put(order.getOrderId(), order);
        } else {
            throw new InsufficientInventoryException("Insufficient inventory for item: " + order.getItemName());
        }
    }

    public OrderStatus trackOrderStatus(int orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            String itemName = order.getItemName();
            int quantity = order.getQuantity();
            String message = "Order details:\nItem Name: " + itemName + "\nQuantity: " + quantity
                    + "\nYour order will be delivered within 7 days.";
            return new OrderStatus(message);
        } else {
            return null;
        }
    }

    public void handleCustomException(Exception e) {
        if (e instanceof InsufficientInventoryException) {
            System.out.println("Exception: InsufficientInventoryException - " + e.getMessage());
        } else if (e instanceof OrderCancellationException) {
            System.out.println("Exception: OrderCancellationException - " + e.getMessage());
        } else {
            System.out.println("Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    public String getItemNameByNumber(int itemNumber) {
        int currentNumber = 1;
        for (String itemName : items.keySet()) {
            if (currentNumber == itemNumber) {
                return itemName;
            }
            currentNumber++;
        }
        return null;
    }
}

public class inventorysystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        char input;
        do {
            System.out.println("Welcome to the Inventory System");
            System.out.println("1. Order an Item");
            System.out.println("2. Track an Order");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    orderItem(inventory, scanner);
                    break;
                case 2:
                    trackOrder(inventory, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-3)");
            }

            System.out.print("Do you want to continue (y/n)? ");
            input = scanner.next().charAt(0);
        } while (input == 'y' || input == 'Y');
    }

    private static void orderItem(Inventory inventory, Scanner scanner) {
        inventory.displayAvailableItems();
        System.out.print("Enter the item number you want to order: ");
        int itemNumber = scanner.nextInt();

        String itemName = inventory.getItemNameByNumber(itemNumber);
        if (itemName == null) {
            System.out.println("Invalid item number. Please enter a valid item number.");
            return;
        }

        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();

        try {
            Order order = new Order(itemName, quantity);
            inventory.placeOrder(order);
        } catch (InsufficientInventoryException e) {
            inventory.handleCustomException(e);
        }
    }

    private static void trackOrder(Inventory inventory, Scanner scanner) {
        System.out.print("Enter the order ID: ");
        int orderId = scanner.nextInt();
        OrderStatus status = inventory.trackOrderStatus(orderId);

        if (status != null) {
            System.out.println(status.getMessage());
        } else {
            System.out.println("Order not found. Please try again.");
        }
    }
}