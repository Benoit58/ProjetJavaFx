package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import business_logic.sensor.ISensor;

import java.io.IOException;

public class DigitalDisplayController extends GridPane {

    @FXML Label sensorName;
    @FXML Label sensorTemp;
    @FXML Button deleteButton;

    private ISensor sensor;

    public DigitalDisplayController(ISensor sensor) throws IOException {
        this.sensor = sensor;
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/ihm/DigitalDisplay.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
    }

    @FXML
    public void closeDisplay(){
        this.setVisible(false);
    }

    public void initialize(){
        sensorName.textProperty().bind(sensor.sensorNameProperty());
        sensorTemp.textProperty().bind((sensor.temperatureProperty().asString()));
    }
}
