<%-- 
    Document   : result
    Created on : Aug 23, 2017, 3:39:43 PM
    Author     : TN041502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>Submitted Student Information</h2>
      
      <table>
          <tr>
            <td>ID</td>
            <td>${id}</td>
         </tr>
         <tr>
            <td>First Name</td>
            <td>${firstName}</td>
         </tr>
         <tr>
            <td>Last Name</td>
            <td>${lastName}</td>
         </tr>
         <tr>
            <td>Job Role</td>
            <td>${jobRole}</td>
         </tr>
         <tr>
            <td>Salary</td>
            <td>${salary}</td>
         </tr>
      </table>  
   </body>
   
</html>