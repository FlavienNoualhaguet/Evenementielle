/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxdragpanzoom.statemachines;

import fr.liienac.statemachine.StateMachine;
import fr.liienac.statemachine.event.Move;
import fr.liienac.statemachine.event.Press;
import fr.liienac.statemachine.event.Release;
import fr.liienac.statemachine.geometry.Vector;
import javafxdragpanzoom.view.controls.ITranslatable;

/**
 *
 * @author noualhfl
 */
public class DragStateMachine extends StateMachine  {

    private double startX, startY;
    
    public DragStateMachine() {
    }

    public State idle = new State() {
        Transition press = new Transition<Press>() {
            @Override
            public State goTo(){
                return waiting;
            }
            
            @Override
            public void action () {
                
                startX = evt.p.x;
                startY = evt.p.y;
                
            }
        };
    };
    
    public State waiting = new State() {
        Transition moveHysteres = new Transition<Move>() {
            @Override
            public State goTo() {
                return dragging;
            };
            
            @Override
            protected boolean guard () {
                Vector delta = new Vector(evt.p.x - startX, evt.p.y - startY);
                return 50 <= delta.norm();
            };
        };
        
        Transition release = new Transition<Release>() {
            @Override
            public State goTo() { return idle;}
        };
    };
    
    
    public State dragging = new State() {
        Transition release = new Transition<Release>() {
            @Override
            public State goTo() {return idle;}
        };
        
        Transition move = new Transition<Move>() {
            @Override
            public void action () {
                double dx = evt.p.x - startX;
                double dy = evt.p.y - startY;
                ((ITranslatable)evt.graphicItem).translate(dx, dy);
            }
        };
    };  
}
