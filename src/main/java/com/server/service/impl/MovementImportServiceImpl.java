package com.server.service.impl;

import com.server.entity.Movement;
import com.server.service.MovementImportService;
import com.server.service.MovementService;
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
 * Импорт приказов по сотрудникам
 * Реализация сервиса MovementImportService
 *
 * Добавление нового приказа по сотруднику при помощи сервисного слоя приказов по сотруднику
 */
@Service
@Transactional
public class MovementImportServiceImpl implements MovementImportService {

        @Autowired
        MovementService movementService;

        /**
         * Импорт приказов по сотруднику из excel файла
         * @param fileBean
         */
        @Override
        public void importMovement(FileBean fileBean){
                try {
                        ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getFileData().getBytes());
                        HSSFWorkbook wb = new HSSFWorkbook(bis);
                        HSSFSheet sheet = wb.getSheetAt(0);
                        HSSFRow row;
                        /**Начало чтения документа с заданной строки*/
                        int startRowIndex = 3;

                        for (int i = startRowIndex; i <= sheet.getLastRowNum(); i++) {

                                row = sheet.getRow(i);

                                Movement movement = new Movement();

                                /**Вспомогательные переменные для конвертации в sqlDate*/
                                java.util.Date utilDate = row.getCell(0).getDateCellValue();
                                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                                /**Дата приказа*/
                                movement.setOrderdate(sqlDate);
                                /**Номер приказа*/
                                movement.setOrdernum(String.valueOf(row.getCell(1).getRichStringCellValue()));
                                /**Тип приказа*/
                                movement.setOrdertype(String.valueOf(row.getCell(2).getRichStringCellValue()));
                                /**ФИО*/
                                movement.setFio(String.valueOf(row.getCell(3).getRichStringCellValue()));
                                /**Текст приказа*/
                                movement.setOrdertext(String.valueOf(row.getCell(4).getRichStringCellValue()));
                                /**Добавление приказа*/
                                movementService.createMovement(movement);
                        }
                } catch (FileNotFoundException ec) {
                        ec.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}