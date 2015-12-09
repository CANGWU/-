package courierui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class CourierUI extends JFrame{
	JPanel statusBar;
	JPanel informationBar;
	JLabel message;

	
	public CourierUI(){
		super("�������ϵͳ");
		this.init();
	}
	
	public void init(){
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter(){
			   @Override
			public void windowClosing(WindowEvent e) {
			    super.windowClosing(e);
			    System.exit(0);
			   }});
			  layoutUI();
			  this.setVisible(true);
	}
	
	private void layoutUI(){
		JTabbedPane tab = new JTabbedPane(SwingConstants.LEFT);
		statusBar = new JPanel();
		informationBar = new JPanel();
		JSeparator sep1=new JSeparator();
		JSeparator sep2=new JSeparator();
		sep1.setOrientation(SwingConstants.HORIZONTAL);
		sep2.setOrientation(SwingConstants.HORIZONTAL);
		
		
		message=new JLabel("���Ա��Ϣ");
		
		
		Container container = this.getLayeredPane();
		
		JPanel orderinputui=new OrderInputUI();
		JPanel receiveui=new ReceiveUI();
		JPanel deliveryui=new DeliveryCheckUI();
		tab.add("��������",orderinputui);
		tab.add("�ռ�����",receiveui);
		tab.add("�ɼ�����ѯ",deliveryui);
		
        informationBar.setLayout(new BorderLayout());
		informationBar.add(new JLabel("�������ϵͳELS"),BorderLayout.WEST);
		informationBar.add(message,BorderLayout.EAST);
		informationBar.add(sep1,BorderLayout.SOUTH);
		
		statusBar.setLayout(new BorderLayout());
		statusBar.add(new JLabel("״̬��(δʵ��)"),BorderLayout.SOUTH);
		statusBar.add(sep2,BorderLayout.NORTH);
		 
		 
		container.setLayout(new BorderLayout());
		container.add(tab, BorderLayout.CENTER);
		container.add(statusBar, BorderLayout.SOUTH);
		container.add(informationBar, BorderLayout.NORTH);
	}

}
