package com.jdbc.service;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.model.Products;

public interface ProductService {
	void insertProduct(Products pro) throws SQLException,ClassNotFoundException;
	void deleteProduct(Integer id) throws SQLException,ClassNotFoundException;
	void updateProduct(Integer id,Products pro) throws SQLException,ClassNotFoundException;
	Products getProduct(Integer id) throws SQLException,ClassNotFoundException;
	List<Products> getAll() throws SQLException,ClassNotFoundException;
}
