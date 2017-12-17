<%-- 
    Document   : employee
    Created on : Aug 23, 2017, 3:43:16 PM
    Author     : TN041502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Employee Data</h2>
        <form method="POST" action="addEmployee">
            <label>Id:</label>  <input type="text" name="id" id="id"><br/>
            <label>First Name:</label>  <input type="text" name="firstName" id="firstName"><br/>
            <label>Last Name:</label>  <input type="text" name="lastName" id="lastName"><br/>
            <label>Job Role:</label>  <input type="text" name="jobRole" id="jobRole"><br/>
            <label>Salary:</label>  <input type="text" name="salary" id="salary"><br/>
            <input type="submit">
        </form>
    </body>
</html>
