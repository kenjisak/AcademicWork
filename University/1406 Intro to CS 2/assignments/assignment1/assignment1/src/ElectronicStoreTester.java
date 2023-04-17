import java.util.Scanner;

public class ElectronicStoreTester {
    public static void main(String[] args){
        ElectronicStore electronicstore = new ElectronicStore("Best Buy");;
        electronicstore.printStock();

        boolean loop = true;
        boolean checkstock;
        String userinput = "";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter a term to search for: ");
            userinput = scanner.nextLine();
            if (userinput.equals("quit")){
                loop = false;
                System.exit(0);
            }else{
                checkstock = electronicstore.searchStock(userinput);
                if (checkstock == true){
                    System.out.println("A matching item is contained in the store's stock.");
                }else{
                    System.out.println("No items in the store's stock match that term.");
                }
            }

        }while (loop == true);


    }
}
