/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obiee.impl;

import com.obiee.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.obiee.dao.EmpDao;
import static java.util.Collections.list;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author TN041502
 */

@Controller

public class ApplicationClass {
//@PathVariable(value= "/employees");
    
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    EmpDao JDBCTemplate
            = (EmpDao) context.getBean("JDBCTemplate");
    

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView result() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "HelloWorld");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView employee() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employee");
        return mv;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public ModelAndView addEmployee(@ModelAttribute Employee employeeObject) {
        ModelAndView mv = new ModelAndView();

        System.out.println("emp data " + employeeObject.getFirstName());
        JDBCTemplate.createEmployee(employeeObject);

        mv.addObject("id", employeeObject.getId());
        mv.addObject("firstName", employeeObject.getFirstName());
        mv.addObject("lastName", employeeObject.getLastName());
        mv.addObject("jobRole", employeeObject.getJobRole());
        mv.addObject("salary", employeeObject.getSalary());
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable(value = "id") Integer id) {
        ModelAndView mv = new ModelAndView();
        JDBCTemplate.deleteEmployee(id);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
    public ModelAndView getEmployee(@PathVariable(value = "id") Integer id, @ModelAttribute Employee emp) {
        ModelAndView mv = new ModelAndView();
        emp = JDBCTemplate.getEmployeeById(id);
        System.out.println("ID is " + emp.getId());
        System.out.println("First Name is " + emp.getFirstName());
        System.out.println("Last Name is " + emp.getLastName());
        System.out.println("Salary is " + emp.getSalary());
        System.out.println("Job role is " + emp.getJobRole());
        mv.setViewName("result");
        return mv;
    }
    
    @RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
    public ModelAndView getAllEmployees(@ModelAttribute Employee emp) {
        ModelAndView mv = new ModelAndView();
      List<Employee> employees = JDBCTemplate.getEmployees();

        System.out.println("name is " + employees);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
    public ModelAndView updateEmployee(@PathVariable(value = "id") Integer id, @ModelAttribute Employee emp) {
        ModelAndView mv = new ModelAndView();
        JDBCTemplate.update(emp, id);
    return mv;
    }
    
    
    
}
