/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxdragpanzoom.view.controls;

import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
import javafxdragpanzoom.view.views.TranslatableHomotheticPane;
import java.lang.Math;

/**
 *
 * @author flavien
 */
public class ZoomController {
    

    public ZoomController(TranslatableHomotheticPane widgetToMove) {
                
        widgetToMove.addEventFilter(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                double scrollValue = Math.pow(1.01, event.getDeltaY());
                event.consume();
                double scale = widgetToMove.scaleProperty().getValue()*scrollValue;
                widgetToMove.scaleProperty().set(scale);
                widgetToMove.appendScale(scrollValue, event.getX(), event.getY());
            }
        });
        
    }

    private static class Point {

        public Point() {
        }

        private Point(double x, double y) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
    
    
}
