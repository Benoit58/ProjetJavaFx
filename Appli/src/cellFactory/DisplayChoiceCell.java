package cellFactory;

import javafx.scene.control.ListCell;

/**
 * Business logic class : DisplayChoiceCell for cellFactory management : Manage choice of ComboBox cell
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class DisplayChoiceCell extends ListCell<String>{

    /**
     * Update the item in the comboBox
     *
     * @param item the item to update
     * @param isEmpty a boolean to know if we reinit the item
     */
    @Override
    protected void updateItem(String item, boolean isEmpty) {
        super.updateItem(item, isEmpty);
        if(isEmpty){
            textProperty().unbind();
            setText(null);
            setGraphic(null);
            return;
        }
        textProperty().setValue(item);
    }
}
