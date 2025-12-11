
package teeshirt;

public class TeeShirtTest {
    public static void main(String[] args) {
        System.out.println("=".repeat(90));
        System.out.println("                        TSHIRT COMPANY ORDER SUMMARY");
        System.out.println("=".repeat(90));
        
        // Create array of different tshirt orders
        TeeShirt[] orders = new TeeShirt[8];
        
        // Regular TeeShirts
        orders[0] = new TeeShirt("ORD001", "S", "Red");
        orders[1] = new TeeShirt("ORD002", "M", "Blue");
        orders[2] = new TeeShirt("ORD003", "L", "Black");
        orders[3] = new TeeShirt("ORD004", "XXL", "White");
        orders[4] = new TeeShirt("ORD005", "XXXL", "Green");
        
        // Custom TeeShirts with slogans
        orders[5] = new CustomTeeShirt("ORD006", "M", "Yellow", "Code is Life");
        orders[6] = new CustomTeeShirt("ORD007", "XXL", "Navy", "Java Rocks!");
        orders[7] = new CustomTeeShirt("ORD008", "L", "Gray", "Born to Program");
        
        // Display all orders
        System.out.println("\nREGULAR TSHIRTS:");
        System.out.println("-".repeat(90));
        double regularTotal = 0;
        int regularCount = 0;
        
        for (TeeShirt order : orders) {
            if (!(order instanceof CustomTeeShirt)) {
                System.out.println(order);
                regularTotal += order.getPrice();
                regularCount++;
            }
        }
        
        System.out.println("\nCUSTOM TSHIRTS:");
        System.out.println("-".repeat(90));
        double customTotal = 0;
        int customCount = 0;
        
        for (TeeShirt order : orders) {
            if (order instanceof CustomTeeShirt) {
                System.out.println(order);
                customTotal += order.getPrice();
                customCount++;
            }
        }
        
        // Summary
        System.out.println("\n" + "=".repeat(90));
        System.out.println("SUMMARY:");
        System.out.println("Regular Orders: " + regularCount + " | Subtotal: $" + String.format("%.2f", regularTotal));
        System.out.println("Custom Orders: " + customCount + " | Subtotal: $" + String.format("%.2f", customTotal));
        System.out.println("Total Orders: " + orders.length + " | Grand Total: $" + 
                         String.format("%.2f", (regularTotal + customTotal)));
        System.out.println("=".repeat(90));
    }
}