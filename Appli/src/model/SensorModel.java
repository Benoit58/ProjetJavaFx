package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import metier.Sensor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SensorModel {

    private ObservableList<Sensor>  sensorList = FXCollections.observableArrayList();

    private final ListProperty<Sensor> sensors = new SimpleListProperty<>(sensorList);
    public ObservableList<Sensor> getSensors() { return sensors.get(); }

    public SensorModel(){

        sensorList.add(new Sensor("Sensor 1", 20, 1));
        sensorList.add(new Sensor("Sensor 2", 30, 4));
        sensorList.add(new Sensor("Sensor 3", -10, 12));

    }
}