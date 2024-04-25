<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Project</title>
<%@include file="css/common_css.jsp"%>
</head>
<body>
<h2>Add Employee</h2><br/>
     <% int employeeId = (Integer) request.getAttribute("employeeId");  %>
	<form action="addProj" method="post">
	    <input type="number" name="employeeId" value=<%=employeeId%> readonly="true" /><br/><br/>
		<input type="number" name="projectId" placeholder="Enter Project Id" /><br/><br/>
		<input type="text" name="projectName" placeholder="Enter Project Name" /><br/><br/>
		<input type="text" name="techStack" placeholder="Enter Tech Stack" /><br/><br/>
	    <input type="submit" value="Add Project" />
	</form>
	<br/>
	<h2>
		<a href="displayAllProjects?employeeId=<%=employeeId%>">Back page</a>
	</h2>
	<br/>
	<h2>
		<a href="displayAllEmployees">Display All Employees Page</a>
	</h2>
	<br/>
	<h2>
		<a href="index.jsp">Home Page</a>
	</h2>
</body>
</html>