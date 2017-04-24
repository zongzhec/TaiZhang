package foo.zongzhe.taizhang.common;

import foo.zongzhe.taizhang.model.StartingPoint;

public class GenerateZongbiao {
	
	LogAction la = new LogAction();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void startGenerate() {
		initialize();
	}

	public void initialize() {
		readInputFile();
	}

	public void readInputFile() {
		la.log(StartingPoint.logFileName, "Info", "Reading from input files.");
		
	}

}
