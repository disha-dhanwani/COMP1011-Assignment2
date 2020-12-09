package Controllers;

import Models.UniversityInfo;
import Utilities.APIUtility;
import Views.SceneChanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class UniversityViewController implements Initializable {

    @FXML
    private TextField textField;

    @FXML
    private ListView<UniversityInfo> listView;

    @FXML
    private RadioButton nameRadioButton;

    @FXML
    private RadioButton countryRadioButton;

    @FXML
    private Label errorLabel;

    public static String searchText;

    /**
     * When the application is launched, the user will be presented with a scene that
     * allows them to interact with the app and find details of any university. They can choose to find
     * the list of universities, either by name or country, by clicking on the respective radio button.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textField.setPromptText("Enter name");
        errorLabel.setText("");

        ToggleGroup group = new ToggleGroup();
        nameRadioButton.setToggleGroup(group);
        countryRadioButton.setToggleGroup(group);

    }

    /**
     * This method changes the scene once the user selects a university from the listview and
     * click the button, to the UniversityInfoView.fxml scene which displays info about the selected
     * university.
     * @param event
     * @throws IOException
     */
    @FXML
    private void viewUniversityDetails(ActionEvent event) throws IOException {
//        SceneChanger.changeScene(event, "UniversityInfoView.fxml","University Details");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("src/Views/UniversityInfoView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        UniversityInfoViewController controller = loader.getController();
        controller.getInfo(listView.getSelectionModel().getSelectedItem());

        stage.setScene(scene);
        stage.setTitle("Details");
        stage.show();

    }

    /**
     *
     */
    @FXML
    private void getUniversities()
    {
        searchText = textField.getText();
        searchText = searchText.replace(" ", "%20");

        if(!nameRadioButton.isSelected() && !countryRadioButton.isSelected() && searchText.isBlank())
        {
            errorLabel.setText("Please choose an option to search for a list of universities!");
        }

        else if(!nameRadioButton.isSelected() && !countryRadioButton.isSelected()) {
            errorLabel.setText("Please choose an option to search for a list of universities!");
        }

        else if(nameRadioButton.isSelected())
        {
            if (searchText.isBlank()) {
                errorLabel.setText("Please enter the name of the university you are looking for in the search box!");
            } else {
                getUniversitiesByName();
            }
        }
        else
        {
            if(searchText.isBlank()) {
                errorLabel.setText("Please enter the name of a country in the search box!");
            }
            else {
                getUniversitiesByCountry();
            }
        }

    }

    private void getUniversitiesByName()
    {
        try
        {
            errorLabel.setText("");
            listView.getItems().clear();

            //Call API
            UniversityInfo res[] = APIUtility.callUniversityByNameAPI(searchText);
            ObservableList<UniversityInfo> newList = FXCollections.observableArrayList(res);

            listView.getItems().addAll(newList);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getUniversitiesByCountry()
    {
        try {
            errorLabel.setText("");
            listView.getItems().clear();

            //Call API
            UniversityInfo res[] = APIUtility.callUniversityByCountryAPI(searchText);
            ObservableList<UniversityInfo> newList = FXCollections.observableArrayList(res);

            listView.getItems().addAll(newList);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
