package controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import metier.ISensors;
import metier.Sensor;
import java.awt.*;

public class DigitalDisplayController {

    @FXML
    Label sensorName;

    @FXML
    Label sensorTemp;

    public void load(ISensors sensor){
        sensorName.textProperty().bind(sensor.sensorNameProperty());
        sensorTemp.textProperty().bind((sensor.temperatureProperty().asString()));
    }
}
