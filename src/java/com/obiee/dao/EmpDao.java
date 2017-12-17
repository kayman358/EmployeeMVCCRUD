/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this jdbcTemplateObject file, choose Tools | Templates
 * and open the jdbcTemplateObject in the editor.
 */
package com.obiee.dao;

/**
 *
 * @author TN041502
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.obiee.model.Employee;
import javax.sql.DataSource;

public class EmpDao {

    private JdbcTemplate jdbcTemplateObject;

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void setTemplate(JdbcTemplate jdbcTemplateObject) {
        this.jdbcTemplateObject = jdbcTemplateObject;
    }

    public void createEmployee(Employee emp) {
        String sql = "insert into employees (firstname,lastname,salary,designation) values "
                + "('" + emp.getFirstName() + "','" + emp.getLastName() + "','" + emp.getSalary() + "','" + emp.getJobRole() + "')";
        
        jdbcTemplateObject.update(sql);
    }

    public int update(Employee emp, int id) {
        String sql = "update employees set firstname='" + emp.getFirstName() + "', lastname= '" + emp.getLastName() + "', salary='" + emp.getSalary() + "',designation='" + emp.getJobRole() + "' where id=" + id+ "";
        return jdbcTemplateObject.update(sql);
    }

    public int deleteEmployee(int id) {
        String sql = "delete from employees where id=" + id;
        return jdbcTemplateObject.update(sql);
    }

    public Employee getEmployeeById(int id) {
        String sql = "select * from employees where id=?";
        return jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee emp = new Employee();
                emp.setId(rs.getInt(1));
                emp.setFirstName(rs.getString(2));
                emp.setLastName(rs.getString(3));
                emp.setSalary(rs.getFloat(4));
                emp.setJobRole(rs.getString(5));
                return emp;
            }
        });
    }

    public List<Employee> getEmployees() {
        return jdbcTemplateObject.query("select * from employees", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee emp = new Employee();
                emp.setId(rs.getInt(1));
                emp.setFirstName(rs.getString(2));
                emp.setLastName(rs.getString(3));
                emp.setSalary(rs.getFloat(4));
                emp.setJobRole(rs.getString(5));
                return emp;
            }
        });
    }
}
