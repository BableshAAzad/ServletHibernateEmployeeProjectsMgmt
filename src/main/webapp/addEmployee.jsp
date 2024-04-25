<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee Page</title>
<%@include file="css/common_css.jsp"%>
</head>
<body>
	<h2>Add Employee</h2><br/>
	<form action="addEmpl" method="post">
		<input type="number" name="employeeId" placeholder="Enter Employee Id" /><br/><br/>
		<input type="text" name="employeeName" placeholder="Enter Employee Name" /><br/><br/>
		<input type="text" name="employeeAddress" placeholder="Enter Employee Address" /><br/><br/>
	    <input type="number" name="employeeSalary" placeholder="Enter Employee Salary" /><br/><br/>
	    <input type="submit" value="Add Employee" />
	</form>
	<br/>
	<h2>
		<a href="index.jsp">Home Page</a>
	</h2>
	<br/>
	<h3><a href="displayAllEmployees">Display All Employees Page</a></h3>
</body>
</html>