/*
 * Module 4 Object-Oriented Programming Assignment
 * Assignment Name: Steam Store
 * Name: Kenji Isak Laguan
 * Date: March 25, 2019
 * Course: ICS4U
 * This program is meant to be a very simplified version of the Steam store. The user goes through a couple of forms, 
 * the first one once the program is launched, is a log in screen that the user can either sign in if they have an existing account, 
 * they can sign in as a guest, they can also create a new account. Once the user has chosen a way to sign in and/or have finished creating a new account, they get redirected to the 
 * Steam store which they have 6 games to choose and buy from. Once they clicked on whatever game they wanted ,it then gets added to their cart and when they are done and want to check out
 * they hit the check out button and the total cost is displayed and so is their new balance in their account.
 */
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SteamStore extends Application {
	Account account = new Account();
	public static void main(String[] args) {
		launch(args);
	}

	
	public static boolean checkPassword(String one,String two ){
		//used an old project to check the password,I had an array to choose a bunch of logins from but just reduced it to one. if they email and password received in the parameters are equal to the set email and pass then return true else its false.
		String password[]=new String[4]; 
		password[0]="021701";
		String email[]=new String[4];
		email[0]="kenjisak17@yahoo.com";
		
		
		if(one.equals(email[0]) && two.equals(password[0])){
			return true;
		}else{ 
			return false;
		}
	
	}
	public static boolean checkPassword(){	
		return true;
	//this method returns true when it is called when the textfields are empty and the log in button is pressed so that the user enters as a guest.
	}
	
	@Override
	
	public void start(Stage primaryStage) {
		
		
		//a log in screen shows up and has 3 different buttons, 1 to sign in if you had an existing account which you can just input the email and password, a guest sign in, and another to create a new account which brings up another form once clicked on.
		primaryStage.setTitle("Steam Login");
		
		primaryStage.show();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		
		Scene scene = new Scene(grid, 500, 400);
		primaryStage.setScene(scene);
		
		
		
	
		
		
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
		grid.add(scenetitle, 0, 0, 2, 1);
	
		Label userName = new Label("Email:");
		grid.add(userName,0,1);
	
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
	
		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);
	
		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
	
	
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
	
		Button btnguest = new Button("Guest sign in");
		hbBtn.getChildren().add(btnguest);
		
		Button btnnewacc = new Button("Create a new account");
		hbBtn.getChildren().add(btnnewacc);
		
	
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		
		
	
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			// if the sign in button is pressed and it checks the password with our previous method and its right then a msg box shows up and welcomes the user and brings them into the steam store otherwise a msg box pops up and declines them access.
			public void handle(ActionEvent e) {
			
				String email= userTextField.getText(); 
				String pass = pwBox.getText();
				Account account = new Account(email,pass);
				boolean tf = checkPassword(email,pass);
				Alert Alert = new Alert(AlertType.INFORMATION);
				if (tf == true){
					Alert.setTitle("Welcome");
					Alert.setHeaderText("Sign in successful");
					account = new Account(email,pass);
					Alert.setContentText("Welcome " + account.getname());
					Alert.showAndWait();

					primaryStage.hide();
					new Stage2();
				}else if (tf == false){
					
			
					Alert.setTitle("Declined");
					Alert.setHeaderText("Sign in unsuccessful");
					Alert.setContentText("Please try again");
					Alert.showAndWait();
				}
		
			}	

		
		});
		btnguest.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			//once clicked the guest user is welcomed, and brings up the steam store 
			public void handle(ActionEvent e) {
				Account account = new Account();
				Alert Alert = new Alert(AlertType.INFORMATION);
			
				Alert.setTitle("Welcome");
				Alert.setHeaderText("Sign in successful");
				Alert.setContentText("Welcome " + account.getname());
				Alert.showAndWait();

				primaryStage.hide();
				new Stage2();
			}	

		
		});
		btnnewacc.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			//once clicked it brings up a form to input all their credentials to create a new account
			public void handle(ActionEvent e) {
				primaryStage.hide();
				new Stageaccount();
			}
		});
}
	class Stageaccount{
		Stageaccount(){
			//This is a form to input all your credentials in to create a new account
			Stage myStageacc = new Stage();
			myStageacc.setTitle("New Account");
			Group root = new Group();
			Scene scene = new Scene(root, 300, 275);
			Button btn = new Button("Done");
			
			btn.setLayoutX(150);
			btn.setLayoutY(240);
		
			root.getChildren().add(btn);
			
			
			Text scenetitle = new Text("Enter your information below: ");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			root.getChildren().add(scenetitle);
			scenetitle.setLayoutX(25);
			scenetitle.setLayoutY(50);
			
			Text lblgreeting = new Text("Create a new Steam Account" );
			lblgreeting.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			root.getChildren().add(lblgreeting);
			lblgreeting.setLayoutX(25);
			lblgreeting.setLayoutY(25);
			
			Label lblemail = new Label("Email address:");
			root.getChildren().add(lblemail);
			lblemail.setLayoutX(25);
			lblemail.setLayoutY(80);
			
			final TextField txtemail = new TextField();
			root.getChildren().add(txtemail);
			txtemail.setLayoutX(110);
			txtemail.setLayoutY(80);
			
			Label lblname = new Label("Name:");
			root.getChildren().add(lblname);
			lblname.setLayoutX(25);
			lblname.setLayoutY(115);
			
			final TextField txtname = new TextField();
			root.getChildren().add(txtname);
			txtname.setLayoutX(110);
			txtname.setLayoutY(115);
			
			Label lbluser = new Label("Username:");
			root.getChildren().add(lbluser);
			lbluser.setLayoutX(25);
			lbluser.setLayoutY(150);
			
			final TextField txtuser = new TextField();
			root.getChildren().add(txtuser);
			txtuser.setLayoutX(110);
			txtuser.setLayoutY(150);
			
			Label lblpass = new Label("Password:");
			root.getChildren().add(lblpass);
			lblpass.setLayoutX(25);
			lblpass.setLayoutY(185);
			
			final TextField txtpass = new TextField();
			root.getChildren().add(txtpass);
			txtpass.setLayoutX(110);
			txtpass.setLayoutY(185);
			//everything above is created to make what the store looks like.
			myStageacc.setScene(scene);
			myStageacc.show();
			
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				//gets all the text in the text boxes and sets their credentials in their new account, then welcomes them in and brings up the steam store.
				public void handle(ActionEvent e) {
					String email = txtuser.getText(); 
					String name = txtname.getText() ;
					String user = txtuser.getText() ;
					String pass = txtpass.getText();
					Account account = new Account(email,name,user,pass);
					//System.out.println(account.getname());
					Alert Alert = new Alert(AlertType.INFORMATION);
					Alert.setTitle("Welcome");
					Alert.setHeaderText("Sign in successful");
					Alert.setContentText("Welcome " + account.getname());
					Alert.showAndWait();
					myStageacc.hide();
					new Stage2();
					}
		});
			
		}
	}
	class Stage2 {
		Stage2() {
			//This is the steam store that displays 6 games that the user can choose and buy.
			Cart cart = new Cart();
			Stage myStage2 = new Stage();
			myStage2.setTitle("Steam Store");
			Group root = new Group();
			Scene scene = new Scene(root);
			myStage2.setScene(scene);
			Canvas canvas = new Canvas(500,400);
			root.getChildren().add(canvas);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			Image r6 = new Image(getClass().getResource("r6.jpg").toExternalForm());
			gc.drawImage(r6, 20,50);
			Image gmod = new Image(getClass().getResource("gmod.jpg").toExternalForm());
			gc.drawImage(gmod, 20,120);
			Image arma = new Image(getClass().getResource("arma.jpg").toExternalForm());
			gc.drawImage(arma, 20,190);
			Image rl = new Image(getClass().getResource("rl.jpg").toExternalForm());
			gc.drawImage(rl, 20,260);
			Image metro = new Image(getClass().getResource("metro.jpg").toExternalForm());
			gc.drawImage(metro, 20,330);
			//hitbox created for the pictures of the games 
			Rectangle r6targetdata = new Rectangle(100,56);
			//root.getChildren().add(r6targetdata);
			r6targetdata.setX(20);
			r6targetdata.setY(50);
			Rectangle gmodtargetdata = new Rectangle(100,56);
			//root.getChildren().add(gmodtargetdata);
			gmodtargetdata.setX(20);
			gmodtargetdata.setY(120);
			Rectangle armatargetdata = new Rectangle(100,56);
			//root.getChildren().add(armatargetdata);
			armatargetdata.setX(20);
			armatargetdata.setY(190);
			Rectangle rltargetdata = new Rectangle(100,56);
			//root.getChildren().add(rltargetdata);
			rltargetdata.setX(20);
			rltargetdata.setY(260);
			Rectangle metrotargetdata = new Rectangle(100,56);
			//root.getChildren().add(metrotargetdata);
			metrotargetdata.setX(20);
			metrotargetdata.setY(330);
			
			Button btn = new Button("Proceed to Checkout");
			btn.setLayoutX(350);
			btn.setLayoutY(350);
			root.getChildren().add(btn);
			
			
			Text lblgreeting = new Text("What games would you like to buy?" );
			lblgreeting.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			root.getChildren().add(lblgreeting);
			lblgreeting.setLayoutX(100);
			lblgreeting.setLayoutY(25);
			
			Text lblr6 = new Text("Rainbow 6 Siege");
			lblr6.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			root.getChildren().add(lblr6);
			lblr6.setLayoutX(130);
			lblr6.setLayoutY(80);
			
			Text lblgmod = new Text("Garry's Mod");
			lblgmod.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			root.getChildren().add(lblgmod);
			lblgmod.setLayoutX(130);
			lblgmod.setLayoutY(150);
			
			Text lblarma = new Text("Arma 3");
			lblarma.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			root.getChildren().add(lblarma);
			lblarma.setLayoutX(130);
			lblarma.setLayoutY(220);
			
			Text lblrl = new Text("Rocket League");
			lblrl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			root.getChildren().add(lblrl);
			lblrl.setLayoutX(130);
			lblrl.setLayoutY(290);
			
			Text lblmetro = new Text("Metro");
			lblmetro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			root.getChildren().add(lblmetro);
			lblmetro.setLayoutX(130);
			lblmetro.setLayoutY(360);
			
			btn.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e){
					//this is the check out button, it calls methods from other classes to calculate the total cost of the games that are in the cart, then subtracts it from the users balance. Then displays this entire process in a msg box
					account.setbalance(cart.gettotal());
					Alert Alert = new Alert(AlertType.INFORMATION);
					Alert.setTitle("Steam");
					Alert.setHeaderText("Cart");
					Alert.setContentText("Your Total cost is: " + cart.gettotal() + "\nYour new account balance is $" + account.getbalance());
					Alert.showAndWait();
					System.exit(0);
				}
			});
			scene.setOnMouseClicked(new EventHandler<MouseEvent>(){
				public void handle(MouseEvent e) {
					//if the pictures of the games gets clicked on then the game gets added to the cart and a msg box pops up and informs the user.
					if (r6targetdata.contains(e.getX(),e.getY())) {
						cart.setr6();
						Alert Alert = new Alert(AlertType.INFORMATION);
						Alert.setTitle("Steam");
						Alert.setHeaderText("Cart");
						Alert.setContentText("Rainbow 6 Siege has been added");
						Alert.showAndWait();
					}else if (gmodtargetdata.contains(e.getX(),e.getY())){
						cart.setgmod();
						Alert Alert = new Alert(AlertType.INFORMATION);
						Alert.setTitle("Steam");
						Alert.setHeaderText("Cart");
						Alert.setContentText("Garry's Mod has been added");
						Alert.showAndWait();
					}else if (armatargetdata.contains(e.getX(),e.getY())){
						cart.setarma3();
						Alert Alert = new Alert(AlertType.INFORMATION);
						Alert.setTitle("Steam");
						Alert.setHeaderText("Cart");
						Alert.setContentText("Arma 3 has been added");
						Alert.showAndWait();
					}else if (rltargetdata.contains(e.getX(),e.getY())){
						cart.setrl();
						Alert Alert = new Alert(AlertType.INFORMATION);
						Alert.setTitle("Steam");
						Alert.setHeaderText("Cart");
						Alert.setContentText("Rocket League has been added");
						Alert.showAndWait();
					}else if (metrotargetdata.contains(e.getX(),e.getY())){
						cart.setmetro();
						Alert Alert = new Alert(AlertType.INFORMATION);
						Alert.setTitle("Steam");
						Alert.setHeaderText("Cart");
						Alert.setContentText("Metro has been added");
						Alert.showAndWait();
					}
				}
			});
			myStage2.show();
			
			
		}
	}
	
	
}
