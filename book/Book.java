package book;

abstract class Book {
    private String title;
    private double price;
    
    public Book(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    public double getPrice() {
        return price;
    }
    
    protected void setPrice(double price) {
        this.price = price;
    }
    
    public abstract String getType();
    
    @Override
    public String toString() {
        return String.format("%-30s | Type: %-10s | Price: $%.2f", 
                           title, getType(), price);
    }
}

// Fiction subclass
class Fiction extends Book {
    public Fiction(String title) {
        super(title);
        setPrice(24.99);
    }
    
    @Override
    public String getType() {
        return "Fiction";
    }
}

// NonFiction subclass
class NonFiction extends Book {
    public NonFiction(String title) {
        super(title);
        setPrice(37.99);
    }
    
    @Override
    public String getType() {
        return "Non-Fiction";
    }
}
