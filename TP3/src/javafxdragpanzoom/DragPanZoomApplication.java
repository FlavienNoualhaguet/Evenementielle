/*
 * Author: Nicolas Saporito - ENAC
 * Direct manipulation interactions in JavaFX : drag, pan, mouse centered differentiated zoom
 */
package javafxdragpanzoom;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxdragpanzoom.view.controls.MoveWithKeyboardController;
import javafxdragpanzoom.view.controls.PanController;
import javafxdragpanzoom.view.views.TranslatableHomotheticPane;
import javafxdragpanzoom.view.views.TranslatableHomotheticPaneGrid;
import javafxdragpanzoom.view.views.TranslatableHomotheticPaneRect;
import javafxdragpanzoom.statemachines.DragStateMachine;
import javafxdragpanzoom.view.controls.DragControllerFSM;
import javafxdragpanzoom.view.controls.PanControllerFSM;
import javafxdragpanzoom.view.controls.ZoomController;

public class DragPanZoomApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Scene creation
        Group root = new Group();
        Scene scene = new Scene(root, 1024, 768);
        stage.setScene(scene);
        stage.setTitle("DragPanZoomDiffInv v4 (FSM) - Code fourni avec l'énoncé");
        stage.show();

        // Grid with pan & zoom
        TranslatableHomotheticPane grid = new TranslatableHomotheticPaneGrid();
        grid.setLayoutX(100);
        grid.setLayoutY(100);
        root.getChildren().add(grid);
        PanControllerFSM panControllerFSM = new PanControllerFSM(grid);
        ZoomController zoomController = new ZoomController(grid);

        
        // Rectangle avec drag
        TranslatableHomotheticPane rect = new TranslatableHomotheticPaneRect();
        rect.setLayoutX(450);
        rect.setLayoutY(450);
        grid.getChildren().add(rect);
        MoveWithKeyboardController moveWithKeyboardController = new MoveWithKeyboardController(rect);
        
       // PanController panController = new PanController(grid);
        DragControllerFSM dragControllerFSM = new DragControllerFSM(rect);
    }
}
