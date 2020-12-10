/**
 * COMP1011 - ASSIGNMENT2
 * Student Name: Disha Dhanwani
 * Student Number: 200434069
 */
package Controllers;

import Models.UniversityInfo;
import Views.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

    /**
     * Initializing the controller class
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * This method accepts a UniversityInfo object and displays the values in their respective labels.
     * @param uni
     */
    public void getInfo(UniversityInfo uni) {
        uniDetails = uni;
        nameLabel.setText(uniDetails.getName());
        countryLabel.setText(uniDetails.getCountry());
        alphaTwoCodeLabel.setText(uniDetails.getAlphaTwoCode());
        webpageLabel.setText(Arrays.toString(uniDetails.getWebPages()));
        domainLabel.setText(Arrays.toString(uniDetails.getDomains()));

        if(uniDetails.getStateProvince() == null)
            stateProvinceLabel.setText("**Sorry, this information is not currently available!**");
        else
            stateProvinceLabel.setText(uniDetails.getStateProvince());

    }

    /**
     * This method leads the user back to the first scene where they can start a new search.
     * @param event
     * @throws IOException
     */
    public void goToListView(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "UniversityView.fxml", "Search universities all over the world!");
    }

}
