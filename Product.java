
public class Product {
    private String name;
    private int stockLevel;
    private double price;

    public Product(String name, int stockLevel, double price) {
        this.name = name;
        this.stockLevel = stockLevel;
        this.price = price;
    }

    public double buyStock(int quantity) {
        this.stockLevel += quantity;
        return quantity * this.price;
    }

    public boolean sell(int quantity) {
        if (quantity <= this.stockLevel) {
            this.stockLevel -= quantity;
            return true;
        }
        return false;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public String getName() {
        return this.name;
    }

    public int getStockLevel() {
        return this.stockLevel;
    }

    public double getPrice() {
        return this.price;
    }
}
