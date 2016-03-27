package com.server.service.impl;

import com.server.entity.Movement;
import com.server.entity.OrderType;
import com.server.service.MovementImportService;
import com.server.service.MovementService;
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

@Service
@Transactional
public class OrderTypeImportServiceImpl implements OrderTypeImportService {

    @Autowired
    OrderTypeService orderTypeService;

    @Override
    public void importOrderType(FileBean fileBean){
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getFileData().getBytes());
            HSSFWorkbook wb = new HSSFWorkbook(bis);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                OrderType orderType = new OrderType();
                orderType.setOrdertype(String.valueOf(row.getCell(0).getRichStringCellValue()));
                orderType.setNotes(String.valueOf(row.getCell(1).getRichStringCellValue()));
                orderTypeService.createOrderType(orderType);
            }
        } catch (FileNotFoundException ec) {
            ec.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}