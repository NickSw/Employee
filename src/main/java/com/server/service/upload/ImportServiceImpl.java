package com.server.service.upload;

import com.server.entity.Movement;
import com.server.service.EmployeeService;
import com.server.service.ImportService;
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

@Service
@Transactional
public class ImportServiceImpl implements ImportService{

       // EmployeeService employeeService;
        @Autowired
        MovementService movementService;

        @Override
        public void importFile(FileBean fileBean){
                try {
                        ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getFileData().getBytes());
                        HSSFWorkbook wb = new HSSFWorkbook(bis);
                        HSSFSheet sheet = wb.getSheetAt(0);
                        HSSFRow row;

                        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                                //Employee employee = new Employee();
                                row = sheet.getRow(i);
                                Movement movement = new Movement();
                                /****converting util date to sql date****/
                                java.util.Date utilDate = row.getCell(0).getDateCellValue();
                                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                                movement.setOrderdate(sqlDate);
                                /*****/
                                movement.setOrdernum(String.valueOf(row.getCell(1).getRichStringCellValue()));
                                movement.setOrdertype(String.valueOf(row.getCell(2).getRichStringCellValue()));
                                movement.setFio(String.valueOf(row.getCell(3).getRichStringCellValue()));
                                movement.setOrdertext(String.valueOf(row.getCell(4).getRichStringCellValue()));
                                movementService.createMovement(movement);
                /*employee.setName(String.valueOf(row.getCell(0).getRichStringCellValue()));
                employee.setAddress(String.valueOf(row.getCell(1).getRichStringCellValue()));
                employee.setBirthday((java.sql.Date)row.getCell(2).getDateCellValue());
                employeeService.createEmployee(employee); // call to spring service layer*/
                        }
                } catch (FileNotFoundException ec) {
                        ec.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}