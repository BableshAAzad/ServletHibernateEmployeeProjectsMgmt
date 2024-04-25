<%@page import="com.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
<%@include file="css/common_css.jsp"%>
</head>
<body>
<h2>Update Employee</h2><br/>
<% Employee emp = (Employee) request.getAttribute("employee"); %>
	<form action="updateEmp" method="post">
		<input type="number" name="employeeId" value="<%=emp.getEmployeeId()%>" readonly="true" /><br/><br/>
		<input type="text" name="employeeName" value="<%=emp.getEmployeeName()%>" placeholder="Enter Employee Name" /><br/><br/>
		<input type="text" name="employeeAddress" value="<%=emp.getEmployeeAddress()%>" placeholder="Enter Employee Address" /><br/><br/>
	    <input type="number" name="employeeSalary" value="<%=emp.getSalary()%>" placeholder="Enter Employee Salary" /><br/><br/>
	    <input type="submit" value="Update Employee" />
	</form>
	<br/>
	<h2>
		<a href="index.jsp">Home Page</a>
	</h2>
	<br/>
	<h3><a href="displayAllEmployees">Display All Employees Page</a></h3>
</body>
</html>