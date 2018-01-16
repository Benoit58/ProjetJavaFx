package business_logic.visitor;

import business_logic.sensor.ISensor;
import business_logic.sensor.Sensor;
import business_logic.sensor.SuperSensor;
import javafx.scene.Node;

import java.lang.reflect.Method;

public interface  Visitor {
     public Node visit(Sensor sensor);
     public Node visit(SuperSensor sensor);

}
