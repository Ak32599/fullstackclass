package com.klu;
import java.sql.*;
public class JDBCCrud {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/fsads3"; //fsads3 is database name
	    String usr="root";
	    String pwd="Ak32599";
	    try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection(url, usr, pwd);
	    System.out.println(" Database Connection Established");
	    Statement st=con.createStatement();
	    String createDept="Create table if not exists Dept("+ "id int primary key auto_increment, " +"dept_name varchar(20)"+ ")";
	    st.execute(createDept);
	    System.out.println(" Department table created");
//	   st.execute("create table if not exists Emp(id int primary key auto_increment, name varchar(50),sal double,dept_id int foreign key(dept_id) references dept(id) ");
	    st.execute(
	    	    "CREATE TABLE IF NOT EXISTS Emp (" +
	    	    "id INT PRIMARY KEY AUTO_INCREMENT, " +
	    	    "name VARCHAR(50), " +
	    	    "sal DOUBLE, " +
	    	    "dept_id INT, " +
	    	    "FOREIGN KEY (dept_id) REFERENCES Dept(id)" +
	    	    ")"
	    	);
	    System.out.println(" Employee Table Created");
	    st.executeUpdate("insert into Dept values(101,'Ak47')");
	    System.out.println("our 1st record have inserted");
	    st.executeUpdate("insert into emp values(4592101,'Sridevi',999999,101)");
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    }
}