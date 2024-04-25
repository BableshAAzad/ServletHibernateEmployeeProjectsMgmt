package com;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/displayAllProjects")
public class DisplayAllProjectsC extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int employeeId = Integer.parseInt(req.getParameter("employeeId"));
       
       Session session = SessionProvider.getSession();
       Transaction tx = session.getTransaction();
       tx.begin();
       
       Employee employee = session.get(Employee.class, employeeId);
       List<Project> projects = employee.getProjects();
       
       System.out.println(employeeId);
       System.out.println(projects);
//       System.out.println(employee);
//       for(Project p : projects) {
//    	   System.out.println(p.getProjectId() +"--"+p.getProjectName()+"--"+p.getTechStack());
//       }
       
       tx.commit();
       session.close();
       
       req.setAttribute("projects", projects);
       req.setAttribute("employeeId", employeeId);
       RequestDispatcher requestDispatcher = req.getRequestDispatcher("displayAllProjects.jsp");
	   requestDispatcher.forward(req, resp);
	}
}
