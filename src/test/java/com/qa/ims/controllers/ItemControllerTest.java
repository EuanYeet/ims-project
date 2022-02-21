package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController controller;
	
	@Before
	public void Before() {
		this.controller = new ItemController(dao);
	}

	@Test
	public void testCreate() {
		String NAME = "barry", DESC = "scott";
		int STOCK = 20;
		double PRICE = 5.50;
		Item created = new Item(NAME, DESC, STOCK, PRICE);
		try (MockedStatic<Utils> util = Mockito.mockStatic(Utils.class)) {

			util.when(Utils::getString).thenReturn(NAME, DESC);
			util.when(Utils::getInt).thenReturn(STOCK);
			util.when(Utils::getDouble).thenReturn(PRICE);
			Mockito.when(dao.create(created)).thenReturn(created);

			Item item = this.controller.create();

			assertEquals(item.getName(), created.getName());
			assertEquals(item.getDesc(), created.getDesc());
			assertEquals(item.getStock(), created.getStock());
			assertEquals(item.getPrice(), created.getPrice());
		}
	}

	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "jordan", "harrison", 25, 5.50));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Item updated = new Item(1L, "chris", "perrins", 38, 5.50);

		try (MockedStatic<Utils> util = Mockito.mockStatic(Utils.class)) {

			util.when(Utils::getLong).thenReturn(1L);
			util.when(Utils::getString).thenReturn(updated.getName(), updated.getDesc());
			util.when(Utils::getInt).thenReturn(updated.getStock());
			util.when(Utils::getDouble).thenReturn(updated.getPrice());
			Mockito.when(dao.update(updated)).thenReturn(updated);

			Item item = this.controller.update();

			assertEquals(item.getId(), updated.getId());
			assertEquals(item.getName(), updated.getName());
			assertEquals(item.getDesc(), updated.getDesc());
			assertEquals(item.getStock(), updated.getStock());
			assertEquals(item.getPrice(), updated.getPrice());
		}
	}

	@Test
	public void testDelete() {
		final long ID = 1L;
		try (MockedStatic<Utils> util = Mockito.mockStatic(Utils.class)) {

			util.when(Utils::getLong).thenReturn(ID);
			Mockito.when(dao.delete(ID)).thenReturn(1);

			assertEquals(1L, this.controller.delete());
			
			int id = this.controller.delete();

			assertEquals(id, ID);
		}
	}

}
