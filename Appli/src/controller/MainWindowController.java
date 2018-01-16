package controller;

import business_logic.sensor.ISensor;
import javafx.scene.layout.*;
import cellFactory.DisplayChoiceFactory;
import business_logic.sensor.SensorsManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {

    @FXML ListView<ISensor> sensorListView;
    @FXML ComboBox displayChoice;
    @FXML Button button_valid;
    @FXML TilePane panes;
    @FXML Button groupButton;

    private ISensor selectedSensor;

    public void initialize() {
        displayChoice.setItems(DisplayChoiceFactory.comboList);
        sensorListView.setItems(SensorsManager.getSensors());
        sensorListView.getSelectionModel().selectFirst();







        /*sensorListView.setOnMouseClicked(e -> selectedSensor = sensorListView.getSelectionModel().getSelectedItem());
        sensorListView.setOnDragDetected(e -> {
            if(selectedSensor != null)sensorListView.startDragAndDrop(TransferMode.ANY);
            sensorListView.setOnDragOver( event -> {
                Sensor s = (Sensor)selectedSensor;
                sensorListView.setOnMouseReleased(hover -> selectedSensor= sensorListView.getSelectionModel().getSelectedItem());
                SuperSensor superSensor = new SuperSensor(selectedSensor.getSensorName(),s);
                event.setDropCompleted(true);
                event.consume();
            });
        });*/
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
            else panes.getChildren().add(new DigitalDisplayController(sensorListView.getSelectionModel().getSelectedItem()));

    }
    @FXML
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
        //addSensorController.getSensorModel(SensorsManager.getSensors());
        add.setResizable(false);
        add.centerOnScreen();
        add.setTitle("Add new sensor");
        add.show();
    }
    @FXML
    public void addSuperSensor() throws IOException{
       /* AddSuperSensorController addSuperSensorController;
        Stage add = new Stage();
        add.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ihm/AddSuperSensor.fxml"));
        Scene windAdd = new Scene(loader.load());


        //addSuperSensorController = new AddSuperSensorController(SensorsManager.getSensors());
        //loader.setController(addSuperSensorController);
        //add.setScene(windAdd);
        add.setResizable(false);
        add.centerOnScreen();*/

        Stage addd = new Stage();
        addd.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader adddloader = new FXMLLoader(getClass().getResource("/ihm/AddSuperSensor.fxml"));
        Scene windAddd = new Scene(adddloader.load());
        addd.setScene(windAddd);
        addd.setResizable(false);
        addd.centerOnScreen();
        addd.setTitle("Add new Super sensor");
        addd.show();

    }

}

