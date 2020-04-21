package net.evrem.commons.export;

import java.util.Date;
import java.util.List;

import net.evrem.commons.global.GlobalConstants;
import net.evrem.commons.util.MixedUtil;
import net.evrem.dtos.dto.HeaderDto;
import net.evrem.dtos.form.NoteFormModel;
import net.evrem.service.service.NoteLocalServiceUtil;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportServiceImpl implements ExportService {

	public Workbook exportAll(Long userId) throws Exception {
		List<NoteFormModel> noteForms = NoteLocalServiceUtil.getNotesEventByUserId(userId, true);

		Workbook wb = new XSSFWorkbook();
		Sheet sheet1 = wb.createSheet("All data");
		CreationHelper createHelper = wb.getCreationHelper();

		HeaderDto[] headerTitles = { new HeaderDto("Color", 3), new HeaderDto("Note text", 20), new HeaderDto("Event time", 4),
				new HeaderDto("Remind time", 4), new HeaderDto("Repeat period", 4), new HeaderDto("Done", 2), new HeaderDto("Deleted", 2),
				new HeaderDto("Creation date", 4), new HeaderDto("Last modified", 4), };
		createHeader(wb, sheet1, headerTitles);

		CellStyle dateStyle = wb.createCellStyle();
		dateStyle.setDataFormat(createHelper.createDataFormat().getFormat(GlobalConstants.DATE_TIME_FORMAT));

		int rowNum = 1;
		for (NoteFormModel form : noteForms) {
			Row row = sheet1.createRow(rowNum);

			XSSFCellStyle colorStyle = (XSSFCellStyle) wb.createCellStyle();
			colorStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			colorStyle.setFillForegroundColor(new XSSFColor(MixedUtil.hex2Rgb(form.getColor().getColorWithHash())));
			XSSFCell cell = (XSSFCell) row.createCell(0);
			cell.setCellStyle(colorStyle);

			CellUtil.createCell(row, 1, form.getText());
			createDateCell(row, 2, form.getEventTime(), dateStyle);
			createDateCell(row, 3, form.getRemindInfo() != null ? form.getRemindInfo().getRemindDate() : null, dateStyle);
			CellUtil.createCell(row, 4, form.getPeriod() != null ? form.getPeriod().getTitle() : null);
			CellUtil.createCell(row, 5, form.getHasCheck() ? form.getIsDone().toString() : "");
			CellUtil.createCell(row, 6, form.getIsDeleted().toString());
			createDateCell(row, 7, form.getCreatedDate(), dateStyle);
			createDateCell(row, 8, form.getModifiedDate(), dateStyle);

			rowNum++;
		}

		return wb;
	}

	private void createHeader(Workbook wb, Sheet sheet, HeaderDto[] headerTitles) {
		Row row = sheet.createRow(0);
		XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
		style.setFillForegroundColor(new XSSFColor(new java.awt.Color(51, 72, 93)));
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

		Font font = wb.createFont();
		font.setBold(true);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);

		for (int i = 0; i < headerTitles.length; i++) {
			HeaderDto header = headerTitles[i];
			CellUtil.createCell(row, i, header.getTitle(), style);
			sheet.setColumnWidth(i, header.getWidth() * 1000);
		}
	}

	private void createDateCell(Row row, Integer column, Date date, CellStyle style) {
		Cell cell = row.createCell(column);
		if (date != null) {
			cell.setCellValue(date);
			cell.setCellStyle(style);
		} else {
			cell.setCellValue("");
		}
	}

}
