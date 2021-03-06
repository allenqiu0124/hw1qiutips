package cs3744;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;

/**
 * Homework 1 start model class.
 * Stores the values of components and color.
 *
 * @author Allen Qiu
 * @version 1
 */
class HW1Model {
    //RGB Values to be set
    private DoubleProperty red = null;
    private DoubleProperty green = null;
    private DoubleProperty blue = null;
    //The final color after calculating with all three colors combined.
    private ObjectProperty<Color> color = null;

    /**
     * A class that describes a change listener for the model's color components properties.
     */
    private class ComponentListener implements ChangeListener<Number> {
        @Override
        public void changed(ObservableValue<? extends Number> o, Number oldVal, Number newVal) {
            color.set(calculateColor(red.get(), green.get(), blue.get()));
        }
    }

    /**
     * Creates an instance of HW1Model class using default parameters
     */
    public HW1Model() { this(0, 0, 0); }

    /**
     * Creates an instance of HW1Model class.
     *
     * @param r The red component.
     * @param g The green component.
     * @param b The blue component.
     */
    public HW1Model(double r, double g, double b) {
        //Constructs the colors
        red = new SimpleDoubleProperty();
        green = new SimpleDoubleProperty();
        blue = new SimpleDoubleProperty();
        color = new SimpleObjectProperty<Color>();
        //Create a listener so we can see when the slider values change
        ComponentListener componentListener = new ComponentListener();
        red.addListener(componentListener);
        green.addListener(componentListener);
        blue.addListener(componentListener);
        //Sets the default value passed in from the Main class.
        setRed(r);
        setGreen(g);
        setBlue(g);
    }

    /**
     * Gets the red component.
     *
     * @return The red component.
     */
    public final double getRed() { return red.get(); }

    /**
     * Sets the red component.
     *
     * @param value The red component.
     */
    public final void setRed(double value) { red.set(value); }

    /**
     * Gets the red property.
     *
     * @return The red property.
     */
    public DoubleProperty redProperty() { return red; }

    /**
     * Gets the green component.
     *
     * @return The green component.
     */
    public final double getGreen() { return green.get(); }

    /**
     * Sets the green component.
     *
     * @param value The green component.
     */
    public final void setGreen(double value) { green.set(value); }

    /**
     * Gets the green property.
     *
     * @return The green property.
     */
    public DoubleProperty greenProperty() { return green; }

    /**
     * Gets the blue component.
     *
     * @return The blue component.
     */
    public final double getBlue() { return blue.get(); }

    /**
     * Sets the blue component.
     *
     * @param value The blue component.
     */
    public final void setBlue(double value) { blue.set(value); }

    /**
     * Gets the blue property.
     *
     * @return The blue property.
     */
    public DoubleProperty blueProperty() { return blue; }

    /**
     * Gets the color of the light.
     *
     * @return The color.
     */
    public final Color getColor() { return color.get(); }

    /**
     * Sets the color of the light.
     *
     * @param value The color.
     */
    public final void setColor(Color value) { color.set(value); }

    /**
     * Gets the color of the light property.
     *
     * @return The color property.
     */
    public ObjectProperty<Color> colorProperty() { return color; }

    /**
     * Calculate the color of the light based on the temperature.
     * The color components are between 0 and 100
     *
     * @param red The red component.
     * @param green The green component.
     * @param blue The blue component.
     * @return The color of the light.
     */
    private Color calculateColor(double red, double green, double blue) {
        return new Color(clamp(red, 0, 100) / 100, clamp(green, 0, 100) / 100,
                clamp(blue, 0, 100) / 100, 1);
    }

    /**
     * Clamps the value so that it is within the range specific by the minimum and maximum.
     *
     * @param v The current value.
     * @param min The minimum value.
     * @param max The maximum value.
     * @return The clamped value.
     */
    private double clamp(double v, double min, double max) { return (v < min ? min : (v > max ? max : v)); }
}