package Controllers;

import Models.UniversityInfo;
import Utilities.APIUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UniversityInfoViewController implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private Label stateProvinceLabel;

    @FXML
    private Label alphaTwoCodeLabel;

    @FXML
    private Label webpageLabel;

    @FXML
    private Label domainLabel;

    UniversityViewController uni = new UniversityViewController();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //uni.onSelection(nameLabel, countryLabel, stateProvinceLabel, alphaTwoCodeLabel, webpageLabel, domainLabel);

    }




}
