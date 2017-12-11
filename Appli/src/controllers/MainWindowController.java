package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import metier.Sensor;
import metier.SensorCell;
import model.SensorModel;

import java.io.IOException;

public class MainWindowController {

    @FXML
    private ListView<Sensor> sensors;
    @FXML
    Button button_valid;
    @FXML
    MenuButton displayType;

    SensorModel data = new SensorModel();


    public void initialize() {
        sensors.itemsProperty().bind(data.sensorProperty());
        sensors.setCellFactory(param -> new SensorCell());
        sensors.setPrefWidth(230);
        sensors.setPrefHeight(200);
    }

    public void display() throws IOException {
        DigitalDisplayController digit;
        ThermoDisplayController thermo;
        IconDIsplayController icon;
        switch (displayType.getText()) {

            case "Digital":
                Stage digitalWindow = new Stage();
                FXMLLoader digitalLoader = new FXMLLoader(getClass().getResource("/views/DigitalDisplay.fxml"));
                digitalWindow.setScene(new Scene(digitalLoader.load()));
                digit = digitalLoader.getController();
                digit.load(sensors.getSelectionModel().getSelectedItem());
                digitalWindow.setResizable(false);
                digitalWindow.centerOnScreen();
                digitalWindow.setTitle("Mon capteur");
                digitalWindow.show();
                break;

            case "Thermometer":
                break;

            case "Icons":
                break;

        }
    }
}