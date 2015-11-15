package receiveslservice;

import vo.DeliverVO;
import vo.OrderVO;

public interface ReceiveService {
	//���ɼ�����õ��ɼ�����Ϣ
	public DeliverVO getDeliver(String deliverNumber);
	
	//�����ɼ���
	public DeliverVO newDeliver(String time);
	public DeliverVO addMember(String id,DeliverVO delivervo);
	public void printDeliver(String id);
	public void saveDeliver(DeliverVO delivervo);
	//�ռ�����
	public OrderVO addExpress(String name,String time,String orderNumber);
	public void saveExpress(OrderVO ordervo);
	public void endReceive();
}
