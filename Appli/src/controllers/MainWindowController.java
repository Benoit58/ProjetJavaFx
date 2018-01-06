package controllers;

import javafx.scene.layout.FlowPane;
import metier.cellFactory.DisplayChoiceFactory;
import metier.sensor.ISensors;
import metier.sensor.SensorsManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {

    @FXML ListView<ISensors> sensorListView;
    @FXML ComboBox displayChoice;
    @FXML Button button_valid;
    @FXML FlowPane panes;

    public void initialize() {
        sensorListView.itemsProperty().bind(SensorsManager.sensorsProperty());
        displayChoice.setItems(DisplayChoiceFactory.comboList);
        panes.setPrefWrapLength(450);
    }

    @FXML
    public void display() throws IOException{
            if(displayChoice.getSelectionModel().getSelectedItem() != null && sensorListView.getSelectionModel().getSelectedItem() != null){
                switch(displayChoice.getSelectionModel().getSelectedItem().toString()){
                    case "Digital" :
                        panes.getChildren().add(new DigitalDisplayController(sensorListView.getSelectionModel().getSelectedItem()));
                        break;

                    case "Thermo" :
                        panes.getChildren().add(new ThermoDisplayController(sensorListView.getSelectionModel().getSelectedItem()));
                        break;

                    case "Icon" :
                        panes.getChildren().add(new IconDisplayController(sensorListView.getSelectionModel().getSelectedItem()));
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
        FXMLLoader addloader = new FXMLLoader(getClass().getResource("/ihm/AddSensor.fxml"));
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

