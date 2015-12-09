package po;

import java.io.Serializable;
import java.util.ArrayList;

import enums.DocumentCondition;

public class DeliverPO implements Serializable {
	private String id;
	private String time;
	private ArrayList<String> member;
	private ArrayList<String> order;
	private DocumentCondition dCondition;

	public DeliverPO(String id, String time, ArrayList<String> member,
			ArrayList<String> order, DocumentCondition dCondition) {
		this.id = id;
		this.time = time;
		this.member = member;
		this.order = order;
		this.dCondition = dCondition;
	}
	
	public DocumentCondition getdCondition() {
		return dCondition;
	}

	public void setdCondition(DocumentCondition dCondition) {
		this.dCondition = dCondition;
	}

	public String getTime(){
		return time;
	}
	public String getID(){
		return id;
	}
	public ArrayList<String> getMember(){
		return member;
	}
	public ArrayList<String> getOrder(){
		return order;
	}
	public void setTime(String time){
		this.time = time;
	}
	public void setID(String id){
		this.id = id;
	}
	public void setMember(ArrayList<String> member){
		this.member = member;
	}
	public void setOrder(ArrayList<String> order){
		this.order = order;
	}
}