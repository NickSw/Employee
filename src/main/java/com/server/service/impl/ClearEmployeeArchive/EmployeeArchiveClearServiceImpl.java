package com.server.service.impl.ClearEmployeeArchive;

import com.server.entity.EmployeeArchive;
import com.server.service.EmployeeArchiveClearService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service("EmployeeArchiveClearServiceImpl")
@Transactional
public class EmployeeArchiveClearServiceImpl implements EmployeeArchiveClearService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void clearEmployeeArchive(HttpServletResponse response) {

        // 1. Create new workbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 2. Create new worksheet
        HSSFSheet worksheet = workbook.createSheet("Архив сотрудников");

        // 3. Define starting indices for rows and columns
        int startRowIndex = 0;
        int startColIndex = 0;

        // 4. Build layout
        // Build title, date, and column headers
        EmployeeArchiveLayouter.buildReport(worksheet, startRowIndex, startColIndex);

        // 5. Fill report
        EmployeeArchiveFillManager.fillReport(worksheet, startRowIndex, startColIndex, getDatasource());

        // 6. Set the response properties
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String strDate = formattedDate.format(now);
        String fileName = strDate + "_Arhiv_Sotrudnikov.xls" ;
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
        Query query = session.createQuery("DELETE FROM EmployeeArchive");
        // Execute query
        int result = query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    private List<EmployeeArchive> getDatasource() {
        // Retrieve session
        Session session = sessionFactory.getCurrentSession();
        // Create query for retrieving products
        Query query = session.createQuery("FROM EmployeeArchive");
        // Execute query
        List<EmployeeArchive> result = query.list();
        // Return the datasource
        return result;
    }
}