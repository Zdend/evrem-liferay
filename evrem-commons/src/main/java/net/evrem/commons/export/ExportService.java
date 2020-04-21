package net.evrem.commons.export;

import org.apache.poi.ss.usermodel.Workbook;

public interface ExportService {

	public Workbook exportAll(Long userId) throws Exception;

}
