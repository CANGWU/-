import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ReportUI extends JPanel {
	public ReportUI(){
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		cReport = new JButton("�ɱ������");
		jReport = new JButton("��Ӫ�����");
		this.setLayout(new BorderLayout());
		//����

	
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,cReport,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,jReport,constraints,0,1,1,1);
        this.add(bpanel,BorderLayout.WEST);

	}
	
	JButton cReport;
	JButton jReport;
	

}
