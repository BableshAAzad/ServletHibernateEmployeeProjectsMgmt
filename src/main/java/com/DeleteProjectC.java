package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.entity.Project;
import com.helper.SessionProvider;

@WebServlet("/deleteProject")
public class DeleteProjectC extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		int projectId = Integer.parseInt(req.getParameter("projectId"));
		
		Session session = SessionProvider.getSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Employee employee = session.get(Employee.class, employeeId);
		Project project = session.get(Project.class, projectId);
		List<Project> projects = employee.getProjects();
		projects.remove(project);
		
		employee.setProjects(projects);
		
		
		session.update(employee);
		session.delete(project);
		tx.commit();
		session.close();
		
		String alertScript = "<script>alert('Project deleted successfully!'); window.location.href='displayAllProjects?employeeId="
				+employeeId+"';</script>";
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(alertScript);
        out.close();
	}
}
