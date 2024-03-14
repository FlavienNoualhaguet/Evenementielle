package javafxdragpanzoom.view.views;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventType;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafxdragpanzoom.view.controls.ITranslatable;
import javafxdragpanzoom.view.controls.IHomothetic;

/**
 * Class describing JavaFX Pane which is translatable and whose scaling is homothetic.
 * @author Nicolas Saporito - ENAC
 */
public class TranslatableHomotheticPane extends Pane implements IHomothetic, ITranslatable {
    
    // Model for the zoom factor (in order to manage the differentiated zoom)
    // (to update when there is a scale change in the overriden xxxScale methods
    // specified in IHomothetic interface)
    private final DoubleProperty scale = new SimpleDoubleProperty(1.0);
    
    // All the transformations are to be accumulated in a single matrix
    private final Affine transforms;

    public TranslatableHomotheticPane() {
        super();
        
        // Initialize the transformation matrix
        transforms = new Affine();
        getTransforms().add(transforms);
    }
    
    /** Get the property managing the scale factor. */
    public final DoubleProperty scaleProperty() {
        return scale;
    }
    
    @Override
    public final double getScale() {
        return scale.get();
    }
    
    @Override
    public void replaceScale(double newScale) {
        this.transforms.setToIdentity();
        this.transforms.append(new Scale(newScale, newScale));
    }
    
    @Override
    public void replaceScale(double newScale, double pivotX, double pivotY) {
        this.transforms.setToIdentity();
        this.transforms.append(new Scale(newScale, newScale, pivotX, pivotY));    
    }

    @Override
    public void appendScale(double deltaScale) {
        this.transforms.append(new Scale(deltaScale,deltaScale));
    }

    @Override
    public void appendScale(double deltaScale, double pivotX, double pivotY) {
        this.transforms.append(new Scale(deltaScale,deltaScale, pivotX, pivotY));
    }

    @Override
    public void translate(double dx, double dy) {
        this.transforms.append(new Translate(dx, dy));
    }
    
    /**
     * Translation along the x axis from the transformation matrix. 
     * This property is not related to the API translateX property. 
     * Since all transformations in this class are done through a single 
     * transformation matrix, only the translation component from this matrix 
     * should be used.
     */
    public DoubleProperty txProperty() {
        return transforms.txProperty();
    }
    
    /**
     * Translation along the y axis from the transformation matrix. 
     * This property is not related to the API translateY property. 
     * Since all transformations in this class are done through a single 
     * transformation matrix, only the translation component from this matrix 
     * should be used.
     */
    public DoubleProperty tyProperty() {
        return transforms.tyProperty();
    }
}
