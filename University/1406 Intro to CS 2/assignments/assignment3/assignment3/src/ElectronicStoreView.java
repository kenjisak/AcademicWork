import javafx.collections.FXCollections;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import java.text.DecimalFormat;

public class ElectronicStoreView extends Pane {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    ElectronicStore model;

    ListView<String> mostpopitemslistview,storestocklistview,currentcartlistview ;

    Label storesummary,storestock,currentcart,numsales,revenue,dollarpersale,mostpopitem;

    TextField numsalesfield,revenuefield,dollarpersalefield;

    Button storestockbutton,removefromcartbutton,completesalebutton,mostpopitembutton;
    Double currentcartvalue = 0.00;
    Integer numsalesvalue = 0;
    Double revenuevalue = 0.00;
    Double dollarpersalevalue = 0.00;
    String[] popitems = new String[3],storestockitems,currentcartitems;
    Product[] product;

    public ElectronicStoreView(ElectronicStore imodel){
        model = imodel;

        storesummary  = new Label("Store Summary:");
        storesummary.relocate(20,10);
        getChildren().add(storesummary);

        storestock  = new Label("Store Stock:");
        storestock.relocate(280,10);
        getChildren().add(storestock);
        storestockbutton = new Button("Add to Cart");
        storestockbutton.setDisable(true);
        storestockbutton.setPrefSize(100,30);
        storestockbutton.relocate(270,360);
        getChildren().add(storestockbutton);

        currentcart  = new Label("Current Cart($0.00):");
        currentcart.relocate(600,10);
        getChildren().add(currentcart);
        removefromcartbutton = new Button("Remove from Cart");
        removefromcartbutton.setDisable(true);
        removefromcartbutton.setPrefSize(150,30);
        removefromcartbutton.relocate(480,360);
        getChildren().add(removefromcartbutton);
        completesalebutton = new Button("Remove from Cart");
        completesalebutton.setDisable(true);
        completesalebutton.setPrefSize(150,30);
        completesalebutton.relocate(630,360);
        getChildren().add(completesalebutton);


        numsales  = new Label("# Sales:");
        numsales.relocate(20,33);
        getChildren().add(numsales);
        numsalesfield  = new TextField();
        numsalesfield.setPrefWidth(80);
        numsalesfield.relocate(65,30);
        getChildren().add(numsalesfield);

        revenue  = new Label("Revenue:");
        revenue.relocate(12,63);
        getChildren().add(revenue);
        revenuefield  = new TextField();
        revenuefield.setPrefWidth(80);
        revenuefield.relocate(65,60);
        getChildren().add(revenuefield);

        dollarpersale  = new Label("$ / Sale:");
        dollarpersale.relocate(20,93);
        getChildren().add(dollarpersale);
        dollarpersalefield  = new TextField();
        dollarpersalefield .setPrefWidth(80);
        dollarpersalefield .relocate(65,90);
        getChildren().add(dollarpersalefield );

        mostpopitem = new Label("Most Popular Items:");
        mostpopitem.relocate(30,150);
        getChildren().add(mostpopitem);
        mostpopitembutton = new Button("Reset Store");
        mostpopitembutton.setPrefSize(100,30);
        mostpopitembutton.relocate(30,360);
        getChildren().add(mostpopitembutton);

        mostpopitemslistview = new ListView<String>();
        mostpopitemslistview.setPrefSize(150,180);
        mostpopitemslistview.relocate(8,170);
        getChildren().add(mostpopitemslistview);



        storestocklistview = new ListView<String>();
        storestocklistview.setPrefSize(300,320);
        storestocklistview.relocate(166,30);
        getChildren().add(storestocklistview);

        currentcartlistview = new ListView<String>();
        currentcartlistview.setItems(FXCollections.observableArrayList(""));
        currentcartlistview.setPrefSize(300,320);
        currentcartlistview.relocate(480,30);
        getChildren().add(currentcartlistview);
        update();
        updatefieldsandlabel();
        updatesaleslistview();
    }
    public TextField getNumsalesfield(){
        return numsalesfield;
    }
    public TextField getRevenuefield(){
        return revenuefield;
    }
    public TextField getDollarpersalefield(){
        return dollarpersalefield;
    }
    public Button getStorestockbutton(){
        return storestockbutton;
    }
    public Button getRemovefromcartbutton(){
        return removefromcartbutton;
    }
    public Button getCompletesalebutton(){
        return completesalebutton;
    }
    public Button getMostpopitembutton(){
        return mostpopitembutton;
    }
    public Label getCurrentcart(){
        return currentcart;
    }
    public ListView<String> getMostpopitemslistview(){
        return mostpopitemslistview;
    }
    public ListView<String> getStorestocklistview(){
        return storestocklistview;
    }
    public ListView<String> getCurrentcartlistview(){
        return currentcartlistview;
    }

    public void update(){
        product = model.getProducts();
        storestockitems = new String[model.getCurProducts()];
        for(int i = 0; i < storestockitems.length; i++){
           storestockitems[i] = product[i].toString();
        }
        storestocklistview.setItems(FXCollections.observableArrayList(storestockitems));
    }

    public void updatefieldsandlabel(){
        getCurrentcart().setText("Current Cart($"+ currentcartvalue + "):");
        getNumsalesfield().setText(Integer.toString(numsalesvalue));
        getRevenuefield().setText(df2.format(revenuevalue));
        getDollarpersalefield().setText(df2.format(dollarpersalevalue));
        if(Double.parseDouble(getDollarpersalefield().getText()) == 0.00){
            getDollarpersalefield().setText("N/A");
        }else{
            getDollarpersalefield().setText(df2.format(dollarpersalevalue));
        }
    }
    public void updatesaleslistview(){

        Product temp1 = product[0];

        for(int i = 0; i < storestockitems.length; i++){
            if (product[i].getSoldQuantity() > temp1.getSoldQuantity()){
                temp1 = product[i];
            }
        }//biggest number out of all
        Product temp2 = product[1];
        for(int i = 0; i < storestockitems.length; i++){
            if (product[i].getSoldQuantity() > temp2.getSoldQuantity() && temp2.getSoldQuantity() < temp1.getSoldQuantity()){
                temp2 = product[i];
            }
        }

        Product temp3 = product[2];
        for(int i = 0; i < storestockitems.length; i++){
            if (product[i].getSoldQuantity() > temp3.getSoldQuantity() && temp2.getSoldQuantity() < temp1.getSoldQuantity() && temp3.getSoldQuantity() < temp2.getSoldQuantity()){
                temp3 = product[i];
            }
        }
        String[] top3 = new String[3];
        top3[0] = temp1.toString();
        top3[1] = temp2.toString();
        top3[2] = temp3.toString();

        mostpopitemslistview.setItems(FXCollections.observableArrayList(top3));
    }
}
