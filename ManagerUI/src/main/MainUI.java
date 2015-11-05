package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import manangerUI.ManagerUI;
import courierUI.CourierUI;
import finance.FinanceUI;

public class MainUI extends JFrame{

	public static void main(String[]args){
		//ManagerUI m = new ManagerUI();
		CourierUI c=new CourierUI();
		//FinanceUI f=new FinanceUI();
		//MainUI mainui=new MainUI();
		}
	
	public MainUI(){
		this.init();
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
	
	
	public void layoutUI(){
		Container container = this.getLayeredPane();
		
		JLabel label1=new JLabel("订单输入查询入口");
		JLabel label2=new JLabel("请输入11位订单号：");
		JLabel label3=new JLabel("工作人员登录入口");
		JLabel label4=new JLabel("账号：");
		JLabel label5=new JLabel("密码：");
		JButton login=new JButton("登录");
		JButton check=new JButton("查询");
		JLabel systemname=new JLabel("快递物流信息查询系统");
		
		JTextField orderinput=new JTextField(20);
		JTextField account=new JTextField(20);
		JTextField code=new JTextField(20);
		JSeparator sep1=new JSeparator();
		sep1.setOrientation(SwingConstants.VERTICAL);
		
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,systemname,constraints,0,0,4,1);
		BaseUI.myAdd(bpanel,label1,constraints,0,1,2,1);
		BaseUI.myAdd(bpanel,label2,constraints,0,3,1,1);
		BaseUI.myAdd(bpanel,orderinput,constraints,1,3,1,1);
		BaseUI.myAdd(bpanel,check,constraints,0,4,1,1);
		BaseUI.myAdd(bpanel,sep1,constraints,3,1,1,5);
		BaseUI.myAdd(bpanel,label3,constraints,4,1,2,1);
		BaseUI.myAdd(bpanel,label4,constraints,4,3,1,1);
		BaseUI.myAdd(bpanel,account,constraints,5,3,1,1);
		BaseUI.myAdd(bpanel,label5,constraints,4,4,1,1);
		BaseUI.myAdd(bpanel,code,constraints,5,4,1,1);
		BaseUI.myAdd(bpanel,login,constraints,5,5,1,1);
		container.setLayout(new BorderLayout());
		container.add(bpanel,BorderLayout.CENTER);
		
	}
	
	
	
	

}




