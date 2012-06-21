package rhok.medical.model.shared;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.io.InputStream;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class SAPI {

    private static String API_KEY = "ud5f3rsgr6z328kxxtttsnp3"; // TODO: put your API key here

    public JsonNode search(String query, String location, String radius) throws Exception {
    
        // construct url for the search endpoint
        URL searchUrl = new URL("http://api.sensis.com.au/ob-20110511/test/search?key=" + API_KEY
                 + "&query="
                 + URLEncoder.encode(query, "UTF-8")
                 + "&radius="
                 + URLEncoder.encode(radius, "UTF-8")
                 + "&location="
                 + URLEncoder.encode(location, "UTF-8"));
        
        // open connection to the server
        HttpURLConnection conn = (HttpURLConnection)searchUrl.openConnection();
        conn.connect();
        
        try {
        
            // ensure HTTP 200 (OK) response
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException(
                        "Error calling Search API (HTTP status "
                        + conn.getResponseCode() + ")");
            }
            
            // grab the response stream
            InputStream stream = conn.getInputStream();
            
            // parse JSON response
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readValue(stream, JsonNode.class);
      
            // grab the reponse code and message
            int code = root.get("code").getIntValue();
            String message = root.get("message").getTextValue();

            // ensure successful status code
            switch (code) {
                case 200: // success
                    break;
                case 206: // spell-checker was run 
                    System.out.println("Note: " + message);
                    break;
                default:
                    throw new RuntimeException(
                            "API returned error: " + message + ", code: " + code);
            } 
 
            System.out.println("Total results found: " + 
                    root.get("totalResults").getIntValue());
            
            String phone = "phone";

            // iterate over the results
            for (JsonNode result : root.get("results")) {
                // print the business name and display address
                System.out.println(result.path("name").getTextValue() 
                        + " (" + result.path("primaryAddress").path("addressLine").getTextValue() + ")");
               
                for (JsonNode contact : result.path("primaryContacts")) {
                	if(phone.equalsIgnoreCase(contact.path("type").getTextValue()))
                	System.out.println("---"+contact.path("value").getTextValue());
                	
                }
                
                
            }     
            
            stream.close(); 
            return root;
        
        } finally {
            conn.disconnect(); // ensure we always close the connection
        }
    
    }    

    public static void main(String[] args) throws Exception {
        new SAPI().search("Pharmacy", "st kilda, vic", "3");
     
    }
    
}
