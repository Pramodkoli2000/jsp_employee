package jsp_employee;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/update")
public class UpdateController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmployeeCrud crud=new EmployeeCrud();
		
		try {
			Employee employee=crud.updateEmployee(id);
			
			//to used HttpSession
			
			HttpSession session=req.getSession();
			System.out.println(session);
			
			String sid=(String) session.getAttribute("hs");
			if (sid!=null) {
				
				if (employee!=null) {
					
					req.setAttribute("emp", employee);
					req.getRequestDispatcher("edit.jsp").forward(req, resp);
					
				}
				
			}else {
				req.setAttribute("message", "plz login frist to used application");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
