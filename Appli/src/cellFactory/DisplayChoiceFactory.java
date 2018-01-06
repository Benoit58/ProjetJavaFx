package cellFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import java.util.Arrays;

public class DisplayChoiceFactory implements Callback<ListView<String>,ListCell<String>>{
    public static ObservableList<String > comboList = FXCollections.observableArrayList(Arrays.asList(
            "Digital",
            "Icon",
            "Thermo"));

    @Override
    public ListCell<String> call(ListView<String> param){return new DisplayChoiceCell();}
}
