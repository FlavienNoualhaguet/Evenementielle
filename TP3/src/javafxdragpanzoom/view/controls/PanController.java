/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxdragpanzoom.view.controls;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafxdragpanzoom.view.views.TranslatableHomotheticPane;

/**
 *
 * @author flavien
 */
public class PanController {
    
    private double startX, startY;

    public PanController(TranslatableHomotheticPane widgetToMove) {
                
        widgetToMove.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startX = event.getX();
                startY = event.getY();
            }
        });
        
        widgetToMove.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                widgetToMove.translate(event.getX() - startX , event.getY() - startY);
            }
        });
    }
    
    
}
