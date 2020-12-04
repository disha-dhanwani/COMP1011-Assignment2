package Models;

import com.google.gson.annotations.SerializedName;

public class UniversityJsonResponse {

    /**
     * Example response:
     * [{
     *  "country": "Canada",
     * 	"web_pages": ["https://www.lambtoncollege.ca"],
     * 	"state-province": "Sarnia",
     * 	"alpha_two_code": "CA",
     * 	"name": "Lambton College",
     * 	"domains": ["lambtoncollege.ca", "mylambton.ca"]
     * 	}]
     */

    @SerializedName("country")
    private String country;

    @SerializedName("web_pages")
    private String webPages[];
    //private List<WebPages> webPagesList = new ArrayList<WebPages>();

    @SerializedName("state-province")
    private String stateProvince;

    @SerializedName("alpha_two_code")
    private String alphaTwoCode;

    @SerializedName("name")
    private String name;

    @SerializedName("domains")
    private String domains[];

}
