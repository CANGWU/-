package receiveslservice;

import vo.DeliverVO;

public interface DeliverService {
	//���ɼ�����õ��ɼ�����Ϣ
	public DeliverVO getDeliver(String deliverNumber);
	
	//�����ɼ���
	public void newDeliver(String time,DeliverVO delivervo);
	public void addMember(String id);
	public void printDeliver(String id);
	public void saveDeliver(DeliverVO delivervo);
	public void endDeliver();
}
