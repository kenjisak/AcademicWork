import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
public class FrameBasedAnimation extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	
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
				gc.drawImage(sun,196, 196);
				
				AnimatedImage ufo = new AnimatedImage();
				Image[] imageArray = new Image [6];
				for(int i = 0; i<6;i++){
					imageArray[i]=new Image("ufo_"+ i +".png");
					ufo.frames = imageArray;
					ufo.duration= 0.100;
				}
				gc.drawImage(ufo.getFrame(t), 450, 25);
			}
		}.start();
		theStage.show();
	}


}


