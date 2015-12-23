package financeui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import dataserviceimpl.DataFactory;
import enums.DocumentCondition;
import enums.PaymentType;
import enums.ResultMessage;
import pamanagementsl.PManagementController;
import usersl.UserManagementController;
import vo.AccountVO;
import vo.PaymentVO;
import vo.ReceiverVO;
import vo.StaffVO;
import financesl.AccountManagementController;
import financesl.CostController;
import free.BaseUI;

public class CostPanel extends JPanel {
	private static PaymentVO payment;
	private static ArrayList<String> paymentTypeStrlist=new ArrayList<String>();
	private static ArrayList<PaymentType> paymentTypelist=new ArrayList<PaymentType>();
	
	
	public static CostPanel createCostPanel(String userId){
		paymentTypeStrlist.add("���");
		paymentTypeStrlist.add("�˷�");
		paymentTypeStrlist.add("����");
		paymentTypeStrlist.add("����");
		
		paymentTypelist.add(PaymentType.Rent);
		paymentTypelist.add(PaymentType.TransFee);
		paymentTypelist.add(PaymentType.Salary);
		paymentTypelist.add(PaymentType.Bonus);
		
		
		
		CostPanel panel=new CostPanel();
		
		JLabel paymentType=new JLabel("������Ŀ:");
		JComboBox paymentTypeCombo=new JComboBox();
		paymentTypeCombo.addItem("���");
		paymentTypeCombo.addItem("�˷�");
		paymentTypeCombo.addItem("����");
		paymentTypeCombo.addItem("����");

		JLabel date=new JLabel("��������:");
	    Date dt = new Date();   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
	    String timeOfPayment=sdf.format(dt);
		JLabel datefield=new JLabel(timeOfPayment);
	    
	    
		JLabel payman=new JLabel("������:");
		UserManagementController umc=new UserManagementController();
		JLabel paymanfield=new JLabel(umc.select(userId).getName());
//		JLabel paymanfield=new JLabel("������");
		
		JLabel paymentfee=new JLabel("������:");
		JTextField paymentfeefield2=new JTextField(20);
		
		JLabel account=new JLabel("�����˻�:");
		
		JComboBox accountCombo=new JComboBox();
//		accountCombo.addItem("�����˻�1");
//		accountCombo.addItem("�����˻�2");
//		accountCombo.addItem("�����˻�3");
//		accountCombo.addItem("�����˻�4");
		AccountManagementController amc=new AccountManagementController();
		ArrayList<AccountVO> list=amc.getAllAccount();
		for(int i=0;i<list.size();i++){
			accountCombo.addItem(list.get(i).getName());
		}
		
		JLabel receiver=new JLabel("�տ���:");
		JTextField receiverfield=new JTextField(20);
		JLabel remarks=new JLabel("��ע:");
		JTextField remarksfield=new JTextField(20);
		
		
		
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		
		BaseUI.myAdd(bpanel,date,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,datefield,constraints,1,0,1,1);
		BaseUI.myAdd(bpanel,payman,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,paymanfield,constraints,1,1,1,1);
		BaseUI.myAdd(bpanel,paymentType,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,paymentTypeCombo,constraints,1,2,1,1);
		BaseUI.myAdd(bpanel,receiver,constraints,0,3,1,1);
		BaseUI.myAdd(bpanel,receiverfield,constraints,1,3,1,1);
		BaseUI.myAdd(bpanel,account,constraints,0,4,1,1);
		BaseUI.myAdd(bpanel,accountCombo,constraints,1,4,1,1);
		
		BaseUI.myAdd(bpanel,paymentfee,constraints,2,0,1,1);
		BaseUI.myAdd(bpanel,paymentfeefield2,constraints,3,0,1,1);
		
		PManagementController pc=new PManagementController();
		CostController cc=new CostController();



		 
		
		BaseUI.myAdd(bpanel,remarks,constraints,2,1,1,1);
		BaseUI.myAdd(bpanel,remarksfield,constraints,3,1,1,1);
		
		
		JButton submit=new JButton("������");	
		BaseUI.myAdd(bpanel,submit,constraints,1,11,1,1);
		
		
		submit.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent arg0) 
		    {
		    	
		    	if(submit.getText().equals("������")){
		    		payment=cc.setPayment(changePayToType(paymentTypeCombo.getSelectedItem().toString()), receiverfield.getText());
		    		payment.setNameOfWriter(paymanfield.getName());
		    		if(paymentTypeCombo.getSelectedItem().equals("����")||paymentTypeCombo.getSelectedItem().equals("�˷�")){
		    			
		    			payment=cc.computePayment(payment);
		    			paymentfeefield2.setText(payment.getNumberOfPayment()+"");
		    		}else{
		    	

		    			double fee=Double.parseDouble(paymentfeefield2.getText());
		    			payment=cc.computePayment(payment,fee);
		    		}
		    		
		    		submit.setText("ȷ��֧��");
		    	}else{
			    	 AccountVO accountvo=amc.findAccount(accountCombo.getSelectedItem().toString());
			    	 
			    	 payment.setRemarks(remarksfield.getText());
			    	 payment.setCondition(DocumentCondition.handing);

		             ResultMessage result=null;
		             
		             result=cc.payPayment(payment, accountvo);
		    	}
		    	
		    	

	             
		    }
		});
		
		panel.add(bpanel);
		
		return panel;
	}
	
	
	private static PaymentType changePayToType(String payment){
		
		int index=paymentTypeStrlist.indexOf(payment);
		return paymentTypelist.get(index);
		
	}
}
