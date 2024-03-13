package javafxdragpanzoom.view.controls;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafxdragpanzoom.view.views.TranslatableHomotheticPane;

/**
 * Controller for moving a TranslatableHomotheticPane with keyboard.
 * @author Nicolas Saporito - ENAC
 */
public class MoveWithKeyboardController {

    private static final int STEP = 50;

    /**
     * Constructor. 
     * @param widgetToMove the widget to control interaction on.
     */
    public MoveWithKeyboardController(TranslatableHomotheticPane widgetToMove) {
        // Get the scene in which the widget is placed
        Scene scene = widgetToMove.getScene();

        // Move the widget with the keyboard direction keys
        // (listening to keystrokes must be done on the scene to be active all the time)
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int dx = 0;
                int dy = 0;
                double deltaScale = 1.0;
                switch (event.getCode()) {
                    case UP:
                        dx = 0;
                        dy = -STEP;
                        break;
                    case DOWN:
                        dx = 0;
                        dy = STEP;
                        break;
                    case LEFT:
                        dx = -STEP;
                        dy = 0;
                        break;
                    case RIGHT:
                        dx = STEP;
                        dy = 0;
                        break;
                    case P:
                        dx = 0;
                        dy = 0;
                        deltaScale = 1.1;
                        break;
                    case M:
                        dx = 0;
                        dy = 0;
                        deltaScale = 0.9;
                        break;
                    default:
                        break;
                }
                // Translate
                widgetToMove.setTranslateX(widgetToMove.getTranslateX() + dx);
                widgetToMove.setTranslateY(widgetToMove.getTranslateY() + dy);
                widgetToMove.setScaleX(widgetToMove.getScaleX()*deltaScale);
                widgetToMove.setScaleY(widgetToMove.getScaleY()*deltaScale);

                // WARNING: 
                // this was just an example to show a subscription to keyboard events.
                // For the graphical transformations on the grid and the rectangle 
                // you will have to implement the methods specified in the interfaces,
                // and thus use:
                // widgetToMove.translate(dx, dy);
            }
        });
    }
}
