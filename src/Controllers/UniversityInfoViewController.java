package Controllers;

import Models.UniversityInfo;
import Utilities.APIUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

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

    /**
     * This method leads the user back to the listView where they can start a new search.
     * @param event
     * @throws IOException
     */
    public void goToListView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UniversityView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("University Application");
        stage.show();
    }

}
