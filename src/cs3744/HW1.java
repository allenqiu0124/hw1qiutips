package cs3744;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Homework 1 start main class. This sets the window dimensions and imports the stylesheet used to format the text.
 *
 * @author Allen Qiu
 * @version 1
 */
public class HW1 extends Application {

    /**
     * Creates GUI and shows the application window.
     * Stylizes the GUI with "cs3744.css"
     *
     * @param stage Top level container.
     */
    public void start(Stage stage) {
        HW1Model model = new HW1Model();
        HW1View view = new HW1View();
        Scene scene = new Scene(view, 400, 500);
        try {
            scene.getStylesheets().add(getClass().getResource("hw1.css").toExternalForm());
        } catch(Exception e) {
            e.printStackTrace();
            //If the stylesheet is not found, throws an exception to the user
        }
        stage.setTitle("HW1 start: qiutips");
        stage.setScene(scene);
        HW1Controller controller = new HW1Controller(model, view, 0, 0, 0);
        stage.show();
    }

    /**
     * Invokes the program from the command line.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
