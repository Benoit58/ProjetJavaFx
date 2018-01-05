package controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import metier.ISensors;
import metier.Manager;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.Sensor;
import metier.SensorCell;
import model.SensorModel;

import java.io.IOException;

public class MainWindowController {

    @FXML
    private ListView<ISensors> sensorListView;
    @FXML
    Button button_valid;
    @FXML
    ComboBox displayChoice;

    private final ObjectProperty<Manager> manager = new SimpleObjectProperty<>(new Manager());
        public Manager getManager() {return manager.get();}
        public void setManager(Manager m){manager.set(m);}
        public ObjectProperty<Manager> managerProperty() { return manager; }

    public void initialize() {
        sensorListView.itemsProperty().bind(getManager().sensorsProperty());
        sensorListView.setCellFactory((param) -> new SensorCell(getManager().getSensors()));
        sensorListView.getSelectionModel().selectedItemProperty().addListener((o, old, newV) -> getListViewSensorsListener(old, newV));
    }

    private void getListViewSensorsListener(ISensors old, ISensors newV){

    }

    public void display() throws IOException {
        DigitalDisplayController digit;
        ThermoDisplayController thermo;
        IconDIsplayController icon;

        String choice = null;
        try {
            choice = displayChoice.getValue().toString();
        }
        catch (NullPointerException e){choice = "Digital";}

        switch(choice){

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

    public void addSensor()  throws IOException{
        AddSensorController addSensorController;
        Stage add = new Stage();
        add.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader addloader = new FXMLLoader(getClass().getResource("/views/addSensor.fxml"));
        Scene windAdd = new Scene(addloader.load());

        add.setScene(windAdd);
        addSensorController = addloader.getController();
        windAdd.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)) {
                    addSensorController.addSensor();
                }
                if(event.getCode().equals(KeyCode.ESCAPE)) {
                    addSensorController.quit();
                }
            }
        });
        addSensorController.getSensorModel(getManager().getSensors());
        add.setResizable(false);
        add.centerOnScreen();

        add.setTitle("Add new sensor");
        add.show();
    }

}

