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

import foo.zongzhe.taizhang.common.GenerateZongbiao;

public class WelcomeView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 框架
	JFrame frame = new JFrame();

	// 总的框架和布局
	JPanel jpBase;
	CardLayout cl;

	// 面板上的内容
	JPanel jpWelcome, jpReady;
	JLabel jl1, jl2, jl3, jl4;
	JLabel jlRd1, jlRd2, jlRd3;
	JButton jb1;
	JButton jbRd1;
	JTextField jtf1;

	// 用于填充的项目
	JLabel jlfi1, jlfi2, jlfi3, jlfi4, jlfi5, jlfi6, jlfi7, jlfi8;
	JLabel jlfiRd1, jlfiRd2, jlfiRd3, jlfiRd4, jlfiRd5, jlfiRd6, jlfiRd7, jlfiRd8, jlfiRd9, jlfiRd10, jlfiRd11, jlfiRd12, jlfiRd13, jlfiRd14;

	int TesterCount;

	public WelcomeView() {
		setup();
		showPage();

	}
	
	public void setup(){
		// 生成log文件
		
	}

	public void showPage() {
		// 设置框架
		frame.setSize(1000, 600);
		frame.setLocation(300, 200);

		// 总的框架和布局
		jpBase = new JPanel();
		// container = new Container();
		cl = new CardLayout();
		jpBase.setLayout(cl);
		frame.setContentPane(jpBase);
		frame.setResizable(false);

		// 全局变量
		TesterCount = 1;

		// ------------------------------------------------
		// 设置欢迎面板
		jpWelcome = new JPanel();
		jpWelcome.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板的边框

		// 设置面板上的通用部件
		Font fontForLargeText = new Font("TimesRoman", Font.PLAIN, 50);
		Font fontForFillingText = new Font("TimesRoman", Font.PLAIN, 20);
		int gridx = 0;
		int gridy = 0;

		GridBagLayout gbl = new GridBagLayout();
		jpWelcome.setLayout(gbl);

		// 开始加载面板上的内容

		// 第二行填写欢迎信息
		gridx = 0;
		gridy = 0;
		jl3 = new JLabel("欢迎使用台账生成软件");
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

		// 第三行还是空行
		gridx = 0;
		gridy++;
		jlfi7 = new JLabel(" ");
		jlfi7.setFont(fontForFillingText);
		GridBagConstraints gbcJlfi7 = new GridBagConstraints();// 创建网格组布局约束条件
		gbcJlfi7.insets = new Insets(5, 0, 5, 0);
		gbcJlfi7.fill = GridBagConstraints.BOTH;
		gbcJlfi7.gridwidth = 5;
		gbcJlfi7.gridheight = 1;
		gbcJlfi7.gridx = gridx;
		gbcJlfi7.gridy = gridy;
		jpWelcome.add(jlfi7, gbcJlfi7);

		// 第四行选择测试者人数
		gridx = 0;
		gridy++;
		jl4 = new JLabel("就问你我帅不帅？");
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

		// 第五行还是空行
		gridx = 1;
		gridy++;
		jlfi8 = new JLabel(" ");
		jlfi8.setFont(fontForFillingText);
		GridBagConstraints gbcJlfi8 = new GridBagConstraints();// 创建网格组布局约束条件
		gbcJlfi8.insets = new Insets(5, 0, 5, 0);
		gbcJlfi8.fill = GridBagConstraints.BOTH;
		gbcJlfi8.gridwidth = 5;
		gbcJlfi8.gridheight = 1;
		gbcJlfi8.gridx = gridx;
		gbcJlfi8.gridy = gridy;
		jpWelcome.add(jlfi8, gbcJlfi8);

		// 第六行为开始测试按钮
		gridx = 1;
		gridy++;
		jb1 = new JButton("帅，并开始生成台账");
		jb1.setFont(fontForLargeText);
		GridBagConstraints gbcJb1 = new GridBagConstraints();// 创建网格组布局约束条件
		gbcJb1.insets = new Insets(5, 5, 5, 5);
		gbcJb1.fill = GridBagConstraints.BOTH;
		gbcJb1.gridwidth = 1;
		gbcJb1.gridheight = 1;
		gbcJb1.gridx = gridx;
		gbcJb1.gridy = gridy;
		jpWelcome.add(jb1, gbcJb1);
		jb1.addActionListener(this);

		// 第七行还是空行
		gridx = 0;
		gridy++;
		jlfi6 = new JLabel(" ");
		jlfi6.setFont(fontForFillingText);
		GridBagConstraints gbcJlfi6 = new GridBagConstraints();// 创建网格组布局约束条件
		gbcJlfi6.insets = new Insets(5, 0, 5, 5);
		gbcJlfi6.fill = GridBagConstraints.BOTH;
		gbcJlfi6.gridwidth = 3;
		gbcJlfi6.gridheight = 1;
		gbcJlfi6.gridx = gridx;
		gbcJlfi6.gridy = gridy;
		jpWelcome.add(jlfi6, gbcJlfi6);

		jpBase.add(jpWelcome);

		frame.setTitle("台账生成软件");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new WelcomeView();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 如果用户在欢迎界面单击"开始生成"，则转到生成界面
		if (e.getSource() == jb1) {

			ProcessView pv = new ProcessView();
			String title = "正在生成文件……";
			pv.showPage(title);
			GenerateZongbiao gzb = new GenerateZongbiao();
			gzb.startGenerate();
		}

	}

}
