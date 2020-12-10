/**
 * COMP1011 - ASSIGNMENT2
 * Student Name: Disha Dhanwani
 * Student Number: 200434069
 */
package Models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class UniversityInfo {

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

    //Initialize variables and state their serialized name.
    @SerializedName("country")
    private String country;

    @SerializedName("web_pages")
    private String webPages[];

    @SerializedName("state-province")
    private String stateProvince;

    @SerializedName("alpha_two_code")
    private String alphaTwoCode;

    @SerializedName("name")
    private String name;

    @SerializedName("domains")
    private String domains[];

    //Controller
    public UniversityInfo(String country, String[] webPages, String stateProvince, String alphaTwoCode, String name, String[] domains) {
        setCountry(country);
        setWebPages(webPages);
        setStateProvince(stateProvince);
        setAlphaTwoCode(alphaTwoCode);
        setName(name);
        setDomains(domains);
    }

    //Getters and Setters
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if(country.matches("[a-zA-Z\\-\\s']*"))
            this.country = country;
        else
            throw new IllegalArgumentException("Country names must start with capital letters and can contain spaces or '-'");
    }

    public String[] getWebPages() {
        return webPages;
    }

    public void setWebPages(String[] webPages) {
        if(Arrays.stream(webPages).anyMatch(w -> w.contains("www.")))
            this.webPages = webPages;
        else
            throw new IllegalArgumentException("Please enter valid website");
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        if(stateProvince.matches("[A-Z][a-zA-Z\\-\\s]*"))
            this.stateProvince = stateProvince;
        else
            throw new IllegalArgumentException("State Provinces must start with a capital letter and can contain spaces or '-'");
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public void setAlphaTwoCode(String alphaTwoCode) {
        if(alphaTwoCode.length()>2)
            this.alphaTwoCode = alphaTwoCode;
        else
            throw new IllegalArgumentException("Country codes can have only 2 letters");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.matches("[A-Z][a-zA-Z\\-\\s]*"))
            this.name = name;
        else
            throw new IllegalArgumentException("University names must start with capital letters and can contain spaces or '-'");
    }

    public String[] getDomains() {
        return domains;
    }

    public void setDomains(String[] domains) {
        if(Arrays.stream(domains).anyMatch(d -> d.length()>0))
            this.domains = domains;
        else
            throw new ArrayIndexOutOfBoundsException("Please enter at least one domain.");
    }

    public String toString(){
        return String.format("%s - %s", name, country);
    }

}
//End of class.