import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;


public class TargetPractice extends Application {
    int points=0;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws Exception {
    
        theStage.setTitle("Empty Form");//name
        
        Group root = new Group();
        Scene theScene= new Scene(root);
        theStage.setScene(theScene);
        
        Canvas canvas = new Canvas (500,500);// size of program
        
        root.getChildren().add(canvas);//sets the size of program
        
        //import image
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image bullseye = new Image(getClass().getResource("bullseye.png").toExternalForm());
        //Image bullseye = new Image("bullseye.png");
        
        //draw blank background        
        gc.setFill(new Color(0.85,0.85,1.0,1.0));
        gc.fillRect(0, 0, 512, 512);
    //
        Rectangle targetData = new Rectangle(20,20,100,100);
        //root.getChildren().add(targetData);
    //draw image at x and y
        gc.drawImage(bullseye, 20,20);
       
        //mouse click events

        theScene.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e) {
                        System.out.println("Mouse Coordinates: "+e.getX()+", "+e.getY());
                        
           
                            
                        
                        if (targetData.contains(e.getX(),e.getY())) {//hit
                            points++;
                            //move target Data rectangle to a new random spot
                           double x=50+400 *Math.random();
                            double y=50+400 * Math.random();
                            targetData.setX(x);
                            targetData.setY(y);
                             gc.setFill(new Color(0.85,0.85,1.0,1.0));
                        gc.fillRect(0, 0, 512, 512);
                        gc.drawImage(bullseye, x,y);
                        gc.setFill(Color.ALICEBLUE);
                        String pointsText = "Points: " + points;
                        gc.fillText(pointsText,  360, 36);
                        gc.strokeText(pointsText, 360, 36);
                           
                        }else {//miss 
                            points = 0;
                        } 
                }

		
        });

        
        // displays text points
        gc.setFill(Color.ALICEBLUE);
        String pointsText = "Points: " + points;
        gc.fillText(pointsText,  360, 36);
        gc.strokeText(pointsText, 360, 36);
        
        theStage.show();
    }

}

