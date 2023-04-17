public class Fridge {
    private double size;
    private boolean freezer;
    private String color;

    public Fridge(double size,  boolean freezer ,String color){
        this.size = size;
        this.freezer = freezer;
        this.color = color;
    }

    public String toString(){
        String sentence;

        if (freezer){
            sentence = size + " cu. ft. Fridge with Freezer (" + color +")";
        }
        else{
            sentence = size + " cu. ft. Fridge (" + color +")";
        }
        return (sentence);

    }

}
