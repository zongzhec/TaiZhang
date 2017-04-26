package foo.zongzhe.taizhang.common;

import java.io.File;
import java.util.HashMap;
import foo.zongzhe.taizhang.model.Details;
import foo.zongzhe.taizhang.model.StartingPoint;
import jxl.write.WriteException;

public class GenerateZongbiao {

	LogAction la = new LogAction();
	HashMap<String, Details> taiZhangMap = new HashMap<String, Details>();
	public static String outputFileName;
	public static String inputFileName[] = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateZongbiao gzb = new GenerateZongbiao();
		gzb.startGenerate();
	}

	public void startGenerate() {
		initialize();
	}

	public void initialize() {
		cleanup();
		checkFiles();
		readInputFile();
	}

	private void cleanup() {
		// TODO Clean up process.
		la.log(StartingPoint.logFileName, "Info", "Clean up all entities.");
		taiZhangMap.clear();
		DirectoryAction da = new DirectoryAction();
		da.deleteAllFile(StartingPoint.outputDir);

	}

	private void checkFiles() {
		// TODO Check input file names.
		la.log(StartingPoint.logFileName, "Info", "Read input file names.");
		DirectoryAction da = new DirectoryAction();
		inputFileName = null;
		inputFileName = da.getFileList(StartingPoint.inputDir);
		for (int i = 0; i < inputFileName.length; i++) {
			String fileName = inputFileName[i];
			int spaceLoc = fileName.indexOf(' ');
			fileName = fileName.substring(0, spaceLoc);
			if (!taiZhangMap.containsKey(fileName)) {
				taiZhangMap.put(fileName, null);
				la.log(StartingPoint.logFileName, "Info", "File Name " + fileName + " added into mapping.");
			}
			outputFileName = StartingPoint.outputDir + "/" + fileName.substring(0, fileName.lastIndexOf('-')) + "-Ͷ���ܱ�.xls";
		}
		la.log(StartingPoint.logFileName, "Info", "Output file name is: " + outputFileName);

		// Create output file.
		la.log(StartingPoint.logFileName, "Info", "Creating output file.");
		FileIOAction io = new FileIOAction();
		try {
			io.writeExcel(new File(outputFileName), 0, 0, "Ͷ��/�����ܱ�", true);
			io.writeExcel(new File(outputFileName), 1, 0, "Ͷ��/�����ܱ�1", false);
			io.writeExcel(new File(outputFileName), 0, 1, "Ͷ��/�����ܱ�2", false);
			io.writeExcel(new File(outputFileName), 1, 1, "Ͷ��/�����ܱ�3", false);
			io.ApplyStyle(new File(outputFileName), "Sheet1", 0, 0, "BOLD");
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readInputFile() {
		la.log(StartingPoint.logFileName, "Info", "Start to read from input files.");
		FileIOAction io = new FileIOAction();
		for (int i = 0; i < inputFileName.length; i++) {
			String fileName = inputFileName[i];
			File file = new File(StartingPoint.inputDir + "/" + fileName);
			try {
				int rows = io.getRowCount(file);
				int columns = io.getColumnCount(file);
				la.log(StartingPoint.logFileName, "Info", "rows: " + columns);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
