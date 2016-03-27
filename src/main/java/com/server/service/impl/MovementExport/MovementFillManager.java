package com.server.service.impl.MovementExport;

import com.server.entity.Movement;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;

import java.util.List;

public class MovementFillManager {

    public static void fillReport(HSSFSheet worksheet, int startRowIndex, int startColIndex, List<Movement> datasource) {
        // Row offset
        startRowIndex += 2;

        // Create cell style for the body
        HSSFCellStyle bodyCellStyle = worksheet.getWorkbook().createCellStyle();
        bodyCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        bodyCellStyle.setWrapText(true);

        HSSFCellStyle dateCellStyle = worksheet.getWorkbook().createCellStyle();
        CreationHelper createHelper = worksheet.getWorkbook().getCreationHelper();
        dateCellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("yyyy-mm-dd"));
        dateCellStyle.setAlignment(CellStyle.ALIGN_CENTER);

        // Create body
        for (int i=startRowIndex; i+startRowIndex-2< datasource.size()+2; i++) {
            // Create a new row
            HSSFRow row = worksheet.createRow((short) i+1);

            HSSFCell cell1 = row.createCell(startColIndex+0);
            cell1.setCellValue(datasource.get(i-2).getOrderdate());
            cell1.setCellStyle(dateCellStyle);

            HSSFCell cell2 = row.createCell(startColIndex+1);
            cell2.setCellValue(datasource.get(i-2).getOrdernum());
            cell2.setCellStyle(bodyCellStyle);

            HSSFCell cell3 = row.createCell(startColIndex+2);
            cell3.setCellValue(datasource.get(i-2).getOrdertype());
            cell3.setCellStyle(bodyCellStyle);

            HSSFCell cell4 = row.createCell(startColIndex+3);
            cell4.setCellValue(datasource.get(i-2).getFio());
            cell4.setCellStyle(bodyCellStyle);

            HSSFCell cell5 = row.createCell(startColIndex+4);
            cell5.setCellValue(datasource.get(i-2).getOrdertext());
            cell5.setCellStyle(bodyCellStyle);
        }
    }
}