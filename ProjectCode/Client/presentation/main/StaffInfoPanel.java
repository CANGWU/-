package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import dataserviceimpl.DataFactory;
import adminui.AdminUI;
import pamanagementsl.PManagement;
import pamanagementsl.PManagementController;
import twaver.TWaverUtil;
import usersl.UserManagement;
import usersl.UserManagementController;
import vo.StaffVO;
import vo.UserVO;
import enums.ResultMessage;
import free.BaseUI;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import free.FreeUtil;

public class StaffInfoPanel extends JPanel{
	
	public static JTabbedPane tab;
	static JPanel fixCodePanel;
	static String userId;
	static StaffVO staffVO;
	public static UserVO userVO;

	
	

	
	public static FreeReportPage  createStaffInfoPage(JTabbedPane tab,String userId){

	    StaffInfoPanel.tab=tab;
	    StaffInfoPanel.userId=userId;
		return createReportPage();
	}
	
    private static FreeReportPage createReportPage() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("�˺�");
        model.addColumn("����");
        model.addColumn("�Ա�");
        model.addColumn("������");
        model.addColumn("ְλ");

        

//        StaffInfoPanel.findUser(userId);
//        
//        Vector row=new Vector();
//        row.add(userId);
//        row.add(staffVO.getName());
//        row.add(staffVO.getSex().toString());
//        row.add(staffVO.getWorkPlaceNumber());
//        row.add(staffVO.getWork().toString());
//        model.addRow(row);
        

        for (int i = 0; i < 1; i++) {
            Vector row = new Vector();
            row.add("000000001");
            row.add("����");
            row.add("��");
            row.add("��¥Ӫҵ��");
            row.add("����Ա");
            model.addRow(row);
        }

        FreeReportPage page = new FreeReportPage();
        page.getTable().setModel(model);
        page.setDescription("��������ĸ�����Ϣ") ;
        setupPageToolbar(page);

        return page;
    }

  public static void setupPageToolbar(FreePagePane page) {
	  FreeToolbarButton fixCode;

      fixCode=createButton("/free/test/refresh.png", "�޸�����", true);
 
      page.getRightToolBar().add(fixCode);
      

		
		fixCode.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent arg0) 
		    {   
		    	String title=fixCode.getToolTipText();                
                try{
                 FreePagePane pagePane = FreeUtil.getPagePane(fixCodePanel);
                 tab.setSelectedComponent(pagePane);
                }catch(Exception ex){
                    createFixCodePanel();
             	    tab.addTab(title, AdminUI.createPage(fixCodePanel));
                    FreePagePane pagePane = FreeUtil.getPagePane(fixCodePanel);
                    tab.setSelectedComponent(pagePane);
                }

             
		    }
		});
      
}
  
	private static void createFixCodePanel(){
		fixCodePanel=new JPanel();
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		
		
		JLabel oldcode=new JLabel("�����룺");
		JTextField codefield=new JTextField(16);
		BaseUI.myAdd(bpanel,oldcode,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,codefield,constraints,1,0,1,1);
		JLabel newcode=new JLabel("�����룺");
		JTextField newcodefield=new JTextField(16);
		BaseUI.myAdd(bpanel,newcode,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,newcodefield,constraints,1,1,1,1);
		JLabel newcodecheck=new JLabel("������ȷ�ϣ�");
		JTextField newcodecheckfield=new JTextField(16);
		BaseUI.myAdd(bpanel,newcodecheck,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,newcodecheckfield,constraints,1,2,1,1);
		
		
		JButton submit=new JButton("ȷ���޸�");
		BaseUI.myAdd(bpanel,submit,constraints,0,5,2,1);
		submit.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent arg0) 
		    {   
                   String oldcodestr=oldcode.getText();
                   String newcodestr=newcode.getText();
                   String newcodecheckstr=newcodecheck.getText();
                   
                   if(!oldcodestr.equals(userVO.getCode())){
                	   oldcode.setText("�������������");
                   }else if(!newcodestr.equals(newcodecheckstr)){
                	   newcode.setText("������ǰ�����벻һ��");
                	   newcodecheck.setText("������ǰ�����벻һ��");
                   }else{
                	      userVO.setCode(newcodestr);
                	      UserManagement userManagement=UserManagement.creatUserManagement();
                	      ResultMessage message=userManagement.saveChange(userVO);
                	      if(message==ResultMessage.SUCCESS){
                	    	  JOptionPane.showMessageDialog(null, "�޸ĳɹ�"); 
                	    	  tab.remove(FreeUtil.getPagePane(fixCodePanel));
                	      }else{
                	    	  JOptionPane.showMessageDialog(null, "�޸�ʧ��"); 
                	      }
                   }
		    }
		});
		
		fixCodePanel.add(bpanel);
	}
	
  public static FreeToolbarButton createButton(String icon, String tooltip, boolean rover) {
      FreeToolbarButton button = null;
      if (rover) {
          button = new FreeToolbarRoverButton();
      } else {
          button = new FreeToolbarButton();
      }
      button.setIcon(TWaverUtil.getIcon(icon));
      button.setToolTipText(tooltip);
      
      return button;
  }

  private static void findUser(String id){
	  
	  PManagementController pm=null;
		pm = new PManagementController();

      staffVO=pm.select(id);
      UserManagementController userManagement=new UserManagementController();
      userVO=userManagement.select(id);
  }

}