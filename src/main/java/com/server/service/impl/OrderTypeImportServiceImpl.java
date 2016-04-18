package com.server.service.impl;

import com.server.entity.OrderType;
import com.server.service.OrderTypeImportService;
import com.server.service.OrderTypeService;
import com.server.util.FileBean;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Импорт типов приказов
 * Реализация сервиса OrderTypeImportService
 *
 * Добавление нового типа приказа при помощи сервисного слоя типа приказов
 */
@Service
@Transactional
public class OrderTypeImportServiceImpl implements OrderTypeImportService {

    @Autowired
    OrderTypeService orderTypeService;

    /**
     * Импорт типов приказов из excel файла
     * TODO: определить формат excel
     * @param fileBean
     */
    @Override
    public void importOrderType(FileBean fileBean){
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getFileData().getBytes());
            HSSFWorkbook wb = new HSSFWorkbook(bis);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            /**Начало чтения документа с заданной строки*/
            int startRowIndex = 3;

            for (int i = startRowIndex; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                OrderType orderType = new OrderType();
                /**Тип приказа*/
                orderType.setOrdertype(String.valueOf(row.getCell(0).getRichStringCellValue()));
                /**Примечания*/
                orderType.setNotes(String.valueOf(row.getCell(1).getRichStringCellValue()));
                /**Добавление типа приказа*/
                orderTypeService.createOrderType(orderType);
            }
        } catch (FileNotFoundException ec) {
            ec.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}