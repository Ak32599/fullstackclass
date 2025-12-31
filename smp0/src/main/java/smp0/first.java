package smp0;
import java.sql.*;
import java.util.*;
public class first {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/own";
		String usr="root";
		String pwd="Ak32599";
		try
		{
		    Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,usr,pwd);
			System.out.println("Connection successful");
			int ch;
			do{
				System.out.println("1.To insert into department");
				System.out.println("2.To insert into employee");
				System.out.println("3.To visit departments");
				System.out.println("2.To visit employees");
				System.out.println("To exit enter : 10");
				System.out.println("Enter your choice=");
				ch=sc.nextInt();
				switch(ch)
				{
				case 1:
					dep(conn);
					break;
				case 2:
					emp(conn);
					break;
				case 3:
					visit(3,conn);
					break;
				case 4:
					visit(4,conn);
					break;
				default:
					System.out.println("Enter the correct option");
					break;
				}
			}while(ch!=10);
					
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Wrong credentials");
		}
	}
	static void crea_dep(Connection con)
	{
		try {
		  String query="Create table if not exists dept("+ "id int primary key,"+" name varchar(20)"+" )";
	      Statement st=con.createStatement();
	      st.execute(query);
	      st.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static void dep(Connection con)
	{
		try {
		crea_dep(con);
		String q1="INSERT INTO dept VALUES (?, ?)";
		PreparedStatement ps=con.prepareStatement(q1);
		System.out.println("Inserting into department table");
		System.out.println("Enter the id");
		ps.setInt(1, sc.nextInt());
		System.out.println("Enter the dept name:");
		ps.setString(2, sc.next());
		System.out.println("Successfully inserted");
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	static void visit(int ch,Connection con)
	{
		if(ch==3)
		{
			try {
			String q1="select * from dept";
			PreparedStatement ps = con.prepareStatement(q1);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
            System.out.println(rs.getInt(1)+"  "+rs.getString(2) + "  ");
        }
		}catch(Exception e)
			{
			e.printStackTrace();
			}
		}
	}
	static void emp(Connection con)
	{
		
	}

}
