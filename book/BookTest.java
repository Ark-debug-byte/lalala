package book;

public class BookTest {
    public static void main(String[] args) {
        // Create array of 10 books
        Book[] books = new Book[10];
        
        // Add fiction books
        books[0] = new Fiction("The Great Gatsby");
        books[1] = new Fiction("To Kill a Mockingbird");
        books[2] = new Fiction("1984");
        books[3] = new Fiction("Pride and Prejudice");
        books[4] = new Fiction("The Catcher in the Rye");
        
        // Add non-fiction books
        books[5] = new NonFiction("Sapiens");
        books[6] = new NonFiction("Educated");
        books[7] = new NonFiction("Thinking, Fast and Slow");
        books[8] = new NonFiction("The Immortal Life of Henrietta Lacks");
        books[9] = new NonFiction("Becoming");
        
        // Display all books
        System.out.println("=".repeat(70));
        System.out.println("                    BOOKSTORE INVENTORY");
        System.out.println("=".repeat(70));
        
        double totalPrice = 0;
        int fictionCount = 0;
        int nonFictionCount = 0;
        
        for (Book book : books) {
            System.out.println(book);
            totalPrice += book.getPrice();
            
            if (book instanceof Fiction) {
                fictionCount++;
            } else {
                nonFictionCount++;
            }
        }
        
        System.out.println("=".repeat(70));
        System.out.println("Fiction Books: " + fictionCount);
        System.out.println("Non-Fiction Books: " + nonFictionCount);
        System.out.println("Total Value: $" + String.format("%.2f", totalPrice));
        System.out.println("=".repeat(70));
    }
}