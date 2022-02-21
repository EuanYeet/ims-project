package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

/**
 * Takes in Item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;

	public ItemController(ItemDAO itemDAO) {
		super();
		this.itemDAO = itemDAO;
		
	}

	/**
	 * Reads all Items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	/**
	 * Creates a Item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter a product name");
		String prodname = Utils.getString();
		LOGGER.info("Please enter a description");
		String desc = Utils.getString();
		LOGGER.info("Please enter the stock");
		Integer stock = Utils.getInt();
		LOGGER.info("Please enter the price");
		Double price = Utils.getDouble();
		
		Item item = itemDAO.create(new Item(prodname, desc, stock, price));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing Item by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the Item you would like to update");
		Long id = Utils.getLong();
		LOGGER.info("Please enter a name");
		String prodname = Utils.getString();
		LOGGER.info("Please enter a description");
		String desc = Utils.getString();
		LOGGER.info("Please enter the stock");
		Integer stock = Utils.getInt();
		LOGGER.info("Please enter the price");
		Double price = Utils.getDouble();
		
		Item item = itemDAO.update(new Item(id, prodname, desc, stock, price));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing Item by the id of the Item
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Item you would like to delete");
		Long id = Utils.getLong();
		return itemDAO.delete(id);
	}

}
