package officerui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import twaver.TWaverUtil;
import free.BaseUI;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import free.FreeUtil;

public class VehicleManagementPanel {
	public static JPanel addVehiclePanel, deleteVehiclePanel, fixVehiclePanel,
			seekVehiclePanel;
	public static JTabbedPane tab;

	public static FreeReportPage createVehicleManagementPage(JTabbedPane tab) {
		VehicleManagementPanel.tab = tab;
		return createReportPage();
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("��������");
		model.addColumn("�������");
		model.addColumn("��������");
		model.addColumn("���̺�");
		model.addColumn("����ʱ��");
		model.addColumn("����ʱ��");
		model.addColumn("����ͼƬ");

		for (int i = 0; i < 100; i++) {
			Vector row = new Vector();
			row.add("00001");
			row.add("00002");
			row.add("00003");
			row.add("00004");
			row.add("2015/12/06");
			row.add("2015/12/07");
			row.add("��");
			model.addRow(row);
		}

		FreeReportPage page = new FreeReportPage();
		page.getTable().setModel(model);
		page.setDescription("All Work Order Items by Part Number. Created "
				+ new Date().toString());
		setupPageToolbar(page);

		return page;
	}

	public static void setupPageToolbar(FreePagePane page) {
		FreeToolbarButton addVehicle, deleteVehicle, fixVehicle, seekVehicle;
		addVehicle = createButton("/free/test/add.png", "���ӳ���", true);
		deleteVehicle = createButton("/free/test/update.png", "ɾ������", true);
		fixVehicle = createButton("/free/test/refresh.png", "�޸ĳ���", true);
		seekVehicle = createButton("/free/test/print.png", "���ҳ���", true);
		page.getRightToolBar().add(addVehicle);
		page.getRightToolBar().add(deleteVehicle);
		page.getRightToolBar().add(fixVehicle);
		page.getRightToolBar().add(seekVehicle);

		addVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = addVehicle.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(addVehiclePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createAddDriverPanel();
					tab.addTab(title, OfficerUI.createPage(addVehiclePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(addVehiclePanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		deleteVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = deleteVehicle.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteVehiclePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createDeleteDriverPanel();
					tab.addTab(title, OfficerUI.createPage(deleteVehiclePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteVehiclePanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		fixVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = fixVehicle.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixVehiclePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createFixDriverPanel();
					tab.addTab(title, OfficerUI.createPage(fixVehiclePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixVehiclePanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		seekVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = seekVehicle.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekVehiclePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createSeekDriverPanel();
					tab.addTab(title, OfficerUI.createPage(seekVehiclePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekVehiclePanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

	}

	public static FreeToolbarButton createButton(String icon, String tooltip,
			boolean rover) {
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

	private static void createAddDriverPanel() {
		addVehiclePanel = new JPanel();
		JLabel vehicleMark = new JLabel("��������");
		JLabel vehicleID = new JLabel("�������");
		JLabel engineID = new JLabel("��������");
		JLabel underpanID = new JLabel("���̺�");
		JLabel timeOfBuy = new JLabel("����ʱ��");
		JLabel workingTime = new JLabel("����ʱ��");
		JLabel picture = new JLabel("����ͼƬ");
		JTextField vehicleMarkfield = new JTextField(10);
		JTextField vehicleIDfield = new JTextField(10);
		JTextField engineIDfield = new JTextField(10);
		JTextField underpanIDfield = new JTextField(10);
		JTextField timeOfBuyfield = new JTextField(10);
		JTextField workingTimefield = new JTextField(10);

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, engineID, constraints, 0, 2, 1, 1);
		BaseUI.myAdd(bpanel, underpanID, constraints, 0, 3, 1, 1);
		BaseUI.myAdd(bpanel, timeOfBuy, constraints, 0, 4, 1, 1);
		BaseUI.myAdd(bpanel, workingTime, constraints, 0, 5, 1, 1);
		BaseUI.myAdd(bpanel, picture, constraints, 0, 6, 1, 1);

		BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 1, 1, 1);
		BaseUI.myAdd(bpanel, engineIDfield, constraints, 1, 2, 1, 1);
		BaseUI.myAdd(bpanel, underpanIDfield, constraints, 1, 3, 1, 1);
		BaseUI.myAdd(bpanel, timeOfBuyfield, constraints, 1, 4, 1, 1);
		BaseUI.myAdd(bpanel, workingTimefield, constraints, 1, 5, 1, 1);

		JButton submit = new JButton("�ύ");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 7, 2, 1);

		addVehiclePanel.add(bpanel);
	}

	private static void createDeleteDriverPanel() {
		deleteVehiclePanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel vehicleMark = new JLabel("��������");
		JTextField vehicleMarkfield = new JTextField(10);
		BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("��ѯɾ��������Ϣ");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 7, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("ȷ��ɾ��");
				bpanel.remove(vehicleMark);
				bpanel.remove(vehicleMarkfield);
				JLabel vehicleMark = new JLabel("��������");
				JLabel vehicleID = new JLabel("�������");
				JLabel engineID = new JLabel("��������");
				JLabel underpanID = new JLabel("���̺�");
				JLabel timeOfBuy = new JLabel("����ʱ��");
				JLabel workingTime = new JLabel("����ʱ��");
				JLabel picture = new JLabel("����ͼƬ");
				JLabel vehicleMarkfield = new JLabel("00001");
				JLabel vehicleIDfield = new JLabel("00002");
				JLabel engineIDfield = new JLabel("00003");
				JLabel underpanIDfield = new JLabel("00004");
				JLabel timeOfBuyfield = new JLabel("2015/12/06");
				JLabel workingTimefield = new JLabel("2015/12/07");

				BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, underpanID, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuy, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTime, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, picture, constraints, 0, 6, 1, 1);

				BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, underpanIDfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuyfield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTimefield, constraints, 1, 5, 1, 1);
			}
		});

		deleteVehiclePanel.add(bpanel);
	}

	private static void createFixDriverPanel() {
		fixVehiclePanel = new JPanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel vehicleMark = new JLabel("��������");
		JTextField vehicleMarkfield = new JTextField(10);
		BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("�޸ĳ�����Ϣ");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 7, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel vehicleMark = new JLabel("��������");
				JLabel vehicleID = new JLabel("�������");
				JLabel engineID = new JLabel("��������");
				JLabel underpanID = new JLabel("���̺�");
				JLabel timeOfBuy = new JLabel("����ʱ��");
				JLabel workingTime = new JLabel("����ʱ��");
				JLabel picture = new JLabel("����ͼƬ");
				JTextField vehicleMarkfield = new JTextField(10);
				JTextField vehicleIDfield = new JTextField(10);
				JTextField engineIDfield = new JTextField(10);
				JTextField underpanIDfield = new JTextField(10);
				JTextField timeOfBuyfield = new JTextField(10);
				JTextField workingTimefield = new JTextField(10);

				BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, underpanID, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuy, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTime, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, picture, constraints, 0, 6, 1, 1);

				BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, underpanIDfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuyfield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTimefield, constraints, 1, 5, 1, 1);
				
				submit.setText("ȷ���޸�");
			}

		});

		fixVehiclePanel.add(bpanel);

	}

	private static void createSeekDriverPanel() {
		seekVehiclePanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel vehicleMark = new JLabel("��������");
		JTextField vehicleMarkfield = new JTextField(10);
		BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("��ѯ������Ϣ");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 7, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("ȷ��");
				bpanel.remove(vehicleMark);
				bpanel.remove(vehicleMarkfield);
				JLabel vehicleMark = new JLabel("��������");
				JLabel vehicleID = new JLabel("�������");
				JLabel engineID = new JLabel("��������");
				JLabel underpanID = new JLabel("���̺�");
				JLabel timeOfBuy = new JLabel("����ʱ��");
				JLabel workingTime = new JLabel("����ʱ��");
				JLabel picture = new JLabel("����ͼƬ");
				JLabel vehicleMarkfield = new JLabel("00001");
				JLabel vehicleIDfield = new JLabel("00002");
				JLabel engineIDfield = new JLabel("00003");
				JLabel underpanIDfield = new JLabel("00004");
				JLabel timeOfBuyfield = new JLabel("2015/12/06");
				JLabel workingTimefield = new JLabel("2015/12/07");

				BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, underpanID, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuy, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTime, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, picture, constraints, 0, 6, 1, 1);

				BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, underpanIDfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuyfield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTimefield, constraints, 1, 5, 1, 1);
			}
		});

		seekVehiclePanel.add(bpanel);
	}
}
