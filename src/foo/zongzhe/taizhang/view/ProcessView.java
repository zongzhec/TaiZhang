package foo.zongzhe.taizhang.view;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProcessView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ���
	JFrame frame = new JFrame();

	// �ܵĿ�ܺͲ���
	JPanel jpPreWel;

	// ����ϵ�����
	JLabel jl1;

	public ProcessView() {

		// showPage("���ڽ����д���ļ�");
	}

	public void showPage(String title) {

		// ���ÿ��
		frame.setSize(400, 300);
		frame.setLocation(600, 300);

		// �ܵĿ�ܺͲ���
		jpPreWel = new JPanel();
		jpPreWel.setBounds(5, 5, 5, 5);

		// ��������ϵ�ͨ�ò���
		Font fontForFillingText = new Font("TimesRoman", Font.PLAIN, 20);

		jl1 = new JLabel("<html><body><p></p><p><center>" + title + "</center></p><p><center>�������Ҫ������</center></p><p><center>�벻Ҫ�رմ˴���</center></p><body></html>");
		jl1.setFont(fontForFillingText);
		jl1.setHorizontalAlignment(JLabel.CENTER);

		jpPreWel.add(jl1, BorderLayout.CENTER);
		frame.add(jpPreWel);

		frame.setTitle("̨����������");

		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void hidePage() {
		frame.setVisible(false);
	}

	public static void main(String[] args) {
		new ProcessView();

	}

}