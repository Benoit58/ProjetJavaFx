package business_logic.visitor;

import business_logic.sensor.ISensor;
import business_logic.sensor.Sensor;
import business_logic.sensor.SuperSensor;
import javafx.scene.Node;

import java.lang.reflect.Method;

public abstract class Visitor {
    abstract public Node visit(Sensor sensor);
    abstract public Node visit(SuperSensor sensor);

}
