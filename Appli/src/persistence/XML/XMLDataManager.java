package persistence.XML;

import metier.ISensors;
import metier.DataManager;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class XMLDataManager implements DataManager {

    private final static String XML_FILE = "files/sensors.xml";

    @Override
    public List<ISensors> loadSensors(){
        List<ISensors> result = null;
        try(XMLDecoder inputStream = new XMLDecoder(new FileInputStream(XML_FILE))){
            result = ((ArrayList<XMLSensors>) inputStream.readObject()).stream().map(s -> s.getModel()).collect(Collectors.toList());
        }catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void writeSensors(List<ISensors> sensors){
        try(XMLEncoder outputStream = new XMLEncoder(new FileOutputStream(XML_FILE))){
            List<XMLSensors> list = sensors.stream().map(sens -> new XMLSensors(sens)).collect(Collectors.toList());
            outputStream.writeObject(list);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
