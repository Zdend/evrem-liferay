package net.evrem.commons.file;

import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;

public interface FileService {

	public void saveFileToTemp(Workbook wb, String fileName) throws Exception;

	public void getFileFromTemp(String fileName, OutputStream out) throws Exception;

	public void deleteFileFromTemp(String fileName) throws Exception;

}
