/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author noualhfl
 */
public class Ex4_DataModel extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        DoubleProperty myProperty = new SimpleDoubleProperty();
        
        HBox root = new HBox();
       // root.getChildren().add();
        
        Slider leftSlider = new Slider();
        TextField textField = new TextField();
        Slider rightSlider = new Slider();
        
        root.getChildren().add(leftSlider);
        root.getChildren().add(textField);
        root.getChildren().add(rightSlider);

        // Liaison du slider gauche a slider droit
        //rightSlider.valueProperty().bind(leftSlider.valueProperty());
        rightSlider.valueProperty().bindBidirectional(myProperty);
        leftSlider.valueProperty().bindBidirectional(myProperty);

        // Liaison du slider de gauche au champ texte
        //textField.textProperty().bind(leftSlider.valueProperty().asString());
        StringConverter sc = new NumberStringConverter("#.##");
        textField.textProperty().bindBidirectional(myProperty, sc);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Binding");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
