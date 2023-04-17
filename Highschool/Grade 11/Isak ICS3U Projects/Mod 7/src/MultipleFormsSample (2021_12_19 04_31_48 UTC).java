import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

public class MultipleFormsSample extends Application{
	
public static void main(String[] args) {
		launch(args);
		
	}
		

		@Override
		public void start(Stage theStage) {
		theStage.setTitle( "Empty Form" );
		Group root = new Group();
		Scene theScene = new Scene(root);
		theStage.setScene(theScene);
		Canvas canvas = new Canvas (500,500);

		
		root.getChildren().add(canvas);
		/*Create a button that will open the new stage */
		Button btn = new Button("Open 2nd stage");
		btn.setLayoutX(200); //position the button
		btn.setLayoutY(200);
		root.getChildren().add(btn);
		/*Open the new stage when button is pressed */
		btn.setOnAction(eve-> new Stage2());
		
		theStage.show();
		
		}
}

/*We add a new class here for Stage 2*/
class Stage2 {
	Stage2() {

		Stage myStage2 = new Stage();
		myStage2.setTitle("2nd Stage");
		Group root = new Group();
		Scene scene = new Scene(root, 300, 200);
		Button btn = new Button("3rd Stage");
		btn.setLayoutX(100);  //position the button 
	    	btn.setLayoutY(100);
	    	root.getChildren().add(btn);
	       
	    	/*Open the new stage when button is pressed */
	    	btn.setOnAction(eve-> new Stage3());
		myStage2.setScene(scene);
		myStage2.show();
	}
}

/*We add another new class here for Stage 3*/
class Stage3 {
	Stage3() {
		Stage myStage3 = new Stage();
		myStage3.setTitle("3rd Stage");
							
		Group root = new Group();
		Scene scene = new Scene(root, 150, 100);
		
		Button btn = new Button("2nd Stage");
		btn.setLayoutX(100);  //position the button 
	    	btn.setLayoutY(100);
	    	root.getChildren().add(btn);
	    	
	    	//btn.setOnAction(eve-> new MultipleFormsSample(main) );
		myStage3.setScene(scene);
		myStage3.show();
	}

}

