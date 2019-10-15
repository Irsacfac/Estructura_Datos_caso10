package JsonManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Sensor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonManager {

	private JSONObject parseJson(){
        JSONParser parser = new JSONParser();
        try {
            FileReader reader =
                    new FileReader(
                            "C:\\Users\\jguty\\OneDrive\\Documents\\GitHub\\Estructura_Datos_caso10\\src\\JsonManager\\locations_json_file");
            return (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

    private JSONArray parseCantons(){
        JSONObject AyAPlantLocations = parseJson();
        JSONArray cantonsJSONArray = (JSONArray)AyAPlantLocations.get("Cantons");
        return cantonsJSONArray;
    }

    private ArrayList<String> getCantons(){

	    JSONObject AyAPlantLocations = parseJson();
	    JSONArray cantonsJSONArray = parseCantons();
        ArrayList<String> cantons = new ArrayList<>();

	    for (int index = 0; index < cantonsJSONArray.size(); index++){
            JSONObject canton = (JSONObject)cantonsJSONArray.get(index);
	        cantons.add((String) canton.get("Name"));
        }
	    return cantons;
    }

    private ArrayList<String> getDistricts(){

        JSONObject AyAPlantLocations = parseJson();
        JSONArray cantonsJSONArray = parseCantons();
        ArrayList<String> districts = new ArrayList<>();

        for (int cantonIndex = 0; cantonIndex < cantonsJSONArray.size(); cantonIndex++){
            JSONObject canton = (JSONObject)cantonsJSONArray.get(cantonIndex);
            JSONArray districtsJSONArray = (JSONArray)canton.get("Districts");

            for (int districtIndex = 0; districtIndex < districtsJSONArray.size(); districtIndex++){
                JSONObject district = (JSONObject)districtsJSONArray.get(districtIndex);
                districts.add((String)district.get("Name"));
            }
        }
        return districts;
    }

    private ArrayList<String> getNeighboorhoods(){

	    JSONObject AyAPlantLocations = parseJson();
        JSONArray cantonsJSONArray = parseCantons();
        ArrayList<String> neighborhoods = new ArrayList<>();

        for (int cantonIndex = 0; cantonIndex < cantonsJSONArray.size(); cantonIndex++){
            JSONObject canton = (JSONObject)cantonsJSONArray.get(cantonIndex);
            JSONArray districtsJSONArray = (JSONArray)canton.get("Districts");

            for (int districtIndex = 0; districtIndex < districtsJSONArray.size(); districtIndex++){
                JSONObject district = (JSONObject)districtsJSONArray.get(districtIndex);
                JSONArray neighborhoodsJSONArray = (JSONArray)district.get("Neighborhhoods");

                for (int neighborhoodIndex = 0; neighborhoodIndex < neighborhoodsJSONArray.size(); neighborhoodIndex++){
                    JSONObject neighborhood = (JSONObject)neighborhoodsJSONArray.get(neighborhoodIndex);
                    neighborhoods.add((String)neighborhood.get("Name"));
                }
            }
        }
        return neighborhoods;
    }

    public String getPlantName(){
        JSONObject AyAPlantLocations = parseJson();
        return (String)AyAPlantLocations.get("Plant");
    }
    public int getPlantCapacity(){
        JSONObject AyAPlantLocations = parseJson();
        return (int)(long)AyAPlantLocations.get("Capacity");
    }

    public boolean cantonExists(String pName){
	    ArrayList<String> cantons = getCantons();
	    boolean exists = false;
	    for (String canton:cantons){
	        if (canton.equals(pName)){
	            exists = true;
	            break;
            }
        }
        return exists;
	}
    public boolean districtExists(String pName){
        ArrayList<String> districts = getDistricts();
        boolean exists = false;
        for (String district:districts){
            if (district.equals(pName)){
                exists = true;
                break;
            }
        }
        return exists;
    }
    public boolean neighborhoodExists(String pName){
        ArrayList<String> neighborhoods = getNeighboorhoods();
        boolean exists = false;
        for (String neighborhood:neighborhoods){
            if (neighborhood.equals(pName)){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public int getConsumptionByName(String pName){

	    JSONArray cantonsJSONArray = parseCantons();
        for (int cantonIndex = 0; cantonIndex < cantonsJSONArray.size(); cantonIndex++){
            JSONObject canton = (JSONObject)cantonsJSONArray.get(cantonIndex);


            JSONArray districtsJSONArray = (JSONArray)canton.get("Districts");
            for (int districtIndex = 0; districtIndex < districtsJSONArray.size(); districtIndex++){
                JSONObject district = (JSONObject)districtsJSONArray.get(districtIndex);


                JSONArray neighborhoodsJSONArray = (JSONArray)district.get("Neighborhhoods");
                for (int neighborhoodIndex = 0; neighborhoodIndex < neighborhoodsJSONArray.size(); neighborhoodIndex++){
                    JSONObject neighborhood = (JSONObject)neighborhoodsJSONArray.get(neighborhoodIndex);
                    if (neighborhood.get("Name").equals(pName)) return (int)(long)district.get("Consumption");
                    if (district.get("Name").equals(pName)) return (int)(long)district.get("Consumption");
                    if (canton.get("Name").equals(pName)) return (int)(long)canton.get("Consumption");


                }
            }
        }
	   return -1;
    }

}

