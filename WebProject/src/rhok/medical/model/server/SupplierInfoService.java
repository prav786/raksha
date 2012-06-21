package rhok.medical.model.server;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;

import rhok.medical.model.shared.*;

public class SupplierInfoService {
	public List<Supplier> getAllAvailableSuppliers(String location, String radius, String keyword){
		List<Supplier> list = new ArrayList<Supplier>();
		
		try {
			JsonNode root = new rhok.medical.model.shared.SAPI().search(keyword, location, "30");
			String phone = "phone";
			Supplier supp = null;
			
            for (JsonNode result : root.get("results")) {
            	supp = new Supplier();
            	supp.setName(result.path("name").getTextValue());
            	supp.setAddress(result.path("primaryAddress").path("addressLine").getTextValue());
            	supp.setLat(result.path("primaryAddress").path("latitude").getTextValue());
            	supp.setLon(result.path("primaryAddress").path("longitude").getTextValue());
            	supp.setId(result.path("id").getTextValue());
                for (JsonNode contact : result.path("primaryContacts")) {
                	if(phone.equalsIgnoreCase(contact.path("type").getTextValue()))
                		supp.setPhone(contact.path("value").getTextValue());		
                }
                
                for(JsonNode product : result.path("productKeywords").path("Product")){
                	supp.addProduct(product.getTextValue());
                }
                
                
                list.add(supp);
                
            }     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String args[]){
		new rhok.medical.model.server.SupplierInfoService().getAllAvailableSuppliers("port melbourne", "5", "Pharmacy");
	}
	
	
}
