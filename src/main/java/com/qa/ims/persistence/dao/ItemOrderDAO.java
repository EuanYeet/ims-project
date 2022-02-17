package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.ItemOrder;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class ItemOrderDAO implements Dao<ItemOrder> {
	
	private static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<ItemOrder> readAll(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM itemorder WHERE fk_order_id = ?");) {
			statement.setLong(1, orderId);
			try (ResultSet resultSet = statement.executeQuery();) {
				List<ItemOrder> ItemOrders = new ArrayList<>();
				while (resultSet.next()) {
					ItemOrders.add(modelFromResultSet(resultSet));
				}
				return ItemOrders;
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public ItemOrder read(Long id) {
		return null;
		
	}
	

	@Override
	public ItemOrder delete(ItemOrder order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM itemorder WHERE fk_order_id = ? AND fk_item_id = ?");) {
			statement.setLong(1, order.getOrderId());
			statement.setLong(2, order.getItemID());
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public ItemOrder modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("fk_order_id");
		Long itemID = resultSet.getLong("fk_item_id");
		int quantity = resultSet.getInt("quantity");
		return new ItemOrder(id, itemID, quantity);
	}

	@Override
	public ItemOrder create(ItemOrder order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO itemorder (fk_order_id, fk_item_id, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, order.getOrderId());
			statement.setLong(2, order.getItemID());
			statement.setInt(3, order.getQuantity());
			statement.executeUpdate();
			return read(order.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public ItemOrder add(ItemOrder order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO itemorder (fk_order_id, fk_item_id, quantity) VALUES ((SELECT id FROM orders WHERE id = ?), (SELECT id FROM item WHERE id = ?),?);");) {
			statement.setLong(1, order.getOrderId());
			statement.setLong(2, order.getItemID());
			statement.setInt(3, order.getQuantity());
			statement.executeUpdate();
			return read(order.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public ItemOrder update(ItemOrder t) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	// Unused Versions of Generic without the parameters I need

	@Override
	public List<ItemOrder> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
