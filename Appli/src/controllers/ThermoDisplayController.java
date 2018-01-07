package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import business_logic.sensor.ISensor;

import java.io.IOException;

public class ThermoDisplayController extends GridPane {

    @FXML Label maxLabel;
    @FXML Label tempLabel;
    @FXML Label minLabel;
    @FXML Rectangle rectangle;
    @FXML Label sensorName;

    private ISensor sensor;

    public ThermoDisplayController(ISensor sensor) throws IOException{
        this.sensor = sensor;
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/ihm/ThermoDisplay.fxml"));
        Loader.setController(this);
        Loader.setRoot(this);
        Loader.load();
    }

    public void initialize(){
        sensorName.textProperty().bind(sensor.sensorNameProperty());
        tempLabel.textProperty().bind((sensor.temperatureProperty().asString()));
        rectangle.heightProperty().bind(sensor.temperatureProperty().multiply(90).divide(200).add(45));
    }
}
