package business_logic.visitor;

import business_logic.sensor.ISensor;

public interface Visitor {
    public void visit(ISensor sensor);
    
}
