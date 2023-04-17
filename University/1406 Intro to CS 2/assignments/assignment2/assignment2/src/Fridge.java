public class Fridge extends Product{
    private double price;
    private int stockQuantity;
    private int soldQuantity;
    private int wattage;
    private String color;
    private String brand;
    private double cubicFeet;
    private boolean hasFreezer;

    public Fridge(double price, int quantity, int wattage, String color, String brand, double cubicFeet, boolean freezer){
        super(price,quantity);
        this.price = price;
        this.stockQuantity = quantity;
        this.wattage = wattage;
        this.color = color;
        this.brand = brand;
        this.cubicFeet = cubicFeet;
        this.hasFreezer = freezer;
    }
    public double sellUnits(int amount){

        double revenue;
        if (stockQuantity >= amount){
            soldQuantity = amount;
            stockQuantity = stockQuantity - soldQuantity;
            revenue = amount * price;
            return revenue;
        }
        return 0.0;
    }
    public String toString(){
        String sentence ="";

        if (hasFreezer){
            sentence = cubicFeet + " cu. ft. " + brand +" Fridge with Freezer (" + color + ", " + wattage + " watts)\n" + "(" + price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity + " sold)";
        }
        else{
            sentence = cubicFeet + " cu. ft. " + brand + " Fridge (" + color + ", " + wattage + " watts)\n" + "(" + price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity + " sold)";
        }
        return (sentence);

    }

}
