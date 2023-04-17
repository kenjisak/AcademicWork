/*
 * RST – Game Launcher
 * Assignment Name: Game Launcher
 * Name: Kenji Isak Laguan
 * Date: June 17, 2019
 * Course: ICS4U
 * This program replicates a game launcher such as steam or origin but with a lot of missing features. Mainly it allows the user 
 * to create a new account and theyre able to purchase games from the store if they so please, as well as letting them launch the game through the library.
 * It saves their information as well so theyre able to still access their games the next time they sign into the program.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.text.DecimalFormat;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Login extends Application {
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	@Override
	public void start (Stage primaryStage) {
		new signIn();
	}
	
}

class signIn{
	Account account = new Account();
	String usercons;
	
	private static DecimalFormat df = new DecimalFormat("0.00");
	public static boolean checkPassword(String one,String two ){
		//used an old project to check the password,I had an array to choose a bunch of logins from but just reduced it to one. if they email and password received in the parameters are equal to the set email and pass then return true else its false.
		File textFileuser = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\usernames.txt");
		File textFilepass = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\passwords.txt");
		FileReader in;
		BufferedReader readFile;
		String lineOfText;
		boolean usern = false;
		boolean passw = false;
		int usercount = 0;
		int passcount = 0;
		//try creating 2 txt files. and check the lines in both of them. add a counter to each time the line is checked and if its the same number then combo is right.
		try {
			in = new FileReader(textFileuser);
			readFile = new BufferedReader(in);
			while ((lineOfText = readFile.readLine()) != null){
				//System.out.println(lineOfText);
				usercount ++;
				//System.out.println(usercount);
				
				if (lineOfText.equals(one)){
					usern = true;
					//System.out.println(usern);	
					break;
				}else{
					usern = false;
				}
				
			}
			readFile.close();
			in.close();
		} catch (FileNotFoundException e){
			System.out.println("File doesn't exist or couldn't be found");
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) { 
			System.out.println("Problem read ing file.");
			System.err.println("IOException: " + e.getMessage());
			
		}
		
		try {
			in = new FileReader(textFilepass);
			readFile = new BufferedReader(in);
			while ((lineOfText = readFile.readLine()) != null){
				//System.out.println(lineOfText);
				passcount ++;
				//System.out.println(passcount);
				
				if (lineOfText.equals(two) && passcount == usercount){
					passw = true;
					//System.out.println(passw);	
					break;
				}else{
					passw = false;
				}
				
			}
			readFile.close();
			in.close();
		} catch (FileNotFoundException e){
			System.out.println("File doesn't exist or couldn't be found");
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) { 
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
			
		}

		if (passw == true && usern == true && passcount == usercount){
			return true;
		}else{
			return false;
		}
		
	}
	public static boolean checkPassword(String one){
		//checks if the username in the account being created is already existing, if it is then it sends back a message for them to choose another username.
		File textFileuser = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\usernames.txt");
		FileReader in;
		BufferedReader readFile;
		String lineOfText;
		boolean usern = false;
		
		try {
			in = new FileReader(textFileuser);
			readFile = new BufferedReader(in);
			while ((lineOfText = readFile.readLine()) != null){
				//System.out.println(lineOfText);
				
				if (lineOfText.equals(one)){
					usern = true;
					//System.out.println(usern);	
					break;
				}else{
					usern = false;
				}		
			}
			readFile.close();
			in.close();
		} catch (FileNotFoundException e){
			System.out.println("File doesn't exist or couldn't be found");
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) { 
			System.out.println("Problem read ing file.");
			System.err.println("IOException: " + e.getMessage());
			
		}
		
		
		//if its true then username is taken
		if (usern == true){
			return true;
		}else{
			return false;
		}
		
	}

	signIn(){
		Stage primaryStage = new Stage();
			//a log in screen shows up and has 3 different buttons, 1 to sign in if you had an existing account which you can just input the email and password, a guest sign in, and another to create a new account which brings up another form once clicked on.
			//new Gamelauncher();
			primaryStage.setTitle("Sign in");
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
		
			Label userName = new Label("Username:");
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
			
			Button btnnewacc = new Button("Create a new account");
			hbBtn.getChildren().add(btnnewacc);
			
		
			final Text actiontarget = new Text();
			grid.add(actiontarget, 1, 6);
			
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				// if the sign in button is pressed and it checks the password with our previous method and its right then a msg box shows up and welcomes the user and brings them into the steam store otherwise a msg box pops up and declines them access.
				public void handle(ActionEvent e) {
				
					String user= userTextField.getText(); 
					String pass = pwBox.getText();
					Alert Alert = new Alert(AlertType.INFORMATION);
					boolean check = checkPassword(user,pass);
					
					if (check == true){
						//System.out.println("Success");
					usercons = user;
						Alert.setTitle("Welcome");
						Alert.setHeaderText("Sign in successful");
						Alert.showAndWait();
						
						primaryStage.close();
						new Gamelauncher();
					}else{
						//System.out.println("Denied");
						userTextField.setText("");
						pwBox.setText("");
						
						Alert.setTitle("Access Denied");
						Alert.setHeaderText("Invalid Username or Password, Please try again.");
						Alert.showAndWait();
					}
				}	
			});
			
			btnnewacc.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				//once clicked it brings up a form to input all their credentials to create a new account
				public void handle(ActionEvent e) {
					new Stageaccount();
				}
			});	
	}
	
	class Gamelauncher{
		Gamelauncher(){
			//This is the game launcher page, its where you can access the game store, library, and it also gives you the option to sign out
			Stage launcher = new Stage();
			launcher.setTitle("Game Launcher");
			
			Group root = new Group();
			Scene scene = new Scene(root);
			
			Canvas canvas = new Canvas(656,369);
			root.getChildren().add(canvas);
			launcher.setScene(scene);
			GraphicsContext gc = canvas.getGraphicsContext2D();

			Text lbltitle = new Text("Generic Name" );
			lbltitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			root.getChildren().add(lbltitle);
			lbltitle.setLayoutX(260);
			lbltitle.setLayoutY(25);
			
			Button btnhome = new Button("Home");
			btnhome.setLayoutX(170);
			btnhome.setLayoutY(50);
			root.getChildren().add(btnhome);
			
			Button btnstore = new Button("Store");
			btnstore.setLayoutX(250);
			btnstore.setLayoutY(50);
			root.getChildren().add(btnstore);
			
			Button btnlibrary = new Button("Library");
			btnlibrary.setLayoutX(330);
			btnlibrary.setLayoutY(50);
			root.getChildren().add(btnlibrary);
			
			Button btnsignout = new Button("Sign out");
			btnsignout.setLayoutX(410);
			btnsignout.setLayoutY(50);
			root.getChildren().add(btnsignout);
			
			Image pic = new Image("pic.jpg");
			gc.drawImage(pic,0,0);
			
			Text txthome = new Text("\nWelcome to Generic Name Launcher \nProceed to the Store to purchase more \ngames or your library to directly play \nsome games.");
			txthome.setFont(Font.font("Tahoma", FontWeight.NORMAL, 36));
			txthome.setFill(Color.WHITE);
			txthome.setStrokeWidth(1);
			txthome.setStroke(Color.BLACK);
			root.getChildren().add(txthome);
			txthome.setLayoutX(25);
			txthome.setLayoutY(100);
			
			btnhome.setOnAction(new EventHandler<ActionEvent>() {
				@Override
			
				public void handle(ActionEvent e) {
					//once clicked it does nothing because were already in home
				}
			});
			
			btnstore.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					//once clicked it brings up the store form where you can purchase games.
					new Stage2();
				}
			});
			
			btnlibrary.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					//once clicked it brings up the users library containing games they can play.
					new library();
					launcher.close();				
				}
			});
			
			btnsignout.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					launcher.close();
					//once clicked it closes the game launcher and brings back the sign in page.
				}
			});
			launcher.show();			
		}
	}
	class library{
		library(){
			//This is the game launcher's library section where the user can access their games.
			Stage library = new Stage();
			library.setTitle("Game library");
			
			Group root = new Group();
			Scene scene = new Scene(root);
			
			Canvas canvas = new Canvas(656,369);
			root.getChildren().add(canvas);
			library.setScene(scene);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			Text lbltitle = new Text("Generic Name" );
			lbltitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			root.getChildren().add(lbltitle);
			lbltitle.setLayoutX(260);
			lbltitle.setLayoutY(25);
			
			Button btnhome = new Button("Home");
			btnhome.setLayoutX(170);
			btnhome.setLayoutY(50);
			root.getChildren().add(btnhome);
			
			Button btnstore = new Button("Store");
			btnstore.setLayoutX(250);
			btnstore.setLayoutY(50);
			root.getChildren().add(btnstore);
			
			Button btnlibrary = new Button("Library");
			btnlibrary.setLayoutX(330);
			btnlibrary.setLayoutY(50);
			root.getChildren().add(btnlibrary);
			
			Button btnsignout = new Button("Sign out");
			btnsignout.setLayoutX(410);
			btnsignout.setLayoutY(50);
			root.getChildren().add(btnsignout);
			
			Image pic = new Image("pic.jpg");
			gc.drawImage(pic,0,0);
			
			Image gmod = new Image(getClass().getResource("gmod.jpg").toExternalForm());
			gc.drawImage(gmod, 20,120);
			Image r6 = new Image(getClass().getResource("r6.jpg").toExternalForm());
			gc.drawImage(r6, 140,120);
			Image arma = new Image(getClass().getResource("arma.jpg").toExternalForm());
			gc.drawImage(arma, 260,120);
			Image rl = new Image(getClass().getResource("rl.jpg").toExternalForm());
			gc.drawImage(rl, 380,120);
			Image metro = new Image(getClass().getResource("metro.jpg").toExternalForm());
			gc.drawImage(metro, 500,120);
			
			
			Button btngmod = new Button("Play Garry's Mod");
			btngmod.setLayoutX(18);
			btngmod.setLayoutY(180);
			root.getChildren().add(btngmod);
			
			Button btnr6 = new Button("Play Rainbow 6");
			btnr6.setLayoutX(142);
			btnr6.setLayoutY(180);
			root.getChildren().add(btnr6);
			
			Button btnarma = new Button("Play Arma 3");
			btnarma.setLayoutX(270);
			btnarma.setLayoutY(180);
			root.getChildren().add(btnarma);
			
			Button btnrl = new Button("Play Rocket League");
			btnrl.setLayoutX(370);
			btnrl.setLayoutY(180);
			root.getChildren().add(btnrl);
			
			Button btnmetro = new Button("Play Metro 2033");
			btnmetro.setLayoutX(500);
			btnmetro.setLayoutY(180);
			root.getChildren().add(btnmetro);
			
			//once any of the next 5 buttons are clicked, it reads the users profile to see if they have this game purchased.If it is in their library then the game launches.
			btngmod.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					File textFileuserlibrary = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\profiles\\" + usercons + ".txt");
					FileReader in;
					BufferedReader readFile;
					String lineOfText;
					boolean owned = false;
					
				
					try {
						in = new FileReader(textFileuserlibrary);
						readFile = new BufferedReader(in);
						while ((lineOfText = readFile.readLine()) != null){
							//System.out.println(lineOfText);
							
							//System.out.println(usercount);
							
							if (lineOfText.equals("gmod")){
								owned = true;
								System.out.println("Works");
								//System.out.println(usern);	
								break;
							}else{
								owned = false;
							}
							
						}
						readFile.close();
						in.close();
					} catch (FileNotFoundException e1){
						System.out.println("File doesn't exist or couldn't be found");
						System.err.println("FileNotFoundException: " + e1.getMessage());
					} catch (IOException e1) { 
						System.out.println("Problem reading file.");
						System.err.println("IOException: " + e1.getMessage());
						
					}
				}
			});
			
			btnr6.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					File textFileuserlibrary = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\profiles\\" + usercons + ".txt");
					FileReader in;
					BufferedReader readFile;
					String lineOfText;
					boolean owned = false;

					try {
						in = new FileReader(textFileuserlibrary);
						readFile = new BufferedReader(in);
						while ((lineOfText = readFile.readLine()) != null){
							//System.out.println(lineOfText);
							//System.out.println(usercount);
							if (lineOfText.equals("r6")){
								owned = true;
								System.out.println("Works r6");
								//System.out.println(usern);	
								break;
							}else{
								owned = false;
							}
						}
						readFile.close();
						in.close();
					} catch (FileNotFoundException e1){
						System.out.println("File doesn't exist or couldn't be found");
						System.err.println("FileNotFoundException: " + e1.getMessage());
					} catch (IOException e1) { 
						System.out.println("Problem reading file.");
						System.err.println("IOException: " + e1.getMessage());
						
					}	
				}
			});
			
			btnarma.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					File textFileuserlibrary = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\profiles\\" + usercons + ".txt");
					FileReader in;
					BufferedReader readFile;
					String lineOfText;
					boolean owned = false;
					
				
					try {
						in = new FileReader(textFileuserlibrary);
						readFile = new BufferedReader(in);
						while ((lineOfText = readFile.readLine()) != null){
							//System.out.println(lineOfText);
							
							//System.out.println(usercount);
							
							if (lineOfText.equals("arma")){
								owned = true;
								System.out.println("Works arma");
								//System.out.println(usern);	
								break;
							}else{
								owned = false;
							}
							
						}
						readFile.close();
						in.close();
					} catch (FileNotFoundException e1){
						System.out.println("File doesn't exist or couldn't be found");
						System.err.println("FileNotFoundException: " + e1.getMessage());
					} catch (IOException e1) { 
						System.out.println("Problem reading file.");
						System.err.println("IOException: " + e1.getMessage());
						
					}
					
					
					
				}
			});
			
			btnrl.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					File textFileuserlibrary = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\profiles\\" + usercons + ".txt");
					FileReader in;
					BufferedReader readFile;
					String lineOfText;
					boolean owned = false;
					
				
					try {
						in = new FileReader(textFileuserlibrary);
						readFile = new BufferedReader(in);
						while ((lineOfText = readFile.readLine()) != null){
							//System.out.println(lineOfText);
							
							//System.out.println(usercount);
							
							if (lineOfText.equals("rl")){
								owned = true;
								System.out.println("Works rl");
								//System.out.println(usern);	
								break;
							}else{
								owned = false;
							}
							
						}
						readFile.close();
						in.close();
					} catch (FileNotFoundException e1){
						System.out.println("File doesn't exist or couldn't be found");
						System.err.println("FileNotFoundException: " + e1.getMessage());
					} catch (IOException e1) { 
						System.out.println("Problem reading file.");
						System.err.println("IOException: " + e1.getMessage());
						
					}
					
					
					
				}
			});
			
			btnmetro.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					File textFileuserlibrary = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\profiles\\" + usercons + ".txt");
					FileReader in;
					BufferedReader readFile;
					String lineOfText;
					boolean owned = false;
					
				
					try {
						in = new FileReader(textFileuserlibrary);
						readFile = new BufferedReader(in);
						while ((lineOfText = readFile.readLine()) != null){
							//System.out.println(lineOfText);
							
							//System.out.println(usercount);
							
							if (lineOfText.equals("metro")){
								owned = true;
								System.out.println("Works metro");
								//System.out.println(usern);	
								break;
							}else{
								owned = false;
							}
							
						}
						readFile.close();
						in.close();
					} catch (FileNotFoundException e1){
						System.out.println("File doesn't exist or couldn't be found");
						System.err.println("FileNotFoundException: " + e1.getMessage());
					} catch (IOException e1) { 
						System.out.println("Problem reading file.");
						System.err.println("IOException: " + e1.getMessage());
						
					}
				}
			});
			
			
			btnhome.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				//once clicked it brings up the home page and closes the library page. 
				public void handle(ActionEvent e) {
		
					new Gamelauncher();
					library.close();
				}
			});
			
			btnstore.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				//once clicked it brings up the store page where the user can purchase games
				public void handle(ActionEvent e) {
					
					new Stage2();
					
				}
			});
			
			btnlibrary.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				//once clicked it does nothing because were already in the library
				public void handle(ActionEvent e) {

				}
			});
			
			btnsignout.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				//once clicked it logs the user out and closes the game launcher. It then brings the user back to the sign in page again.
				public void handle(ActionEvent e) {

						library.close();
						new signIn();
				}
			});
			library.show();			
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
					Alert.setContentText("Your Total cost is: " + df.format(cart.gettotal()) + "\nYour new account balance is $" + df.format(account.getbalance()));
					Alert.showAndWait();
					
					if (cart.getgmod() == 1){
						//If gmod is purchased then it writes it into the users profile so they have it in their library.
						FileWriter out; 
						BufferedWriter writeFile;

						try {
							File textFileuser = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\profiles\\" + usercons +".txt");
							out = new FileWriter(textFileuser,true);
							writeFile = new BufferedWriter(out);
							
							writeFile.newLine();
							writeFile.write("gmod");

							writeFile.close();
							out.close();
							//System.out.println("Data has been saved.");
						
						}catch (IOException e1){
							System.out.println("Problem writing to file.");
							System.err.println("IOException: " + e1.getMessage());
						}

					}
					
					if (cart.getr6() == 1){
						//If r6 is purchased then it writes it into the users profile so they have it in their library.
						FileWriter out; 
						BufferedWriter writeFile;

						
						try {
							File textFileuser = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\profiles\\" + usercons +".txt");
							out = new FileWriter(textFileuser,true);
							writeFile = new BufferedWriter(out);
							
							writeFile.newLine();
							writeFile.write("r6");

							writeFile.close();
							out.close();
							//System.out.println("Data has been saved.");
						
						}catch (IOException e1){
							System.out.println("Problem writing to file.");
							System.err.println("IOException: " + e1.getMessage());
						}	
					}
					
					if (cart.getarma3() == 1){
						//If arma3 is purchased then it writes it into the users profile so they have it in their library.
						FileWriter out; 
						BufferedWriter writeFile;

						
						try {
							File textFileuser = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\profiles\\" + usercons +".txt");
							out = new FileWriter(textFileuser,true);
							writeFile = new BufferedWriter(out);
							
							writeFile.newLine();
							writeFile.write("arma");

							writeFile.close();
							out.close();
							//System.out.println("Data has been saved.");
						
						}catch (IOException e1){
							System.out.println("Problem writing to file.");
							System.err.println("IOException: " + e1.getMessage());
						}
					}
					
					if (cart.getrl() == 1){
						//If rl is purchased then it writes it into the users profile so they have it in their library.
						FileWriter out; 
						BufferedWriter writeFile;

						
						try {
							File textFileuser = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\profiles\\" + usercons +".txt");
							out = new FileWriter(textFileuser,true);
							writeFile = new BufferedWriter(out);
							
							writeFile.newLine();
							writeFile.write("rl");

							writeFile.close();
							out.close();
							//System.out.println("Data has been saved.");
						
						}catch (IOException e1){
							System.out.println("Problem writing to file.");
							System.err.println("IOException: " + e1.getMessage());
						}	
					}
					
					if (cart.getmetro() == 1){
						//If metro is purchased then it writes it into the users profile so they have it in their library.
						FileWriter out; 
						BufferedWriter writeFile;

						
						try {
							File textFileuser = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\profiles\\" + usercons +".txt");
							out = new FileWriter(textFileuser,true);
							writeFile = new BufferedWriter(out);
							
							writeFile.newLine();
							writeFile.write("metro");

							writeFile.close();
							out.close();
							//System.out.println("Data has been saved.");
						
						}catch (IOException e1){
							System.out.println("Problem writing to file.");
							System.err.println("IOException: " + e1.getMessage());
						}
					}
					
					myStage2.close();
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
			
			Text lblgreeting = new Text("Create a new Account" );
			lblgreeting.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			root.getChildren().add(lblgreeting);
			lblgreeting.setLayoutX(25);
			lblgreeting.setLayoutY(25);
			
			Label lbluser = new Label("Username:");
			root.getChildren().add(lbluser);
			lbluser.setLayoutX(25);
			lbluser.setLayoutY(80);
			
			final TextField txtuser = new TextField();
			root.getChildren().add(txtuser);
			txtuser.setLayoutX(110);
			txtuser.setLayoutY(80);
			
			Label lblpass = new Label("Password:");
			root.getChildren().add(lblpass);
			lblpass.setLayoutX(25);
			lblpass.setLayoutY(115);
			
			final TextField txtpass = new TextField();
			root.getChildren().add(txtpass);
			txtpass.setLayoutX(110);
			txtpass.setLayoutY(115);
			
			Label lblconpass = new Label("Confirm Pass:");
			root.getChildren().add(lblconpass);
			lblconpass.setLayoutX(25);
			lblconpass.setLayoutY(150);
			
			final TextField txtconpass = new TextField();
			root.getChildren().add(txtconpass);
			txtconpass.setLayoutX(110);
			txtconpass.setLayoutY(150);
			
			//everything above is created to make what the store looks like.
			myStageacc.setScene(scene);
			myStageacc.show();
			
			
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				//gets all the text in the text boxes and sets their credentials in their new account.
				public void handle(ActionEvent e) {
		
					String user = txtuser.getText(); 
					String pass = txtpass.getText() ;
					String conpass = txtconpass.getText() ;
					Alert Alert = new Alert(AlertType.INFORMATION);
					
					if (user.equals("")|| pass.equals("")||conpass.equals("")){
						Alert.setTitle("Incomplete");
						Alert.setHeaderText("Please complete your information.");
						Alert.showAndWait();
					}else{
						if(pass.equals(conpass)){
							//check if username is taken
							boolean check = checkPassword(user);
						
							if(check == true){
								Alert.setTitle("Error");
								Alert.setHeaderText("Username already exists.");
								Alert.showAndWait();
							}else{
								
								FileWriter out; 
								BufferedWriter writeFile;
	
								
								try {
									File textFileuser = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\usernames.txt");
									out = new FileWriter(textFileuser,true);
									writeFile = new BufferedWriter(out);
									
									writeFile.newLine();
									writeFile.write(user);
	
									writeFile.close();
									out.close();
								
								}catch (IOException e1){
									System.out.println("Problem writing to file.");
									System.err.println("IOException: " + e1.getMessage());
								}
								
								try {
									File textFilepass = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\passwords.txt");
									out = new FileWriter(textFilepass,true);
									writeFile = new BufferedWriter(out);
									
									writeFile.newLine();
									writeFile.write(pass);
	
									writeFile.close();
									out.close();

									Alert.setTitle("New account");
									Alert.setHeaderText("A new account has been created.");
									Alert.showAndWait();
									
									myStageacc.close();
								}catch (IOException e1){
									System.out.println("Problem writing to file.");
									System.err.println("IOException: " + e1.getMessage());
								}
								
								File textFileprofile = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak-RST Game Launcher\\src\\profiles\\" + user + ".txt");
								
								if(textFileprofile.exists()){
									System.out.println("File already exists.");
								}else{
									try {
										textFileprofile.createNewFile();
									//	System.out.println("New file created.");
									} catch (IOException e1) {
										System.out.println("File could not be created.");
										System.err.println("IOException: " + e1.getMessage());
									}
								}
							}
							txtuser.setText("");
							txtpass.setText("");
							txtconpass.setText("");
						}else{ 
							txtuser.setText("");
							txtpass.setText("");
							txtconpass.setText("");
							System.out.println("Passwords don't match.");
						}
					}
				}
		});
			
		}
	}

}
