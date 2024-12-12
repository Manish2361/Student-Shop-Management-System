import java.util.*;

public class ShopApp {

    public static Product[] products = new Product[5];
   public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        

        products[0] = new Product("Laptop", 20, 2000.00);
        products[1] = new Product("Book", 10, 1500.00);
        products[2] = new Product("Mouse", 5, 2500.00);
        products[3] = new Product("Airpods", 15, 3000.00);
        products[4] = new Product("Iphone 16 ProMax", 25, 1500.00);

        System.out.println("Enter Your Student id: ");

        while (true) {
            displayTheManagementShop();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayTheListOfProduct();
                    break;

                case 2:
                    buyStock();
                    break;
                case 3:
                    Sell();
                    break;

                case 4:
                    ReplaceItem();
                    break;
                case 5:
                    TotalValue();
                    break;

                case 6:
                    System.out.println("Thank You Soo Much Using This App!");
                    return;
                default:
                    System.out.println("Please Enter The Value Range From(1-6)");

            }

        }

    }

    public static void displayTheManagementShop() {
        System.out.println("\nThe list of All The Product Management");
        System.out.println("1. Display All The List Of Product");
        System.out.println("2. Buy The Product");
        System.out.println("3. Sell The Product");
        System.out.println("4. Replace The Product price");
        System.out.println("5. Total Value Of The Product");
        System.out.println("6. Exit");
        System.out.println("Enter The Value Range From (1-6)");
    }

    public static void displayTheListOfProduct() {
        for (int i = 0; i < products.length; i++)
            System.out.println((i+1)+"  " +products[i].getName() + "--Stock Label--" + products[i].getStockLevel() + "--Price--" + products[i].getPrice());

    }

    public static void buyStock() {
        System.out.print("Enter product index (0-4): ");
        int buyIndex = sc.nextInt();
        System.out.print("Enter quantity to buy: ");
        int buyQuantity = sc.nextInt();
        double valueBought = products[buyIndex].buyStock(buyQuantity);
        System.out.println("Bought stock worth: $" + valueBought);

    }

    public static void Sell() {
        System.out.print("Enter product index (0-4): ");
        int sellIndex = sc.nextInt();
        System.out.print("Enter quantity to sell: ");
        int sellQuantity = sc.nextInt();
        if (products[sellIndex].sell(sellQuantity)) {
            System.out.println("Sale successful!");
        } else {
            System.out.println("Not enough stock to complete the sale.");

        }

    }

    public static void ReplaceItem() {
        System.out.print("Enter product index (0-4): ");
        int priceIndex = sc.nextInt();
        System.out.print("Enter new price: ");
        double newPrice = sc.nextDouble();
        products[priceIndex].setPrice(newPrice);
        System.out.println("Price updated successfully!");

    }

    public static void TotalValue() {
        double totalValue = 0;
        for (Product product : products) {
            totalValue += product.getStockLevel() * product.getPrice();
        }
        System.out.println("Total value of all stock: $" + totalValue);

    }

    public static class Product {
        private String name;
        private int stockLevel;
        private double price;

        public Product(String name, int stockLevel, double price) {
            this.name = name;
            this.stockLevel = stockLevel;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getStockLevel() {
            return stockLevel;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double buyStock(int quantity) {
            if (quantity > 0) {
                stockLevel += quantity;
                return quantity * price;
            } else {
                return 0;
            }
        }

        public boolean sell(int quantity) {
            if (quantity > 0 && stockLevel >= quantity) {
                stockLevel -= quantity;
                return true;
            } else {
                return false;
            }
        }
    }
}