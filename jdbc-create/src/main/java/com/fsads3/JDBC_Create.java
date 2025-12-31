

package com.fsads3;
import java.sql.*;

public class JDBC_Create {

  public static void main(String[] args) {
    String url="jdbc:mysql://localhost:3306/fsads3";
    String usr="root";
    String pwd="Ak32599";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=DriverManager.getConnection(url,usr,pwd);
      System.out.println("Connection Established");
      String query="Create table if not exists student("+ "id int primary key,"+" name varchar(20)"+" )";
      Statement st=con.createStatement();
      st.execute(query);
      st.close();
      con.close();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }

}