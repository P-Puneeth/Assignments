package com.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.Products;
import com.jdbc.util.Dbcon;

public class ProductServiceImp implements ProductService {

	@Override
	public void insertProduct(Products pro) throws SQLException, ClassNotFoundException {
		PreparedStatement pst = Dbcon.connect().prepareStatement("insert into products values(?,?,?)");
		pst.setInt(1, pro.getPid());
		pst.setString(2, pro.getPname());
		pst.setInt(3, pro.getPrice());
		pst.execute();
		System.out.println("inserted...");
	}

	@Override
	public void deleteProduct(Integer id) throws SQLException, ClassNotFoundException {
		PreparedStatement pst = Dbcon.connect().prepareStatement("delete products where pid=?");
		pst.setInt(1, id);
		pst.execute();
		System.out.println("deleted...");
	}

	@Override
	public void updateProduct(Integer id, Products pro) throws SQLException, ClassNotFoundException {
		Connection con= Dbcon.connect();
		con.setAutoCommit(false);
		PreparedStatement pst = con.prepareStatement("update products set pname=?,price=? where pid=?");
		try {
		pst.setInt(3,id);
		pst.setString(1, pro.getPname());
		pst.setInt(2, pro.getPrice());
		pst.execute();
		}catch(Exception e) {
			con.rollback();
		}
		con.commit();
		System.out.println("updated...");
	}

	@Override
	public Products getProduct(Integer id) throws SQLException, ClassNotFoundException {
		PreparedStatement pst = Dbcon.connect().prepareStatement("select * from products where pid=?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Products p = new Products();
		
		while(rs.next()) {
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getInt(3));
		}
		return p;
	}

	@Override
	public List<Products> getAll() throws SQLException, ClassNotFoundException {
		List<Products> plist = new ArrayList<>();
		Statement st = Dbcon.connect().createStatement();
		ResultSet rs = st.executeQuery("select * from Products");
		while(rs.next()) {
			Products p = new Products();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getInt(3));
			plist.add(p);
		}
		return plist;
	}

}
