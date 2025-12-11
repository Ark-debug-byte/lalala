package teeshirt;


class TeeShirt {
    private String orderNumber;
    private String size;
    private String color;
    private double price;
    
    public TeeShirt(String orderNumber, String size, String color) {
        this.orderNumber = orderNumber;
        this.size = size;
        this.color = color;
        setPrice();
    }
    
    private void setPrice() {
        if (size.equalsIgnoreCase("XXL") || size.equalsIgnoreCase("XXXL")) {
            this.price = 22.99;
        } else {
            this.price = 19.99;
        }
    }
    
    public String getOrderNumber() {
        return orderNumber;
    }
    
    public String getSize() {
        return size;
    }
    
    public String getColor() {
        return color;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return String.format("Order: %-8s | Size: %-4s | Color: %-10s | Price: $%.2f",
                           orderNumber, size, color, price);
    }
}

// CustomTeeShirt class with slogan
class CustomTeeShirt extends TeeShirt {
    private String slogan;
    
    public CustomTeeShirt(String orderNumber, String size, String color, String slogan) {
        super(orderNumber, size, color);
        this.slogan = slogan;
    }
    
    public String getSlogan() {
        return slogan;
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Slogan: \"" + slogan + "\"";
    }
}

