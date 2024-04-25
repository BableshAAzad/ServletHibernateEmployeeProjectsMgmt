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

@WebServlet("/deleteEmployee")
public class DeleteEmployeeC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		
		Session session = SessionProvider.getSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Employee employee = session.get(Employee.class, employeeId);
		System.out.println(employee.getEmployeeName());
		List<Project> projects = employee.getProjects();
		session.delete(employee);
		if(projects.size() != 0) {
			session.delete(projects);
		}
		
		tx.commit();
		session.close();
		
		String alertScript = "<script>alert('Employee Deleted successfully!'); window.location.href='displayAllEmployees';</script>";
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(alertScript);
        out.close();
    }
}
