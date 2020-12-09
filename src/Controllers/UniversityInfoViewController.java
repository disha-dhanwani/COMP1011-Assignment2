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
import java.util.Arrays;
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

    private UniversityInfo uniDetails;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getInfo(UniversityInfo uni){
        uniDetails = uni;
        nameLabel.setText(uniDetails.getName());
        countryLabel.setText(uniDetails.getCountry());
        stateProvinceLabel.setText(uniDetails.getStateProvince());
        alphaTwoCodeLabel.setText(uniDetails.getAlphaTwoCode());
        webpageLabel.setText(Arrays.toString(uniDetails.getWebPages()));
        domainLabel.setText(Arrays.toString(uniDetails.getDomains()));

    }



}
