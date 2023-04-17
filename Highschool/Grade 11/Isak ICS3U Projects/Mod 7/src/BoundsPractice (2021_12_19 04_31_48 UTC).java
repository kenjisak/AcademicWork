import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
public class BoundsPractice extends Application {
	
	Shape intersectShape;
	boolean collide12 = false;
	public static void main (String [] args) {
		launch(args);
	}
	@Override
	public void start(Stage theStage) {
		 Group root = new Group();
	        Scene theScene = new Scene( root );
	        theStage.setScene( theScene );

	        Canvas canvas = new Canvas( 512, 512 );
	        root.getChildren().add( canvas );
      Circle circle3=new Circle(250,250,20);
      Circle circle4=new Circle(400,250,20);
      //Shape intersectDemo=Shape.intersect(circle3, circle4);
      circle3.setFill(Color.PURPLE);
      circle4.setFill(Color.PINK);
      root.getChildren().add(circle3);
      root.getChildren().add(circle4);
      
      if(!collide12){
    	  circle3.setCenterX(circle3.getCenterX()+1);
    	  circle4.setCenterX(circle4.getCenterX()-1);
      }
       intersectShape=Shape.intersect(circle3, circle4);
      if (intersectShape.getBoundsInLocal().getWidth()!=-1){
    	  System.out.println("3 & 4 have collided");
    	  collide12=true;
      }
      
      theScene.addEventFilter(KeyEvent.ANY, keyEvent->{
     	 if (keyEvent.getCode()==KeyCode.RIGHT) {
     		 circle3.setCenterX(circle3.getCenterX()+10);
     	 }
     	 if(keyEvent.getCode()==KeyCode.UP) {
     		circle3.setCenterY(circle3.getCenterY()-10);
     	 }
     	 if(keyEvent.getCode()==KeyCode.LEFT) {
     		circle3.setCenterX(circle3.getCenterX()-10);
     	 }
     	 if (keyEvent.getCode()==KeyCode.DOWN) {
     		circle3.setCenterY(circle3.getCenterY()+10);
     	 }
     	 
         intersectShape=Shape.intersect(circle3, circle4);
         if (intersectShape.getBoundsInLocal().getWidth()!=-1){
       	  System.out.println("3 & 4 have collided");
       	  collide12=true;
         }
      });

      
      theStage.show();
	}
    }
