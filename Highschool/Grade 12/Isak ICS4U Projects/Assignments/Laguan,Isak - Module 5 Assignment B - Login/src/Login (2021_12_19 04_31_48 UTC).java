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
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;


public class Login extends Application {

	public static void main(String[] args) {
		
		launch(args);
	}

	
	
	public static boolean checkPassword(String one,String two ){
		//used an old project to check the password,I had an array to choose a bunch of logins from but just reduced it to one. if they email and password received in the parameters are equal to the set email and pass then return true else its false.
		File textFileuser = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak - Mod 5 AsnB - Login\\src\\usernames.txt");
		File textFilepass = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak - Mod 5 AsnB - Login\\src\\passwords.txt");
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
		//used an old project to check the password,I had an array to choose a bunch of logins from but just reduced it to one. if they email and password received in the parameters are equal to the set email and pass then return true else its false.
		File textFileuser = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak - Mod 5 AsnB - Login\\src\\usernames.txt");
		
		FileReader in;
		BufferedReader readFile;
		String lineOfText;
		boolean usern = false;
		

		//try creating 2 txt files. and check the lines in both of them. add a counter to each time the line is checked and if its the same number then combo is right.
		
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
	
	
	public void start(Stage primaryStage) {
			
			
			//a log in screen shows up and has 3 different buttons, 1 to sign in if you had an existing account which you can just input the email and password, a guest sign in, and another to create a new account which brings up another form once clicked on.
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
					
						Alert.setTitle("Welcome");
						Alert.setHeaderText("Sign in successful");
						Alert.showAndWait();
						
						primaryStage.hide();
						new hello();
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
	class hello{
		hello(){
			
			Stage hi = new Stage();
			hi.setTitle("Hello World!");
			Button btn = new Button();
			btn.setText("Say 'Hello World'");
			btn.setOnAction(new EventHandler<ActionEvent>(){
				
				@Override
				public void handle(ActionEvent event) {
				System.out.println("Hello World!");
				
			}
			});
			
			StackPane root = new StackPane();
			root.getChildren().add(btn);
			hi.setScene(new Scene(root, 300, 250));
			hi.show();
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
				//gets all the text in the text boxes and sets their credentials in their new account, then welcomes them in and brings up the steam store.
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
									File textFileuser = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak - Mod 5 AsnB - Login\\src\\usernames.txt");
									out = new FileWriter(textFileuser,true);
									writeFile = new BufferedWriter(out);
									
									writeFile.newLine();
									writeFile.write(user);
	
									writeFile.close();
									out.close();
									//System.out.println("Data has been saved.");
								
								}catch (IOException e1){
									System.out.println("Problem writing to file.");
									System.err.println("IOException: " + e1.getMessage());
								}
								
								try {
									File textFilepass = new File("C:\\Users\\s400749\\workspace\\Laguan,Isak - Mod 5 AsnB - Login\\src\\passwords.txt");
									out = new FileWriter(textFilepass,true);
									writeFile = new BufferedWriter(out);
									
									writeFile.newLine();
									writeFile.write(pass);
	
									writeFile.close();
									out.close();
									//System.out.println("Data has been saved.");
									
									Alert.setTitle("New account");
									Alert.setHeaderText("A new account has been created.");
									Alert.showAndWait();
									myStageacc.hide();
									//primaryStage.show();
								}catch (IOException e1){
									System.out.println("Problem writing to file.");
									System.err.println("IOException: " + e1.getMessage());
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
