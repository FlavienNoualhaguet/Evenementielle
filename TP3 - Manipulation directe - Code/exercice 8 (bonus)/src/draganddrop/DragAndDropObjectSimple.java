package draganddrop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Drag & Drop objects from container1 to container2.
 */
public class DragAndDropObjectSimple extends Application {
    
    private static final String STYLE_IDLE = "-fx-border-color: black; -fx-background-color: lightgrey;";
    private static final String STYLE_ACCEPT = "-fx-border-color: black; -fx-background-color: lightgreen;";
    private static final String STYLE_TEXT = "-fx-fill: sienna; -fx-font-size: 32; -fx-font-weight: bolder";

    private Text source;
    HBox container1, container2;

    @Override
    public void start(Stage stage) {
        final HBox root = new HBox();
        final Scene scene = new Scene(root, 400, 200);

        container1 = new HBox();
        container1.setStyle(STYLE_IDLE);
        container1.setMinWidth(200);
        container1.setAlignment(Pos.CENTER);
        root.getChildren().add(container1);

        container2 = new HBox();
        container2.setStyle(STYLE_IDLE);
        container2.setMinWidth(200);
        container2.setAlignment(Pos.CENTER);
        root.getChildren().add(container2);

        source = new Text(50, 100, "DRAG ME");
        source.setStyle(STYLE_TEXT);
        container1.getChildren().add(source);

        // EXERCICE 2
        // ----------
        // En vous inspirant du D&D de contenu textuel provenant du tuto "drag and drop features" de JavaFX,
        // Mettez en place des EventHandler de D&D pour réellement déplacer le composant "source"
        // depuis "container1" vers "container2" (source doit réellement changer de parent).

        // EXERCICE 3
        // ----------
        // Modifiez le code de l'exercice 2 pour maintenant faire du D&D aller/retour.
        // - "source" doit donc pouvoir être reparenté à volonté,
        // - il ne faut plus faire cette fois ci de code à façon avec des classes internes anonymes, 
        //   mais produire à la place un code réutilisable avec un seul handler pour abonner les deux conteneurs.
        //   Vous devrez donc utiliser correctement les API de Event et DragEvent pour récupérer 
        //   la source du drag et son parent ainsi que la cible du drop...

        stage.setScene(scene);
        stage.setTitle("Drag & Drop objects from container1 to container2");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
