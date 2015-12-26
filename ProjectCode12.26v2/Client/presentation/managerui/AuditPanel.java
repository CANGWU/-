package managerui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import auditsl.AuditController;
import auditslservice.AuditService;
import courierui.OrderInputPanel;
import enums.DocumentCondition;
import enums.Packing;
import free.BaseUI;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeTabbedPane;
import free.FreeTable;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import free.FreeUtil;
import sendsl.SendController;
import twaver.TWaverUtil;
import vo.BillVO;
import vo.GoodsVO;
import vo.IoputVO;
import vo.OrderVO;
import vo.PaymentVO;
import vo.ReceiptsVO;
import vo.ReceiverVO;
import vo.SenderVO;
import vo.TransportVO;


public class AuditPanel {
	private static FreeTabbedPane tab;
	private static AuditService auditService;
	private static ArrayList<OrderVO> Order;
	private static ArrayList<TransportVO> Trans;
	private static ArrayList<PaymentVO> Payment;
	private static ArrayList<ReceiptsVO> Receipts;
	private static ArrayList<IoputVO> Input, Output;


	public static FreePagePane createAuditPage(FreeTabbedPane tab) {
		// TODO Auto-generated method stub
		AuditPanel.setTab(tab);
		auditService = new AuditController();
		return createReportPage();
	}

