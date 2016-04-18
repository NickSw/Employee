package com.server.util;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 * Вспомогательный класс для экспорта файла
 * Пишет все в файл
 */
public class Writer {
    public static void write(HttpServletResponse response, HSSFSheet worksheet) {
        try {
            /**Получаем output stream с HttpServletResponse*/
            ServletOutputStream outputStream = response.getOutputStream();
            /**Пишет в потом*/
            worksheet.getWorkbook().write(outputStream);
            /**Закрывает поток*/
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
