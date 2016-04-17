package com.server.controller;
import com.server.entity.Employee;
import com.server.entity.WorkPlace;
import com.server.service.EmployeeService;

import com.server.service.WorkPlaceService;
import com.server.util.FileBean;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *  онтроллер дл€ таблицы сотрудники
 * ћетоды:
 * »звлечение всех сотрудников из таблицы и помещение на страницу
 * —оздание сотрудника
 * –едактирование сотрудника
 * ”даление сотрудника
 * —охранение сотрудника
 * ѕеремещение сотрудника в таблицу архив сотрудников
 * »звлечение сотрудника и помещение на страницу карточка сотрудника
 */
@Controller
public class EmployeeController {

	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WorkPlaceService workPlaceService;

    /**
     * »звлечение всех сотрудников из таблицы
     * »звлечение мест работы дл€ фильтра
     * @param fileBean
     * @param result
     * @return
     */
    @RequestMapping(value = {"getAllEmployees", "/"})
    public ModelAndView getAllEmployees(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        logger.info("Getting the all Employees.");
        /**»звлечение всех сотрудников*/
        List<Employee> employeeList = employeeService.getAllEmployees();
        /**»звлечение всех мест работы*/
        List<WorkPlace> workPlaceList = workPlaceService.getAllWorkPlaces();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employeeList", employeeList);
        model.put("workPlaceList", workPlaceList);
        return new ModelAndView("employeeList", "model", model);
    }

    /**
     * —оздание сотрудника
     * »звлечение мест работы дл€ выпадающего списка места работы
     * @param employee
     * @return
     */
    @RequestMapping("createEmployee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
    	logger.info("Creating Employee. Data: " + employee);
        /**»звлечение мест работы*/
        List<WorkPlace> workPlaceList = workPlaceService.getAllWorkPlaces();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("workPlaceList", workPlaceList);
        return new ModelAndView("employeeForm", "model", model);
    }

    /**
     * –едактирование сотрудника
     * »звлечение мест работы дл€ выпадающего списка места работы
     * TODO: добавить соответсвующее значение при редактировании первым, пустое значение
     * @param id
     * @param employee
     * @return
     */
    @RequestMapping("editEmployee")
    public ModelAndView editEmployee(@RequestParam int id, @ModelAttribute Employee employee) {
    	logger.info("Updating the Employee for the Id " + id);
        /**»звлечение сотрудника дл€ редактировани€*/
        employee = employeeService.getEmployee(id);
        /**»звлечение всех мест работы*/
        List<WorkPlace> workPlaceList = workPlaceService.getAllWorkPlaces();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employee", employee);
        model.put("workPlaceList", workPlaceList);
        return new ModelAndView("employeeForm", "model", model);
    }


    /**
     * —охранение сотрудника в базу
     *
     * –азрешение пустых полей дат
     * ѕроверка полей дат на пустую строку через дополнительные строковые
     * пол€ сущности -> преобразование в null если строковые пол€ пустые
     * @param employee
     * @return
     */
    @RequestMapping("saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
    	logger.info("Saving the Employee. Data : " + employee);
        /**
         * ѕроверка полей дат на пустую строку через дополнительные строковые
         * пол€ сущности -> преобразование в null если строковые пол€ пустые
         */
        if (employee.getBirthdayString() == "") employee.setBirthday(null);
        if (employee.getEnrolldateString() =="") employee.setEnrolldate(null);
        if (employee.getEnrollorderdateString() == "") employee.setEnrolldateString(null);
        /**
         * ѕроверка редактировали сотрудника или создавали нового
         * ≈сли employee id 0, тогда создаем сотрудника, если нет, то обновл€ем существующего
         */
        if(employee.getId() == 0){
            employeeService.createEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:getAllEmployees");
    }

    /**
     * ”даление сотрудника
     * @param id
     * @return
     */
    @RequestMapping("deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam int id) {
        logger.info("Deleting the Employee. Id : "+id);
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:getAllEmployees");
    }

    /**
     * ѕеремещение сотрудника в архив
     * @param id
     * @return
     */
    @RequestMapping("archiveEmployee")
    public ModelAndView archiveEmployee(@RequestParam int id) {
        logger.info("Archiving the Employee. Id : " + id);
        employeeService.moveToEmployeeArchive(id);
        return new ModelAndView("redirect:getAllEmployeesArchive");
    }

    /**
     * »звлечение сотрудника и помещение на страницу карточка сотрудника
     * @param id
     * @param employee
     * @return
     */
    @RequestMapping("getEmployee")
    public ModelAndView getEmployee(@RequestParam int id, @ModelAttribute Employee employee){
        logger.info("Getting Employee. Id : " + id);
        employee = employeeService.getEmployee(id);
        return new ModelAndView("employeeCard", "employeeObject", employee);
    }
}