package rhok.medical.model.shared;

public class DisasterAlert {

	private Disaster disaster;
	//private CheckList checkList;
	private String checkList;
	
	public Disaster getDisaster() {
		return disaster;
	}
	public void setDisaster(Disaster disaster) {
		this.disaster = disaster;
	}
	public String getCheckList() {
		return checkList;
	}
	public void setCheckList(String checkList) {
		this.checkList = checkList;
	}
	public String toString() {
		StringBuffer jsonString=new StringBuffer();
		jsonString.append("{\"disasteralert\": {");
		jsonString.append(" \"disaster\": \"").append(getDisaster()).append("\",");
		jsonString.append(" \"checklist\": \"").append(getCheckList()).append("\"");
		jsonString.append("}}");
		return jsonString.toString();
	}
	
}
