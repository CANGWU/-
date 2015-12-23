package managerui;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import auditslservice.AuditService;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeTabbedPane;
import free.FreeTable;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import po.IoputPO;
import po.OrderPO;
import po.PaymentPO;
import po.TransportPO;
import twaver.TWaverUtil;
import twaver.table.editor.AbstractCellEditor;
import vo.PaymentVO;

public class AuditPanel {
	private static FreeTabbedPane tab;
	private static AuditService auditService;
	private static ArrayList<OrderPO> Order;
	private static ArrayList<TransportPO> Trans;
	private static ArrayList<PaymentPO> Payment;
	private static ArrayList<IoputPO> Input, Output;


	public static FreePagePane createAuditPage(FreeTabbedPane tab) {
		// TODO Auto-generated method stub
		AuditPanel.tab = tab;

		//auditService =  new  AuditController(null, null, null, null, null, null);

		return createReportPage();
	}

	private static FreePagePane createReportPage() {
		// TODO Auto-generated method stub

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ѡ��");;
		model.addColumn("���ݱ��");
		model.addColumn("��������");
		model.addColumn("״̬");
		//model.addColumn("�տ���/������");


		FreeReportPage page = new FreeReportPage();
		FreeTable table=(FreeTable) page.getTable();
		table.setModel(model);
		
//		TableValue tv =new TableVaule();
//		TableColumnModel tcm= table.getColumnModel();
//        TableColumn tc = tcm.getColumn(TableValues.GENDER);
//        //���á��Ա��еĵ�Ԫ����Ⱦ����renderer��
//        tc.setCellRenderer(newGenderRenderer());
		
		

		TableColumnModel tableColumnModel = table.getColumnModel();
		tableColumnModel.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
		
		
		
		for(int i=0;i<10;i++){
			Vector row=new Vector();
			row.add(new Boolean(false));
			row.add("123456789");
			row.add("װ����");
			row.add("handing");
			model.addRow(row);
		}
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int selectRows=table.getSelectedRows().length;// ȡ���û���ѡ�е�����
				//JOptionPane.showMessageDialog(null, selectRows);
	            int columnIndex = table.columnAtPoint(arg0.getPoint()); //��ȡ�������
				if(selectRows==1&&columnIndex!=0){
					String id = (String) model.getValueAt(table.getSelectedRow(),1);
					String type = (String) model.getValueAt(table.getSelectedRow(),2);
					
				}else if(selectRows>1){
					
					
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				 if(arg0.getClickCount() == 1){
			            int columnIndex = table.columnAtPoint(arg0.getPoint()); //��ȡ�������
			            int rowIndex = table.rowAtPoint(arg0.getPoint()); //��ȡ�������

			            if(columnIndex == 0) {//��0��ʱ��ִ�д���
			                if(table.getValueAt(rowIndex,columnIndex) == null){ //���δ��ʼ����������Ϊfalse
			                      table.setValueAt(false, rowIndex, columnIndex);
			                  }

			                if(((Boolean)table.getValueAt(rowIndex,columnIndex)).booleanValue()){ //ԭ��ѡ��
			                      table.setValueAt(false, rowIndex, 0); //�����ȡ��ѡ��
			                  }
			                else {//ԭ��δѡ��
			                      table.setValueAt(true, rowIndex, 0);
			                  }
			             }
			}
			}
		});

		FreeToolbarButton seek=createButton("/free/test/print.png", "��������", true);
		seek.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				for(int i=0;i<model.getRowCount();i++){
			if((boolean) model.getValueAt(i, 0))
				model.setValueAt("audit", i, 3);
			else 
				model.setValueAt("handing", i, 3);
			}
				
			}
		});
		page.getRightToolBar().add(seek);
		return page;
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
	

  //~ Inner Classes ----------------------------------------------------------------------------------------------------
    
   
    
    
    
     
  

}
