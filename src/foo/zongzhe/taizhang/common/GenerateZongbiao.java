package foo.zongzhe.taizhang.common;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			outputFileName = StartingPoint.outputDir + "/" + fileName.substring(0, fileName.lastIndexOf('-')) + "-投资总表.xls";
		}
		la.log(StartingPoint.logFileName, "Info", "Output file name is: " + outputFileName);

		// 检查输出文件
		la.log(StartingPoint.logFileName, "Info", "Creating output file.");
		FileIOAction io = new FileIOAction();
		try {
			io.writeExcel(new File(outputFileName), 0, 0, "产品投资/清算总表");
			io.ApplyStyle(new File(outputFileName), "Sheet1", 0, 0, "BOLD");
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 创建输出文件标题
		la.log(StartingPoint.logFileName, "Info", "Creating title of output file.");
		try {
			io.writeExcel(new File(outputFileName), 0, 1, "序号");
			io.writeExcel(new File(outputFileName), 1, 1, "产品编号");
			io.writeExcel(new File(outputFileName), 2, 1, "票号");
			io.writeExcel(new File(outputFileName), 3, 1, "成立日期");
			io.writeExcel(new File(outputFileName), 4, 1, "起息日期");
			io.writeExcel(new File(outputFileName), 5, 1, "到期日期");
			io.writeExcel(new File(outputFileName), 6, 1, "存续天数");
			io.writeExcel(new File(outputFileName), 7, 1, "兑付日期");
			io.writeExcel(new File(outputFileName), 8, 1, "预期年化收益率");
			io.writeExcel(new File(outputFileName), 9, 1, "投资人次");
			io.writeExcel(new File(outputFileName), 10, 1, "投资金额");
			io.writeExcel(new File(outputFileName), 11, 1, "投资收益");
			io.writeExcel(new File(outputFileName), 12, 1, "本息合计");
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
				la.log(StartingPoint.logFileName, "Info", "rows: " + rows + ", columns: " + columns);

				Details details = new Details();
				details.setXuHao(i + 1);
				details.setChanPinBiaoHao(fileName);

				int col = 0;
				String cellContent;
				DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
				Date date = new Date();

				col = io.findContent(file, "票号");
				if (col == -1) {
					la.log(StartingPoint.logFileName, "Warn", "file " + file + " does not contain 票号");
					details.setPiaoHao("");
				} else {
					cellContent = io.readCell(file, 3, col);
					details.setPiaoHao(cellContent);
				}

				details.setChengliRiQi(null);

				// 一个文件中的起息日期可能不同
				col = io.findContent(file, "起息日");
				if (col == -1) {
					la.log(StartingPoint.logFileName, "Warn", "file " + file + " does not contain 起息日");
					details.setQiXiRiQi(null);
				} else {
					date = format.parse(io.readCell(file, 2, col));
					for (int j = 3; j < rows-2; j++) {
						if (!date.toString().equals(format.parse(io.readCell(file, j, col)).toString())) {
							la.log(StartingPoint.logFileName, "Warn", "file " + file + " contains different 起息日");
							date = null;
							break;
						}
					}
					
					details.setQiXiRiQi(date);
				}
				
				taiZhangMap.put(fileName, details);

			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
