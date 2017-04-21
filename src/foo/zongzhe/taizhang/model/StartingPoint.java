package foo.zongzhe.taizhang.model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ClassGenerator;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MethodGenerator;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TypeCheckError;

import foo.zongzhe.taizhang.common.DirectoryAction;
import foo.zongzhe.taizhang.common.LogAction;
import foo.zongzhe.taizhang.view.PreWelcomeView;
import foo.zongzhe.taizhang.view.WelcomeView;

public class StartingPoint {

	static String ErrorMsg;
	static File inputDir = new File("C:/taizhang/input");
	static File outputDir = new File("C:/taizhang/output");
	static File logDir = new File("C:/taizhang/log");
	public static String logFileName;

	public static void main(String[] args) {

		/**
		 * ----------------------- Initialization Phase -----------------------
		 */
		// Variables in the initialization phase

		// Check required directory and start to log
		DirectoryAction da = new DirectoryAction();
		File dir = new File("C:/taizhang/log");
		if (!da.whetherDirectoryExists(StartingPoint.logDir)) {
			da.createDir(dir);
		}

		if (!da.whetherDirectoryExists(StartingPoint.inputDir)) {
			da.createDir(dir);
		}

		if (!da.whetherDirectoryExists(StartingPoint.outputDir)) {
			da.createDir(dir);
		}

		// Set time format
		SimpleDateFormat dfFileName = new SimpleDateFormat("yyyyMMdd");
		String sysTimeFileName = dfFileName.format(new Date()).toString();
		logFileName = StartingPoint.logDir + "/taizhang_" + sysTimeFileName + ".out";
		File logFile = new File(logFileName);
		if (!da.whetherFileExists(logFile)) {
			da.createFile(logFile);
		}

		LogAction la = new LogAction();
		la.log(StartingPoint.logFileName, "Info", "------------------------New Run--------------------------------");
		la.log(StartingPoint.logFileName, "Info", "Link Start!");

		// 显示准备界面
		PreWelcomeView preWelView = new PreWelcomeView();
		preWelView.showPage("正在加载数据");

		try

		{
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 处理信息，当出现异常后退出
		boolean itWorks = true;

		while (itWorks) {

			// 检查输入的文本是否存在，若不存在，则报错后退出
			String[] fileList = da.getFileList(StartingPoint.inputDir);
			itWorks = false;
			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].contains("投资明细")) {
					la.log(StartingPoint.logFileName, "Info", "file checking success. 投资明细 is included in file names.");
				}
			}
			if (!itWorks) {
				ErrorMsg = "File names does not contain 投资明细";
				break;
			}
			itWorks = true;

		}

		if (!itWorks) {
			la.log(StartingPoint.logFileName, "ERROR", ErrorMsg);
			preWelView.setVisible(false);
			System.exit(0);
		}

		// 准备完毕，关闭准备界面，并显示欢迎界面
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
