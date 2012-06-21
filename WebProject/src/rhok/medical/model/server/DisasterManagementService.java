package rhok.medical.model.server;

import java.util.List;

import rhok.medical.model.shared.DisasterAlert;
import rhok.medical.model.shared.EndUser;
import rhok.medical.model.shared.Supplier;


public class DisasterManagementService {

	public String sapi_key = "ud5f3rsgr6z328kxxtttsnp3";
	
	public DisasterManagementService() {
		// TODO Auto-generated constructor stub
	}

	public void notifyDisaster(long lat, long lon, int radius, String DisasterType){
		
	}
	
	public List getAvailableStocks(long lat, long lon, int radius, String healthCondition){
		return null;
	}
	
	public List getRequiredStocks(long lat, long lon, int radius, String healthCondition){
		return null;
	}
	
	public DisasterAlert getDisasterAlert(float latitude,float longitude,int radius, int userId) {
		UserInformationService userInfoServer = new UserInformationService();
		//userInfoService.getAllUsersInaLocation();
		return null;
	}

	public List<Supplier> getAvailableStores(String location,String radius,String healthCondition){
		List<Supplier> suppliers = new rhok.medical.model.server.SupplierInfoService().getAllAvailableSuppliers(location, radius, "Pharmacy");
		
		for(int i=0; i<suppliers.size();i++){
			Supplier supp = suppliers.get(i);
			System.out.println(supp.getName());
		}
		
		return suppliers;
	}


	public List<Supplier> getAvailableStores(String location,String radius,String healthCondition, String userId){
		
		UserInformationService data = new UserInformationService();
		EndUser user = data.map.get(userId);
		
		
		List<Supplier> suppliers = new rhok.medical.model.server.SupplierInfoService().getAllAvailableSuppliers(location, radius,user.getProducts() );
		
		for(int i=0; i<suppliers.size();i++){
			Supplier supp = suppliers.get(i);
			System.out.println(supp.getName());
		}
		
		return suppliers;
	}
	
	
}
	