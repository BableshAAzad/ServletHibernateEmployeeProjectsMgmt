<%@page import="com.entity.Project"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Projects</title>
<%@include file="css/common_css.jsp"%>
</head>
<body>
<%
	List<Project> projects = (List) request.getAttribute("projects");
    int employeeId = (Integer) request.getAttribute("employeeId");
	%>
	<h1>Projects Dashboard</h1><br/>
	<table border="1" cellspacing="0" cellpadding="5px">
		<thead>
			<tr>
				<th>Project Id</th>
				<th>Project Name</th>
				<th>Tech Stack</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Project pro : projects) {
			%>
			<tr>
				<td><%=pro.getProjectId()%></td>
				<td><%=pro.getProjectName()%></td>
				<td><%=pro.getTechStack()%></td>
				<td><a href="updateProject?employeeId=<%=pro.getEmployee().getEmployeeId()%>&projectId=<%=pro.getProjectId()%>">UPDATE</a></td>
				<td><a href="deleteProject?employeeId=<%=pro.getEmployee().getEmployeeId()%>&projectId=<%=pro.getProjectId()%>">DELETE</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br/>
	<h2>
		<a href="addProject?employeeId=<%=employeeId%>">Add Project</a>
	</h2>
	<br/>
	<h2>
		<a href="displayAllEmployees">Back Page</a>
	</h2>
	<br/>
	<h2>
		<a href="index.jsp">Home Page</a>
	</h2>
</body>
</html>