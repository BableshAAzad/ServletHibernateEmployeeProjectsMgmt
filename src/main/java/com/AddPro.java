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

@WebServlet("/addProj")
public class AddPro extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		
		int projectId = Integer.parseInt(req.getParameter("projectId"));
		String projectName = req.getParameter("projectName");
		String techStack = req.getParameter("techStack");
		
		Project pro = new Project();
		pro.setProjectId(projectId);
		pro.setProjectName(projectName);
		pro.setTechStack(techStack);
		
		Session session = SessionProvider.getSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Employee employee = session.get(Employee.class, employeeId);
		pro.setEmployee(employee);
		
		employee.getProjects().add(pro);
		session.persist(employee);
		session.save(pro);
		
		tx.commit();
		session.close();
		
		String alertScript = "<script>alert('Project added successfully!'); window.location.href='displayAllProjects?employeeId="
				+employeeId+"';</script>";
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(alertScript);
        out.close();
	}
}
