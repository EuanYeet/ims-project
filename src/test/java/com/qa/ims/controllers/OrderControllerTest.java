package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.ItemOrderDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.ItemOrder;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	public static final Logger LOGGER = LogManager.getLogger();

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO orderDao;

	@Mock
	private ItemOrderDAO iOrderDao;

	@Mock
	private ItemDAO itemDao;

	@InjectMocks
	private OrderController controller;

	@Before
	public void Before() {
		this.controller = new OrderController(orderDao, iOrderDao, itemDao);
	}

	@Test
	public void testCreate() {
		Order created = new Order(1L);
		created.setId(1L);
		ItemOrder itemOrderCreated = new ItemOrder(1L, 4L, 10);
		itemOrderCreated.setOrderId(1L);

		try (MockedStatic<Utils> util = Mockito.mockStatic(Utils.class)) {

			util.when(Utils::getLong).thenReturn(1L, 4L);
			util.when(Utils::getInt).thenReturn(10);
			Mockito.when(iOrderDao.create(itemOrderCreated)).thenReturn(itemOrderCreated);
			Mockito.when(orderDao.create(new Order(1L))).thenReturn(created);

			Order order = this.controller.create();

			assertEquals(created.getUserID(), order.getUserID());
			assertEquals(itemOrderCreated.getOrderId(), order.getId());
			ItemOrder itemorder = order.getItems().get(0);
			assertEquals(itemOrderCreated.getOrderId(), itemorder.getOrderId());
			assertEquals(itemOrderCreated.getItemID(), itemorder.getItemID());
			assertEquals(itemOrderCreated.getQuantity(), itemorder.getQuantity());
		}
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		List<ItemOrder> itemorders = new ArrayList<>();
		itemorders.add(new ItemOrder(4L, 10L, 10));
		
		Order orderWithID = new Order(1L, 5L);
		orderWithID.setId(1L);
		orders.add(orderWithID);
		
		orders.add(new Order(4L, 1L));
		orders.add(new Order(7L, 3L));
		Mockito.when(itemDao.read(10L)).thenReturn(new Item(10L, "greg", "guy", 10, 5.50));
		Mockito.when(iOrderDao.readAll(1L)).thenReturn(itemorders);
		Mockito.when(orderDao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());
		

		Mockito.verify(orderDao, Mockito.times(1)).readAll();

	}

	@Test
	public void testUpdateAdd() {
		ItemOrder itemorder = new ItemOrder();
		itemorder.setOrderId(1L);
		itemorder.setItemID(1L);
		itemorder.setQuantity(10);
		Order order = new Order(1L,1L);
		

		try (MockedStatic<Utils> util = Mockito.mockStatic(Utils.class)) {
			
			util.when(Utils::getString).thenReturn("ADD","RETURN");
			util.when(Utils::getLong).thenReturn(1L);
			util.when(Utils::getInt).thenReturn(10);
			Mockito.when(orderDao.read(1L)).thenReturn(order);
			Mockito.when(iOrderDao.add(itemorder)).thenReturn(itemorder);
			
			this.controller.update();
			
			Mockito.verify(iOrderDao, Mockito.times(1)).add(itemorder);
		}
	}
	
	@Test
	public void testUpdateRemove() {
		ItemOrder itemorder = new ItemOrder();
		itemorder.setOrderId(1L);
		itemorder.setItemID(1L);
		Order order = new Order(1L,1L);
		

		try (MockedStatic<Utils> util = Mockito.mockStatic(Utils.class)) {
			
			util.when(Utils::getString).thenReturn("REMOVE","RETURN");
			util.when(Utils::getLong).thenReturn(1L);
			Mockito.when(orderDao.read(1L)).thenReturn(order);
			Mockito.when(iOrderDao.delete(itemorder)).thenReturn(itemorder);
			
			this.controller.update();
			
			Mockito.verify(iOrderDao, Mockito.times(1)).delete(itemorder);
		}
	}

	@Test
	public void testDelete() {
		final long ID = 1L;
		try (MockedStatic<Utils> util = Mockito.mockStatic(Utils.class)) {

			util.when(Utils::getLong).thenReturn(ID);
			Mockito.when(orderDao.delete(ID)).thenReturn(1);

			assertEquals(1L, this.controller.delete());

			int id = this.controller.delete();

			assertEquals(id, ID);
		}
	}

}
