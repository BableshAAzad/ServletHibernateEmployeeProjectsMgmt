package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/updateProject")
public class UpdateProjectC extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		int projectId = Integer.parseInt(req.getParameter("projectId"));

		Session session = SessionProvider.getSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		Project project = session.get(Project.class, projectId);
//		System.out.println(project.getProjectId() + "+++" + project.getProjectName() + "+++" + project.getTechStack());
		tx.commit();
		session.close();

		req.setAttribute("employeeId", employeeId);
		req.setAttribute("project", project);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProject.jsp");
		requestDispatcher.forward(req, resp);
	}
}
