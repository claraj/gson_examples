package iss;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import iss.model.ISSNow;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by clara on 12/4/17.
 *
 * Where is the International Space Station right now?
 * In space, obviously, but above what part of the world?
 * Open Notify provides an API to return the current location of the ISS.
 *
 * Uses GSON to deserialize the response from
 * http://open-notify.org/Open-Notify-API/ISS-Location-Now/
 * into a Java object.
 *
 * This is an open API, no key or auth needed.
 *
 * Exception handling is omitted for clarity BUT it should absolutely be added
 * in a real application. Many things that can go wrong, for example
 * URL not valid format, no internet connection, not authorized to access the API server,
 * API server down, response is not in the format expected....
 *
 */
public class Main {
    
    public static void main(String[] args) throws Exception  {
    
        // The API URL to request
        String urlString = "http://api.open-notify.org/iss-now.json";
        
        // Create an URL object from the URL string
        URL url = new URL(urlString);
        
        // Make a web request. Response is returned as a stream of bytes
        InputStream stream = url.openStream();
        
        // Need something to read that stream
        InputStreamReader streamReader = new InputStreamReader(stream);
        
        //Now GSON gets involved. Can wrap the InputStreamReader in GSON's JsonReader
        JsonReader jsonReader = new JsonReader(streamReader);
        
        //Create a new GSON object... which can turn objects to JSON and JSON to objects
        Gson gson = new Gson();
        
        //... and give it the jsonReader (the JSON response from the server)
        // and the class it will use to make objects
        // If the structure of the ISSNow class matches the JSON response from the server,
        // GSON will be able to turn the response into ISSNow objects, containing the data
        
        ISSNow whereIsTheIssNow = gson.fromJson(jsonReader, ISSNow.class);
    
        System.out.println("Latitude: " + whereIsTheIssNow.getIss_position().getLatitude());
        System.out.println("Longitude: " + whereIsTheIssNow.getIss_position().getLongitude());
        
        // Although you can customize the ISSNow class with a user-friendly message
        System.out.println(whereIsTheIssNow.userString());
        
        
    }
    
}
