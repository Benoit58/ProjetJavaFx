package controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import metier.Sensor;

public class ThermoDisplayController {
    @FXML
    Label maxLabel;

    @FXML
    Label tempLabel;

    @FXML
    Label minLabel;

    @FXML
    Rectangle rectangleLabel;

    @FXML
    Label sensorName;


    public void load(Sensor sensor){
        sensorName.textProperty().bind(sensor.sensorNameProperty());
        tempLabel.textProperty().bind((sensor.temperatureProperty().asString()));
        rectangleLabel.heightProperty().bind(sensor.temperatureProperty().multiply(90).divide(200).add(45));
    }
}
