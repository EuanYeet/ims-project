package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.ItemOrderDAO;
import com.qa.ims.persistence.domain.ItemOrder;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in Order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private ItemOrderDAO itemOrderDAO;

	public OrderController(OrderDAO orderDAO, ItemOrderDAO itemOrderDAO) {
		super();
		this.orderDAO = orderDAO;
		this.itemOrderDAO = itemOrderDAO;
	}

	/**
	 * Reads all Orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			List<ItemOrder> items = itemOrderDAO.readAll(order.getId());
			order.setItems(items);
			StringBuilder sb = new StringBuilder();
			sb.append("Order ID");
			LOGGER.info(String.format("ID: %s", order.getId()));
		}
		return orders;
	}

	/**
	 * Creates a Order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a user ID");
		Long userId = Utils.getLong();
		LOGGER.info("Please enter an item ID");
		Long itemId = Utils.getLong();
		LOGGER.info("Please enter a Quantity");
		int quantity = Utils.getInt();
		Order order = orderDAO.create(new Order(userId));
		Long orderId = order.getId();
		ItemOrder itemOrder = itemOrderDAO.create(new ItemOrder(orderId, itemId, quantity));
		order.getItems().add(itemOrder);
		LOGGER.info("Order Created");
		return null;

	}

	/**
	 * Updates an existing Order by taking in user input
	 */
	@Override
	public Order update() {
		boolean breaker = false;
		do {
			ItemOrder order = new ItemOrder();
			Long id = 0L;
			
			LOGGER.info("What would you like to update");
			LOGGER.info("ADD: Add an item");
			LOGGER.info("REMOVE: Remove an item");
			LOGGER.info("RETURN: Go back to previous menu");
			String choice = Utils.getString().toUpperCase();
			
			if (!choice.equalsIgnoreCase("RETURN")) {
				LOGGER.info("Please enter the id of the order you would like to edit");
				id = Utils.getLong();

				order = itemOrderDAO.read(id);
			}

			switch (choice) {
			case "ADD":
				LOGGER.info("Please enter an item id");
				Long itemID = Utils.getLong();
				LOGGER.info("Please enter the quantity");
				int quantity = Utils.getInt();
				order = itemOrderDAO.add(new ItemOrder(id, itemID, quantity));
				LOGGER.info("Item Added to Order");
				break;
			case "REMOVE":
				LOGGER.info("Please enter the item id");
				itemID = Utils.getLong();
				order = itemOrderDAO.delete(new ItemOrder(id, itemID));
				LOGGER.info("Item Added to Order");
				break;
			case "RETURN":
				breaker = true;
				break;
			default:
				break;
			}
		} while (!breaker);
		return null;

	}

	/**
	 * Deletes an existing Order by the id of the Order
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Order you would like to delete");
		Long id = Utils.getLong();
		return orderDAO.delete(id);
	}

}
