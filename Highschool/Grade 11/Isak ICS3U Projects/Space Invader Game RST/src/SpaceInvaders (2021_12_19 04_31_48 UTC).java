import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.animation.AnimationTimer;
public class SpaceInvaders extends Application{
    
    public static void main(String[] args) {
    
        launch(args);
    }

    class stage2{
    	//global variables
        boolean space = false ;
        boolean aliendead = false;
        boolean aliendead1 = false;
        boolean aliendead2 = false;
        boolean aliendead3 = false;
        boolean aliendead4 = false;
        boolean aliendead5 = false;
        boolean end = false;
        stage2(){
        	//creates a form
            Stage mystage2 = new Stage();
            mystage2.setTitle("Game");
            
            Group root = new Group();
            Scene scene = new Scene(root);
            
            
            Canvas canvas = new Canvas(1000, 800);
            root.getChildren().add(canvas);
            mystage2.setScene(scene);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            
            //sets the form background to black
            gc.setFill(Color.BLACK);
            gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
            
            //setting image variables
            Image alien = new Image ("alien.jpg");
            Image alien1 = new Image ("alien.jpg");
            Image alien2 = new Image ("alien.jpg");
            Image alien3 = new Image ("alien.jpg");
            Image alien4 = new Image ("alien.jpg");
            Image alien5 = new Image ("alien.jpg");
            Image done  = new Image ("Game_Over_Screen.jpg");
            Image galaga = new Image("galaga.jpg");
            
            //hitboxes
            Rectangle aliendata = new Rectangle(100,200,87,66);
            Rectangle aliendata1 = new Rectangle(250,200,87,66);
            Rectangle aliendata2 = new Rectangle(400,200,87,66);
            Rectangle aliendata3 = new Rectangle(550,200,87,66);
            Rectangle aliendata4 = new Rectangle(700,200,87,66);
            Rectangle aliendata5 = new Rectangle(850,200,87,66);
            Rectangle galagadata = new Rectangle(490, 710,68,82);
            
            //player controls
            scene.addEventFilter(KeyEvent.ANY,keyEvent ->{
                  
                // move the player right
                if (keyEvent.getCode()== KeyCode.RIGHT){
                    galagadata.setX(galagadata.getX()+30);
                    
                }
                //move the player left
                if (keyEvent.getCode()== KeyCode.LEFT) {
                    galagadata.setX(galagadata.getX()-30);
                }
                
             
            });
            
            
            //player animation
            AnimationTimer player = new AnimationTimer(){
                @Override
                public void handle(long arg0) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
                    gc.drawImage(galaga, galagadata.getX(), galagadata.getY());
                }
                
            };
            player.start();
            
            
           //alien animation. draws the alien pictures onto canvas
            AnimationTimer alientmr = new AnimationTimer(){
                @Override
                public void handle(long arg0 ) {
                    gc.drawImage(alien,aliendata.getX(),aliendata.getY());
                }
                
            };
            alientmr.start();
            
            AnimationTimer alientmr1 = new AnimationTimer(){
                @Override
                public void handle(long arg0) {
                    gc.drawImage(alien1,aliendata1.getX(),aliendata1.getY());   
                }
                
            };
            alientmr1.start();
            
            AnimationTimer alientmr2 = new AnimationTimer(){
                @Override
                public void handle(long arg0) {  
                    gc.drawImage(alien2,aliendata2.getX(),aliendata2.getY());
                }
                
            };
            alientmr2.start();
            
            AnimationTimer alientmr3 = new AnimationTimer(){
                @Override
                public void handle(long arg0) {
 
                    gc.drawImage(alien3,aliendata3.getX(),aliendata3.getY());
                }
                
            };
            alientmr3.start();
            
            AnimationTimer alientmr4 = new AnimationTimer(){
                @Override
                public void handle(long arg0) {
                    gc.drawImage(alien4,aliendata4.getX(),aliendata4.getY());
                }
                
            };
            alientmr4.start();
            
            AnimationTimer alientmr5 = new AnimationTimer(){
                @Override
                public void handle(long currentNanoTime) {
                    gc.drawImage(alien5,aliendata5.getX(),aliendata5.getY());
                }
                
            };
            alientmr5.start();
            

            //buttons for when the game is over
            Button btn = new Button("Restart");
            btn.setLayoutX(490);  //position the button 
            btn.setLayoutY(570);
                       
