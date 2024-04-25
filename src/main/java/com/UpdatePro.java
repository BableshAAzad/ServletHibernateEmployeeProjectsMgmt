package com;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/updateProj")
public class UpdatePro extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		
		int projectId = Integer.parseInt(req.getParameter("projectId"));
		String projectName = req.getParameter("projectName");
		String techStack = req.getParameter("techStack");
		
		
		Session session = SessionProvider.getSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Project project = session.get(Project.class, projectId);
		project.setProjectName(projectName);
		project.setTechStack(techStack);
		
		session.update(project);
		
		tx.commit();
		session.close();
		
		String alertScript = "<script>alert('Project Updated successfully!'); window.location.href='displayAllProjects?employeeId="
				+employeeId+"';</script>";
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(alertScript);
        out.close();
	}
}
