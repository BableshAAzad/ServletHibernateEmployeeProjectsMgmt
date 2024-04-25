<%@page import="com.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Employees</title>
<%@include file="css/common_css.jsp"%>
</head>
<body>
	<%
	List<Employee> list = (List) request.getAttribute("list");
	%>
	<h1>Employee Dashboard</h1><br/>
	<table border="1" cellspacing="0" cellpadding="5px">
		<thead>
			<tr>
				<th>EmployeeId</th>
				<th>EmployeeName</th>
				<th>EmployeeAddress</th>
				<th>Salary</th>
				<th>Projects</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Employee emp : list) {
			%>
			<tr>
				<td><%=emp.getEmployeeId()%></td>
				<td><%=emp.getEmployeeName()%></td>
				<td><%=emp.getEmployeeAddress()%></td>
				<td><%=emp.getSalary()%> lpa</td>
				<td><a href="displayAllProjects?employeeId=<%=emp.getEmployeeId()%>">View</a></td>
				<td><a href="updateEmployee?employeeId=<%=emp.getEmployeeId()%>">UPDATE</a></td>
				<td><a href="deleteEmployee?employeeId=<%=emp.getEmployeeId()%>">DELETE</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br/>
	<h2>
		<a href="addEmployee.jsp">Add Employee</a>
	</h2>
	<br/>
	<h2>
		<a href="index.jsp">Home Page</a>
	</h2>
</body>
</html>