import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 *
 * @author saporito
 */
public class Ex2_CoordinateSystems extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create a container to be the root container of the application
        Pane root = new Pane();
        
        // Create a nested container
        Pane nestedContainer = new Pane();
        root.getChildren().add(nestedContainer);
        nestedContainer.setLayoutX(100);
        nestedContainer.setLayoutY(100);
        final String STYLE = "-fx-background-color: lightgrey;";
        nestedContainer.setStyle(STYLE);
        
        Scale myScale = new Scale();
        nestedContainer.getTransforms().add(myScale);
        
        myScale.setX(2);
        myScale.setY(2);
        
        
        // Create a shape inside the nested container
        Rectangle rect = new Rectangle(150, 100);
        nestedContainer.getChildren().add(rect);
        rect.setLayoutX(100);
        rect.setLayoutY(100);
        rect.setFill(Color.BLUE);
        
        // Listen mouse clicks on rect and display coordinates in the different systems
        rect.setOnMouseClicked(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent event) {
                // Warning: 
                // Demo for coordinate system conversion API only,
                // There are better ways to get coordinates directly from an event...
                Point2D coord_in_rect = new Point2D(event.getX(), event.getY());
                
                // Question 1.2:
                // Use the conversion methods to convert coordinates from rect coord system
                // to its parent, the scene, and the stage coordinate systems...
                
                System.out.println(coord_in_rect + " in rect");
                
                Point2D coord_in_nestedContainer = rect.localToParent(coord_in_rect);
                System.out.println(coord_in_nestedContainer + " in nestedContainer");

                Point2D coord_in_scene = rect.localToScene(coord_in_rect);
                System.out.println(coord_in_scene + " in scene");
                
                Point2D coord_screen = rect.localToScreen(coord_in_rect);
                System.out.println(coord_screen + " in screen");
                
            }
        });

        // Set up root container, scene and stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Coordinate Systems");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


//            root qui est un pane (800, 600)
//                    |
//               nestedcontainer qui est un pane positionner a 100,100 par rapport a root
//                    |
//                   rect qui est un rectangle de dimension 150, 100 positionner a 100, 100 de nested container
//                    