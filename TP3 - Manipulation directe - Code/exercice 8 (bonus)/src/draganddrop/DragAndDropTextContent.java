package draganddrop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Drag and drop basique (copie du texte, fonctionne aussi vers d'autres applications).
 */
public class DragAndDropTextContent extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 200);
        scene.setFill(Color.LIGHTGREEN);

        final Text source = new Text(50, 100, "DRAG ME");
        source.setScaleX(2.0);
        source.setScaleY(2.0);

        final Text target = new Text(250, 100, "DROP HERE");
        target.setScaleX(2.0);
        target.setScaleY(2.0);

        // EXERCICE 1
        // ----------
        // En vous inspirant du tuto "drag and drop features" de JavaFX mettez en place une interaction basique
        // de D&D permettant de transférer du texte depuis le composant "source" vers le composant "target".
        // Tuto ---> https://docs.oracle.com/javase/8/javafx/events-tutorial/drag_drop_feature.htm
        // Une fois le mécanisme compris passez à l'exercice 2 (DragAndDropObjectSimple.java) pour mettre en place 
        // un véritable D&D de composants (d'un conteneur à un autre ou entre plusieurs applications).

        root.getChildren().addAll(source, target);
        stage.setScene(scene);
        stage.setTitle("Drag & Drop text content");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
