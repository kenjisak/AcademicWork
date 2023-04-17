import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
public class JavaFXForm extends Application {
int counter=0;
	public static void main(String[] args) {
		launch(args);
	}
	public static boolean checkPassword(String one,String two ){
		
		String password[]=new String[4]; 
		password[0]="ICS3U";
		password[1]="snappy";
		password[2]="123456";
		password[3]="katie1";
		String user[]=new String[4];
		user[0]="MsMcDougall";
		user[1]="John";
		user[2]="CharlieM";
		user[3]="Katie";
		
		if(one.equals(user[0]) && two.equals(password[0])){
			return true;
		}else if (one.equals(user[1]) && two.equals(password[1])){
			return true;
		}else if (one.equals(user[2]) && two.equals(password[2])){
			return true;
		}else if (one.equals(user[3]) && two.equals(password[3])){
			return true;
		}else{ 
			return false;
		}
	
	}
	
	@Override
	
	public void start(Stage primaryStage) {
		
		
		
		primaryStage.setTitle("JavaFX Welcome");
		
		primaryStage.show();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		
		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		
		
		
	
		
		
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
		grid.add(scenetitle, 0, 0, 2, 1);
	
		Label userName = new Label("User Name;");
		grid.add(userName,0,1);
	
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
	
		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);
	
		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
	
	
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
	
	
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		
		
	
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent e) {

				
				String username = userTextField.getText();
				String pass = pwBox.getText();
				
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("Sign in button pressed");
				
				
		
				boolean tf = checkPassword(username,pass);
				Alert Alert = new Alert(AlertType.INFORMATION);
				if (tf == true){
					Alert.setTitle("Welcome");
					Alert.setHeaderText("Sign in successful");
					Alert.setContentText(username + " " + pass);
					Alert.showAndWait();
				}else if (tf == false){
					
			
					Alert.setTitle("Declined");
					Alert.setHeaderText("Sign in unsuccessful");
					Alert.setContentText("Please try again");
					Alert.showAndWait();
					counter++;
					if (counter == 5){
						Alert myAlert = new Alert(AlertType.INFORMATION);
						myAlert.setTitle("Attention");
						myAlert.setHeaderText("You failed to login too many times");
						myAlert.setContentText("The window will now close");
						myAlert.showAndWait();
						System.exit(counter);
					}
				}
		
			}	

		
	});
	
		
	//grid.setGridLinesVisible(true);
}


}
