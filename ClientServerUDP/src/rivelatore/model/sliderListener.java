/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivelatore.model;

/**
 *
 * @author stoyan.botusharov
 */

	import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class sliderListener{
    public void start(Stage primaryStage) {
        // Add a scene
        VBox root = new VBox();
        Scene scene = new Scene(root, 500, 200);

        final Label betLabel = new Label("sdsd");

        final Slider betSlider = new Slider();
        betSlider.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                betLabel.textProperty().setValue(
                        String.valueOf((int) betSlider.getValue()));

            }
        });

        root.getChildren().addAll(betSlider, betLabel);
        betLabel.textProperty().setValue("abc");

        // show the stage
        primaryStage.setTitle("Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
