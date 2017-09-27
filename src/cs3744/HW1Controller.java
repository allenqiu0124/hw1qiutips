package cs3744;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;

/**
 * Homework 1 start controller class.
 * Connects model and view.
 *
 * @author Allen Qiu
 * @version 1
 */
public class HW1Controller {
    private HW1Model model = null;
    private HW1View view = null;

    /**
     * A class that describes a change listener for the model's color property.
     */
    private class ModelListener implements ChangeListener<Color> {
        @Override
        public void changed(ObservableValue<? extends Color> o, Color oldVal, Color newVal) {
            view.setColor(newVal, model.getRed(), model.getGreen(), model.getBlue());
        }
    };

    /**
     * A class that describes a change listener for the view's temperature property. The listener also checks which
     * property has been changed, and changes the color accordingly.
     */
    private class ViewListener implements ChangeListener<Number> {
        @Override
        public void changed(ObservableValue<? extends Number> o, Number oldVal, Number newVal) {
            //Checks which property of the model has been changed.
            if(o == view.redProperty())
            {
                model.setRed(newVal.doubleValue());
            }
            if (o == view.greenProperty())
            {
                model.setGreen(newVal.doubleValue());
            }
            if (o == view.blueProperty())
            {
                model.setBlue(newVal.doubleValue());
            }
        }
    }

    /**
     * Creates an instance of <code>HW1Controller</code> class.
     *
     * @param m The model object.
     * @param v The view object.
     * @param red The initial percentage value for the Red slider
     * @param green The initial percentage value for the Green slider
     * @param blue The initial percentage value for the Blue slider
     */
    public HW1Controller(HW1Model m, HW1View v, double red, double green, double blue) {
        model = m;
        view = v;
        ModelListener modelListener = new ModelListener();
        ViewListener viewListener = new ViewListener();
        //Adds listeners to the colors so we can see when they have been changed on the GUI
        model.colorProperty().addListener(modelListener);
        view.redProperty().addListener(viewListener);
        view.greenProperty().addListener(viewListener);
        view.blueProperty().addListener(viewListener);
        //If all values are passed in as 0, set the color to Black by default
        if (red == 0 && green == 0 && blue == 0)
        {
            model.setColor(Color.BLACK);
        }
        else {
            view.setRed(red);
            view.setGreen(green);
            view.setBlue(blue);
        }
    }

}
