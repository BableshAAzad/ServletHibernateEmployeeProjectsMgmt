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
import com.helper.SessionProvider;

@WebServlet("/updateEmployee")
public class UpdateEmployeeC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int employeeId = Integer.parseInt(req.getParameter("employeeId"));
    	
    	Session session = SessionProvider.getSession();
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	Employee employee = session.get(Employee.class, employeeId);
        tx.commit();
    	session.close();
    	
    	req.setAttribute("employee", employee);
    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateEmployee.jsp");
 	   requestDispatcher.forward(req, resp);
    }
}
