package javafxdragpanzoom.view.views;

import java.util.ArrayList;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.shape.Line;

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
    private ArrayList<Line> lines;
    
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
        lines = new ArrayList();
        
        for (int i=GRID_OFFSET; i<WIDTH; i=i+GRID_OFFSET) {
            lines.add(new Line(i, 0, i, HEIGHT));
        }
        
        for (int i=GRID_OFFSET; i<HEIGHT; i=i+GRID_OFFSET) {
            lines.add(new Line(0, i, WIDTH, i));
        }
        
        getChildren().addAll(lines);
        
        ChangeListener listener = new ChangeListener<Double>(){
            @Override
            public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
                double width = 1/newValue;
                for (Line line: lines) {
                    line.strokeWidthProperty().set(width);
                }
            }
            
        };
        
        
        this.scaleProperty().addListener(listener);
        
    }
}
