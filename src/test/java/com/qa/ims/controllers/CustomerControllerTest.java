package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	public static final Logger LOGGER = LogManager.getLogger();

	@Mock
	private Utils utils;

	@Mock
	private CustomerDAO dao;

	@InjectMocks
	private CustomerController controller;

	@Before
	public void Before() {
		this.controller = new CustomerController(dao);
	}

	@Test
	public void testCreate() {
		String F_NAME = "barry", L_NAME = "scott", T_PHONE = "07288765432";
		int AGE = 45;
		Customer created = new Customer(F_NAME, L_NAME, AGE, T_PHONE);
		try (MockedStatic<Utils> util = Mockito.mockStatic(Utils.class)) {

			util.when(Utils::getString).thenReturn(F_NAME, L_NAME, T_PHONE);
			util.when(Utils::getInt).thenReturn(AGE);
			Mockito.when(dao.create(created)).thenReturn(created);

			Customer cust = this.controller.create();

			assertEquals(cust.getFirstName(), "barry");
			assertEquals(cust.getSurname(), "scott");
			assertEquals(cust.getAge(), 45);
			assertEquals(cust.getTelephone(), "07288765432");
		}
	}

	@Test
	public void testReadAll() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1L, "jordan", "harrison", 25, "07288765432"));

		Mockito.when(dao.readAll()).thenReturn(customers);

		assertEquals(customers, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Customer updated = new Customer(1L, "chris", "perrins", 38, "07564321749");

		try (MockedStatic<Utils> util = Mockito.mockStatic(Utils.class)) {

			util.when(Utils::getLong).thenReturn(1L);
			util.when(Utils::getString).thenReturn(updated.getFirstName(), updated.getSurname(),
					updated.getTelephone());
			util.when(Utils::getInt).thenReturn(updated.getAge());
			Mockito.when(dao.update(updated)).thenReturn(updated);

			Customer cust = this.controller.update();

			assertEquals(cust.getId(), updated.getId());
			assertEquals(cust.getFirstName(), updated.getFirstName());
			assertEquals(cust.getSurname(), updated.getSurname());
			assertEquals(cust.getAge(), updated.getAge());
			assertEquals(cust.getTelephone(), updated.getTelephone());
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
