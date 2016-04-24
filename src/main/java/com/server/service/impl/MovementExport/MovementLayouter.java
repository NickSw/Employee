package com.server.service.impl.MovementExport;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontCharset;

/**
 * Класс для построения макета таблицы приказов по сотрудникам
 */
public class MovementLayouter {

    /**
     * Построение макета
     * @param worksheet
     * @param startRowIndex
     * @param startColIndex
     */
    public static void buildReport(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
        /**Ширина колонок*/
        worksheet.setColumnWidth(0, 5000);
        worksheet.setColumnWidth(1, 5000);
        worksheet.setColumnWidth(2, 5000);
        worksheet.setColumnWidth(3, 5000);
        worksheet.setColumnWidth(4, 5000);

        /**Название*/
        buildTitle(worksheet, startRowIndex, startColIndex);
        /**Имена колонок*/
        buildHeaders(worksheet, startRowIndex, startColIndex);
    }

    /**
     * Название таблицы
     * @param worksheet
     * @param startRowIndex
     * @param startColIndex
     */
    public static void buildTitle(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
        /**Задать стиль шрифта для названия*/
        Font fontTitle = worksheet.getWorkbook().createFont();
        fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
        fontTitle.setFontHeight((short) 280);

        /**Задать стиль ячеек для названия*/
        HSSFCellStyle cellStyleTitle = worksheet.getWorkbook().createCellStyle();
        cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyleTitle.setWrapText(true);
        cellStyleTitle.setFont(fontTitle);

        /**Задать название для ответа*/
        HSSFRow rowTitle = worksheet.createRow((short) startRowIndex);
        rowTitle.setHeight((short) 500);
        HSSFCell cellTitle = rowTitle.createCell(startColIndex);
        cellTitle.setCellValue("Приказы по сотрудникам");
        cellTitle.setCellStyle(cellStyleTitle);

        /**Соеденить 3 ячейки в 1 ряду*/
        worksheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
    }

    /**
     * Заголовки колонок
     * @param worksheet
     * @param startRowIndex
     * @param startColIndex
     */
    public static void buildHeaders(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
        /**Стиль шрифта для заголовков колонок*/
        Font font = worksheet.getWorkbook().createFont();
        font.setCharSet(FontCharset.RUSSIAN.getValue());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        /**Стиль ячеек для заголовков колонок*/
        HSSFCellStyle headerCellStyle = worksheet.getWorkbook().createCellStyle();
        headerCellStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
        headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        headerCellStyle.setWrapText(true);
        headerCellStyle.setFont(font);
        headerCellStyle.setBorderBottom(CellStyle.BORDER_THIN);

        /**Создать заголовки колонок*/
        HSSFRow rowHeader = worksheet.createRow((short) startRowIndex +2);
        rowHeader.setHeight((short) 500);

        HSSFCell cell1 = rowHeader.createCell(startColIndex+0);
        cell1.setCellValue("Дата приказа");
        cell1.setCellStyle(headerCellStyle);

        HSSFCell cell2 = rowHeader.createCell(startColIndex+1);
        cell2.setCellValue("Номер приказа");
        cell2.setCellStyle(headerCellStyle);

        HSSFCell cell3 = rowHeader.createCell(startColIndex+2);
        cell3.setCellValue("Тип приказа");
        cell3.setCellStyle(headerCellStyle);

        HSSFCell cell4 = rowHeader.createCell(startColIndex+3);
        cell4.setCellValue("ФИО");
        cell4.setCellStyle(headerCellStyle);

        HSSFCell cell5 = rowHeader.createCell(startColIndex+4);
        cell5.setCellValue("Текст приказа");
        cell5.setCellStyle(headerCellStyle);

    }
}