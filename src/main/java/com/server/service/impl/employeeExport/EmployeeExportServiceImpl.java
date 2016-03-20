package com.server.service.impl.employeeExport;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.server.entity.Employee;
import com.server.service.EmployeeExportService;
import com.server.util.Writer;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Service("EmployeeExportServiceImpl")
@Transactional
public class EmployeeExportServiceImpl implements EmployeeExportService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void exportEmployee(HttpServletResponse response) {

        // 1. Create new workbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 2. Create new worksheet
        HSSFSheet worksheet = workbook.createSheet("Сотрудники");

        // 3. Define starting indices for rows and columns
        int startRowIndex = 0;
        int startColIndex = 0;

        // 4. Build layout
        // Build title, date, and column headers
        EmployeeLayouter.buildReport(worksheet, startRowIndex, startColIndex);

        // 5. Fill report
        EmployeeFillManager.fillReport(worksheet, startRowIndex, startColIndex, getDatasource());

        // 6. Set the response properties
        String fileName = "Baza_Sotrudnikov.xls";
        response.setHeader("Content-Disposition", "inline; filename=" + fileName);
        // Make sure to set the correct content type
        response.setContentType("application/vnd.ms-excel");
        //7. Write to the output stream
        Writer.write(response, worksheet);
    }

    @SuppressWarnings("unchecked")
    private List<Employee> getDatasource() {
        // Retrieve session
        Session session = sessionFactory.getCurrentSession();
        // Create query for retrieving products
        Query query = session.createQuery("FROM Employee");
        // Execute query
        List<Employee> result = query.list();
        // Return the datasource
        return result;
        }
}