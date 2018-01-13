package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

	String driver;
	String server,dbname,url,user,password;
	Connection con;
	Statement stmtl;
	ResultSet rs;
	
		public MySQL() {
		this.driver = "org.gjt.mm.mysql.Driver";
		this.server = "ms000.sist.ac.jp";
		this.dbname = "java2017";
		this.url = "jdbc:mysql://"+server+"/"+dbname+"?userUnicode=true&characterEncoding=UTF-8";
		this.user = "java2017";
		this.password = "java2017";
		
		try {
		this.con = DriverManager.getConnection(url,user,password);
		this.stmtl = con.createStatement();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
		Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
		
	

public void close() {
	try {
		rs.close();
		stmtl.close();
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
}

public ResultSet selectAll() {
	
	String sql="SELECT*FROM`50616039`";
	ResultSet rs=null;
	try {
	rs=stmtl.executeQuery(sql);
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return rs;
}
}