            Button btn1 = new Button ("End Game");
            btn1.setLayoutX(490);
            btn1.setLayoutY(610);
           
            
            btn.setOnAction(new EventHandler<ActionEvent>()  {
            	@Override
            	public void handle(ActionEvent e) {
            		new stage2();
            	}
              
            });
           
            btn1.setOnAction(new EventHandler<ActionEvent>()  {
              	@Override
              	public void handle(ActionEvent e) {
              		int i = 0 ;
              		System.exit(i );
              	}
            });
            
     
       	
            //controls when the laser shoots and its animation
            scene.addEventFilter(KeyEvent.KEY_PRESSED,keyEvent ->{
            	if (keyEvent.getCode()== KeyCode.SPACE) {                    
            		space = true; 
            		Rectangle laserdata = new Rectangle(galagadata.getX(),galagadata.getY(),5,10);
                    Image laser = new Image("laser.png");
                    // display lasers
                    AnimationTimer lasertmr = new AnimationTimer(){
               
                    	@Override
                    	public void handle(long arg0) {
                
                    		gc.drawImage(laser, laserdata.getX(), laserdata.getY());
                    		laserdata.setY(laserdata.getY()-10);
               
                    		//laser collsions
                    		if( laserdata.intersects(aliendata.getBoundsInLocal())){
                    			alientmr.stop();
                    			aliendead = true;

                    		}
                
                    		if( laserdata.intersects(aliendata1.getBoundsInLocal())){
                    			alientmr1.stop();
                    			aliendead1 = true;
                  
                    		}
                
                    		if( laserdata.intersects(aliendata2.getBoundsInLocal())){
                    			alientmr2.stop();
                    			aliendead2 = true;
                  
                    		}
                
                    		if( laserdata.intersects(aliendata3.getBoundsInLocal())){
                    			alientmr3.stop();
                    			aliendead3 = true;
              	     
                    		}
                
                    		if( laserdata.intersects(aliendata4.getBoundsInLocal())){
                    			alientmr4.stop();
                    			aliendead4 = true;
                  
                    		}
                
                    		if( laserdata.intersects(aliendata5.getBoundsInLocal())){
                    			alientmr5.stop();
                    			aliendead5 = true;
                 
                    		}
                    		// if all aliens are dead then end the game
                    		if ((aliendead == true) && (aliendead1 == true) &&( aliendead2 == true) && (aliendead3 == true) && (aliendead4 == true) && (aliendead5 == true)){
                    			end= true;

                    		}
                    		
                 
                    	}    
                    };
                    //starts the laser animation if spacebar is pressed
                    if (space == true ){
                        lasertmr.start();    
                    }        
                    //if all the aliens are dead then clears the canvas,shows the game over screen. player can choose to restart or end the game
                    if (end == true ) {
                    	gc.setFill(Color.BLACK);
                    	gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
                    	lasertmr.stop();
                    	player.stop();
                    	Alert alert = new Alert (AlertType.INFORMATION);
                    	alert.setTitle("Game");
                    	alert.setHeaderText("You Won!");
                    	alert.setContentText("You killed all the Aliens.");
                    	alert.showAndWait();
                    	gc.setFill(Color.BLACK);
                    	gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
                    	gc.drawImage(done, 300, 0);
                    	root.getChildren().add(btn);
                    	root.getChildren().add(btn1);    
                    }
                
            	}
             
            });
           

            mystage2.show();
            
        }
    }

    public void start(Stage theStage)  {
    	//creates the form and its specifications
        theStage.setTitle("Space Invaders");
        
        Group root = new Group();
        Scene theScene = new Scene ( root);
        theStage.setScene (theScene);
        
        Canvas canvas = new Canvas(1000, 800);
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //adds a black background
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        
        
        Image spaceinv = new Image ("spaceinv.jpg",500,300,false,false);
        gc.drawImage(spaceinv, 250, 0);
        
        //button starts the game when pressed and brings up the game form
        Button btn = new Button("Start Game");
        btn.setLayoutX(490);  
        btn.setLayoutY(570);
        root.getChildren().add(btn);
        
      
        btn.setOnAction(eve-> new stage2() {
            
        });
        
        //exit game when btn pressed
        Button btn1 = new Button("Exit");
        btn1.setLayoutX(490);  //position the button 
        btn1.setLayoutY(610);
        root.getChildren().add(btn1);
        
        btn1.setOnAction(new EventHandler<ActionEvent>()  {
          	@Override
          	public void handle(ActionEvent e) {
          		int i = 0 ;
          		System.exit(i );
          	}
        });
 
        theStage.show();
    
    }
}