package rhok.medical.model.shared;

public class Disaster {

	private String severity;
	private String disasterType;
	private String location;
	private String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getDisasterType() {
		return disasterType;
	}
	public void setDisasterType(String disasterType) {
		this.disasterType = disasterType;
	}
	
	
	public String toString() {
		StringBuffer jsonString=new StringBuffer();
		jsonString.append("{");
		jsonString.append(" \"severity\": \"").append(getSeverity()).append("\",");
		jsonString.append(" \"disasterType\": \"").append(getDisasterType()).append("\",");
		jsonString.append(" \"message\": \"").append(getMessage()).append("\",");
		jsonString.append(" \"location\": \"").append(getLocation()).append("\"");
		jsonString.append("}");
		return jsonString.toString();
	}
	
}
