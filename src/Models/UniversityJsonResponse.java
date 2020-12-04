package Models;

import com.google.gson.annotations.SerializedName;

public class UniversityJsonResponse {

    @SerializedName("Search")
    private UniversityInfo[] search;

    public UniversityInfo[] getSearch() {
        return search;
    }

    public void setSearch(UniversityInfo[] search) {
        this.search = search;
    }
}
