package model;

import metier.Sensor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SensorModel {

    private ObservableList<Sensor>  sensorList = FXCollections.observableArrayList();

    public void addSensor(){
        sensorList.add(new Sensor("Sensor 1",1));
        sensorList.add(new Sensor("Sensor 2", 2));
    }
}