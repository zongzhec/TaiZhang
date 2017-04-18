package foo.zongzhe.taizhang.view;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class WelcomeView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ���
	JFrame frame = new JFrame();

	// �ܵĿ�ܺͲ���
	JPanel jpBase;
	CardLayout cl;

	// ����ϵ�����
	JPanel jpWelcome, jpReady;
	JLabel jl1, jl2, jl3, jl4;
	JLabel jlRd1, jlRd2, jlRd3;
	JButton jb1;
	JButton jbRd1;
	JTextField jtf1;

	// ����������Ŀ
	JLabel jlfi1, jlfi2, jlfi3, jlfi4, jlfi5, jlfi6, jlfi7, jlfi8;
	JLabel jlfiRd1, jlfiRd2, jlfiRd3, jlfiRd4, jlfiRd5, jlfiRd6, jlfiRd7, jlfiRd8, jlfiRd9, jlfiRd10, jlfiRd11, jlfiRd12, jlfiRd13, jlfiRd14;

	int TesterCount;

	public WelcomeView() {

		showPage();

	}

	public void showPage() {
		// ���ÿ��
		frame.setSize(1000, 600);
		frame.setLocation(300, 200);

		// �ܵĿ�ܺͲ���
		jpBase = new JPanel();
		// container = new Container();
		cl = new CardLayout();
		jpBase.setLayout(cl);
		frame.setContentPane(jpBase);
		frame.setResizable(false);

		// ȫ�ֱ���
		TesterCount = 1;

		// ------------------------------------------------
		// ���û�ӭ���
		jpWelcome = new JPanel();
		jpWelcome.setBorder(new EmptyBorder(5, 5, 5, 5));// �������ı߿�

		// ��������ϵ�ͨ�ò���
		Font fontForLargeText = new Font("TimesRoman", Font.PLAIN, 50);
		Font fontForFillingText = new Font("TimesRoman", Font.PLAIN, 20);
		int gridx = 0;
		int gridy = 0;

		GridBagLayout gbl = new GridBagLayout();
		jpWelcome.setLayout(gbl);

		// ��ʼ��������ϵ�����

		// �ڶ�����д��ӭ��Ϣ
		gridx = 0;
		gridy = 0;
		jl3 = new JLabel("��ӭʹ��̨���������");
		jl3.setFont(fontForLargeText);
		jl3.setHorizontalAlignment(JLabel.CENTER);
		GridBagConstraints gbcJl3 = new GridBagConstraints();
		gbcJl3.insets = new Insets(5, 0, 5, 0);
		gbcJl3.fill = GridBagConstraints.BOTH;
		gbcJl3.gridwidth = 5;
		gbcJl3.gridheight = 1;
		gbcJl3.gridx = gridx;
		gbcJl3.gridy = gridy;
		jpWelcome.add(jl3, gbcJl3);

		// �����л��ǿ���
		gridx = 0;
		gridy++;
		jlfi7 = new JLabel(" ");
		jlfi7.setFont(fontForFillingText);
		GridBagConstraints gbcJlfi7 = new GridBagConstraints();// ���������鲼��Լ������
		gbcJlfi7.insets = new Insets(5, 0, 5, 0);
		gbcJlfi7.fill = GridBagConstraints.BOTH;
		gbcJlfi7.gridwidth = 5;
		gbcJlfi7.gridheight = 1;
		gbcJlfi7.gridx = gridx;
		gbcJlfi7.gridy = gridy;
		jpWelcome.add(jlfi7, gbcJlfi7);

		// ������ѡ�����������
		gridx = 0;
		gridy++;
		jl4 = new JLabel("��������˧��˧��");
		jl4.setFont(fontForLargeText);
		jl4.setHorizontalAlignment(JLabel.CENTER);
		GridBagConstraints gbcJl4 = new GridBagConstraints();
		gbcJl4.insets = new Insets(5, 0, 5, 0);
		gbcJl4.fill = GridBagConstraints.BOTH;
		gbcJl4.gridwidth = 5;
		gbcJl4.gridheight = 1;
		gbcJl4.gridx = gridx;
		gbcJl4.gridy = gridy;
		jpWelcome.add(jl4, gbcJl4);

		// �����л��ǿ���
		gridx = 1;
		gridy++;
		jlfi8 = new JLabel(" ");
		jlfi8.setFont(fontForFillingText);
		GridBagConstraints gbcJlfi8 = new GridBagConstraints();// ���������鲼��Լ������
		gbcJlfi8.insets = new Insets(5, 0, 5, 0);
		gbcJlfi8.fill = GridBagConstraints.BOTH;
		gbcJlfi8.gridwidth = 5;
		gbcJlfi8.gridheight = 1;
		gbcJlfi8.gridx = gridx;
		gbcJlfi8.gridy = gridy;
		jpWelcome.add(jlfi8, gbcJlfi8);

		// ������Ϊ��ʼ���԰�ť
		gridx = 1;
		gridy++;
		jb1 = new JButton("˧������ʼ����̨��");
		jb1.setFont(fontForLargeText);
		GridBagConstraints gbcJb1 = new GridBagConstraints();// ���������鲼��Լ������
		gbcJb1.insets = new Insets(5, 5, 5, 5);
		gbcJb1.fill = GridBagConstraints.BOTH;
		gbcJb1.gridwidth = 1;
		gbcJb1.gridheight = 1;
		gbcJb1.gridx = gridx;
		gbcJb1.gridy = gridy;
		jpWelcome.add(jb1, gbcJb1);
		jb1.addActionListener(this);

		// �����л��ǿ���
		gridx = 0;
		gridy++;
		jlfi6 = new JLabel(" ");
		jlfi6.setFont(fontForFillingText);
		GridBagConstraints gbcJlfi6 = new GridBagConstraints();// ���������鲼��Լ������
		gbcJlfi6.insets = new Insets(5, 0, 5, 5);
		gbcJlfi6.fill = GridBagConstraints.BOTH;
		gbcJlfi6.gridwidth = 3;
		gbcJlfi6.gridheight = 1;
		gbcJlfi6.gridx = gridx;
		gbcJlfi6.gridy = gridy;
		jpWelcome.add(jlfi6, gbcJlfi6);

		jpBase.add(jpWelcome);

		frame.setTitle("̨���������");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new WelcomeView();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// ����û��ڻ�ӭ���浥��"��ʼ����"����ת�����ɽ���
		if (e.getSource() == jb1) {

			ProcessView pv = new ProcessView();
			String title = "���������ļ�����";
			pv.showPage(title);
			;
		}

	}

}
