/**
 * COMP1011 - ASSIGNMENT2
 * Student Name: Disha Dhanwani
 * Student Number: 200434069
 */
package Utilities;

import Models.UniversityInfo;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    /***
     * This is the method to read the JSON file and return
     * UniversityInfo[] objects.
     * @param jsonFile
     * @return result
     */
    public static UniversityInfo[] getUniversitiesFromJson(File jsonFile){

        Gson gson = new Gson();
        UniversityInfo[] result = null;

        try(
                FileReader fileReader = new FileReader(jsonFile);
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            result = gson.fromJson(jsonReader, UniversityInfo[].class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * This method receives a String called "search" and calls the
     * university API to receive a json file. This file will be written to
     * universitiesInfo.json
     * This API call returns UniversityInfo[] objects based on university names.
     */
    public static UniversityInfo[] callUniversityByNameAPI(String search) throws IOException, InterruptedException {

        //Path to universitiesInfo JSON file
        String jsonFile = "src/Utilities/universitiesInfo.json";
        //Link used to call the API and search a university by its name
        String uri = "http://universities.hipolabs.com/search?name=" + search;

        //Using HttpClient and HttpRequest to send the request
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        //return the results and write it to jsonFile
        HttpResponse<Path> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers
                .ofFile(Paths.get(jsonFile)));

        UniversityInfo[] uniResponse = getUniversitiesFromJson(new File(jsonFile));
        return uniResponse;
    }

    /**
     * This method receives a String called "search" and calls the
     * university API to receive a json file. This file will be written to
     * universitiesInfo.json.
     * This API call returns UniversityInfo[] objects based on country names.
     */
    public static UniversityInfo[] callUniversityByCountryAPI(String search) throws IOException, InterruptedException {

        //Path to universitiesInfo JSON file
        String jsonFile = "src/Utilities/universitiesInfo.json";
        //Link used to call the API and search a university by country name
        String uri = "http://universities.hipolabs.com/search?country=" + search;

        //Using HttpClient and HttpRequest to send the request
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        //return the results and write it to jsonFile
        HttpResponse<Path> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers
                .ofFile(Paths.get(jsonFile)));

        UniversityInfo[] uniResponse = getUniversitiesFromJson(new File(jsonFile));
        return uniResponse;
    }

}
//End of Class.