package business_logic.sensor;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.*;
import javafx.collections.ObservableMap;

import java.util.*;

/**
 * Business class : SuperSensor
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class SuperSensor extends AbstractSensor {

    /**
     * Map property : list of super contained in a super sensor
     */
    private final MapProperty<ISensor,Integer> sensorMap = new SimpleMapProperty<>();
        /**
         * Get the map of Sensors
         *
         * @return an ObservableMap which corresponds to the map in the MapProperty
         */
        public ObservableMap<ISensor, Integer> getSensorMap(){return sensorMap.get();}
        /**
         * Set the sensors Map
         *
         * @param m the map to be set
         */
        public void setSensorMap(ObservableMap<ISensor, Integer> m){this.sensorMap.setValue(m);}
        /**
         * get the MapPropert of sensors
         *
         * @return a mapProperty sensorMap
         */
        public MapProperty<ISensor,Integer> sensorMapProperty(){return sensorMap;}


        private final IntegerProperty temp = new SimpleIntegerProperty();
        @Override public IntegerProperty temperatureProperty(){return temp;}

    private IntegerBinding temperature = new IntegerBinding() {
        {this.bind(temp);}
        @Override
        protected int computeValue() {
            int temperature;
            int poidsTotal= 0;
            int result = 0;
            Set<Map.Entry<ISensor,Integer>> entry = sensorMapProperty().entrySet();
            Iterator<Map.Entry<ISensor, Integer>> it = entry.iterator();
            while (it.hasNext()){
                Map.Entry<ISensor, Integer> e = it.next();
                result += e.getKey().getTemperature() * e.getValue();
                poidsTotal += e.getValue();
            }
            return result/poidsTotal;
        }
    };

    public SuperSensor(String sensorName){
        setSensorName(sensorName);
    }

    public String toString(){
        return  String.format("%s - temp : %d - (f : %d)", getSensorName(), getTemperature(), getFrequency());
    }
}
