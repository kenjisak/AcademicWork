public class Laptop {
    private double CPU;
    private int RAM;
    private int storage;
    private boolean SSD;
    private int screen_size;

    public Laptop(int screen_size,double CPU, int RAM, int storage , boolean SSD){
        this.screen_size = screen_size;
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.SSD = SSD;
    }
    public String toString(){
        String sentence;
        if (SSD){
            sentence = screen_size+"\" Laptop PC with "+ CPU+"ghz CPU, "+RAM+"GB RAM, "+storage+"GB SSD drive";
        }
        else{
            sentence = screen_size+ "\" Laptop PC with "+CPU+"ghz CPU, "+RAM+"GB RAM, "+storage+"GB HDD drive";
        }
        return (sentence);

    }
}
