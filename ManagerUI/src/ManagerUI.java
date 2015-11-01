import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



//

public class ManagerUI extends JFrame{
	
	
	public ManagerUI(){
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

private void layoutUI(){
	//ʵ��ҳ���ڵķ�ҳ
	JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
	//������ֻ�Ƿ��㲼��
	Container container = this.getLayeredPane();
	 //��δʵ�֣�����
	 JPanel statusBar = new JPanel();
	 JPanel informationBar = new JPanel();
	 //
	 JPanel aM = new AManagementUI();
	 JPanel pM = new PManagementUI();
	 JPanel report = new ReportUI();
	 JPanel audit = new AuditUI();
	 JPanel constant = new ConstantUI();
	 JPanel salary = new SalaryStrategyUI();
	 JPanel log = new LogIUI();
	 tab.add("��Ա����", aM);
	 tab.add("��������", pM);
	 tab.add("ͳ�Ʊ���", report);
	 tab.add("���е���", audit);
	 tab.add("�ƶ�����", constant);
	 tab.add("нˮ����", salary);
	 tab.add("��־�鿴", log);
	 
	 
	 //��δʵ��
	 statusBar.add(new JLabel("״̬��(δʵ��)"));
	 informationBar.add(new JLabel("�ܾ�����Ϣ(δʵ��)"));
	 //
	container.setLayout(new BorderLayout());
	container.add(tab, BorderLayout.WEST);
	container.add(statusBar, BorderLayout.SOUTH);
	container.add(informationBar, BorderLayout.NORTH);
}


public static void main(String[]args){
	ManagerUI m = new ManagerUI();
}
}
