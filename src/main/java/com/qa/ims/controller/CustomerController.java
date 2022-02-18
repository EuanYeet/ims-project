package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = LogManager.getLogger();

	private CustomerDAO customerDAO;

	public CustomerController(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
		
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Customer> readAll() {
		List<Customer> customers = customerDAO.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer);
		}
		return customers;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Customer create() {
		LOGGER.info("Please enter a first name");
		String firstName = Utils.getString();
		LOGGER.info("Please enter a surname");
		String surname = Utils.getString();
		LOGGER.info("Please enter an age");
		Integer age = Utils.getInt();
		LOGGER.info("Please enter a telephone number");
		String telephone = Utils.getString();
		
		Customer customer = customerDAO.create(new Customer(firstName, surname,age,telephone));
		LOGGER.info("User created");
		return customer;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Customer update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		Long id = Utils.getLong();
		LOGGER.info("Please enter a first name");
		String firstName = Utils.getString();
		LOGGER.info("Please enter a surname");
		String surname = Utils.getString();
		LOGGER.info("Please enter an age");
		Integer age = Utils.getInt();
		LOGGER.info("Please enter a telephone number");
		String telephone = Utils.getString();
		
		Customer customer = customerDAO.update(new Customer(id, firstName, surname, age, telephone));
		LOGGER.info("Customer Updated");
		return customer;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Utils.getLong();
		return customerDAO.delete(id);
	}

}
