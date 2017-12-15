package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.IAlgorithmStrategy;
import metier.IntervalValueStrategy;
import metier.Sensor;
import metier.SensorCell;
import model.SensorModel;

import java.io.IOException;

public class MainWindowController {

    @FXML
    private ListView<Sensor> sensorListView;
    @FXML
    Button button_valid;
    @FXML
    MenuButton displayType;
    @FXML
    ComboBox<IAlgorithmStrategy> algoChoice;

    SensorModel data = new SensorModel();

    public void initialize() {
        //sensors
        sensorListView.itemsProperty().bind(data.sensorProperty());
        sensorListView.setCellFactory(param -> new SensorCell());
        sensorListView.setPrefWidth(230);
        sensorListView.setPrefHeight(200);

        /*
        sensorListView.setCellFactory((param) -> {
            return new ListCell<Sensor>(){
                @Override
                protected void updateItem(Sensor sensor, boolean empty) {
                    super.updateItem(sensor, empty);
                    if (item == null || empty ) {
                        textProperty().bind(sensor.sensorNameProperty());
                    } else {
                        textProperty().unbind();
                        setText(null);
                        setStyle("");
                    }
                }
            };
        });
        sensorListView.getSelectionModel().selectedItemProperty().addListener((o,oldValue,newValue)->{
            if (old != null) {
                sensorName.textProperty().unbindBidirectional(oldValue.sensorNameProperty());

            }
            if (newV != null) {
                sensorName.textProperty().bindBidirectional(oldValue.sensorNameProperty());
            }
        });
*/
        //algorithm context
        IAlgorithmStrategy algoSelected = algoChoice.getSelectionModel().getSelectedItem();
        //sensors.getSelectionModel().getSelectedItem().setAlgorithmStrategy(new IntervalValueStrategy());
    }

    public void display() throws IOException {
        DigitalDisplayController digit;
        ThermoDisplayController thermo;
        IconDIsplayController icon;
        switch (displayType.getText()) {

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
                break;

            case "Icons":
                break;

        }
    }

    public void addSensor()  throws IOException{
        AddSensorController addSensorController;
        Stage add = new Stage();
        add.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader addloader = new FXMLLoader(getClass().getResource("/views/addSensor.fxml"));
        add.setScene(new Scene(addloader.load()));
        addSensorController = addloader.getController();
        addSensorController.getSensorModel(data);
        add.setResizable(false);
        add.centerOnScreen();

        add.setTitle("Add new sensor");
        add.show();
    }

}

