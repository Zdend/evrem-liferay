package net.evrem.commons.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.portal.kernel.util.PropsUtil;

public class FileServiceImpl implements FileService {

	public void saveFileToTemp(Workbook wb, String fileName) throws Exception {
		String exportDirectory = PropsUtil.get("evrem.export.folder");
		String fullPath = exportDirectory + fileName;
		File tempDirectory = new File(exportDirectory);
		FileUtils.forceMkdir(tempDirectory);

		FileOutputStream fileOut = new FileOutputStream(fullPath);

		wb.write(fileOut);
		fileOut.close();
	}

	public void getFileFromTemp(String fileName, OutputStream out) throws Exception {
		String exportDirectory = PropsUtil.get("evrem.export.folder");
		InputStream is = new FileInputStream(exportDirectory + fileName);
		IOUtils.copy(is, out);
		is.close();
	}

	public void deleteFileFromTemp(String fileName) throws Exception {
		String exportDirectory = PropsUtil.get("evrem.export.folder");
		File file = new File(exportDirectory + fileName);
		file.delete();
	}

}
