public class ToasterOven extends Product{
    private double price;
    private int stockQuantity;
    private int soldQuantity;
    private int wattage;
    private String color;
    private String brand;
    private int width;
    private boolean convection;

    public ToasterOven(double price, int quantity, int wattage, String color, String brand, int width, boolean convection){
        super(price, quantity);
        this.price = price;
        this.stockQuantity = quantity;
        this.wattage = wattage;
        this.color = color;
        this.brand = brand;
        this.width = width;
        this.convection = convection;
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
        if (convection){
            sentence = width + " inch " + brand + " Toaster with convection (" + color + ", " + wattage + " watts)\n(" + price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity +" sold)";
        }
        else{
            sentence = width + " inch " + brand + " Toaster (" + color + ", " + wattage + " watts)\n("+ price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity +" sold)";
        }
        return (sentence);

    }
}
