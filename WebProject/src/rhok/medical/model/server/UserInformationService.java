package rhok.medical.model.server;

import java.util.*;

import rhok.medical.model.shared.EndUser;

public class UserInformationService {
	EndUser user = null;
	public Map<String, EndUser> map = new HashMap<String, EndUser>();

	
	public UserInformationService() {
		user = new EndUser();
		user.setLocation("southbank");
		user.setName("James");
		user.setMobile("111");
		user.setProducts("Diabetic Equipment");
		user.setUserId("111");
		user.setSuburb("southbank");

		map.put("111", user);
				
		
		EndUser user1 = new EndUser();
		user1.setLocation("Hawthorn");
		user1.setName("Steve");
		user1.setMobile("222");
		user1.setProducts("Diabetic Equipment");
		user1.setUserId("222");
		user1.setSuburb("Hawthorn");

		map.put("222", user1);

	}
	
	public Map<String, EndUser> getAllUsersInaLocation() {
		return map;
	}
}
