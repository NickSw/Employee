package com.server.service.impl.MovementExport;

import com.server.entity.Movement;
import com.server.service.MovementExportService;
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

@Service("MovementExportServiceImpl")
@Transactional
public class MovementExportServiceImpl implements MovementExportService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void exportMovement(HttpServletResponse response) {

        // 1. Create new workbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 2. Create new worksheet
        HSSFSheet worksheet = workbook.createSheet("Приказы по сотрудникам");

        // 3. Define starting indices for rows and columns
        int startRowIndex = 0;
        int startColIndex = 0;

        // 4. Build layout
        // Build title, date, and column headers
        MovementLayouter.buildReport(worksheet, startRowIndex, startColIndex);

        // 5. Fill report
        MovementFillManager.fillReport(worksheet, startRowIndex, startColIndex, getDatasource());

        // 6. Set the response properties
        String fileName = "Prikazi_po_sotryd.xls";
        response.setHeader("Content-Disposition", "inline; filename=" + fileName);
        // Make sure to set the correct content type
        response.setContentType("application/vnd.ms-excel");
        //7. Write to the output stream
        Writer.write(response, worksheet);

    }

    @SuppressWarnings("unchecked")
    private List<Movement> getDatasource() {
        // Retrieve session
        Session session = sessionFactory.getCurrentSession();
        // Create query for retrieving products
        Query query = session.createQuery("FROM Movement");
        // Execute query
        List<Movement> result = query.list();
        // Return the datasource
        return result;
    }
}