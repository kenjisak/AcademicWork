import java.util.Scanner;

public class ElectronicStore {

    private final int MAX_PRODUCTS = 10;
    public String name;
    private double revenue = 0.0;
    private Product[] products = new Product[MAX_PRODUCTS];

    public ElectronicStore(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean addProduct(Product p){
        for (int i=0; i<products.length; i++) {
            if(products[i] == null) {
                products[i] = p;
                break;
            }
        }
        return true;
    }

    public void sellProducts(){
        System.out.println(getName() + "'s Starting Stock Is:");
        printStock();
        Scanner scanner = new Scanner (System.in);
        int useritemnum;
        int useramountnum;
        do{
            useritemnum = scanner.nextInt();
            useramountnum = scanner.nextInt();
        } while ((useritemnum < 0 || useritemnum > 10) && products[useritemnum] == null && useramountnum < 0);
        sellProducts(useritemnum,useramountnum);
    }

    public void sellProducts(int item, int amount){
        if (item < 10 && products[item] != null && amount > 0){
            revenue += products[item].sellUnits(amount);
        }
    }

    public double getRevenue(){
        return revenue;
    }

    public void printStock(){
       for (int i = 0; i < products.length;i++){
           if (products[i] != null){
               System.out.print(i + ". ");
               System.out.print(products[i]+"\n");
           }
       }
    }

}
