/**
 * COMP1011 - ASSIGNMENT2
 * Student Name: Disha Dhanwani
 * Student Number: 200434069
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * The Main class launches the application.
 */
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/UniversityView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Search universities all over the world!");
        stage.getIcons().add(new Image("book.png"));
        stage.show();
    }
}
//End of class.