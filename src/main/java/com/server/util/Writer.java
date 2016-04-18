package com.server.util;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 * ��������������� ����� ��� �������� �����
 * ����� ��� � ����
 */
public class Writer {
    public static void write(HttpServletResponse response, HSSFSheet worksheet) {
        try {
            /**�������� output stream � HttpServletResponse*/
            ServletOutputStream outputStream = response.getOutputStream();
            /**����� � �����*/
            worksheet.getWorkbook().write(outputStream);
            /**��������� �����*/
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
