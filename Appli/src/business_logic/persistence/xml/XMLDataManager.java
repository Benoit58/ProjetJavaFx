package business_logic.persistence.xml;

import business_logic.sensor.ISensor;
import business_logic.persistence.DataManager;

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

/**
 * Business class for XML persistence management : DataManager to manage XML persistence
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class XMLDataManager implements DataManager {

    private final static String XML_FILE = "files/sensors.xml";

    /**
     * Load all the ISensors
     *
     * @return the lsit of ISensors loaded
     */
    @Override
    public List<ISensor> loadSensors() {
        List<ISensor> result = null;
        try (XMLDecoder ois = new XMLDecoder(new FileInputStream(XML_FILE))) {
            result = ((ArrayList<XMLSensor>)ois.readObject()).stream().map(n -> n.getModel()).collect(Collectors.toList());
        }
        catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    /**
     * Save sensors using the XML serialization
     *
     * @param users all the ISensors to serialize
     */
    @Override
    public void saveSensors(List<ISensor> users) {
        try (XMLEncoder oos = new XMLEncoder(new FileOutputStream(XML_FILE))) {
            List<XMLSensor> bn = users.stream().map(n -> new XMLSensor(n)).collect(Collectors.toList());
            oos.writeObject(bn);
        }
        catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }
}
