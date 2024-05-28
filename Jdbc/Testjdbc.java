package com.training.jdbc;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;

public class Testjdbc {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:9501/xe","system","rps@123");
		System.out.println("success");
		Statement st = con.createStatement();		
		Jdbc2 obj = new Jdbc2();
		
		obj.add(con);
		obj.update(st);
		obj.delete(con);
		obj.show(st);
		con.close();
	}

}
