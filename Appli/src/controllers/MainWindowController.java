package controllers;

import display.DigitalDisplay;
import display.Display;
import cellFactory.DisplayChoiceFactory;
import display.IconDisplay;
import display.ThermoDisplay;
import metier.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {

    Display display;

    @FXML ListView<ISensors> sensorListView;
    @FXML ComboBox displayChoice;
    @FXML Button button_valid;


    public void initialize() {
        sensorListView.itemsProperty().bind(SensorsManager.sensorsProperty());
        displayChoice.setItems(DisplayChoiceFactory.comboList);
    }

    public void display() throws IOException{
        if(displayChoice.getSelectionModel().getSelectedItem() != null && sensorListView.getSelectionModel().getSelectedItem() != null){
            switch(displayChoice.getSelectionModel().getSelectedItem().toString()){
                case "Digital" :
                    display = new DigitalDisplay();
                    display.display(sensorListView.getSelectionModel().getSelectedItem());
                    break;

                case "Thermo" :
                    display = new ThermoDisplay();
                    display.display(sensorListView.getSelectionModel().getSelectedItem());
                    break;

                case "Icon" :
                    display = new IconDisplay();
                    display.display(sensorListView.getSelectionModel().getSelectedItem());
                    break;

                default :
                    throw new UnsupportedOperationException("ERROR");
            }
        }
    }

    public void addSensor()  throws IOException{
        AddSensorController addSensorController;
        Stage add = new Stage();
        add.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader addloader = new FXMLLoader(getClass().getResource("/ihm/addSensor.fxml"));
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
        addSensorController.getSensorModel(SensorsManager.getSensors());
        add.setResizable(false);
        add.centerOnScreen();

        add.setTitle("Add new sensor");
        add.show();
    }

}