	private static FreePagePane createReportPage() {
		// TODO Auto-generated method stub
		Order = auditService.getOrder();
		Trans = auditService.getTransport();
		Payment = auditService.getPayment();
		Receipts = auditService.getReceipts();

		Input = auditService.getInput();
		Output = auditService.getOutput();

		int orderNum = Order.size();
		int transNum = Trans.size();
		int paymentNum = Payment.size();
		int receiptsNum = Receipts.size();

		int inputNum = Input.size();
		int outputNum = Output.size();



		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ѡ��");;
		model.addColumn("���ݱ��");
		model.addColumn("��������");
		model.addColumn("״̬");
		//model.addColumn("�տ���/������");


		FreeReportPage page = new FreeReportPage();
		FreeTable table=(FreeTable) page.getTable();
		table.setModel(model);


		TableColumnModel tableColumnModel = table.getColumnModel();
		tableColumnModel.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));



		for(int i=0;i<Order.size();i++){
			OrderVO vo = Order.get(i);
			Vector row=new Vector();
			row.add(new Boolean(false));
			row.add(vo.getOrdernumber());
			row.add("��ݶ���");
			row.add(vo.getDocumentCondition());
			model.addRow(row);
		}

		for(int i=0;i<Trans.size();i++){
			TransportVO vo = Trans.get(i);
			Vector row=new Vector();
			row.add(new Boolean(false));
			row.add(vo.getID());
			row.add("���䵥");
			row.add(vo.getDocumentCondition());
			model.addRow(row);
		}


		for(int i=0;i<Payment.size();i++){
			PaymentVO vo = Payment.get(i);
			Vector row=new Vector();
			row.add(new Boolean(false));
			row.add(vo.getAuditnumber());
			row.add("���");
			row.add(vo.getCondition());
			model.addRow(row);
		}

		for(int i=0;i<Receipts.size(); i++){
			ReceiptsVO vo = Receipts.get(i);
			Vector row=new Vector();
			row.add(new Boolean(false));
			row.add("--");
			row.add("�տ");
			row.add(vo.getdCondition());
			model.addRow(row);
		}



		//		for(int i=0;i<10;i++){
		//			//IoputVO vo = Output.get(i);
		//			Vector row=new Vector();
		//			row.add(new Boolean(false));
		//			row.add("dd");
		//			row.add("22");
		//			row.add("handing");
		//			model.addRow(row);
		//		}


		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int selectRows=table.getSelectedRows().length;// ȡ���û���ѡ�е�����
				//JOptionPane.showMessageDialog(null, selectRows);
				int columnIndex = table.columnAtPoint(arg0.getPoint()); //��ȡ�������
				if(selectRows==1&&columnIndex!=0){
					int selectRow = table.getSelectedRow();
					String id = (String) model.getValueAt(selectRow,1);
					String type = (String) model.getValueAt(selectRow,2);
					if(type.equals("��ݶ���")){
						String title="��ݶ����޸�";              
							OrderVO vo = Order.get(selectRow);
							JPanel panel = createOrderFixPanel();
							tab.addTab(title, panel);
							FreePagePane pagePane = FreeUtil.getPagePane(panel);
							tab.setSelectedComponent(pagePane);
					}else if(type.equals("���䵥")){


					}else if(type.equals("���")){



					}else if(type.equals("�տ")){


					}else if(type.equals("��ⵥ")){


					}else if(type.equals("��ⵥ")){


					}

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

					if((boolean) model.getValueAt(i, 0)){
						if(i<orderNum){
							OrderVO vo = Order.get(i);
							vo.setDocumentCondition(DocumentCondition.audited);
							Order.set(i, vo);
						}else if(i<(orderNum+transNum)){
							TransportVO vo = Trans.get(i-orderNum);
							vo.setDocumentCondition(DocumentCondition.audited);
							Trans.set(i-orderNum, vo);
						}else if(i<(orderNum+transNum+paymentNum)){
							PaymentVO vo = Payment.get(i-orderNum-transNum);
							vo.setCondition(DocumentCondition.audited);
							Payment.set(i-orderNum-transNum, vo);
						}else if(i<(orderNum+transNum+paymentNum+receiptsNum)){

							ReceiptsVO vo = Receipts.get(i-orderNum-transNum-paymentNum);
							vo.setdCondition(DocumentCondition.audited);
							Receipts.set(i-orderNum-transNum-paymentNum, vo);
						}
						//				}else if(i<(orderNum+transNum+paymentNum+inputNum+receiptsNum)){
						//					IoputVO vo = Input.get(i-orderNum-transNum-paymentNum-receiptsNum);
						////					vo.set;
						//					Input.set(i-orderNum-transNum-paymentNum-receiptsNum, vo);
						//					
						//				}else{
						//					IoputVO vo = Output.get(i-orderNum-transNum-paymentNum-inputNum-receiptsNum);
						////					vo.set;
						//					Output.set(i-orderNum-transNum-paymentNum-inputNum-receiptsNum, vo);	
						model.setValueAt(DocumentCondition.audited, i, 3);
					}else{ 
						if(i<orderNum){
							OrderVO vo = Order.get(i);
							vo.setDocumentCondition(DocumentCondition.handing);
							Order.set(i, vo);
						}else if(i<(orderNum+transNum)){
							TransportVO vo = Trans.get(i-orderNum);
							vo.setDocumentCondition(DocumentCondition.handing);
							Trans.set(i-orderNum, vo);
						}else if(i<(orderNum+transNum+paymentNum)){
							PaymentVO vo = Payment.get(i-orderNum-transNum);
							vo.setCondition(DocumentCondition.handing);
							Payment.set(i-orderNum-transNum, vo);
						}else if(i<(orderNum+transNum+paymentNum+receiptsNum)){
							ReceiptsVO vo = Receipts.get(i-orderNum-transNum-paymentNum);
							vo.setdCondition(DocumentCondition.handing);
							Receipts.set(i-orderNum-transNum-paymentNum, vo);
						}
						//				}else if(i<(orderNum+transNum+paymentNum+inputNum)){
						//					IoputVO vo = Input.get(i-orderNum-transNum-paymentNum);
						////					vo.set;
						//					Input.set(i-orderNum-transNum-paymentNum, vo);
						//					
						//				}else{
						//					IoputVO vo = Output.get(i-orderNum-transNum-paymentNum-inputNum);
						////					vo.set;
						//					Output.set(i-orderNum-transNum-paymentNum-inputNum, vo);	
						//				}
						model.setValueAt(DocumentCondition.handing, i, 3);

					}
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

	public static FreeTabbedPane getTab() {
		return tab;
	}

	public static void setTab(FreeTabbedPane tab) {
		AuditPanel.tab = tab;
	}


	public static JPanel createOrderFixPanel(v(OrderVO vo){
		
//		BillVO billvo = vo.getBill();
		SenderVO senderVO = vo.getSender();
		ReceiverVO receiverVO = vo.getReceiver();
		GoodsVO goodsVO = vo.getGoods();
	    ArrayList<String> packstrlist = new ArrayList<String>();
		ArrayList<Packing> packlist = new ArrayList<Packing>();
		packstrlist.add("ֽ��");
		packstrlist.add("ľ��");
		packstrlist.add("��ݴ�");
		
		packlist.add(Packing.Carton);
		packlist.add(Packing.Wood);
		packlist.add(Packing.Bag);
		
	    MaskFormatter mobilephoneformatter=null;
		try {
			mobilephoneformatter = new MaskFormatter("###########");
		    mobilephoneformatter.setPlaceholderCharacter('0');
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    JPanel panel=new JPanel();
	    JLabel sendername,senderaddress,senderworkplace,senderphone,sendermobilephone;
//	    JTextField sendernamefie,senderaddressfie,senderworkplacefie,senderphonefie;
	    JFormattedTextField sendermobilephonefie = new JFormattedTextField(mobilephoneformatter);
	    JLabel receivername,receiveraddress,receiverworkplace,receiverphone,receivermobilephone;
//	    JTextField receivernamefie,receiveraddressfie,receiverworkplacefie,receiverphonefie;
	    JFormattedTextField receivermobilephonefie = new JFormattedTextField(mobilephoneformatter);
	    JLabel  numberOfGoods,weight,vol,nameOfGoods,size;
//	    JTextField numberOfGoodsfie,weightfie,volfie,nameOfGoodsfie,sizefie;
	    JLabel typeOfPackage;
//		JComboBox packageCombo;
	    JLabel totalFee,receiveFee,changeFee;
	    JLabel dueOfReceive;
	    JLabel typeOfExpress;
//	    JComboBox expressCombo;
	    JLabel ordernumber;
//	    JLabel ordernumberfie;

	    
	    ordernumber=new JLabel("�������룺   " + vo.getOrdernumber());
//	    ordernumberfie=new JLabel("������");
	    sendername=new JLabel("�ļ���������   " + senderVO.getName());
	    senderaddress=new JLabel("�ļ��˵�ַ��   " + senderVO.getAddress());
	    senderworkplace=new JLabel("�ļ��˵�λ��   " + senderVO.getAddress());
	    senderphone=new JLabel("�ļ��˵绰��   " + senderVO.getTelNumber());
	    sendermobilephone=new JLabel("�ļ����ֻ���   " + senderVO.getPhoneNumber());
//	    sendernamefie=new JTextField(20);
//	    senderaddressfie=new JTextField(20);
//	    senderworkplacefie=new JTextField(20);
//	    senderphonefie=new JTextField(20);
//	    sendermobilephonefie=new JTextField(20);
	    receivername=new JLabel("�ռ���������   " + receiverVO.getName());
	    receiveraddress=new JLabel("�ռ��˵�ַ��   " + receiverVO.getAddress() );
	    receiverworkplace=new JLabel("�ռ��˵�λ��   " + receiverVO.getWorkPlace());
	    receiverphone=new JLabel("�ռ��˵绰��   " + receiverVO.getTelNumber());
	    receivermobilephone=new JLabel("�ռ����ֻ���   " + receiverVO.getPhoneNumber());
//	    receivernamefie=new JTextField(20);
//	    receiveraddressfie=new JTextField(20);
//	    receiverworkplacefie=new JTextField(20);
//	    receiverphonefie=new JTextField(20);
//	    receivermobilephonefie=new JTextField(20);
	    numberOfGoods=new JLabel("���������   " + goodsVO.getNumberOfGoods());
	    weight=new JLabel("����������   " + goodsVO.getWeight());
	    vol=new JLabel("���������   " + goodsVO.getVolume());
	    nameOfGoods=new JLabel("�ڼ�Ʒ����   " + goodsVO.getNameOfGoods());
	    size=new JLabel("����ߴ磺   " + goodsVO.getSize());
//	    numberOfGoodsfie=new JTextField(20);
//	    weightfie=new JTextField(20);
//	    volfie=new JTextField(20);
//	    nameOfGoodsfie=new JTextField(20);
//	    sizefie=new JTextField(20);
	    typeOfPackage=new JLabel("��װ���ͣ�   " + goodsVO.getPacking());
//	    packageCombo=new JComboBox();
//	    for(int i=0;i<packstrlist.size();i++){
//	        packageCombo.addItem(packstrlist.get(i));
//	    }

	    totalFee=new JLabel("�ܷ��ã�   " + vo.getBill().getTotalfee());
//	    JLabel totalFeefie=new JLabel("������");
//	    receiveFee=new JLabel("���շ��ã�");
//	    JTextField receiveFeefie=new JTextField(20);
//	    changeFee=new JLabel("���㣺");
//	    JLabel changeFeefie=new JLabel("������");
	    dueOfReceive=new JLabel("Ԥ�ڵ������ڣ�   " + vo.getDueOfReceive());
//	    JLabel dueOfReceivefie=new JLabel("������");
	    typeOfExpress=new JLabel("������ͣ�   " + goodsVO.getExpressType());
//	    expressCombo=new JComboBox();
//	    expressCombo.addItem("���ÿ��");
//	    expressCombo.addItem("��׼���");
//	    expressCombo.addItem("�ؿ�");
	    
	    
	    
	    
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(10,0,10,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		
		BaseUI.myAdd(bpanel,sendername,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,senderaddress,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,senderworkplace,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,senderphone,constraints,0,3,1,1);
		BaseUI.myAdd(bpanel,sendermobilephone,constraints,0,4,1,1);
//		BaseUI.myAdd(bpanel,sendernamefie,constraints,1,0,1,1);
//		BaseUI.myAdd(bpanel,senderaddressfie,constraints,1,1,1,1);
//		BaseUI.myAdd(bpanel,senderworkplacefie,constraints,1,2,1,1);
//		BaseUI.myAdd(bpanel,senderphonefie,constraints,1,3,1,1);
		BaseUI.myAdd(bpanel,sendermobilephonefie,constraints,1,4,1,1);
		BaseUI.myAdd(bpanel,receivername,constraints,2,0,1,1);
		BaseUI.myAdd(bpanel,receiveraddress,constraints,2,1,1,1);
		BaseUI.myAdd(bpanel,receiverworkplace,constraints,2,2,1,1);
		BaseUI.myAdd(bpanel,receiverphone,constraints,2,3,1,1);
		BaseUI.myAdd(bpanel,receivermobilephone,constraints,2,4,1,1);
//		BaseUI.myAdd(bpanel,receivernamefie,constraints,3,0,1,1);
//		BaseUI.myAdd(bpanel,receiveraddressfie,constraints,3,1,1,1);
//		BaseUI.myAdd(bpanel,receiverworkplacefie,constraints,3,2,1,1);
//		BaseUI.myAdd(bpanel,receiverphonefie,constraints,3,3,1,1);
		BaseUI.myAdd(bpanel,receivermobilephonefie,constraints,3,4,1,1);
		
		BaseUI.myAdd(bpanel,numberOfGoods,constraints,0,5,1,1);
		BaseUI.myAdd(bpanel,weight,constraints,0,6,1,1);
		BaseUI.myAdd(bpanel,vol,constraints,0,7,1,1);
		BaseUI.myAdd(bpanel,nameOfGoods,constraints,0,8,1,1);
		BaseUI.myAdd(bpanel,size,constraints,0,9,1,1);
//		BaseUI.myAdd(bpanel,numberOfGoodsfie,constraints,1,5,1,1);
//		BaseUI.myAdd(bpanel,weightfie,constraints,1,6,1,1);
//		BaseUI.myAdd(bpanel,volfie,constraints,1,7,1,1);
//		BaseUI.myAdd(bpanel,nameOfGoodsfie,constraints,1,8,1,1);
//		BaseUI.myAdd(bpanel,sizefie,constraints,1,9,1,1);
		
		BaseUI.myAdd(bpanel,typeOfPackage,constraints,2,5,1,1);
		BaseUI.myAdd(bpanel,typeOfExpress,constraints,2,6,1,1);
		BaseUI.myAdd(bpanel,totalFee,constraints,2,7,1,1);
//		BaseUI.myAdd(bpanel,receiveFee,constraints,2,8,1,1);
//		BaseUI.myAdd(bpanel,changeFee,constraints,2,9,1,1);
//		BaseUI.myAdd(bpanel,packageCombo,constraints,3,5,1,1);
//		BaseUI.myAdd(bpanel,expressCombo,constraints,3,6,1,1);
//		BaseUI.myAdd(bpanel,totalFeefie,constraints,3,7,1,1);
//		BaseUI.myAdd(bpanel,receiveFeefie,constraints,3,8,1,1);
//		BaseUI.myAdd(bpanel,changeFeefie,constraints,3,9,1,1);
		
		BaseUI.myAdd(bpanel,ordernumber,constraints,0,10,1,1);
//		BaseUI.myAdd(bpanel,ordernumberfie,constraints,1,10,1,1);
		BaseUI.myAdd(bpanel,dueOfReceive,constraints,2,10,1,1);
//		BaseUI.myAdd(bpanel,dueOfReceivefie,constraints,3,10,1,1);
		
//		weightfie.setText("(��λ��ǧ��)");
//		volfie.setText("(��λ����������)");
//		sizefie.setText("(��λ������*����*����)");
//		
		JButton sure=new JButton("ȷ��");
		
        JPanel submitpanel=new JPanel();
        submitpanel.add(sure);
		BaseUI.myAdd(bpanel,submitpanel,constraints,1,11,4,1);
		
		sure.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent arg0) 
		    {
//		      if(sure.getText().equals("�������")){
//		    	  if(sendernamefie.getText().equals("")||senderaddress.getText().equals("")||senderworkplacefie.getText().equals("")||sendermobilephonefie.getText().equals("000000000")
//		    			  ||receivernamefie.getText().equals("")||receiveraddress.getText().equals("")||receiverworkplacefie.getText().equals("")||receivermobilephonefie.getText().equals("000000000")
//		    			  ||numberOfGoodsfie.getText().equals("")||weightfie.getText().equals("(��λ��ǧ��)")||volfie.getText().equals("(��λ����������)")||nameOfGoodsfie.getText().equals("")||sizefie.getText().equals("(��λ������*����*����)")){
//		    		  JOptionPane.showMessageDialog(null, "�������ռ��ˡ��ļ��ˡ�����������Ϣ");
//		    		  
//		    	  }else{
//			    	    Date dt = new Date();   
//			    	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
//			    	    String timeOfSend=sdf.format(dt); 
//			    	    int _numberOfGoods=Integer.parseInt(numberOfGoodsfie.getText());
//			    	    double _vol=Double.parseDouble(volfie.getText());
//			    	    double _weight=Double.parseDouble(weightfie.getText());
////			    	    ordervo=new OrderVO(timeOfSend,courierId,sendernamefie.getText(),senderaddressfie.getText(),senderworkplacefie.getText(),senderphonefie.getText(),sendermobilephonefie.getText()
////			    			  ,receivernamefie.getText(),receiveraddressfie.getText(),receiverworkplacefie.getText(),receiverphonefie.getText(),receivermobilephonefie.getText(),_numberOfGoods,_weight,_vol,nameOfGoodsfie.getText(),sizefie.getText()
////			    			  ,expressCombo.getSelectedItem().toString(),changePackingStr(packageCombo.getSelectedItem().toString()),DocumentCondition.handing);
//			    	    vo.setTimeOfSend(timeOfSend);
//			    	    vo.set
//			    	    
//			    	    
//			    	    sc=new SendController();
//			    	    ordervo=sc.calculate(ordervo);
//			    	    billvo=sc.setBill(ordervo);
//			    	    billvo=sc.getchange(Double.parseDouble(receiveFeefie.getText()), billvo);
//			    	    String _dueOfReceive=sc.computedue(ordervo);
//			    	    dueOfReceivefie.setText(_dueOfReceive);
//			    	    ordervo.setDueOfReceive(_dueOfReceive);
//			    	    String _ordernumber=sc.computeOrdernumber();
//			    	    ordernumberfie.setText(_ordernumber);
//			    	    ordervo.setOrdernumber(_ordernumber);
//			    	    
//			    	    sure.setText("ȷ�϶���");
//		    	  }
//		      }else if(sure.getText().equals("ȷ�϶���")){
//		    	  
//		    	  sc.orderend(billvo, ordervo);
//
//
//		      }
		    	tab.remove(FreeUtil.getPagePane(panel));
		    }
		});    
		
		
	    
		panel.add(bpanel);
		
	    return panel;
	}






}
