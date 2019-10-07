package JsonManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonManager {

	public JSONObject parseJson(){
        JSONParser parser = new JSONParser();
        try {
            FileReader reader =
                    new FileReader(
                            "C:\\Users\\jguty\\OneDrive\\Documents\\GitHub\\Estructura_Datos_caso10\\src\\JsonManager\\locations_json_file");
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);
            return jsonObject;
        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }
}

