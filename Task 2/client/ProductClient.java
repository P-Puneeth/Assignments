package com.jdbc.client;

import java.sql.SQLException;

import com.jdbc.model.Products;
import com.jdbc.service.ProductServiceImp;

public class ProductClient {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ProductServiceImp ps = new ProductServiceImp();
		Products pp = new Products();
//		ps.insertProduct(new Products(1,"milk",200));
//		ps.insertProduct(new Products(2,"oranges",300));
//		ps.insertProduct(new Products(3,"apples",50));
		
//		ps.updateProduct(2,pp);
		
//		ps.deleteProduct(3);
		
//		System.out.println(ps.getProduct(1));
		
		ps.getAll().stream().forEach(p->System.out.println(p));
		

		
		}

}
