package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import metier.Sensor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SensorModel {

    private ObservableList<Sensor> sensorListObs = FXCollections.observableArrayList();

    private final ListProperty<Sensor> sensors = new SimpleListProperty<>(sensorListObs);
        public ObservableList<Sensor> getSensors() { return sensors.get(); }
        public void setSensors(ObservableList<Sensor> value){sensors.set(value);}
        public ListProperty<Sensor> sensorProperty(){return sensors; }

    public  SensorModel(){
        sensorListObs.add(new Sensor("Bureau", 20, 1));
        sensorListObs.add(new Sensor("Salon", 25, 4));
        sensorListObs.add(new Sensor("Cuisine", 28, 12));
        sensorListObs.add(new Sensor("0°C", 0, 1));
        sensorListObs.add(new Sensor("100°C", 100, 1));
    }

}