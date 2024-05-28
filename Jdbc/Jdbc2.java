package com.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc2 {
	Scanner sc = new Scanner(System.in);
	
	public void add(Connection con) throws SQLException {
		PreparedStatement pst = con.prepareStatement("insert into products values(?,?,?)");
		int pid = sc.nextInt();  sc.nextLine();
		String pname = sc.nextLine();
		int price = sc.nextInt();
		pst.setInt(1, pid);
		pst.setString(2, pname);
		pst.setInt(3, price);
		pst.execute();
		System.out.println("inserted...");
	}
	
	public void update(Statement st) throws SQLException {
		st.executeUpdate("update products set price=2000 where id=3 ");
		System.out.println("updated...");
	}
	
	public void delete(Connection con) throws SQLException {
		System.out.println("Select product pid");
		PreparedStatement pst = con.prepareStatement("delete products where pid=?");
		int pid = sc.nextInt(); sc.nextLine();
		pst.setInt(1, pid);
		pst.execute();
		System.out.println("deleted...");
	}
	
	public void show(Statement st) throws SQLException {
		System.out.println("Products List");
		ResultSet rs = st.executeQuery("select * from products");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
	}
}
