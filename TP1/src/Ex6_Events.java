import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ex6_Events extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a button
        Button btn = new Button("Click me!");
        
        // Listen to ActionEvents on button (convenience method)
   /*     btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Convenience method ActionEvent on button");
                System.out.println("    target: " + event.getTarget() + " - source:" + event.getSource() + "\n");
            }
        }); */
        btn.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Action due to btn subscription");                        
            }
        });

        // Create the root container and add the button as its child
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        root.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Action due to root subscription");
                event.consume();
            }
        });

        // Set up root container, scene and stage
        Scene scene = new Scene(root, 300, 250);
        
        root.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                System.out.println("Action due to scene subscription");
            }
        });
        
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
