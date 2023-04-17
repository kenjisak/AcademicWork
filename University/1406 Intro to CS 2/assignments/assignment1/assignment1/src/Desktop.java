public class Desktop {
    private double CPU;
    private int RAM;
    private int storage;
    private boolean SSD;

    public Desktop(double CPU, int RAM, int storage , boolean SSD){
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.SSD = SSD;
    }
    public String toString(){
        String sentence;
        if (SSD){
           sentence = "Desktop PC with "+ CPU+"ghz CPU, "+RAM+"GB RAM, "+storage+"GB SSD drive";
        }
        else{
            sentence = "Desktop PC with "+CPU+"ghz CPU, "+RAM+"GB RAM, "+storage+"GB HDD drive";
        }
        return (sentence);
    }
}
