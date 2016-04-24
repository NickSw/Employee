package com.server.service.impl.OrderTypeExport;

import com.server.entity.OrderType;
import com.server.service.OrderTypeExportService;
import com.server.util.Writer;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Экспорт таблицы типов приказов
 * Методы:
 * Экспорт типов приказов
 * Извлечение всех типов приказов
 */
@Service("OrderTypeExportServiceImpl")
@Transactional
public class OrderTypeExportServiceImpl implements OrderTypeExportService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void exportOrderType(HttpServletResponse response) {

        // 1. Create new workbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 2. Create new worksheet
        HSSFSheet worksheet = workbook.createSheet("Типы приказов");

        // 3. Define starting indices for rows and columns
        int startRowIndex = 0;
        int startColIndex = 0;

        // 4. Build layout
        // Build title, date, and column headers
        OrderTypeLayouter.buildReport(worksheet, startRowIndex, startColIndex);

        // 5. Fill report
        OrderTypeFillManager.fillReport(worksheet, startRowIndex, startColIndex, getDatasource());

        // 6. Set the response properties
        String fileName = "Tipi_prikazov.xls";
        response.setHeader("Content-Disposition", "inline; filename=" + fileName);
        // Make sure to set the correct content type
        response.setContentType("application/vnd.ms-excel");
        //7. Write to the output stream
        Writer.write(response, worksheet);

    }

    @SuppressWarnings("unchecked")
    private List<OrderType> getDatasource() {
        // Retrieve session
        Session session = sessionFactory.getCurrentSession();
        // Create query for retrieving products
        Query query = session.createQuery("FROM OrderType");
        // Execute query
        List<OrderType> result = query.list();
        // Return the datasource
        return result;
    }
}