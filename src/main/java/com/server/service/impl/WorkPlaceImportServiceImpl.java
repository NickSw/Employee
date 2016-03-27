package com.server.service.impl;

import com.server.entity.OrderType;
import com.server.entity.WorkPlace;
import com.server.service.OrderTypeImportService;
import com.server.service.OrderTypeService;
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

@Service
@Transactional
public class WorkPlaceImportServiceImpl implements WorkPlaceImportService {

    @Autowired
    WorkPlaceService workPlaceService;

    @Override
    public void importWorkPlace(FileBean fileBean){
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getFileData().getBytes());
            HSSFWorkbook wb = new HSSFWorkbook(bis);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                WorkPlace workPlace = new WorkPlace();
                workPlace.setPlace(String.valueOf(row.getCell(0).getRichStringCellValue()));
                workPlace.setAddress(String.valueOf(row.getCell(1).getRichStringCellValue()));
                Double cellValue = row.getCell(2).getNumericCellValue();
                DecimalFormat format = new DecimalFormat("0.#");
                workPlace.setPhone(String.valueOf(format.format(cellValue)));
                workPlaceService.createWorkPlace(workPlace);
            }
        } catch (FileNotFoundException ec) {
            ec.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}