package po;

import java.io.Serializable;
import java.util.ArrayList;

import enums.Condition;
import enums.DocumentCondition;
import enums.Position;
import enums.Traffic;
import enums.TransportType;

public class TransportPO implements Serializable {
	private TransportType sign;
	private String id;
	private Position departure;
	private Position destination;
	private String time;
	private Traffic traffic;
	private double fare;
	private ArrayList<String> member;
	private ArrayList<String> order;
	private ArrayList<Condition> condition;
	private DocumentCondition dCondition;

	public TransportPO(TransportType sign, String id, Position departure, Position destination,
			String time, Traffic traffic, double fare, ArrayList<String> member,
			ArrayList<String> order, ArrayList<Condition> condition,DocumentCondition dCondition) {
		this.id=id;
		this.sign=sign;
		this.departure=departure;
		this.destination=destination;
		this.time=time;
		this.traffic=traffic;
		this.fare=fare;
		this.member=member;
		this.order=order;
		this.condition=condition;
		this.dCondition = dCondition;
	}
	
	public DocumentCondition getdCondition() {
		return dCondition;
	}

	public void setdCondition(DocumentCondition dCondition) {
		this.dCondition = dCondition;
	}

	public TransportType getSign(){
		return sign;
	}
	public String getID(){
		return id;
	}

	public String getTime(){
		return time;
	}
	public Traffic getTraffic(){
		return traffic;
	}
	public double getfare(){
		return fare;
	}
	public  ArrayList<String> getMember(){
		return member;
	}
	public  ArrayList<String> getOrder(){
		return order;
	}
	public  ArrayList<Condition> getCondition(){
		return condition;
	}
	public  void setSign(TransportType sign){
		this.sign=sign;
	}
	public  void setID(String id){
		this.id=id;
	}
	
	public Position getDeparture() {
		return departure;
	}

	public void setDeparture(Position departure) {
		this.departure = departure;
	}

	public Position getDestination() {
		return destination;
	}

	public void setDestination(Position destination) {
		this.destination = destination;
	}

	public  void setTime(String time){
		this.time=time;
	}
	public  void setTraffic(Traffic traffic){
		this.traffic=traffic;
	}
	public  void setFare(double fare){
		this.fare=fare;
	}
	public  void setMember(ArrayList<String> member){
		this.member=member;
	}
	public void setOrder(ArrayList<String> order){
		this.order=order;
	}
	public void setCondition(ArrayList<Condition> condition){
		this.condition=condition;
	}
}
//class Test{  
//public static void main(String[] args) throw Exception{  
//  ArrayList<String> al = new ArrayLIst<String>();  
//  al.add("1");  
//  al.add("2");  
//  al.add("3");  
//  //�Ƚ������ݵı���  
//  Connection conn = DataBase.getConnection();  
//  PreparedStatement pstmt = con.prepareStatement("insert into books values(1,?)");//�����ݿ��в����һ������  
//  pstmt.setObject(1,al);  
//  int time = pstmt.executeUpdate();//ִ�в���  
//  System.out.println(time+"�������");//��ʾ�������  
//  pstmt.close();  
//  //�ٽ������ݵ����  
//  Statement stmt = con.createStatement();  
//  ResultSet rs = stmt.executeQuery("select book from books where id=1");  
//  if(rs.next()){  
//      ObjectInputStream oips = new ObjectInputStream(rs.getBinaryStream(1));  
//      //��rs�еõ��������,���ֱ�Ӵ�rs.getObject(1)�õ��Ķ������޷�ֱ��ת��Ϊ����Ķ���ġ�  
//      ArrayList<String> obb = (ArrayList<String>)oips.readObject();//�����ж�ȡ����  
//      System.out.println(obb.get(2));//���������ָ��������  
//      oips.close();  
//  }  
//  rs.close();  
//  stmt.close();                 
//  con.close();  
//}  
//}  
