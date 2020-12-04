import Utilities.APIUtility;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        APIUtility.getUniversitiesFromJson(new File("src/Utilities/universitiesInfo.json"));

        try {
            APIUtility.callUniversityAPI("Canada");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
