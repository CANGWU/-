import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class PManagementUI extends JPanel {
	public PManagementUI(){
		init();
	}
	
	//��ʼ��
	public void init(){
        add = new JButton("��ӻ���");
		del = new JButton("ɾ������");
		update = new JButton("�޸Ļ���");
		seek = new JButton("���һ���");
		this.setLayout(new BorderLayout());
		//����

	
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,add,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,del,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,update,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,seek,constraints,0,3,1,1);
        this.add(bpanel,BorderLayout.WEST);

	}
	//����������Գ������������
	
	JButton add;
	JButton del;
	JButton update;
	JButton seek;

}
