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

	// 框架
	JFrame frame = new JFrame();

	// 总的框架和布局
	JPanel jpPreWel;

	// 面板上的内容
	JLabel jl1;

	public ProcessView() {

		// showPage("正在将结果写入文件");
	}

	public void showPage(String title) {

		// 设置框架
		frame.setSize(400, 300);
		frame.setLocation(600, 300);

		// 总的框架和布局
		jpPreWel = new JPanel();
		jpPreWel.setBounds(5, 5, 5, 5);

		// 设置面板上的通用部件
		Font fontForFillingText = new Font("TimesRoman", Font.PLAIN, 20);

		jl1 = new JLabel("<html><body><p><center>" + title + "</center></p><p><center>这可能需要几分钟</center></p><p><center>请不要关闭此窗口</center></p><body></html>");
		jl1.setFont(fontForFillingText);
		jl1.setHorizontalAlignment(JLabel.CENTER);

		jpPreWel.add(jl1, BorderLayout.CENTER);
		frame.add(jpPreWel);

		frame.setTitle("台账生成软件");

		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public void hidePage() {
		frame.setVisible(false);
	}

	public static void main(String[] args) {
		ProcessView pv = new ProcessView();
		pv.showPage("正在生成文件……");

	}

}
