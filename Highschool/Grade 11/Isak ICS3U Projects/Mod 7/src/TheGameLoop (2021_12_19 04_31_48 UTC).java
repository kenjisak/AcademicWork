import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
public class TheGameLoop extends Application{

	public static void main(String[] args) {
	launch(args);
	

	}
	
	public void start(Stage theStage){
		theStage.setTitle("AnimationTimer Example");
		
		Group root = new Group();
		Scene theScene = new Scene ( root);
		theStage.setScene (theScene);
		
		Canvas canvas = new Canvas(512, 512);
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		Image earth = new Image("earth.jpg");
		Image sun = new Image("sun.jpg");
		Image space = new Image ( "space.jpg");
		
		final long startNanoTime = System.nanoTime();
		
		new AnimationTimer(){
			public void handle(long currentNanoTime){
			double t = (currentNanoTime - startNanoTime) / 1000000000.0;
			double x = 232 + 128 * Math.cos(t);
			double y = 232 + 128 * Math.sin(t);
			
				gc.clearRect(0,0,512,512);
				
				
				gc.drawImage(space, 0, 0);
				gc.drawImage(earth, x, y);
				gc.drawImage(sun, 50, 50);
			}
		}.start();
		theStage.show();
	}

}
