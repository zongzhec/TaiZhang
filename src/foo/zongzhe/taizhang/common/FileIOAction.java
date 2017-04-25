package foo.zongzhe.taizhang.common;

import java.io.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;
import org.apache.poi.poifs.filesystem.*;

import com.sun.rowset.internal.Row;

import foo.zongzhe.taizhang.model.StartingPoint;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class FileIOAction {

	LogAction la = new LogAction();

	public static void main(String[] args) {
		// TODO 进行文件的读写操作

	}

	// 按字符读取txt文件
	public void readTXTFileByChars(String fileName) {
		File file = new File(fileName);
		Reader reader = null;
		try {
			System.out.println("以字符为单位读取文件内容，一次读一个字节：");
			// 一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file));
			int tempchar;
			while ((tempchar = reader.read()) != -1) {
				// 对于windows下，rn这两个字符在一起时，表示一个换行。
				// 但如果这两个字符分开显示时，会换两次行。
				// 因此，屏蔽掉r，或者屏蔽n。否则，将会多出很多空行。
				if (((char) tempchar) != 'r') {
					System.out.print((char) tempchar);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("以字符为单位读取文件内容，一次读多个字节：");
			// 一次读多个字符
			char[] tempchars = new char[30];
			int charread = 0;
			reader = new InputStreamReader(new FileInputStream(fileName));
			// 读入多个字符到字符数组中，charread为一次读取字符数
			while ((charread = reader.read(tempchars)) != -1) {
				// 同样屏蔽掉r不显示
				if ((charread == tempchars.length) && (tempchars[tempchars.length - 1] != 'r')) {
					System.out.print(tempchars);
				} else {
					for (int i = 0; i < charread; i++) {
						if (tempchars[i] == 'r') {
							continue;
						} else {
							System.out.print(tempchars[i]);
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public void writeExcel(File file, int column, int row, String outputMsg, boolean create) throws RowsExceededException, WriteException {

		// 根据index来判断写入的阶段
		System.out.println("Ready to write in excel: " + column + ", " + row + ", " + outputMsg);
		try {
			if (!file.exists()) {
				jxl.write.WritableWorkbook wwb;
				wwb = Workbook.createWorkbook(file);
				jxl.write.WritableSheet ws = wwb.createSheet("Sheet1", 0);
				Label label = new Label(column, row, outputMsg);
				ws.addCell(label);
				// 写入Exel工作表
				wwb.write();
				// 关闭Excel工作薄对象
				wwb.close();
			} else {
				System.out.println("file exists, ready to add in " + file.toString());
				Workbook rwb = Workbook.getWorkbook(file);
				System.out.println("workboog get");
				File tempfile = file;
				WritableWorkbook wwb = Workbook.createWorkbook(tempfile, rwb);
				System.out.println("WritableWorkbook get");
				WritableSheet ws = wwb.getSheet(0);
				System.out.println("WritableSheet get");
				// Label label = new Label(column, row, outputMsg);
				Label label = new Label(column, row, outputMsg);
				System.out.println("writing in excel: " + column + ", " + row + ", " + outputMsg);
				ws.addCell(label);
				System.out.println("cell added");
				wwb.write();
				System.out.println("wwb wrote");
				wwb.close();
				System.out.println("wwb closed");
				rwb.close();
				System.out.println("rwb closed");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ApplyStyle(File file, String sheetName, int row, int column, String style) throws RowsExceededException, WriteException {

		// 根据index来判断写入的阶段
		la.log(StartingPoint.logFileName, "Info", "Applying styles.");
		try {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFFont font = workbook.createFont();
			HSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				la.log(StartingPoint.logFileName, "Info", "Creating " + sheetName);
				sheet = workbook.createSheet(sheetName);
			}
			int rows = sheet.getPhysicalNumberOfRows();
			for (int r = 0; r < rows; r++) {
				HSSFRow hssfRow = sheet.getRow(1);
				if (hssfRow != null) {
					HSSFCell cell = hssfRow.getCell(column);
					la.log(StartingPoint.logFileName, "Info", "Applying styles on " + cell.getStringCellValue() + " with " + style);
					if (style.equals("BOLD")) {
						la.log(StartingPoint.logFileName, "Info", "BOLD");
						font.setBold(true);
					}

					HSSFCellStyle cellStyle = workbook.createCellStyle(); // 样式对象
					cellStyle.setFont(font);
					cell.setCellStyle(cellStyle);

					FileOutputStream fileOutputStream = new FileOutputStream(file, false);
					workbook.write(fileOutputStream);
					fileOutputStream.close();
					workbook.close();
				}
			}

			// 人走带门

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getRowStart(String fileName) throws RowsExceededException, WriteException {

		int rows = 0;
		File file = new File("C:/hptest/output/result_output/" + fileName);
		System.out.println("file is " + file.toString());
		Workbook rwb;

		try {
			rwb = Workbook.getWorkbook(file);
			System.out.println("workbook get.");
			File tempfile = file;
			WritableWorkbook wwb = Workbook.createWorkbook(tempfile, rwb);
			System.out.println("WritableWorkbook get.");
			WritableSheet ws = wwb.getSheet(0);
			rows = rwb.getSheet(0).getRows();
			System.out.println("rows: " + String.valueOf(rows));
			ws.setColumnView(rows, 20); // 设置列宽
			wwb.write();
			wwb.close();
			System.out.println("wwb closed.");
			rwb.close();
			System.out.println("rwb closed");
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;

	}

}
