package userUI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

//

public class UserUI extends JFrame{
	JLabel message;
	JTabbedPane tab;
	
	public UserUI(){
		super("�������ϵͳ");
		init();
	}
	
	public void init(){
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter(){
			   public void windowClosing(WindowEvent e) {
			    super.windowClosing(e);
			    System.exit(0);
			   }});
			  layoutUI();
			  this.setVisible(true);
}

	
	public static void main(String[] args){
		UserUI user = new UserUI();
	}
	
private void layoutUI(){
	//ʵ��ҳ���ڵķ�
	tab = new JTabbedPane(JTabbedPane.LEFT);
	//������ֻ�Ƿ��㲼��
	Container container = this.getLayeredPane();
	
	JSeparator sep1=new JSeparator();
	JSeparator sep2=new JSeparator();
	sep1.setOrientation(SwingConstants.HORIZONTAL);
	sep2.setOrientation(SwingConstants.HORIZONTAL);
	message=new JLabel("����Ա��Ϣ");
	 //��δʵ�֣�����
	 JPanel statusBar = new JPanel();
	 JPanel informationBar = new JPanel();
	 //
	 JPanel user = new UserManagementUI();
	 tab.add("�û�����",user);
	
	 
	 
	 //��δʵ��
     informationBar.setLayout(new BorderLayout());
		informationBar.add(new JLabel("�������ϵͳELS"),BorderLayout.WEST);
		informationBar.add(message,BorderLayout.EAST);
		informationBar.add(sep1,BorderLayout.SOUTH);
		
		statusBar.setLayout(new BorderLayout());
		statusBar.add(new JLabel("״̬��(δʵ��)"),BorderLayout.SOUTH);
		statusBar.add(sep2,BorderLayout.NORTH);
	 //
	container.setLayout(new BorderLayout());
	container.add(tab, BorderLayout.CENTER);
	container.add(statusBar, BorderLayout.SOUTH);
	container.add(informationBar, BorderLayout.NORTH);
}



}
