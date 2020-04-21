package net.evrem.commons.export;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.evrem.commons.file.FileService;
import net.evrem.commons.file.FileServiceImpl;

import org.apache.poi.ss.usermodel.Workbook;

public class ExportManager {

	public static String getExportAllFile(Long userId) throws Exception {

		ExportService exportService = new ExportServiceImpl();

		Workbook wb = exportService.exportAll(userId);

		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String fileName = "Evrem_data_" + userId + "_" + format.format(new Date()) + ".xlsx";

		FileService fileService = new FileServiceImpl();
		fileService.saveFileToTemp(wb, fileName);

		return fileName;
	}

}
