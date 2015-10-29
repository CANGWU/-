package transportslservice;

import vo.TransportVO;

public interface TransportService {
	//�鿴���䵥��Ϣ
	public TransportVO getTransport(String Transportid);
	
	//�������䵥�Ĺ���
	public TransportVO choose(String sign);//ѡ�����ɺ��ֵ���
	public TransportVO addMember(String id,TransportVO transportvo);
	public TransportVO addExpress(String orderNumber,TransportVO transportvo);
	public TransportVO addCondition(String orderNumber,String conditon,TransportVO transportvo);
	public TransportVO addMessage(String departure,String destination,String time,TransportVO transportvo);
	public TransportVO addTraffic(String id,TransportVO transportvo);
	public TransportVO addFare(String departure,String destination,TransportVO transportvo);
	public void saveTransport(TransportVO transportvo);
	public void printTransport(String id);
	public void endTransport();
}
