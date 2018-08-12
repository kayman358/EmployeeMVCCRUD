/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obiee.dao;

import com.obiee.model.Employee;
import java.util.List;

/**
 *
 * @author Kolade
 */
public interface EmployeeDAO {
    void createEmployee(Employee e);
    void deleteEmployeeById(int empId);
    Employee getEmployeeById(int empId);
    void updateEmployeeById(Employee e, int empId);
    List<Employee> getAllEmployees();
    
}
