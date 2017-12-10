package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import metier.Sensor;
import model.SensorModel;

import static java.awt.SystemColor.window;

public class mainWindowControl {

    @FXML private ListView<Sensor> sensors;
    @FXML private ChoiceBox displayType;
    @FXML Button button_valid;

    SensorModel data = new SensorModel();

    public void initialize(){
        sensors.itemsProperty().bind(data.sensorProperty());
    }

    public void display(){
        button_valid.setOnAction(event -> {
            Sensor selectedSensor = sensors.getSelectionModel().getSelectedItem(); //get Sensor
            Stage window = new Stage();
            Label random = new Label();
            random.setText(selectedSensor.getSensorName());
            VBox layout = new VBox(10);
            layout.getChildren().add(random);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout, 480, 480);
            window.setScene(scene);
            window.show();
        });



    }
    

 }

