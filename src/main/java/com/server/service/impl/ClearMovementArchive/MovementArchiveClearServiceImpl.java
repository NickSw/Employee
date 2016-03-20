package com.server.service.impl.ClearMovementArchive;

import com.server.entity.MovementArchive;
import com.server.service.MovementArchiveClearService;
import com.server.util.Writer;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Service("MovementArchiveClearServiceImpl")
@Transactional
public class MovementArchiveClearServiceImpl implements MovementArchiveClearService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void clearMovementArchive(HttpServletResponse response) {

        // 1. Create new workbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 2. Create new worksheet
        HSSFSheet worksheet = workbook.createSheet("Архив приказов");

        // 3. Define starting indices for rows and columns
        int startRowIndex = 0;
        int startColIndex = 0;

        // 4. Build layout
        // Build title, date, and column headers
        MovementArchiveLayouter.buildReport(worksheet, startRowIndex, startColIndex);

        // 5. Fill report
        MovementArchiveFillManager.fillReport(worksheet, startRowIndex, startColIndex, getDatasource());

        // 6. Set the response properties
        String fileName = "Arhiv_Prikazov.xls";
        response.setHeader("Content-Disposition", "inline; filename=" + fileName);
        // Make sure to set the correct content type
        response.setContentType("application/vnd.ms-excel");
        //7. Write to the output stream
        Writer.write(response, worksheet);

        deleteAll();

    }

    private void deleteAll(){
        // Retrieve session
        Session session = sessionFactory.getCurrentSession();
        // Create query for retrieving products
        Query query = session.createQuery("DELETE FROM MovementArchive");
        // Execute query
        int result = query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    private List<MovementArchive> getDatasource() {
        // Retrieve session
        Session session = sessionFactory.getCurrentSession();
        // Create query for retrieving products
        Query query = session.createQuery("FROM MovementArchive");
        // Execute query
        List<MovementArchive> result = query.list();
        // Return the datasource
        return result;
    }
}