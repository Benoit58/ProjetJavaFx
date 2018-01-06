package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import metier.sensor.ISensors;

import java.io.IOException;

public class DigitalDisplayController extends GridPane {

    @FXML Label sensorName;
    @FXML Label sensorTemp;
    @FXML Button deleteButton;

    private ISensors sensor;

    public DigitalDisplayController(ISensors sensor) throws IOException {
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
