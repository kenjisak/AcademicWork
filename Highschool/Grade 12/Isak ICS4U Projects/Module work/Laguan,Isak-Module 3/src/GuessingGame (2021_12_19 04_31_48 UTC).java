import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.Group;


public class GuessingGame extends Application{

	public static void main(String[] args) {
		launch(args);
		

	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Login Screen");
		
		
		primaryStage.show();
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		
		
		Button btnLogin = new Button ("Log in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btnLogin);
		grid.add(hbBtn, 1,4);
		
		
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1,6);
		
		Scene scene = new Scene (grid,300,275);
		
		primaryStage.setScene(scene);
		
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle,0,0,2,1);
		//set scene title
		
		Label lblUserName = new Label("User Name:");
		grid.add(lblUserName,0,1);
		//creates a new label as the user name and puts it in a certain location
		final TextField txtUserName = new TextField();
		grid.add(txtUserName,1,1);
		//creates a text field for the user to input a username
		Label lblPW = new Label("Password:");
		grid.add(lblPW, 0, 2);
		//creates a new label as the password and puts it in a certain location
		final PasswordField txtPW = new PasswordField();
		grid.add(txtPW,1,2);
		//creates a text field for the user to input a password
		btnLogin.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				
				String userName = txtUserName.getText();
				String PW = txtPW.getText();
				Boolean check = checkPassword(PW, userName);
				Boolean chek = checkPassword();
				//creates a boolean that receives the returned boolean from overloading methods
				if (check == true){
					primaryStage.hide();
					new Stage2();
					//if the right username and password is entered then it hides the main stage and brings you into the game
				}else if(txtUserName.getText().equals("") && txtPW.getText().equals("")){
					checkPassword();
					if (chek == true){
						primaryStage.hide();
						new Stage2guest();
					}
				//if the text fields are empty then it will sign in as guest and calls a different version of the game so it will say welcome guest instead of the user
				}else{
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("Wrong Login Please Try Again");
					txtUserName.clear();
					txtPW.clear();
					//if the username or password is wrong then it denies you entry and asks for it again
				}
			}
		});
		
	}
	
	class Stage2 {
		Stage2() {
			Stage myStage2 = new Stage();
			myStage2.setTitle("Guessing Game");
			Group root = new Group();
			Scene scene = new Scene(root, 300, 275);
			Button btn = new Button("Guess");
			Button btnlog = new Button("Log out");
			Button btnhint = new Button("Hint");
			btnlog.setLayoutX(240);
			btnlog.setLayoutY(240);
			btn.setLayoutX(150);
			btn.setLayoutY(240);
			btnhint.setLayoutX(200); 
			btnhint.setLayoutY(240);
			root.getChildren().add(btn);
			root.getChildren().add(btnlog);
			root.getChildren().add(btnhint);
			
			Text scenetitle = new Text("Pick a number between 1-10");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			root.getChildren().add(scenetitle);
			scenetitle.setLayoutX(25);
			scenetitle.setLayoutY(50);
			
			Text lblgreeting = new Text("Welcome Kenji" );
			lblgreeting.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			root.getChildren().add(lblgreeting);
			lblgreeting.setLayoutX(25);
			lblgreeting.setLayoutY(25);
			
			Label lblnum = new Label("Enter Number:");
			root.getChildren().add(lblnum);
			lblnum.setLayoutX(25);
			lblnum.setLayoutY(80);
			
			Label lblredo = new Label("Try again");
			lblredo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			root.getChildren().add(lblredo);
			lblredo.setLayoutX(130);
			lblredo.setLayoutY(130);
			lblredo.setVisible(false);
			
			final TextField txtnum = new TextField();
			root.getChildren().add(txtnum);
			txtnum.setLayoutX(110);
			txtnum.setLayoutY(80);
			//everything above is created to make what the game looks like, it creates a guess,hint, and log out button. it creates labels to state a greeting,enter a number, and a try again label when the user gets the number wrong
			
			txtnum.setOnMouseClicked(e -> {
				lblredo.setVisible(false);
				//if the text field is clicked, it resets the try again msg and hides it
			});
			
			int randnum = (int) (10 * Math.random() + 1);
			// creates a random number between 1 and 10
			//System.out.println(randnum);
			btn.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e){
					int number = Integer.parseInt(txtnum.getText());
					//number varable is set to what the user input is
					if (number == randnum) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Guessing Game");
						alert.setHeaderText("The Game will now Exit");
						alert.setContentText("YOU WIN!");
						alert.showAndWait().ifPresent(rs -> {
						    if (rs == ButtonType.OK) {
						    	System.exit(0);	
						    }
						});
						lblredo.setVisible(false);
						//if user input is equal to the random number generated, then it displays an alert message that you win
					}else{
						lblredo.setVisible(true);
						//otherwise the try again message is displayed and they have to guess again
					}		
				}
			});
			
			btnlog.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e){
					System.exit(0);	
					//if the logout button is pressed the game closes
				}
			});
			
			btnhint.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e){
					int number = Integer.parseInt(txtnum.getText());
					if (number>randnum){
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Guessing Game");
						alert.setHeaderText("Hint");
						alert.setContentText("Try a lower number");
						alert.showAndWait();
						//if the hint button is pressed then if the user number is higher than the random number, an alert message is shown and tells them to try a lower number
					}else if (number<randnum){
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Guessing Game");
						alert.setHeaderText("Hint");
						alert.setContentText("Try a higher number");
						alert.showAndWait();
						//if the hint button is pressed then if the user number is lower than the random number, an alert message is shown and tells them to try a higher number
					}
				}
			});
			
			
			myStage2.setScene(scene);
			myStage2.show();
		}
		}
	
	class Stage2guest {
		Stage2guest() {
			Stage myStage2 = new Stage();
			myStage2.setTitle("Guessing Game");
			Group root = new Group();
			Scene scene = new Scene(root, 300, 275);
			Button btn = new Button("Guess");
			Button btnlog = new Button("Log out");
			Button btnhint = new Button("Hint");
			btnlog.setLayoutX(240);
			btnlog.setLayoutY(240);
			btn.setLayoutX(150);
			btn.setLayoutY(240);
			btnhint.setLayoutX(200); 
			btnhint.setLayoutY(240);
			root.getChildren().add(btn);
			root.getChildren().add(btnlog);
			root.getChildren().add(btnhint);
			
			Text scenetitle = new Text("Pick a number between 1-10");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			root.getChildren().add(scenetitle);
			scenetitle.setLayoutX(25);
			scenetitle.setLayoutY(50);
			
			Text lblgreeting = new Text("Welcome Guest" );
			lblgreeting.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			root.getChildren().add(lblgreeting);
			lblgreeting.setLayoutX(25);
			lblgreeting.setLayoutY(25);
			
			Label lblnum = new Label("Enter Number:");
			root.getChildren().add(lblnum);
			lblnum.setLayoutX(25);
			lblnum.setLayoutY(80);
			
			Label lblredo = new Label("Try again");
			lblredo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			root.getChildren().add(lblredo);
			lblredo.setLayoutX(130);
			lblredo.setLayoutY(130);
			lblredo.setVisible(false);
			
			final TextField txtnum = new TextField();
			root.getChildren().add(txtnum);
			txtnum.setLayoutX(110);
			txtnum.setLayoutY(80);
			//everything above is created to make what the game looks like, it creates a guess,hint, and log out button. it creates labels to state a greeting,enter a number, and a try again label when the user gets the number wrong
			
			txtnum.setOnMouseClicked(e -> {
				lblredo.setVisible(false);
				//if the text field is clicked, it resets the try again msg and hides it
			});
			
			int randnum = (int) (10 * Math.random() + 1);
			// creates a random number between 1 and 10
			//System.out.println(randnum);
			btn.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e){
					int number = Integer.parseInt(txtnum.getText());
					//number varable is set to what the user input is
					if (number == randnum) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Guessing Game");
						alert.setHeaderText("The Game will now Exit");
						alert.setContentText("YOU WIN!");
						alert.showAndWait().ifPresent(rs -> {
						    if (rs == ButtonType.OK) {
						    	System.exit(0);	
						    }
						});
						lblredo.setVisible(false);
						//if user input is equal to the random number generated, then it displays an alert message that you win
					}else{
						lblredo.setVisible(true);
						//otherwise the try again message is displayed and they have to guess again
					}		
				}
			});
			
			btnlog.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e){
					System.exit(0);	
					//if the logout button is pressed the game closes
				}
			});
			
			btnhint.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e){
					int number = Integer.parseInt(txtnum.getText());
					if (number>randnum){
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Guessing Game");
						alert.setHeaderText("Hint");
						alert.setContentText("Try a lower number");
						alert.showAndWait();
						//if the hint button is pressed then if the user number is higher than the random number, an alert message is shown and tells them to try a lower number
					}else if (number<randnum){
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Guessing Game");
						alert.setHeaderText("Hint");
						alert.setContentText("Try a higher number");
						alert.showAndWait();
						//if the hint button is pressed then if the user number is lower than the random number, an alert message is shown and tells them to try a higher number
					}
				}
			});
			
			
			myStage2.setScene(scene);
			myStage2.show();
		}
		}

	public static boolean checkPassword(String pass, String user){
		String usern = "Kenji";
		String passw = "123";
		//the correct username and password 
		if(pass.equals(passw) && user.equals(usern)){
			return(true);
			//if the right username and password is inputed, then this method returns a boolean true so that the user may log in
		}else{
			return(false);
			//otherwise if the wrong username and password is inputed, then this method returns a boolean false so that the user has to try a different log in
		}
	}
	
	public static boolean checkPassword(){	
		return true;
	//this method returns true when it is called when the textfields are empty and the log in button is pressed so that the user enters as a guest.
	}
}
