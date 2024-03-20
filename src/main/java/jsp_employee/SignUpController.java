package jsp_employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Employee employee=new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setPhone(phone);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setPassword(password);
		
		EmployeeCrud crud=new EmployeeCrud();
	
		try {
			int count = crud.signUp(employee);
			if (count!=0)
			{
			    //	pw.print("Register Successfully");
				req.setAttribute("message", "singup success plese login");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	}


