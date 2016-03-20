package com.server.service.impl.employeeExport;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontCharset;

public class EmployeeLayouter {

        public static void buildReport(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
            // Set column widths
            worksheet.setColumnWidth(0, 5000);
            worksheet.setColumnWidth(1, 5000);
            worksheet.setColumnWidth(2, 5000);
            worksheet.setColumnWidth(3, 5000);
            worksheet.setColumnWidth(4, 5000);
            worksheet.setColumnWidth(5, 5000);
            worksheet.setColumnWidth(6, 5000);
            worksheet.setColumnWidth(7, 5000);
            worksheet.setColumnWidth(8, 5000);
            worksheet.setColumnWidth(9, 5000);
            worksheet.setColumnWidth(10, 5000);
            worksheet.setColumnWidth(11, 5000);
            worksheet.setColumnWidth(12, 5000);
            worksheet.setColumnWidth(13, 5000);
            worksheet.setColumnWidth(14, 5000);
            worksheet.setColumnWidth(15, 5000);
            worksheet.setColumnWidth(16, 5000);
            worksheet.setColumnWidth(17, 5000);
            worksheet.setColumnWidth(18, 5000);
            worksheet.setColumnWidth(19, 5000);

            // Build the title and date headers
            buildTitle(worksheet, startRowIndex, startColIndex);
            // Build the column headers
            buildHeaders(worksheet, startRowIndex, startColIndex);
        }

        public static void buildTitle(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
        // Create font style for the report title
        Font fontTitle = worksheet.getWorkbook().createFont();
        fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
        fontTitle.setFontHeight((short) 280);

        // Create cell style for the report title
        HSSFCellStyle cellStyleTitle = worksheet.getWorkbook().createCellStyle();
        cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyleTitle.setWrapText(true);
        cellStyleTitle.setFont(fontTitle);

        // Create report title
        HSSFRow rowTitle = worksheet.createRow((short) startRowIndex);
        rowTitle.setHeight((short) 500);
        HSSFCell cellTitle = rowTitle.createCell(startColIndex);
        cellTitle.setCellValue("База сотрудников");
        cellTitle.setCellStyle(cellStyleTitle);

        // Create merged region for the report title
        worksheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
/*
        // Create date header
        HSSFRow dateTitle = worksheet.createRow((short) startRowIndex +1);
        HSSFCell cellDate = dateTitle.createCell(startColIndex);
        cellDate.setCellValue("This report was generated at " + new Date());
*/
        }

        public static void buildHeaders(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
            // Create font style for the headers
            Font font = worksheet.getWorkbook().createFont();
            font.setCharSet(FontCharset.RUSSIAN.getValue());
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);

            // Create cell style for the headers
            HSSFCellStyle headerCellStyle = worksheet.getWorkbook().createCellStyle();
            headerCellStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
            headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            headerCellStyle.setWrapText(true);
            headerCellStyle.setFont(font);
            headerCellStyle.setBorderBottom(CellStyle.BORDER_THIN);

            // Create the column headers
            HSSFRow rowHeader = worksheet.createRow((short) startRowIndex +2);
            rowHeader.setHeight((short) 500);

            HSSFCell cell1 = rowHeader.createCell(startColIndex+0);
            cell1.setCellValue("ФИО");
            cell1.setCellStyle(headerCellStyle);

            HSSFCell cell2 = rowHeader.createCell(startColIndex+1);
            cell2.setCellValue("Телефон");
            cell2.setCellStyle(headerCellStyle);

            HSSFCell cell3 = rowHeader.createCell(startColIndex+2);
            cell3.setCellValue("Адресс");
            cell3.setCellStyle(headerCellStyle);

            HSSFCell cell4 = rowHeader.createCell(startColIndex+3);
            cell4.setCellValue("ВУЗ");
            cell4.setCellStyle(headerCellStyle);

            HSSFCell cell5 = rowHeader.createCell(startColIndex+4);
            cell5.setCellValue("Специальность");
            cell5.setCellStyle(headerCellStyle);

            HSSFCell cell6 = rowHeader.createCell(startColIndex+5);
            cell6.setCellValue("Дата Рождения");
            cell6.setCellStyle(headerCellStyle);

            HSSFCell cell7 = rowHeader.createCell(startColIndex+6);
            cell7.setCellValue("Идент. код");
            cell7.setCellStyle(headerCellStyle);

            HSSFCell cell8 = rowHeader.createCell(startColIndex+7);
            cell8.setCellValue("Паспорт");
            cell8.setCellStyle(headerCellStyle);

            HSSFCell cell9 = rowHeader.createCell(startColIndex+8);
            cell9.setCellValue("Должность 1");
            cell9.setCellStyle(headerCellStyle);

            HSSFCell cell10 = rowHeader.createCell(startColIndex+9);
            cell10.setCellValue("Должность 2");
            cell10.setCellStyle(headerCellStyle);

            HSSFCell cell11 = rowHeader.createCell(startColIndex+10);
            cell11.setCellValue("Почта");
            cell11.setCellStyle(headerCellStyle);

            HSSFCell cell12 = rowHeader.createCell(startColIndex+11);
            cell12.setCellValue("Где Работает");
            cell12.setCellStyle(headerCellStyle);

            HSSFCell cell13 = rowHeader.createCell(startColIndex+12);
            cell13.setCellValue("Тип Оформления");
            cell13.setCellStyle(headerCellStyle);

            HSSFCell cell14 = rowHeader.createCell(startColIndex+13);
            cell14.setCellValue("Дети до 16 лет");
            cell14.setCellStyle(headerCellStyle);

            HSSFCell cell15 = rowHeader.createCell(startColIndex+14);
            cell15.setCellValue("Дата зачисления");
            cell15.setCellStyle(headerCellStyle);

            HSSFCell cell16 = rowHeader.createCell(startColIndex+15);
            cell16.setCellValue("Прказ о зачислении");
            cell16.setCellStyle(headerCellStyle);

            HSSFCell cell17 = rowHeader.createCell(startColIndex+16);
            cell17.setCellValue("Дата приказа о зачисл.");
            cell17.setCellStyle(headerCellStyle);

            HSSFCell cell18 = rowHeader.createCell(startColIndex+17);
            cell18.setCellValue("Трудовая книжка");
            cell18.setCellStyle(headerCellStyle);

            HSSFCell cell19 = rowHeader.createCell(startColIndex+18);
            cell19.setCellValue("Примечания");
            cell19.setCellStyle(headerCellStyle);
        }
}