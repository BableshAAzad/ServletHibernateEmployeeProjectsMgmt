package com;

import java.io.IOException;
import java.util.ArrayList;
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
import com.helper.SessionProvider;

@WebServlet("/displayAllEmployees")
public class DisplayAllEmployeeC extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session session = SessionProvider.getSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
//        NativeQuery<Employee> nativeQuery = session.createNativeQuery("select * from employee");
//        List<Employee> list = nativeQuery.list()
		org.hibernate.query.Query<Employee> query = session.createQuery("from Employee");
        List<Employee> list = query.list();
//        for(Employee e : list) {
//        	System.out.println(e.getEmployeeName());
//        }
//		List<Employee> list = new ArrayList<>();
//		list.add(new Employee(101, "Bablesh", "Raipur", 5, null));
		
		tx.commit();
		session.close();
		
		req.setAttribute("list", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("displayAllEmployees.jsp");
		requestDispatcher.forward(req, resp);
	}
}
