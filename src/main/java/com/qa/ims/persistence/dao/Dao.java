package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import com.qa.ims.persistence.domain.ItemOrder;


public interface Dao<T> {

	List<T> readAll();
	
	T read(Long id);

	T create(T t);

	T update(T t);

	
	// OrderDAO
	int delete(long id);
	
	// itemOrder
	ItemOrder delete(T order);
	List<T> readAll(Long id);

	T modelFromResultSet(ResultSet resultSet) throws SQLException;

}
