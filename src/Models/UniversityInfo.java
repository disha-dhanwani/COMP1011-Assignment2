package Models;

import com.google.gson.annotations.SerializedName;

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

    public UniversityInfo(String country, String[] webPages, String stateProvince, String alphaTwoCode, String name, String[] domains) {
        setCountry(country);
        setWebPages(webPages);
        setStateProvince(stateProvince);
        setAlphaTwoCode(alphaTwoCode);
        setName(name);
        setDomains(domains);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getWebPages() {
        return webPages;
    }

    public void setWebPages(String[] webPages) {
        this.webPages = webPages;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public void setAlphaTwoCode(String alphaTwoCode) {
        this.alphaTwoCode = alphaTwoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getDomains() {
        return domains;
    }

    public void setDomains(String[] domains) {
        this.domains = domains;
    }

    public String toString(){
        return String.format("%s - %s", name, country);
    }

}
