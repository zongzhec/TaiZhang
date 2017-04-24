package foo.zongzhe.taizhang.common;

import java.io.File;
import java.io.IOException;

public class DirectoryAction {

	public boolean whetherDirectoryExists(File dir) {

		// System.out.println("Dir is: " + dir);
		if (!dir.exists() && !dir.isDirectory()) {
			System.out.println("������");
			return false;
		}
		return true;
	}

	public boolean whetherFileExists(File file) {

		if (!file.exists() && !file.isDirectory()) {
			System.out.println("������");
			return false;
		}
		return true;
	}

	public void createDir(File dir) {
		System.out.println("��ʼ����·��");
		dir.mkdir();
	}

	public void createFile(File file) {
		System.out.println("��ʼ�����ļ�");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ��ȡ�ļ����������ļ���
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
