package Controllers;

import Models.UniversityInfo;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class UniversityViewController {

    @FXML
    private TextField textField;

    @FXML
    private ListView<UniversityInfo> listView;

    @FXML
    private void getUniversities()
    {
        String searchText = textField.getText();
        listView.getItems().clear();


    }

}
