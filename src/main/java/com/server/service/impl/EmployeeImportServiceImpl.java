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

@Service
@Transactional
public class EmployeeImportServiceImpl implements EmployeeImportService {

    @Autowired
    EmployeeService employeeService;

    @Override
    public void importEmployee(FileBean fileBean){
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getFileData().getBytes());
            HSSFWorkbook wb = new HSSFWorkbook(bis);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;

            for (int i = 3; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                Employee employee = new Employee();
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                employee.setName(String.valueOf(row.getCell(0).getRichStringCellValue()));
                employee.setPhone(String.valueOf(row.getCell(1).getRichStringCellValue()));
                employee.setMail(String.valueOf(row.getCell(2).getRichStringCellValue()));
                employee.setPosition1(String.valueOf(row.getCell(3).getRichStringCellValue()));
                employee.setPosition2(String.valueOf(row.getCell(4).getRichStringCellValue()));
                employee.setWorkplace(String.valueOf(row.getCell(5).getRichStringCellValue()));
                /*b-day*/
                try {
                    if (String.valueOf(row.getCell(6).getRichStringCellValue()) == "")
                        employee.setBirthday(null);
                }
                catch(java.lang.IllegalStateException ex){
                        utilDate = row.getCell(6).getDateCellValue();
                        sqlDate = new java.sql.Date(utilDate.getTime());
                        employee.setBirthday(sqlDate);
                    }
                employee.setBirthday(sqlDate);
                try {
                    employee.setChildren(String.valueOf(row.getCell(7).getRichStringCellValue()));
                }
                catch(java.lang.IllegalStateException ex){
                    employee.setChildren(String.valueOf((int) row.getCell(7).getNumericCellValue()));
                }
                employee.setAddress(String.valueOf(row.getCell(8).getRichStringCellValue()));
                employee.setStudy(String.valueOf(row.getCell(9).getRichStringCellValue()));
                employee.setSpeciality(String.valueOf(row.getCell(10).getRichStringCellValue()));
                try {
                    employee.setCode(Integer.valueOf((int) row.getCell(11).getNumericCellValue()));
                }
                catch(java.lang.IllegalStateException ex){
                    employee.setCode(Integer.parseInt(String.valueOf(row.getCell(11).getRichStringCellValue())));
                }
                employee.setPassport(String.valueOf(row.getCell(12).getRichStringCellValue()));
                employee.setDecortype(String.valueOf(row.getCell(13).getRichStringCellValue()));
                /*enroll-date*/
                try {
                    if (String.valueOf(row.getCell(14).getRichStringCellValue()) == "")
                        employee.setEnrolldate(null);
                }
                catch(java.lang.IllegalStateException ex){
                    utilDate = row.getCell(14).getDateCellValue();
                    sqlDate = new java.sql.Date(utilDate.getTime());
                    employee.setEnrolldate(sqlDate);
                }
                employee.setEnrollorder(String.valueOf(row.getCell(15).getRichStringCellValue()));
                /*enroll-order-date*/
                try {
                    if (String.valueOf(row.getCell(16).getRichStringCellValue()) == "")
                        employee.setEnrollorderdate(null);
                }
                catch(java.lang.IllegalStateException ex){
                    utilDate = row.getCell(16).getDateCellValue();
                    sqlDate = new java.sql.Date(utilDate.getTime());
                    employee.setEnrollorderdate(sqlDate);
                }
                employee.setRecofservice(String.valueOf(row.getCell(17).getRichStringCellValue()));
                employee.setNotes(String.valueOf(row.getCell(18).getRichStringCellValue()));
                employeeService.createEmployee(employee);
            }
        } catch (FileNotFoundException ec) {
            ec.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}