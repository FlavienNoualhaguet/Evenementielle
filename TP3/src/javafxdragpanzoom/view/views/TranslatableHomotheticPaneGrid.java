package javafxdragpanzoom.view.views;

import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

/**
 * Grid which is translatable and whose scaling is homothetic.
 * @author Nicolas Saporito - ENAC
 */
public class TranslatableHomotheticPaneGrid extends TranslatableHomotheticPane {
    
    // Style and size
    private final static String STYLE = "-fx-background-color: lightgrey; -fx-border-color: blue;";
    private final static int WIDTH = 600;
    private final static int HEIGHT = 600;
    private final static int GRID_OFFSET = 50;
    
    // Group to hold the grid drawings
    protected final Group grid = new Group();
    
    public TranslatableHomotheticPaneGrid() {
        super();
        
        // Add the group to this component's scene graph
        getChildren().add(grid);
        
        // Make this group transparent to mouse events
        // (we don't want to interact with the group itself)
        grid.setMouseTransparent(true);
        
        // Create the grid
        setStyle(STYLE);
        setPrefSize(WIDTH, HEIGHT);
        // ...
        
        Shape lines = new Line();
        for (int i=GRID_OFFSET; i<WIDTH; i=i+GRID_OFFSET) {
            lines = Shape.union(lines, new Line(i, 0, i, HEIGHT));
        }
        
        for (int i=GRID_OFFSET; i<HEIGHT; i=i+GRID_OFFSET) {
            lines = Shape.union(lines, new Line(0, i, WIDTH, i));
        }
        
        getChildren().add(lines);
        
    }
}
