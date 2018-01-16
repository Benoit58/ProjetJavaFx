package controller;

import business_logic.sensor.ISensor;
import business_logic.sensor.SensorsManager;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.*;

public class ISensorCell extends ListCell<ISensor> {
    public ISensorCell(){
        setOnDragDetected((MouseEvent event) -> {
            Dragboard db = startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            if(getItem() != null){
                content.putString(getItem().getSensorName());
                SensorsManager.setSelectedSensor(getItem());
                db.setContent(content);
            }
            event.consume();
        });
    }

    @Override
    protected void updateItem(ISensor item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
        }
        else
            setText(item.getSensorName());
    }
}
