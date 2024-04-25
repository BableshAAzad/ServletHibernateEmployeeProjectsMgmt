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
import com.helper.SessionProvider;

@WebServlet("/updateEmp")
public class UpdateEmp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		String employeeName = req.getParameter("employeeName");
		String employeeAddress = req.getParameter("employeeAddress");
		int employeeSalary = Integer.parseInt(req.getParameter("employeeSalary"));
//		System.out.println(employeeId + "  " + employeeName + "  " + employeeAddress + "  " + employeeSalary);
		
		Employee emp = new Employee();
		emp.setEmployeeId(employeeId);
		emp.setEmployeeName(employeeName);
		emp.setEmployeeAddress(employeeAddress);
		emp.setSalary(employeeSalary);
		
		Session session = SessionProvider.getSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		session.update(emp);
		
		tx.commit();
		session.close();
		
		String alertScript = "<script>alert('Employee Updated successfully!'); window.location.href='displayAllEmployees';</script>";
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(alertScript);
        out.close();
	}
}
