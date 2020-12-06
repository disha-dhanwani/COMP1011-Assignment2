package Controllers;

import Models.UniversityInfo;
import Utilities.APIUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniversityViewController {

    @FXML
    private TextField textField;

    @FXML
    private ListView<UniversityInfo> listView;

    @FXML
    private void getUniversities()
    {
        String searchText = textField.getText();
        searchText = searchText.replace(" ", "%20");

        try {
//            UniversityInfo[] response = APIUtility.callUniversityAPI(searchText);
//            List<UniversityInfo[]> universities = Arrays.asList(response);
//            listView.getItems().addAll(universities);
            listView.getItems().clear();

            //Call API
//            UniversityInfo[] response = APIUtility.callUniversityAPI(searchText);
            UniversityInfo res[] = APIUtility.callUniversityByNameAPI(searchText);
            ObservableList<UniversityInfo> newList = FXCollections.observableArrayList(res);

            listView.getItems().addAll(newList);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
