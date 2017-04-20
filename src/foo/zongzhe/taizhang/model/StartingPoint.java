package foo.zongzhe.taizhang.model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import foo.zongzhe.taizhang.common.DirectoryAction;
import foo.zongzhe.taizhang.common.LogAction;
import foo.zongzhe.taizhang.view.PreWelcomeView;
import foo.zongzhe.taizhang.view.WelcomeView;

public class StartingPoint {

	static String ErrorMsg;
	public static String logFileName;
	static File fileName;

	public static void main(String[] args) {

		/**
		 * ----------------------- Initialization Phase -----------------------
		 */
		// Variables in the initialization phase

		// Check required directory and start to log
		DirectoryAction da = new DirectoryAction();
		File dir = new File("C:/taizhang/log");
		if (!da.whetherDirectoryExists(dir)) {
			da.createDir(dir);
		}

		dir = new File("C:/taizhang/input");
		if (!da.whetherDirectoryExists(dir)) {
			da.createDir(dir);
		}

		dir = new File("C:/taizhang/output");
		if (!da.whetherDirectoryExists(dir)) {
			da.createDir(dir);
		}

		// Set time format
		SimpleDateFormat dfFileName = new SimpleDateFormat("yyyyMMdd");
		String sysTimeFileName = dfFileName.format(new Date()).toString();
		logFileName = "C:/taizhang/log/taizhang_" + sysTimeFileName + ".out";
		File logFile = new File(logFileName);
		if (!da.whetherFileExists(logFile)) {
			da.createFile(logFile);
		}

		LogAction la = new LogAction();
		la.log(StartingPoint.logFileName, "Info", "------------------------New Run--------------------------------");
		la.log(StartingPoint.logFileName, "Info", "Link Start!");

		// ��ʾ׼������
		PreWelcomeView preWelView = new PreWelcomeView();
		preWelView.showPage("���ڼ�������");

		try

		{
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ������Ϣ���������쳣���˳�
		boolean itWorks = true;

		while (itWorks) {

			// ���������ı��Ƿ���ڣ��������ڣ��򱨴����˳�
			File inputText = new File("C:/taizhang/input");
			if (!da.whetherDirectoryExists(inputText)) {
				ErrorMsg = "Input file does not exist, exit";
				itWorks = false;
				break;
			}

		}

		if (!itWorks) {
			la.log(StartingPoint.logFileName, "ERROR", ErrorMsg);
			preWelView.setVisible(false);
			System.exit(0);
		}

		// ׼����ϣ��ر�׼�����棬����ʾ��ӭ����
		try

		{
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		preWelView.hidePage();
		WelcomeView welView = new WelcomeView();
		welView.showPage();

	}

}