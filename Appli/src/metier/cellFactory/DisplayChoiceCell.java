package metier.cellFactory;

import javafx.scene.control.ListCell;

public class DisplayChoiceCell extends ListCell<String>{

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
