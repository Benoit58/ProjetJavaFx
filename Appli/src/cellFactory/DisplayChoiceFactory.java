package cellFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import java.util.Arrays;

/**
 * Business logic class for cellFactory management : DisplayChoiceFactory
 * Create AlgorithmChoices
 */
public class DisplayChoiceFactory implements Callback<ListView<String>,ListCell<String>>{
    /**
     * List of different choices possible
     */
    public static ObservableList<String> comboList = FXCollections.observableArrayList(Arrays.asList(
            "Digital",
            "Icon",
            "Thermo"));

    /**
     * Create a comboBox item
     *
     * @param param a listView param of String
     * @return displayChoiceCell which is a ComboBox item
     */
    @Override
    public ListCell<String> call(ListView<String> param){return new DisplayChoiceCell();}
}
