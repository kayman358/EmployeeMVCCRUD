/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obiee.dao.impl;

import com.obiee.dao.EmployeeDAO;
import com.obiee.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author Kolade
 */
public class EmployeeDAOImpl implements EmployeeDAO {
HibernateTemplate template;

public void setTemplate(HibernateTemplate template) {  
    this.template = template;  
}  
    @Override
    public void createEmployee(Employee e) {
      template.save(e);  
    }

    @Override
    public void deleteEmployeeById(int empId) {
         template.delete(empId);
    }

    @Override
    public Employee getEmployeeById(int empId) {
         Employee e = (Employee)template.get(Employee.class, empId);  
    return e;  
    }

    @Override
    public void updateEmployeeById(Employee e, int empId) {
     template.update(e);  
    }

    @Override
    public List<Employee> getAllEmployees() {
         List<Employee> list = new ArrayList<Employee>();
         list=template.loadAll(Employee.class);  
    return list;  
    }
    
}
