import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Arrays;

public class ElectronicStoreApp extends Application {
    ElectronicStore model;
    ElectronicStoreView view;
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        model = ElectronicStore.createStore();
        view = new ElectronicStoreView(model);
        String[] selectedItem = new String[100];
        Arrays.fill(selectedItem, "");
        view.getStorestocklistview().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getStorestockbutton().setDisable(false);
            }
        });
        view.getStorestockbutton().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                for(int i = 0 ; i < selectedItem.length; i++){
                    if (selectedItem[i].equals("")){
                        selectedItem[i] = view.getStorestocklistview().getSelectionModel().getSelectedItem();
                        
                        break;
                    }
                }

                view.getCurrentcartlistview().setItems(FXCollections.observableArrayList(selectedItem));
            }
        });
        primaryStage.setTitle("Electronic Store Application - Watts Up Electronics");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(view, 800,400)); // Set size of window
        primaryStage.show();
    }
}
