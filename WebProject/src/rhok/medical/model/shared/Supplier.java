package rhok.medical.model.shared;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Supplier {

	public String lat;
	public String lon;
	public String suburb;
	public String id;
	public String status;
	public String name;
	public String phone;
	public String address;
	public String url;
	public List<String> products = new ArrayList<String>();
	
	
	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getLat() {
		return lat;
	}



	public void setLat(String lat) {
		this.lat = lat;
	}



	public String getLon() {
		return lon;
	}



	public void setLon(String lon) {
		this.lon = lon;
	}


	public String getSuburb() {
		return suburb;
	}



	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void addProduct(String prod) {
		products.add(prod);
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url=url;
	}

	public Supplier() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		StringBuffer jsonString=new StringBuffer();
		jsonString.append("{\"supplier\": {");
		jsonString.append(" \"id\": \"").append(getId()).append("\",");
		jsonString.append(" \"name\": \"").append(getName()).append("\",");
		jsonString.append(" \"lat\": \"").append(getLat()).append("\",");
		jsonString.append(" \"long\": \"").append(getLon()).append("\",");
		jsonString.append(" \"phone\": \"").append(getPhone()).append("\",");
		jsonString.append(" \"url\": \"").append(getUrl()).append("\",");
		jsonString.append(" \"address\": \"").append(getAddress()).append("\"");
		jsonString.append("}}");
		return jsonString.toString();
	}

}
