package receiveslservice;

import vo.DeliverVO;

public interface DeliverService {
	//���ɼ�����õ��ɼ�����Ϣ
	public DeliverVO getDeliver(String deliverNumber) throws Exception;
	
	//�����ɼ���
	public void newDeliver(String time,DeliverVO delivervo);
	public void addExpress(String orderNumber,DeliverVO delivervo);
	public void addMember(String id,DeliverVO delivervo);
	public void printDeliver(String id);
	public void saveDeliver(DeliverVO delivervo) throws Exception;
	public void endDeliver() throws Exception;
}
