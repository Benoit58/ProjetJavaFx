package persistence.xml;

import metier.ISensors;
import persistence.DataManager;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class XMLDataManager implements DataManager {

    private final static String XML_FILE = "files/sensors.xml";

    @Override
    public List<ISensors> loadSensors() {
        List<ISensors> result = null;
        try (XMLDecoder ois = new XMLDecoder(new FileInputStream(XML_FILE))) {
            result = ((ArrayList<XMLSensors>)ois.readObject()).stream().map(n -> n.getModel()).collect(Collectors.toList());
        }
        catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public void writeSensors(List<ISensors> users) {
        try (XMLEncoder oos = new XMLEncoder(new FileOutputStream(XML_FILE))) {
            List<XMLSensors> bn = users.stream().map(n -> new XMLSensors(n)).collect(Collectors.toList());
            oos.writeObject(bn);
        }
        catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }
}
