import java.util.Arrays;

public class ElectronicStore {
    private String name;
    private Desktop[] desktop;
    private Laptop[] laptop;
    private Fridge[] fridge;
    private String comparingstring = "";

    public ElectronicStore(String name){
        this.name = name;
        desktop = new Desktop[3];
        laptop = new Laptop[3];
        fridge = new Fridge[3];

        desktop[0] = new Desktop(3.5,8 , 500, false);
        desktop[1] = new Desktop(3.0,16 , 250, true);
        desktop[2] = new Desktop(4.3,32 , 500, true);

        laptop[0] = new Laptop(15,3.1,32,500,true);
        laptop[1] = new Laptop(13,2.5,8,250,false);
        laptop[2] = new Laptop(15,3.0,16,250,true);

        fridge[0] = new Fridge(16.5,true,"Black");
        fridge[1] = new Fridge(12.0,false,"White");
        fridge[2] = new Fridge(23.0,true,"Stainless Steel");

    }
    public void printStock(){
        comparingstring += "The store stock includes:\n";
        for (int desktopnum = 0; desktopnum < 3;desktopnum++){
            comparingstring += desktop[desktopnum].toString() + "\n";
        }
        for (int laptopnum = 0; laptopnum < 3;laptopnum++){
            //System.out.println(laptop[laptopnum].toString());
            comparingstring += laptop[laptopnum].toString() + "\n";
        }
        for (int fridgenum = 0; fridgenum<3;fridgenum++){
            //System.out.println(fridge[fridgenum].toString());
            comparingstring += fridge[fridgenum].toString() + "\n";
        }
        System.out.println(comparingstring);
    }
    public boolean searchStock(String item){
        if (containsIgnoreCase(comparingstring,item)){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean containsIgnoreCase(String str, String subString) {
        return str.toLowerCase().contains(subString.toLowerCase());
    }
}
