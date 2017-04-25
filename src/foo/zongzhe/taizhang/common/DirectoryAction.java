package foo.zongzhe.taizhang.common;

import java.io.File;
import java.io.IOException;

public class DirectoryAction {

	public boolean whetherDirectoryExists(File dir) {

		// System.out.println("Dir is: " + dir);
		if (!dir.exists() && !dir.isDirectory()) {
			System.out.println("不存在");
			return false;
		}
		return true;
	}

	public boolean whetherFileExists(File file) {

		if (!file.exists() && !file.isDirectory()) {
			System.out.println("不存在");
			return false;
		}
		return true;
	}

	public void deleteAllFile(File dir) {
		// Purge all files in a dir
		for (File file : dir.listFiles())
			if (!file.isDirectory()){
				file.delete();
			}	
	}

	public void createDir(File dir) {
		System.out.println("开始生成路径");
		dir.mkdir();
	}

	public void createFile(File file) {
		System.out.println("开始生成文件");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 读取文件夹下所有文件名
	public String[] getFileList(File dir) {
		String[] fileList = null;
		try {
			fileList = dir.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileList;
	}

}
