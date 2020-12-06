package Utilities;

import Models.UniversityInfo;
import Models.UniversityJsonResponse;
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
     * Method to read the json file and return details of universities
     * @param jsonFile
     * @return
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
            System.out.println();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Method that receives a String called "searchText", calls the university API to receive
     * a json file. This file will be written to universitiesInfo.json
     */
    public static UniversityInfo[] callUniversityByNameAPI(String search) throws IOException, InterruptedException {

        //Path to universitiesInfo JSON file
        String jsonFile = "src/Utilities/universitiesInfo.json";
        //Link used to call the API and search a university name
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

    public static UniversityInfo[] callUniversityByCountryAPI(String search) throws IOException, InterruptedException {

        //Path to universitiesInfo JSON file
        String jsonFile = "src/Utilities/universitiesInfo.json";
        //Link used to call the API and search a university name
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
