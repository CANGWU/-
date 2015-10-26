package receivedataservice;

import java.util.ArrayList;

import po.DeliverPO;
import po.OrderPO;

public interface ReceiveDataService{
	//��OrderPO�Ĳ���
	public OrderPO findO(String id) throws Exception;
	public ArrayList<OrderPO> findsO(String field,String id) throws Exception;
	public void insertO(OrderPO po) throws Exception;
	public void deleteO(OrderPO po) throws Exception;
	public void updateO(OrderPO po) throws Exception;
	public DeliverPO findD(String id) throws Exception;
	//��DeliverPO�Ĳ���
	public ArrayList<DeliverPO> findsD(String field,String id) throws Exception;
	public void insertD(DeliverPO po) throws Exception;
	public void deleteD(DeliverPO po) throws Exception;
	public void updateD(DeliverPO po) throws Exception;
	public void init() throws Exception;
	public void finish() throws Exception;
}
