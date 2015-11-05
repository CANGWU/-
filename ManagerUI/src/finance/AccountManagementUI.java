package finance;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import main.BaseUI;


public class AccountManagementUI extends JPanel {

	JButton add;
	JButton delete;
	JButton fix;
	JButton seek;
	JList list;
	JLabel accountname;
	JLabel money;
	
	public AccountManagementUI(){
		init();
	}
	
	private void init(){
		add = new JButton("����˻�");
		delete=new JButton("ɾ���˻�");
		fix=new JButton("�޸��˻���Ϣ");
		seek=new JButton("�鿴�˻���Ϣ");
		accountname=new JLabel("�˻�����");
		money=new JLabel("�˻����");

		this.setLayout(new BorderLayout());
		//����
        
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,add,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,delete,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,fix,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,seek,constraints,0,3,1,1);

		JPanel lpanel=new JPanel();
		lpanel.setLayout(gb);
		constraints.insets=new Insets(0,0,0,100);
		
		BaseUI.myAdd(lpanel,accountname,constraints,0,0,1,1);
		BaseUI.myAdd(lpanel,money,constraints,1,0,1,1);
	
		
		String nation[] ={"����1","����2","����1","���1"};
		list=new JList(nation);
		this.add(new JScrollPane(list));
		
		
		this.add(lpanel,BorderLayout.NORTH);
		this.add(list,BorderLayout.CENTER);
        this.add(bpanel,BorderLayout.WEST);
	}
 
}
