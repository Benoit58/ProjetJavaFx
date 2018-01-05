package controllers;

import metier.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {

    @FXML ListView<ISensors> sensorListView;
    @FXML ComboBox displayChoice;

    public void initialize() {
        sensorListView.itemsProperty().bind(Manager.sensorsProperty());
    }

    public void display() throws IOException {
        DigitalDisplayController digit;
        ThermoDisplayController thermo;
        IconDIsplayController icon;

        if(displayChoice.getSelectionModel().getSelectedItem() != null && sensorListView.getSelectionModel().getSelectedItem() != null){

            switch(displayChoice.getSelectionModel().getSelectedItem().toString()){

                case "Digital":
                    Stage digitalWindow = new Stage();
                    FXMLLoader digitalLoader = new FXMLLoader(getClass().getResource("/views/digitalDisplay.fxml"));
                    digitalWindow.setScene(new Scene(digitalLoader.load()));
                    digit = digitalLoader.getController();
                    digit.load(sensorListView.getSelectionModel().getSelectedItem());
                    digitalWindow.setResizable(false);
                    digitalWindow.centerOnScreen();
                    digitalWindow.setTitle("Mon capteur");
                    digitalWindow.show();
                    break;

                case "Thermometer":

                    Stage thermometerWindow = new Stage();
                    FXMLLoader thermometerLoader = new FXMLLoader(getClass().getResource("/views/thermoDisplay.fxml"));
                    thermometerWindow.setScene(new Scene(thermometerLoader.load()));
                    thermo = thermometerLoader.getController();
                    thermo.load(sensorListView.getSelectionModel().getSelectedItem());
                    thermometerWindow.setResizable(false);
                    thermometerWindow.centerOnScreen();
                    thermometerWindow.setTitle("Mon capteur");
                    thermometerWindow.show();

                    break;

                case "Icon":
                    Stage iconWindow = new Stage();
                    FXMLLoader iconLoader = new FXMLLoader(getClass().getResource("/views/iconDisplay.fxml"));
                    iconWindow.setScene(new Scene(iconLoader.load()));
                    icon = iconLoader.getController();
                    icon.load(sensorListView.getSelectionModel().getSelectedItem());
                    iconWindow.setResizable(false);
                    iconWindow.centerOnScreen();
                    iconWindow.setTitle("Mon capteur");
                    iconWindow.show();
                    break;
            }
        }
    }

    public void addSensor()  throws IOException{
        AddSensorController addSensorController;
        Stage add = new Stage();
        add.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader addloader = new FXMLLoader(getClass().getResource("/views/addSensor.fxml"));
        Scene windAdd = new Scene(addloader.load());

        add.setScene(windAdd);
        addSensorController = addloader.getController();
        windAdd.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)) {
                addSensorController.addSensor();
            }
            if(event.getCode().equals(KeyCode.ESCAPE)) {
                addSensorController.quit();
            }
        });
        addSensorController.getSensorModel(Manager.getSensors());
        add.setResizable(false);
        add.centerOnScreen();

        add.setTitle("Add new sensor");
        add.show();
    }

}

