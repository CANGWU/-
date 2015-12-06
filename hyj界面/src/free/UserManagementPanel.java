package free;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import twaver.TWaverUtil;
import free.BaseUI;

public class UserManagementPanel extends JPanel {
	public static JPanel addUserPanel, deleteUserPanel, fixUserPanel,
			seekUserPanel;
	public static JTabbedPane tab;

	public static FreeReportPage createUserManagementPage(JTabbedPane tab) {
		UserManagementPanel.tab = tab;
		return createReportPage();
	}

	private static void createAddUserPanel() {
		addUserPanel = new JPanel();
		JLabel account = new JLabel("�˺�");
		JLabel name = new JLabel("����");
		JLabel code = new JLabel("����");
		JLabel privileges = new JLabel("Ȩ��");
		JLabel work = new JLabel("������λ");
		JTextField accountfield = new JTextField(10);
		JTextField namefield = new JTextField(20);
		JTextField codefield = new JTextField(20);
		JComboBox privilegesCombo = new JComboBox();
		privilegesCombo.addItem("��");
		privilegesCombo.addItem("��");
		JComboBox workCombo = new JComboBox();
		workCombo.addItem("���Ա");
		workCombo.addItem("Ӫҵ��ҵ��Ա");
		workCombo.addItem("��ת����ҵ��Ա");
		workCombo.addItem("��ת���Ĳֿ����Ա");
		workCombo.addItem("������Ա");
		workCombo.addItem("����Ա");
		workCombo.addItem("�ܾ���");
		workCombo.addItem("˾��");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, code, constraints, 0, 2, 1, 1);
		BaseUI.myAdd(bpanel, privileges, constraints, 0, 3, 1, 1);
		BaseUI.myAdd(bpanel, work, constraints, 0, 4, 1, 1);

		BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
		BaseUI.myAdd(bpanel, codefield, constraints, 1, 2, 1, 1);
		BaseUI.myAdd(bpanel, privilegesCombo, constraints, 1, 3, 1, 1);
		BaseUI.myAdd(bpanel, workCombo, constraints, 1, 4, 1, 1);

		JButton submit = new JButton("�ύ");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);

		addUserPanel.add(bpanel);
	}

	private static void createDeleteUserPanel() {
		deleteUserPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel account = new JLabel("�˺�");
		JTextField accountfield = new JTextField(10);
		BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("��ѯɾ���û���Ϣ");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("ȷ��ɾ��");
				bpanel.remove(account);
				bpanel.remove(accountfield);
				JLabel account = new JLabel("�˺�");
				JLabel name = new JLabel("����");
				JLabel code = new JLabel("����");
				JLabel privileges = new JLabel("Ȩ��");
				JLabel work = new JLabel("������λ");
				JLabel accountfield = new JLabel();
				JLabel namefield = new JLabel();
				JLabel codefield = new JLabel();
				JLabel privilegesfield = new JLabel();
				JLabel workfield = new JLabel();

				BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, code, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, privileges, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, work, constraints, 0, 4, 1, 1);

				BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, codefield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, privilegesfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, workfield, constraints, 1, 4, 1, 1);
			}
		});

		deleteUserPanel.add(bpanel);
	}

	private static void createFixUserPanel() {
		fixUserPanel = new JPanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel account = new JLabel("�˺�");
		JTextField accountfield = new JTextField(10);
		BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("��ѯ�޸��û���Ϣ");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel account = new JLabel("�˺�");
				JLabel name = new JLabel("����");
				JLabel code = new JLabel("����");
				JLabel privileges = new JLabel("Ȩ��");
				JLabel work = new JLabel("������λ");
				JTextField accountfield = new JTextField(10);
				JTextField namefield = new JTextField(20);
				JTextField codefield = new JTextField(20);
				JComboBox privilegesCombo = new JComboBox();
				privilegesCombo.addItem("��");
				privilegesCombo.addItem("��");
				JComboBox workCombo = new JComboBox();
				workCombo.addItem("���Ա");
				workCombo.addItem("Ӫҵ��ҵ��Ա");
				workCombo.addItem("��ת����ҵ��Ա");
				workCombo.addItem("��ת���Ĳֿ����Ա");
				workCombo.addItem("������Ա");
				workCombo.addItem("����Ա");
				workCombo.addItem("�ܾ���");
				workCombo.addItem("˾��");

				BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, code, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, privileges, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, work, constraints, 0, 4, 1, 1);

				BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, codefield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, privilegesCombo, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, workCombo, constraints, 1, 4, 1, 1);

				submit.setText("ȷ���޸�");
			}

		});

		fixUserPanel.add(bpanel);

	}

	private static void createSeekUserPanel() {
		seekUserPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel account = new JLabel("�˺�");
		JTextField accountfield = new JTextField(10);
		BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("��ѯ�û���Ϣ");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("ȷ��");
				bpanel.remove(account);
				bpanel.remove(accountfield);
				JLabel account = new JLabel("�˺�");
				JLabel name = new JLabel("����");
				JLabel code = new JLabel("����");
				JLabel privileges = new JLabel("Ȩ��");
				JLabel work = new JLabel("������λ");
				JLabel accountfield = new JLabel();
				JLabel namefield = new JLabel();
				JLabel codefield = new JLabel();
				JLabel privilegesfield = new JLabel();
				JLabel workfield = new JLabel();

				BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, code, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, privileges, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, work, constraints, 0, 4, 1, 1);

				BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, codefield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, privilegesfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, workfield, constraints, 1, 4, 1, 1);
			}
		});

		seekUserPanel.add(bpanel);
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("�˺�");
		model.addColumn("����");
		model.addColumn("����");
		model.addColumn("Ȩ��");
		model.addColumn("������λ");

		for (int i = 0; i < 100; i++) {
			Vector row = new Vector();
			row.add("000000001");
			row.add("����");
			row.add("123456");
			row.add("��");
			row.add("���Ա");
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
		FreeToolbarButton addUser, deleteUser, fixUser, seekUser;
		addUser = createButton("/free/test/add.png", "�����û�", true);
		deleteUser = createButton("/free/test/update.png", "ɾ���û�", true);
		fixUser = createButton("/free/test/refresh.png", "�޸��û�", true);
		seekUser = createButton("/free/test/print.png", "�����û�", true);
		page.getRightToolBar().add(addUser);
		page.getRightToolBar().add(deleteUser);
		page.getRightToolBar().add(fixUser);
		page.getRightToolBar().add(seekUser);

		addUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = addUser.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil.getPagePane(addUserPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createAddUserPanel();
					tab.addTab(title, Shell.createPage(addUserPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(addUserPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		deleteUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = deleteUser.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteUserPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createDeleteUserPanel();
					tab.addTab(title, Shell.createPage(deleteUserPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteUserPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		fixUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = fixUser.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil.getPagePane(fixUserPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createFixUserPanel();
					tab.addTab(title, Shell.createPage(fixUserPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(fixUserPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		seekUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = seekUser.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil.getPagePane(seekUserPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createSeekUserPanel();
					tab.addTab(title, Shell.createPage(seekUserPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(seekUserPanel);
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

}
