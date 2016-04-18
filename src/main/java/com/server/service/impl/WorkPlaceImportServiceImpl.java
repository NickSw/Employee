package com.server.service.impl;

import com.server.entity.WorkPlace;
import com.server.service.WorkPlaceImportService;
import com.server.service.WorkPlaceService;
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
import java.text.DecimalFormat;

/**
 * Импорт типов приказов
 * Реализация сервиса OrderTypeImportService
 *
 * Добавление нового типа приказа при помощи сервисного слоя типа приказов
 */
@Service
@Transactional
public class WorkPlaceImportServiceImpl implements WorkPlaceImportService {

    @Autowired
    WorkPlaceService workPlaceService;

    /**
     * Импорт места работы из excel файла
     * @param fileBean
     */
    @Override
    public void importWorkPlace(FileBean fileBean){
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getFileData().getBytes());
            HSSFWorkbook wb = new HSSFWorkbook(bis);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            /**Начало чтения документа с заданной строки*/
            int startRowIndex = 3;

            for (int i = startRowIndex; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                WorkPlace workPlace = new WorkPlace();
                /**Место работы*/
                workPlace.setPlace(String.valueOf(row.getCell(0).getRichStringCellValue()));
                /**Адрес места работы*/
                workPlace.setAddress(String.valueOf(row.getCell(1).getRichStringCellValue()));
                /**Телефон*/
                Double cellValue = row.getCell(2).getNumericCellValue();
                DecimalFormat format = new DecimalFormat("0.#");
                workPlace.setPhone(String.valueOf(format.format(cellValue)));
                /**Создание места работы*/
                workPlaceService.createWorkPlace(workPlace);
            }
        } catch (FileNotFoundException ec) {
            ec.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}