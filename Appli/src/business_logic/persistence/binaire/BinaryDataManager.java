package business_logic.persistence.binaire;

import business_logic.persistence.DataManager;
import business_logic.sensor.ISensor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Business class for Binary persistence management : DataManager to manage Binary persistence
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class BinaryDataManager implements DataManager {

    private final static String BIN_FILE = "files/sensors.bin";

    /**
     * Load all the ISensors
     *
     * @return the lsit of ISensors loaded
     */
    @Override
    public List<ISensor> loadSensors() {
        List<ISensor> result = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BIN_FILE))) {
            result = ((ArrayList<BinarySensor>) ois.readObject()).stream().map(n -> n.getModel()).collect(Collectors.toList());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Save sensors using the Binary serialization
     *
     * @param sensors all the ISensors to serialize
     */
    @Override
    public void saveSensors(List<ISensor> sensors) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BIN_FILE))) {
            List<BinarySensor> bn = sensors.stream().map(n -> new BinarySensor(n)).collect(Collectors.toList());
            oos.writeObject(bn);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}