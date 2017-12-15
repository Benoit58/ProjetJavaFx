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
        public ListProperty<Sensor> sensorProperty(){return sensors; }

    public SensorModel(){
        sensorList.add(new Sensor("Bureau", 20, 1));
        sensorList.add(new Sensor("Salon", 25, 4));
        sensorList.add(new Sensor("Cuisine", 28, 12));
    }

}