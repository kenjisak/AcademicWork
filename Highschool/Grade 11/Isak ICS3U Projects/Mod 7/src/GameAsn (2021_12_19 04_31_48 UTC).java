import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;



// Animation of Earth rotating around the sun. (Hello, world!)
public class GameAsn extends Application 
{
	
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage) 
    {
    	
    	
        theStage.setTitle( "UFO Game" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 512, 512 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        // we need 4 images for this class
        // remember to move them into the src folder!
        Image earth = new Image( "earth.jpg" );
        Image sun   = new Image( "sun.jpg" );
        Image space = new Image( "space.jpg" );
        Image ufo = new Image("ufo_0.png");
        Image ufo2 = new Image("ufo_1.png");

        /*  *** ADD Code Section 1 (yellow) here *** */
        //rectangle hitbox for ufo and earth
        Rectangle ufoData = new Rectangle(10,10,25,30);
        Rectangle ufoData2 = new Rectangle(470,10,25,30);
        Circle earthData = new Circle(10,10,22);
        Circle sunData = new Circle(260,260,60);
        earthData.setFill(Color.ALICEBLUE);
        
        //only for testing
        //root.getChildren().add(sunData);
                
        final long startNanoTime = System.nanoTime();  //60 times per second
        
               
        /*  *** ADD Code Section 2 (pink) here *** */
       // controls
       theScene.addEventFilter(KeyEvent.ANY,keyEvent ->{
    	   
    	// move the ufo right
        if (keyEvent.getCode()== KeyCode.D){
        	ufoData.setX(ufoData.getX()+10);
        }
        
        //move ufo up
        if (keyEvent.getCode()== KeyCode.W) {
        	ufoData.setY(ufoData.getY()-10);
        }
        
        //move ufo left
        if (keyEvent.getCode()== KeyCode.A) {
        	ufoData.setX(ufoData.getX()-10);
        }
        
        //move ufo down
        if (keyEvent.getCode()== KeyCode.S) {
        	ufoData.setY(ufoData.getY()+10);
        }
        
        ///////////////////////////
        
    	// move the ufo right
        if (keyEvent.getCode()== KeyCode.RIGHT){
        	ufoData2.setX(ufoData2.getX()+10);
        }
        
        //move ufo up
        if (keyEvent.getCode()== KeyCode.UP) {
        	ufoData2.setY(ufoData2.getY()-10);
        }
        
        //move ufo left
        if (keyEvent.getCode()== KeyCode.LEFT) {
        	ufoData2.setX(ufoData2.getX()-10);
        }
        
        //move ufo down
        if (keyEvent.getCode()== KeyCode.DOWN) {
        	ufoData2.setY(ufoData2.getY()+10);
        }
        
       
       
       });
       
       theScene.setOnMouseClicked(new EventHandler<MouseEvent>(){
           public void handle(MouseEvent e) {
                       System.out.println("Mouse Coordinates: "+e.getX()+", "+e.getY());
           }            
       });
        new AnimationTimer(){
            public void handle(long currentNanoTime){
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 

                double x = 232 + 128 * Math.cos(t);  // move the x coordinate on a cosine path
                double y = 232 + 128 * Math.sin(t);	 // move the y coordinate on a sine path

                // background image clears canvas
                gc.drawImage( space, 0, 0 );  //draw the background
                gc.drawImage( earth, x, y );  // draw the earth in a new location each tick
                gc.drawImage( sun, 196, 196 );
                
                /*  *** ADD Code Section 3 (green) here *** */
                // move the earthData behind earth
                //(x and y are the top corner of the image, so we need to move them over and down)
                // 24 was determined using trial and error
                earthData.setCenterX(x+24);
                earthData.setCenterY(y+24);
                
                              
                
                /*  *** ADD Code Section 4 (purple) here *** */
                //add the ufo
                gc.drawImage(ufo, ufoData.getX(), ufoData.getY());
                gc.drawImage(ufo2, ufoData2.getX(), ufoData2.getY());
                /*  *** ADD Code Section 5 (orange) here *** */
                //checks if ufo is colliding with the earth
                if (ufoData.intersects(earthData.getBoundsInLocal())){
                	System.out.println("Collision");
                	this.stop();
                	
                	Alert alert = new Alert (AlertType.INFORMATION);
                	alert.setTitle("Information Dialog");
                	alert.setHeaderText("Collision!!");
                	alert.setContentText("Aliens have invaded earth");
                	alert.show();
                	
                	
                
                }
                
                if (ufoData2.intersects(earthData.getBoundsInLocal())){
                	System.out.println("Collision");
                	this.stop();
                	
                	Alert alert2 = new Alert (AlertType.INFORMATION);
                	alert2.setTitle("Information Dialog");
                	alert2.setHeaderText("Collision!!");
                	alert2.setContentText("Aliens have invaded earth");
                	alert2.show();
                }
        
              
                if (ufoData.intersects(ufoData2.getBoundsInLocal())){
                	System.out.println("Collision");
                	this.stop();
                	
                	Alert alert2 = new Alert (AlertType.INFORMATION);
                	alert2.setTitle("Information Dialog");
                	alert2.setHeaderText("Collision!!");
                	alert2.setContentText("Aliens killed each other!");
                	alert2.show();
                }
                
                if (ufoData.intersects(sunData.getBoundsInLocal())||ufoData2.intersects(sunData.getBoundsInLocal())){
                	System.out.println("Collision");
                	this.stop();
                	
                	Alert alert2 = new Alert (AlertType.INFORMATION);
                	alert2.setTitle("Information Dialog");
                	alert2.setHeaderText("Collision!!");
                	alert2.setContentText("Aliens Died in the Sun!");
                	alert2.show();
                }
                
            }    
        }.start();
        
      
       
        

        theStage.show();
       
    }
}