package business_logic.visitor;

import business_logic.sensor.ISensor;

public class SensorVisitor extends Visitor{
    public void visit(Object sensor) {
        try {
            getMethod(sensor.getClass()).invoke(this, o);
        } catch (Exception ex) {
            System.out.println( "DownVisitor - no appropriate visit() method" );
        }
    }
}
