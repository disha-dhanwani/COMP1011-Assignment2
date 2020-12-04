package Utilities;

import Models.UniversityJsonResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;

public class APIUtility {

    public static UniversityJsonResponse getUniversitiesFromJson(File jsonFile){

        Gson gson = new Gson();
        UniversityJsonResponse result = null;

        try(
                FileReader fileReader = new FileReader(jsonFile);
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            result = gson.fromJson(jsonReader, UniversityJsonResponse.class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
