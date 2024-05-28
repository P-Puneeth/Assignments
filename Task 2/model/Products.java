package com.jdbc.model;

public class Products {
	Integer pid;
	String pname;
	Integer price;
	public Products(Integer pid, String pname, Integer price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
	
	
	public Products() {
		super();
	}


	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
	
}
