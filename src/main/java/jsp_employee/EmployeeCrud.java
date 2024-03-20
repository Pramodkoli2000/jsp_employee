package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmployeeCrud {
	
	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "root");
		return connection;
    }
	
	public int signUp(Employee employee) throws Exception
	{
		
		Connection connection=getConnection();
		PreparedStatement statement=connection.prepareStatement("Insert into employee values(?,?,?,?,?,?)");
		statement.setInt(1, employee.getId());
		statement.setString(2, employee.getName());
		statement.setLong(3, employee.getPhone());
		statement.setString(4, employee.getAddress());
		statement.setString(5, employee.getEmail());
		statement.setString(6, employee.getPassword());
		int set=statement.executeUpdate();
		connection.close();
		return set;
	}
	public String LogIn(String email) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement statement=connection.prepareStatement("Select *  from employee where email=?");
		statement.setString(1, email);
		ResultSet set=statement.executeQuery();
		
		String password=null;
		if (set.next()) {
			
			password=set.getString("password");
			
		}
		connection.close();
		return password;
	}
	
	 public List<Employee> getAllEmployee() throws Exception
	 {
		 Connection connection=getConnection();
		 PreparedStatement statement=connection.prepareStatement("select * from employee");
		 
		 ResultSet set=statement.executeQuery();
		 
		 List<Employee> list=new ArrayList<Employee>();
		 
		 while (set.next()) {
			 
			 Employee employee=new Employee();
			 employee.setId(set.getInt("id"));
			 employee.setName(set.getString("name"));
			 employee.setPhone(set.getLong("phone"));
			 employee.setAddress(set.getString("address"));
			 employee.setEmail(set.getString("email"));
			 employee.setPassword(set.getString("password"));
			
			 list.add(employee);
		}
		 
		 connection.close();
		 return list;
	 }
	 public int deleteEmployee(int id) throws Exception
	 {
		 	Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement("delete from employee where id=?");
			statement.setInt(1, id);
			int set=statement.executeUpdate();
			
			connection.close();
		return set;
		 
	 }
	 public Employee updateEmployee(int id) throws Exception
	 {
		 Connection connection=getConnection();
		 PreparedStatement statement=connection.prepareStatement("select * from employee  where id=?");
		 statement.setInt(1, id);
		 ResultSet set=statement.executeQuery();
		 
		 Employee employee=new Employee();
		 
		 while (set.next()) {
			 
			 employee.setId(set.getInt("id"));
			 employee.setName(set.getString("name"));
			 employee.setPhone(set.getLong("phone"));
			 employee.setAddress(set.getString("address"));
			 employee.setEmail(set.getString("email"));
			 employee.setPassword(set.getString("password"));
			
			 
		}
		 
		 connection.close();
		 return employee;
	 }

	public int update(Employee employee) throws Exception {

		
		 Connection connection=getConnection();
		 
		 	PreparedStatement statement=connection.prepareStatement("update employee set name=?,email=?,phone=?,address=?,password=? where id=?");
			statement.setInt(6, employee.getId());
			statement.setString(1, employee.getName());
			statement.setLong(3, employee.getPhone());
			statement.setString(4, employee.getAddress());
			statement.setString(2, employee.getEmail());
			statement.setString(5, employee.getPassword());
			int set=statement.executeUpdate();
			connection.close();
			
		 return set;
	}

	


}

