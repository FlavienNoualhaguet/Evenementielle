package fr.enac.tictactoe.view;

import fr.enac.tictactoe.model.Player;
import fr.enac.tictactoe.model.TicTacToeModel;
import java.io.InputStream;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX version of a tic-tac-toe game.  
 * Contrary to the Swing implementation, this class is not just a container 
 * but a complete application (inheriting from javafx.application.Application)
 *
 * @author saporito
 */
public class TicTacToeJavaFXView extends Application implements IBoardGameView {

    private final TicTacToeModel model;
    private final int BOARD_SIZE;

    private final ImageView[][] squareViews;
    private ImageView nextPlayer;
    private Button buttonNew, buttonQuit;
    private MenuItem menuItemNew, menuItemQuit;

    private VBox root;

    // Resource retrieval: solution 1
    // The path to load resources is specified relative to the project root.
    // These resources will not be included in the jar when it is built.
    // When deploying the jar, it is therefore necessary to keep a relative path 
    // from the folder containing the jar identical to the one declared below 
    // (except that here it is from the root of the project).
    private final Image CROSS = new Image("file:resources/cross.jpg");
    private final Image CIRCLE = new Image("file:resources/circle.jpg");
    private final Image VOID = new Image("file:resources/void.jpg");
    // Resource retrieval: solution 2
    // Solution 1 leaves the resources accessible in the jar folder.
    // If there is a need to lock them, place them in a directory 
    // in the src folder and use getResource() to access them. 
    // The resources will then be included in the jar when it is built.
//    private final InputStream streamCross = this.getClass().getResourceAsStream("/resources/cross.jpg");
//    private final InputStream streamCircle = this.getClass().getResourceAsStream("/resources/circle.jpg");
//    private final InputStream streamVoid = this.getClass().getResourceAsStream("/resources/void.jpg");
//    private final Image CROSS = new Image(streamCross);
//    private final Image CIRCLE = new Image(streamCircle);
//    private final Image VOID = new Image(streamVoid);

    /**
     * Constructor. 
     * By subscribing this view to the model (at the end of the constructor), 
     * the latter will call the view for updates through the methods 
     * specified in the {@link IBoardGameView} interface.
     */
    public TicTacToeJavaFXView() {
        // Set up this instance
        this.model = TicTacToeModel.getInstance();
        BOARD_SIZE = model.BOARD_SIZE;
        squareViews = new ImageView[BOARD_SIZE][BOARD_SIZE];
        // The rest is done in the start(Stage primaryStage) method, automatically
        // called by the application when the initialization is effective. 
        // This avoids, among other things, potential reference leakage problems 
        // before the initialization is complete 
        // (see notes in the text and swing implementations).
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the application scene
        root = new VBox();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Tic-tac-toe JavaFX version");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        // Create the view
        createView();
        // Show the stage
        primaryStage.show();
        // Subscribe to the model so that it updates the view 
        // (by calling the methods specified by the IBoardGameView interface).
        model.subscribe(this);
    }

    /**
     * Create the view and give it the ability to modify the model (controller aspect).
     */
    private void createView() {
        // Board game
        // TODO...

        // Next player label and game control buttons
        // TODO...

        // Control bar
        // TODO...

        // menus and shortcuts
        // TODO...
    }

    @Override
    public void displayGame() {
        // TODO...
    }

    @Override
    public void displayLastMove(int lig, int col) {
        // TODO...
    }

    @Override
    public void displayError(String err) {
        // TODO...
    }

    @Override
    public void displayWinnerAndRestart(Player winner) {
        displayEndAndRestart(winner + " won!");
    }

    @Override
    public void displayEndWithNoWinnerAndRestart() {
        displayEndAndRestart("No one has won!");
    }

    private void displayEndAndRestart(String message) {
        // TODO...
    }

    @Override
    public void exit() {
        Platform.exit();
        // This method was created to exit the application as a result 
        // of a user action on the Exit button or menu. It does not manage 
        // the case of closing the window but it is not necessary in JavaFX: 
        // closing the window automatically ends the application. 
        // If the developer wants to perform a specific processing before exiting 
        // (e.g. save a file), he can redefine the stop() method.
    }

}
