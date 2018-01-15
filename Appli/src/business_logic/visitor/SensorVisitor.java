package business_logic.visitor;

import business_logic.sensor.ISensor;

public class SensorVisitor implements Visitor{
    public void visit(ISensor sensor);

}
