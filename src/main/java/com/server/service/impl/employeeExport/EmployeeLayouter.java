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

/**
 * Класс для построения макета таблицы сотрудников
 */
public class EmployeeLayouter {

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
            cellTitle.setCellValue("База сотрудников");
            cellTitle.setCellStyle(cellStyleTitle);

            /**Соеденить 5 ячеек в 1 ряду*/
            worksheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
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
            cell1.setCellValue("ФИО");
            cell1.setCellStyle(headerCellStyle);

            HSSFCell cell2 = rowHeader.createCell(startColIndex+1);
            cell2.setCellValue("Телефон");
            cell2.setCellStyle(headerCellStyle);

            HSSFCell cell3 = rowHeader.createCell(startColIndex+2);
            cell3.setCellValue("Почта");
            cell3.setCellStyle(headerCellStyle);

            HSSFCell cell4 = rowHeader.createCell(startColIndex+3);
            cell4.setCellValue("Должность 1");
            cell4.setCellStyle(headerCellStyle);

            HSSFCell cell5 = rowHeader.createCell(startColIndex+4);
            cell5.setCellValue("Должность 2");
            cell5.setCellStyle(headerCellStyle);

            HSSFCell cell6 = rowHeader.createCell(startColIndex+5);
            cell6.setCellValue("Где Работает");
            cell6.setCellStyle(headerCellStyle);

            HSSFCell cell7 = rowHeader.createCell(startColIndex+6);
            cell7.setCellValue("Дата Рождения");
            cell7.setCellStyle(headerCellStyle);

            HSSFCell cell8 = rowHeader.createCell(startColIndex+7);
            cell8.setCellValue("Дети до 16 лет");
            cell8.setCellStyle(headerCellStyle);

            HSSFCell cell9 = rowHeader.createCell(startColIndex+8);
            cell9.setCellValue("Адрес");
            cell9.setCellStyle(headerCellStyle);

            HSSFCell cell10 = rowHeader.createCell(startColIndex+9);
            cell10.setCellValue("ВУЗ");
            cell10.setCellStyle(headerCellStyle);

            HSSFCell cell11 = rowHeader.createCell(startColIndex+10);
            cell11.setCellValue("Специальность");
            cell11.setCellStyle(headerCellStyle);

            HSSFCell cell12 = rowHeader.createCell(startColIndex+11);
            cell12.setCellValue("Идент. код");
            cell12.setCellStyle(headerCellStyle);

            HSSFCell cell13 = rowHeader.createCell(startColIndex+12);
            cell13.setCellValue("Паспорт");
            cell13.setCellStyle(headerCellStyle);

            HSSFCell cell14 = rowHeader.createCell(startColIndex+13);
            cell14.setCellValue("Тип Оформления");
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