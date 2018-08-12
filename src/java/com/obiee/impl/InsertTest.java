/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obiee.impl;

/**
 *
 * @author Kolade
 */
 
  
import com.obiee.dao.impl.EmployeeDAOImpl;
import com.obiee.model.Employee;
import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;  
  
public class InsertTest {  
public static void main(String[] args) {  
      
    Resource r=new ClassPathResource("applicationContext.xml");  
    BeanFactory factory = new XmlBeanFactory(r);  
      
    EmployeeDAOImpl dao=(EmployeeDAOImpl)factory.getBean("d");  
      
    Employee e=new Employee();  
    e.setId(114);  
    e.setFirstName("varun");  
    e.setSalary(50000);  
      
    dao.createEmployee(e);  
      
}  
}  
