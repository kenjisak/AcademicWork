public class Desktop extends Product{
    private double price;
    private int stockQuantity;
    private int soldQuantity;
    private double cpuSpeed;
    private boolean ssd;
    private int ram;
    private int storage;
    private String profile;


    public Desktop(double price, int quantity , double cpuSpeed, int ram, boolean ssd, int storage, String profile){
        super(price,quantity);
        this.price = price;
        this.stockQuantity = quantity;
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.ssd = ssd;
        this.storage = storage;
        this.profile = profile;
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
    public String toString(){
        String sentence;
        if (ssd){
           sentence = profile + " Desktop PC with " + cpuSpeed + "ghz CPU, " + ram +"GB RAM, " + storage + "GB SSD drive.\n" + "(" + price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity +" sold)";
        } else{
            sentence = profile + " Desktop PC with " + cpuSpeed + "ghz CPU, " + ram +"GB RAM, " + storage + "GB HDD drive.\n" + "(" + price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity +" sold)";
        }
        return (sentence);
    }
}
