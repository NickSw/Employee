package com.server.service.impl;

import com.server.entity.Employee;
import com.server.service.EmployeeImportService;
import com.server.service.EmployeeService;
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
 * Реализация сервиса импорта сотрудника
 */
@Service
@Transactional
public class EmployeeImportServiceImpl implements EmployeeImportService{

    @Autowired
    EmployeeService employeeService;

    /**
     * Функция импорта сотрудника из файла
     * @param fileBean
     */
    @Override
    public void importEmployee(FileBean fileBean){
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getFileData().getBytes());
            HSSFWorkbook wb = new HSSFWorkbook(bis);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            /**Начало чтения документа с заданной строки*/
            int startRowIndex = 3;

            for (int i = startRowIndex; i <= sheet.getLastRowNum(); i++) {

                /**Берем строку*/
                row = sheet.getRow(i);

                Employee employee = new Employee();

                /**Вспомогательные переменные для конвертации в sqlDate*/
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                /**Исключаю null строки*/
                //try {
                    /**ФИО*/
                    employee.setName(String.valueOf(row.getCell(0).getRichStringCellValue()));
                    /**Телефон*/
                    employee.setPhone(String.valueOf(row.getCell(1).getRichStringCellValue()));
                    /**Почта*/
                    employee.setMail(String.valueOf(row.getCell(2).getRichStringCellValue()));
                    /**Должность 1*/
                    employee.setPosition1(String.valueOf(row.getCell(3).getRichStringCellValue()));
                    /**Должность 2*/
                    employee.setPosition2(String.valueOf(row.getCell(4).getRichStringCellValue()));
                    /**Место работы*/
                    employee.setWorkplace(String.valueOf(row.getCell(5).getRichStringCellValue()));
                    /**Дата рождения*/
                    /**Проверка на пустое поле(пустая строка) даты в файле*/
                    try {
                        if (String.valueOf(row.getCell(6).getRichStringCellValue()) == "")
                            employee.setBirthday(null);
                    } catch (java.lang.IllegalStateException ex) {
                        utilDate = row.getCell(6).getDateCellValue();
                        sqlDate = new java.sql.Date(utilDate.getTime());
                        employee.setBirthday(sqlDate);
                    }
                    /**Дети*/
                    /**Проверка на возможность числового поля*/
                    try {
                        employee.setChildren(String.valueOf(row.getCell(7).getRichStringCellValue()));
                    } catch (java.lang.IllegalStateException ex) {
                        employee.setChildren(String.valueOf((int) row.getCell(7).getNumericCellValue()));
                    }
                    /**Адрес*/
                    employee.setAddress(String.valueOf(row.getCell(8).getRichStringCellValue()));
                    /**ВУЗ*/
                    employee.setStudy(String.valueOf(row.getCell(9).getRichStringCellValue()));
                    /**Специальность*/
                    employee.setSpeciality(String.valueOf(row.getCell(10).getRichStringCellValue()));
                    /**Идентиф. код*/
                    /**Проверка на строковое поле*/
                    try {
                        employee.setCode(Integer.valueOf((int) row.getCell(11).getNumericCellValue()));
                    } catch (java.lang.IllegalStateException ex) {
                        employee.setCode(Integer.parseInt(String.valueOf(row.getCell(11).getRichStringCellValue())));
                    }
                    /**Паспорт*/
                    employee.setPassport(String.valueOf(row.getCell(12).getRichStringCellValue()));
                    /**Тип оформления*/
                    employee.setDecortype(String.valueOf(row.getCell(13).getRichStringCellValue()));
                    /**Дата зачисления*/
                    /**Проверка на пустое поле(пустая строка) даты в файле*/
                    try {
                        if (String.valueOf(row.getCell(14).getRichStringCellValue()) == "")
                            employee.setEnrolldate(null);
                    } catch (java.lang.IllegalStateException ex) {
                        utilDate = row.getCell(14).getDateCellValue();
                        sqlDate = new java.sql.Date(utilDate.getTime());
                        employee.setEnrolldate(sqlDate);
                    }
                    /**Приказ о зачислении*/
                    employee.setEnrollorder(String.valueOf(row.getCell(15).getRichStringCellValue()));
                    /**Дата приказа о зачислении*/
                    /**Проверка на пустое поле(пустая строка) даты в файле*/
                    try {
                        if (String.valueOf(row.getCell(16).getRichStringCellValue()) == "")
                            employee.setEnrollorderdate(null);
                    } catch (java.lang.IllegalStateException ex) {
                        utilDate = row.getCell(16).getDateCellValue();
                        sqlDate = new java.sql.Date(utilDate.getTime());
                        employee.setEnrollorderdate(sqlDate);
                    } catch (NullPointerException ex) {
                        employee.setEnrollorderdate(null);
                    }
                    /**Трудовая книжка*/
                    employee.setRecofservice(String.valueOf(row.getCell(17).getRichStringCellValue()));
                    /**Примечание*/
                    employee.setNotes(String.valueOf(row.getCell(18).getRichStringCellValue()));
                /*}
                catch (NullPointerException ex){
                    return;
                }*/
                /**Добавления сотрудника*/
                employeeService.createEmployee(employee);
            }
        } catch (FileNotFoundException ec) {
            ec.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}