package com.server.service.impl.MovementExport;

import com.server.entity.Movement;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;

import java.util.List;

/**
 * Класс менеджер заполнения excel таблицы приказов по сотрудникам
 */
public class MovementFillManager {

    /**
     * Функция заполнения документа
     * Заполняет из принятого списка приказов о сотрудникам
     * @param worksheet
     * @param startRowIndex
     * @param startColIndex
     * @param datasource
     */
    public static void fillReport(HSSFSheet worksheet, int startRowIndex, int startColIndex, List<Movement> datasource) {
        /**Сдвиг строки*/
        startRowIndex += 2;

        /**Создание стиля bodyCellStyle*/
        HSSFCellStyle bodyCellStyle = worksheet.getWorkbook().createCellStyle();
        /**Выравнивание по центру для bodyCellStyle*/
        bodyCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        /**Установить перенос текста для bodyCellStyle*/
        bodyCellStyle.setWrapText(true);

        /**Создание стиля dateCellStyle*/
        HSSFCellStyle dateCellStyle = worksheet.getWorkbook().createCellStyle();
        /**Задает формат даты для стиля dateCellStyle*/
        CreationHelper createHelper = worksheet.getWorkbook().getCreationHelper();
        dateCellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("yyyy-mm-dd"));
        /**Выравнивание по центру для стиля dateCellStyle*/
        dateCellStyle.setAlignment(CellStyle.ALIGN_CENTER);

        /**Цикл заполнения ячеек документа*/
        for (int i=startRowIndex; i+startRowIndex-2< datasource.size()+2; i++) {
            /**Создание строки*/
            HSSFRow row = worksheet.createRow((short) i+1);

            /**Дата приказа*/
            HSSFCell cell1 = row.createCell(startColIndex+0);
            cell1.setCellValue(datasource.get(i-2).getOrderdate());
            cell1.setCellStyle(dateCellStyle);

            /**Номер приказа*/
            HSSFCell cell2 = row.createCell(startColIndex+1);
            cell2.setCellValue(datasource.get(i-2).getOrdernum());
            cell2.setCellStyle(bodyCellStyle);

            /**Тип приказа*/
            HSSFCell cell3 = row.createCell(startColIndex+2);
            cell3.setCellValue(datasource.get(i-2).getOrdertype());
            cell3.setCellStyle(bodyCellStyle);

            /**ФИО*/
            HSSFCell cell4 = row.createCell(startColIndex+3);
            cell4.setCellValue(datasource.get(i-2).getFio());
            cell4.setCellStyle(bodyCellStyle);

            /**Текст приказа*/
            HSSFCell cell5 = row.createCell(startColIndex+4);
            cell5.setCellValue(datasource.get(i-2).getOrdertext());
            cell5.setCellStyle(bodyCellStyle);
        }
    }
}