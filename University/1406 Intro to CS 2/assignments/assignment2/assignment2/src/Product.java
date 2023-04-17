public class Product {

    protected double price;
    protected int stockQuantity;
    protected int soldQuantity;

    public Product(double price, int quantity){
        this.price = price;
        this.stockQuantity = quantity;
    }

    public double sellUnits(int amount){
        double revenue;

        if (stockQuantity >= amount){
            soldQuantity += amount;
            stockQuantity = stockQuantity - amount;
            revenue = amount * price;
            return revenue;
        }

        return 0.0;
    }
}
