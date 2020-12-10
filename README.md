# COMP1011-Assignment2

The goal of this assignment is to create an interactive application that allows users to read data from a JSON file / API. For my application, I have chosen an API that displays information about universities all around the world, such as: university name, country, websites and domains. 
The app launches with a scene where users can choose to search a list of universities, either by name or the country by clicking on the respective options and entering the text in a search bar. Once they've selected a university, they can click on a button that takes them to another scene that displays more information on that particular university. The application reads data from a live API. 

API link: https://github.com/Hipo/university-domains-list-api

Example of a search request:
http://universities.hipolabs.com/search?name=University%20of%20toronto
```
[{
	"country": "Canada",
	"web_pages": ["http://www.utoronto.ca/"],
	"state-province": null,
	"alpha_two_code": "CA",
	"name": "University of Toronto",
	"domains": ["utoronto.ca"]
}]
```

Following languages were used: Java, CSS; using IntelliJ.

The given code files are a part of my assignment in COMP1011 at Georgian College.

© Disha Dhanwani 2020
