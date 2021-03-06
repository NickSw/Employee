package com.server.service.impl.employeeExport;

import java.util.List;
import com.server.entity.Employee;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;

/**
 * ����� �������� ���������� excel ������� �����������
 */
public class EmployeeFillManager {

    /**
     * ������� ���������� ���������
     * ��������� �� ��������� ������ �����������
     * @param worksheet
     * @param startRowIndex
     * @param startColIndex
     * @param datasource
     */
        public static void fillReport(HSSFSheet worksheet, int startRowIndex, int startColIndex, List<Employee> datasource) {
        /**����� ������*/
        startRowIndex += 2;

        /**�������� ����� bodyCellStyle*/
        HSSFCellStyle bodyCellStyle = worksheet.getWorkbook().createCellStyle();
        /**������������ �� ������ ��� bodyCellStyle*/
        bodyCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        /**���������� ������� ������ ��� bodyCellStyle*/
        bodyCellStyle.setWrapText(true);

        /**�������� ����� dateCellStyle*/
        HSSFCellStyle dateCellStyle = worksheet.getWorkbook().createCellStyle();
        CreationHelper createHelper = worksheet.getWorkbook().getCreationHelper();
        /**������ ������ ���� ��� ����� dateCellStyle*/
        dateCellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("yyyy-mm-dd"));
        /**������������ �� ������ ��� ����� dateCellStyle*/
        dateCellStyle.setAlignment(CellStyle.ALIGN_CENTER);

        /**���� ���������� ����� ���������*/
        for (int i=startRowIndex; i+startRowIndex-2 < datasource.size()+2; i++) {
            /**�������� ������*/
            HSSFRow row = worksheet.createRow((short) i+1);

            /**���*/
            HSSFCell cell1 = row.createCell(startColIndex+0);
            cell1.setCellValue(datasource.get(i-2).getName());
            cell1.setCellStyle(bodyCellStyle);

            /**�������*/
            HSSFCell cell2 = row.createCell(startColIndex+1);
            cell2.setCellValue(datasource.get(i-2).getPhone());
            cell2.setCellStyle(bodyCellStyle);

            /**�����*/
            HSSFCell cell3 = row.createCell(startColIndex+2);
            cell3.setCellValue(datasource.get(i-2).getMail());
            cell3.setCellStyle(bodyCellStyle);

            /**��������� 1*/
            HSSFCell cell4 = row.createCell(startColIndex+3);
            cell4.setCellValue(datasource.get(i-2).getPosition1());
            cell4.setCellStyle(bodyCellStyle);

            /**��������� 2*/
            HSSFCell cell5 = row.createCell(startColIndex+4);
            cell5.setCellValue(datasource.get(i-2).getPosition2());
            cell5.setCellStyle(bodyCellStyle);

            /**����� ������*/
            HSSFCell cell6 = row.createCell(startColIndex+5);
            cell6.setCellValue(datasource.get(i-2).getWorkplace());
            cell6.setCellStyle(bodyCellStyle);

            /**���� ��������*/
            /**��������� ������ ������ �������, ���� ��� ����*/
            HSSFCell cell7 = row.createCell(startColIndex+6);
            try {
                cell7.setCellValue(datasource.get(i - 2).getBirthday());
                cell7.setCellStyle(dateCellStyle);
            }
            catch (NullPointerException ex){
                cell7.setCellValue("");
                cell7.setCellStyle(bodyCellStyle);
            }

            /**����*/
            HSSFCell cell8 = row.createCell(startColIndex+7);
            cell8.setCellValue(datasource.get(i-2).getChildren());
            cell8.setCellStyle(bodyCellStyle);

            /**�����*/
            HSSFCell cell9 = row.createCell(startColIndex+8);
            cell9.setCellValue(datasource.get(i-2).getAddress());
            cell9.setCellStyle(bodyCellStyle);

            /**���*/
            HSSFCell cell10 = row.createCell(startColIndex+9);
            cell10.setCellValue(datasource.get(i-2).getStudy());
            cell10.setCellStyle(bodyCellStyle);

            /**�������������*/
            HSSFCell cell11 = row.createCell(startColIndex+10);
            cell11.setCellValue(datasource.get(i-2).getSpeciality());
            cell11.setCellStyle(bodyCellStyle);

            /**�������. ���*/
            HSSFCell cell12 = row.createCell(startColIndex+11);
            cell12.setCellValue(datasource.get(i-2).getCode());
            cell12.setCellStyle(bodyCellStyle);

            /**�������*/
            HSSFCell cell13 = row.createCell(startColIndex+12);
            cell13.setCellValue(datasource.get(i-2).getPassport());
            cell13.setCellStyle(bodyCellStyle);

            /**��� ����������*/
            HSSFCell cell14 = row.createCell(startColIndex+13);
            cell14.setCellValue(datasource.get(i-2).getDecortype());
            cell14.setCellStyle(bodyCellStyle);

            /**���� ����������*/
            /**��������� ������ ������ �������, ���� ��� ����*/
            HSSFCell cell15 = row.createCell(startColIndex+14);
            try {
                cell15.setCellValue(datasource.get(i-2).getEnrolldate());
                cell15.setCellStyle(dateCellStyle);
            }
            catch (NullPointerException ex){
                cell15.setCellValue("");
                cell15.setCellStyle(bodyCellStyle);
            }

            /**������ � ������.*/
            HSSFCell cell16 = row.createCell(startColIndex+15);
            cell16.setCellValue(datasource.get(i-2).getEnrollorder());
            cell16.setCellStyle(bodyCellStyle);

            /**���� ������� � ������.*/
            /**��������� ������ ������ �������, ���� ��� ����*/
            HSSFCell cell17 = row.createCell(startColIndex+16);
            try {
                cell17.setCellValue(datasource.get(i-2).getEnrollorderdate());
                cell17.setCellStyle(dateCellStyle);
            }
            catch (NullPointerException ex){
                cell17.setCellValue("");
                cell17.setCellStyle(bodyCellStyle);
            }

            /**�������� ������*/
            HSSFCell cell18 = row.createCell(startColIndex+17);
            cell18.setCellValue(datasource.get(i-2).getRecofservice());
            cell18.setCellStyle(bodyCellStyle);

            /**����������*/
            HSSFCell cell19 = row.createCell(startColIndex+18);
            cell19.setCellValue(datasource.get(i-2).getNotes());
            cell19.setCellStyle(bodyCellStyle);
        }
        }
}