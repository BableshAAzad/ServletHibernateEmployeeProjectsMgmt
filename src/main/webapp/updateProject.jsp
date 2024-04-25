<%@page import="com.entity.Project"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Project</title>
<%@include file="css/common_css.jsp"%>
</head>
<body>
 <h2>Update Employee</h2><br/>
     <% int employeeId = (Integer) request.getAttribute("employeeId");
     Project project = (Project) request.getAttribute("project");
     %>
	<form action="updateProj" method="post">
	    <input type="number" name="employeeId" value=<%=employeeId%> readonly="true" /><br/><br/>
		<input type="number" name="projectId" value=<%=project.getProjectId()%> readonly="true" /><br/><br/>
		<input type="text" name="projectName" value=<%=project.getProjectName()%>  placeholder="Enter Project Name" /><br/><br/>
		<input type="text" name="techStack" value=<%=project.getTechStack()%> placeholder="Enter Tech Stack" /><br/><br/>
	    <input type="submit" value="Update Project" />
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