import Utilities.APIUtility;

import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {

        APIUtility.getUniversitiesFromJson(new File("src/Utilities/universitiesInfo.json"));

    }
}
