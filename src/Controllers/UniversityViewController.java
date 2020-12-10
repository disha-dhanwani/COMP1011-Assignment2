/**
 * COMP1011 - ASSIGNMENT2
 * Student Name: Disha Dhanwani
 * Student Number: 200434069
 */
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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * When the application is launched, the user will be presented with a scene that
 * allows them to interact with the app and find details of any university. They can choose to find
 * the list of universities, either by name or country, by clicking on the respective radio button.
 */
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

    @FXML
    private Button detailsButton;

    public String searchText;

    /**
     * Initializing the controller class.
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

        this.detailsButton.setDisable(true);
    }

    /**
     * This method disables the 'Get Details' button until the user clicks on
     * any list item.
     */
    @FXML
    public void userSelectedListItem()
    {
        this.detailsButton.setDisable(false);
    }

    /**
     * This method is connected to the 'Find Universities' button. Based on the
     * status of the application, the user will receive different messages.
     */
    @FXML
    private void getUniversities()
    {
        searchText = textField.getText();
        searchText = searchText.replace(" ", "%20");

        //If the user has entered something in the search bar and clicked the button without
        // choosing a search option
        if(!nameRadioButton.isSelected() && !countryRadioButton.isSelected()) {
            errorLabel.setText("Please choose an option to search for a list of universities! 2");
        }

        else if(nameRadioButton.isSelected())
        {
            if (searchText.isBlank()) {
                errorLabel.setText("Please enter the name of the university you are looking for in the search box! 3");
            } else {
                getUniversitiesByName();
                errorLabel.setText("Universities returned: " + listView.getItems().size());
            }
        }
        else
        {
            if(searchText.isBlank()) {
                errorLabel.setText("Please enter the name of a country in the search box! 4");
            }
            else {
                getUniversitiesByCountry();
                errorLabel.setText("Universities returned: " + listView.getItems().size());
            }
        }
    }

    /**
     * This method runs when the user has chosen to search universities by name.
     * Calls the API from APIUtility class and displays results in listview.
     */
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

    /**
     * This method runs when the user has chosen to search universities by country.
     * Calls the API from APIUtility class and displays results in listview.
     */
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

    /**
     * This method changes the scene once the user selects a university from the listview and
     * click the button, to the UniversityInfoView.fxml scene which displays info about the selected
     * university.
     * @param event
     * @throws IOException
     */
    @FXML
    private void viewUniversityDetails(ActionEvent event) throws Exception {

        //if no item is selected in listview but a button is clicked on, give error msg
        if(listView.getSelectionModel().getSelectedItem() == null)
            errorLabel.setText("Please click on a university to get more details!");

        else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../Views/UniversityInfoView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            UniversityInfoViewController controller = loader.getController();
            controller.getInfo(listView.getSelectionModel().getSelectedItem());

            stage.setScene(scene);
            stage.setTitle("Details");
            stage.show();
        }

    }

}
//End of Controller class.