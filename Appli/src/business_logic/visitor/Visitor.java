package business_logic.visitor;

import business_logic.sensor.ISensor;

import java.lang.reflect.Method;

public abstract class Visitor {
    abstract public void visit(Object sensor);

    protected Method getMethod(Class source){
        Class  clazz = source;
        Method methodName   = null;
        while (methodName == null  &&  clazz != Object.class) {
            String clazzName = clazz.getName();
            clazzName = "visit" + clazzName.substring(clazzName.lastIndexOf('.') + 1);
            try {
                methodName = getClass().getMethod(clazzName, clazz);
            } catch (NoSuchMethodException ex) {
                clazz = clazz.getSuperclass();
            }
        }
        if (clazz == Object.class) {
            System.out.println( "Searching for interfaces" );
            Class[] interfaces = source.getInterfaces();
            for (Class intface : interfaces) {
                String interfaceName = intface.getName();
                interfaceName = "visit" + interfaceName.substring(interfaceName.lastIndexOf('.') + 1);
                try {
                    methodName = getClass().getMethod(interfaceName, intface);
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (methodName == null)
            try {
                methodName = getClass().getMethod("visitObject", Object.class);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        return methodName;
    }
}
