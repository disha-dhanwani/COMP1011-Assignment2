/**
 * COMP1011 - ASSIGNMENT2
 * Student Name: Disha Dhanwani
 * Student Number: 200434069
 */
package Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class contains a method that is used to change scenes. The method allows 3 parameters:
 * ActionEvent, path to .fxml file and the title of that scene.
 */
public class SceneChanger {
    public static void changeScene(ActionEvent event, String viewName, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(viewName));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.getIcons().add(new Image("./book.png"));
        stage.show();
    }
}
//End of class.