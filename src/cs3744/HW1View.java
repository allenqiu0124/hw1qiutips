package cs3744;

import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

/**
 * Provides the layout and adds the different objects onto the GUI.
 *
 * @author Allen Qiu
 * @version 1
 */
public class HW1View extends GridPane {
    //The square box showing the changed color
    private Label labelColor = null;
    //The different sliders that represent the percentage values of the color
    private Slider sliderRed = null;
    private Slider sliderGreen = null;
    private Slider sliderBlue = null;
    //Labels each slider their appropriate color
    private Label labelRedName = null;
    private Label labelGreenName = null;
    private Label labelBlueName = null;
    //Displays the percentage of the color value
    private Label labelRedValue = null;
    private Label labelGreenValue = null;
    private Label labelBlueValue = null;

    /**
     * Creates an instance of HW1View class using default parameters
     */
    public HW1View() { this(0, 0, 0); }

    /**
     * Creates an instance of W1View class with specific RGB values.
     *
     * @param r The initial red component value.
     * @param g The initial green component value.
     * @param b The initial blue component value.
     */
    public HW1View(double r, double g, double b) {
        super();

        //Divides the GUI into different sections and specifies how large each section is.
        setPadding(new Insets(10, 10, 10, 10));
        setVgap(10);
        setHgap(10);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(25);
        getColumnConstraints().addAll(column1, column2, column3);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(70);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(10);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(10);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(10);
        getRowConstraints().addAll(row1, row2, row3, row4);

        //Red Sliders
        sliderRed = new Slider(0, 100, r);
        sliderRed.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(sliderRed, 1, 1);
        //Red percentage values
        labelRedValue = new Label();
        labelRedValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        labelRedValue.setId("labelRedValue");
        add(labelRedValue, 2, 1);
        //Red description
        labelRedName = new Label("Red");
        labelRedName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        labelRedName.setId("labelRedName");
        add(labelRedName, 0, 1);

        //Green Sliders
        sliderGreen = new Slider(0, 100, g);
        sliderGreen.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(sliderGreen, 1, 2);
        //Green percentage values
        labelGreenValue = new Label();
        labelGreenValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        labelGreenValue.setId("labelGreenValue");
        add(labelGreenValue, 2, 2);
        //Green description
        labelGreenName = new Label("Green");
        labelGreenName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        labelGreenName.setId("labelGreenName");
        add(labelGreenName, 0, 2);

        //Blue Sliders
        sliderBlue = new Slider(0, 100, b);
        sliderBlue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(sliderBlue, 1, 3);
        //Blue percentage values
        labelBlueValue = new Label();
        labelBlueValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        labelBlueValue.setId("labelBlueValue");
        add(labelBlueValue, 2, 3);
        //Blue description
        labelBlueName = new Label("Blue");
        labelBlueName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        labelBlueName.setId("labelBlueName");
        add(labelBlueName, 0, 3);

        //The box showing the changing colors.
        labelColor = new Label();
        labelColor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(labelColor, 0, 0, 3, 1);
        labelColor.setId("labelColor");
    }

    /**
     * Sets the new color in the view.
     *
     * @param c The new color.
     * @param r The percentage value to be displayed
     * @param g The percentage value to be displayed
     * @param b The percentage value to be displayed
     */
    public void setColor(Color c, double r, double g, double b) {
        //Calculates the actual color of the square
        labelColor.setStyle("-fx-background-color: rgb(" + c.getRed() * 100 + "%, " + c.getGreen() * 100 + "%, " + c.getBlue() * 100 + "%);");

        //Changes the RGB values to the 2 decimal places
        r = Math.round(r * 100.0) / 100.0;
        g = Math.round(g * 100.0) / 100.0;
        b = Math.round(b * 100.0) / 100.0;

        //Sets the numbers on the GUI to the rounded number. Since it's a text, we convert it to a String.
        labelRedValue.setText(Double.toString(r));
        labelGreenValue.setText(Double.toString(g));
        labelBlueValue.setText(Double.toString(b));
    }

    /**
     * Gets the red component.
     *
     * @return The red component.
     */
    public final double getRed() { return redProperty().get(); }

    /**
     * Sets the red component of light.
     *
     * @param value The red component.
     */
    public final void setRed(double value) { redProperty().set(value); }

    /**
     * Gets the red component.
     *
     * @return The red component property.
     */
    public DoubleProperty redProperty() { return sliderRed.valueProperty(); }

    /**
     * Gets the green component.
     *
     * @return The green component.
     */
    public final double getGreen() { return greenProperty().get(); }

    /**
     * Sets the green component of light.
     *
     * @param value The green component.
     */
    public final void setGreen(double value) { greenProperty().set(value); }

    /**
     * Gets the green component.
     *
     * @return The green component property.
     */
    public DoubleProperty greenProperty() { return sliderGreen.valueProperty(); }

    /**
     * Gets the blue component.
     *
     * @return The blue component.
     */
    public final double getBlue() { return blueProperty().get(); }

    /**
     * Sets the blue component of light.
     *
     * @param value The blue component.
     */
    public final void setBlue(double value) { blueProperty().set(value); }

    /**
     * Gets the blue component.
     *
     * @return The blue component property.
     */
    public DoubleProperty blueProperty() { return sliderBlue.valueProperty(); }
}
