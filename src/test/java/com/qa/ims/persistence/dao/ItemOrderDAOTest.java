package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.ItemOrder;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class ItemOrderDAOTest {
	
	private final ItemOrderDAO DAO = new ItemOrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/IMS-Project-Test-Order.sql", "src/test/resources/sql-data-Order.sql");
	}

	@Test
	public void testCreate() {
		
		final ItemOrder created = new ItemOrder(2L,1L,1);
		assertEquals(null, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<ItemOrder> expected = new ArrayList<>();
		expected.add(new ItemOrder(1L,1L,1));
		assertEquals(expected, DAO.readAll(1L));
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(null, DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final ItemOrder updated = null;
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(1));
	}
	
	@Test
	public void testAdd() {
		final ItemOrder expect = new ItemOrder(1L,2L,1);
		List<ItemOrder> expected = new ArrayList<ItemOrder>();
		expected.add(new ItemOrder(1L,2L,1));
		assertEquals(null, DAO.add(expect));
	}
	
	@Test
	public void testDeleteOrder() {
		ItemOrder expected = new ItemOrder(1L,1L);
		assertEquals(null, DAO.delete(expected));
	}

}
