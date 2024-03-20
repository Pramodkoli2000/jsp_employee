package jsp_employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		// TODO Auto-generated method stub
			//	PrintWriter pw=resp.getWriter();
				String email=req.getParameter("email");
				String password=req.getParameter("password");
				
				Employee employee=new Employee();
				employee.setEmail(email);
				
				EmployeeCrud crud=new EmployeeCrud();
			
				try {
					
					String dbPassword=crud.LogIn(email);
					if(dbPassword!=null)
					{
						if(password.equals(dbPassword))
						{
							//req.setAttribute("emp's", crud.getAllEmployee());
							
							
							//Create Cookie
							Cookie cookie=new Cookie("session", email);
							resp.addCookie(cookie);
							
							//To create HttpsServlet
							
							HttpSession session=req.getSession();
							System.out.println(session);
							session.setAttribute("hs","8552865558");
							
							List<Employee> employees=crud.getAllEmployee();
							req.setAttribute("list", employees);
							req.getRequestDispatcher("success.jsp").forward(req, resp);
						
							
						}
						else
						{
							req.setAttribute("message", "invalid password");
							req.getRequestDispatcher("login.jsp").forward(req, resp);
							
							
						}
					}
					else
					{
						req.setAttribute("message", "user not register");
						req.getRequestDispatcher("signup.jsp").forward(req, resp);

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
}
