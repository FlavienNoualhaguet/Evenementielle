/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxdragpanzoom.view.controls;

import fr.liienac.statemachine.event.Move;
import fr.liienac.statemachine.event.Press;
import fr.liienac.statemachine.event.Release;
import fr.liienac.statemachine.geometry.Point;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafxdragpanzoom.statemachines.DragStateMachine;
import javafxdragpanzoom.view.views.TranslatableHomotheticPane;

/**
 *
 * @author flavien
 */
public class PanControllerFSM {
    
    private final DragStateMachine dragStateMachine;
    
    public PanControllerFSM(TranslatableHomotheticPane widgetToMove) {
        
        dragStateMachine = new DragStateMachine();
                
        widgetToMove.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Point p = new Point(event.getX(), event.getY());
                Press press = new Press(p, widgetToMove);
                dragStateMachine.handleEvent(press);

            }
        });
        
        
        
        widgetToMove.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Point p = new Point(event.getX(), event.getY());
                Release release = new Release(p, widgetToMove);
                dragStateMachine.handleEvent(release);

            }
        });
        
        
        widgetToMove.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Point p = new Point(event.getX(), event.getY());
                Move dragged = new Move(p, widgetToMove);
                dragStateMachine.handleEvent(dragged);
            }
        });
    }
    
    
}
