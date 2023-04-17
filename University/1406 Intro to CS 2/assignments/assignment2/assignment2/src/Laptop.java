public class Laptop extends Product{
    private double price;
    private int stockQuantity;
    private int soldQuantity;
    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;
    private double screenSize;

    public Laptop(double price, int quantity, double cpuSpeed, int ram, boolean ssd, int storage, double screenSize){
        super(price, quantity);
        this.price = price;
        this.stockQuantity = quantity;
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.ssd = ssd;
        this.storage = storage;
        this.screenSize = screenSize;
    }
    public double sellUnits(int amount){
        double revenue;
        super.sellUnits(amount);
        if (stockQuantity >= amount){
            soldQuantity += amount;
            stockQuantity = stockQuantity - amount;
            revenue = amount * price;
            return revenue;
        }
        return 0.0;
    }
    public String toString(){
        String sentence;
        if (ssd){
            sentence = screenSize +" inch Laptop PC with " + cpuSpeed +"ghz CPU, "+ ram +"GB RAM, "+storage+"GB SSD drive.\n" + "(" + price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity +" sold)";
        }
        else{
            sentence = screenSize +" inch Laptop PC with " + cpuSpeed +"ghz CPU, "+ ram +"GB RAM, "+storage+"GB HDD drive.\n" + "(" + price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity +" sold)";
        }
        return (sentence);

    }
}
