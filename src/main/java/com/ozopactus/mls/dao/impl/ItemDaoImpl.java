package com.ozopactus.mls.dao.impl;

import com.ozopactus.mls.dao.ItemDao;
import com.ozopactus.mls.model.Item;
import com.ozopactus.mls.util.QueryParams;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Victor
 */
public class ItemDaoImpl implements ItemDao {
    private String url;
    private String login;
    private String password;

    public ItemDaoImpl() {
	super();
        Properties properties = new Properties();
        InputStream inputStream = ItemDaoImpl.class
                                    .getClassLoader()
                                    .getResourceAsStream("db.properties");
	try {
            properties.load(inputStream);
            Class.forName(properties.getProperty("driver"));
            this.login = properties.getProperty("login");
            this.password = properties.getProperty("password");
            this.url = properties.getProperty("url");
	} catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
	}
    }
    
    @Override
    public List<Item> getItems(QueryParams params) {
        List<Item> result = new ArrayList<>();
		
	try(Connection connection = DriverManager.getConnection(this.url, this.login, this.password);
            PreparedStatement statement = connection.prepareStatement(params.getSelectExpression())) {           
            
            statement.setString(1, params.getPart_number());
            statement.setString(2, params.getPart_number());
            statement.setString(3, params.getPart_name());
            statement.setString(4, params.getPart_name());
            statement.setString(5, params.getVendor());
            statement.setString(6, params.getVendor());
            statement.setInt(7, params.getQty());
            statement.setInt(8, params.getQty());            
            statement.setDate(9, params.getReceived_from());
            statement.setDate(10, params.getReceived_from());
            statement.setDate(11, params.getReceived_to());
            statement.setDate(12, params.getReceived_to());
            statement.setDate(13, params.getShipped_from());
            statement.setDate(14, params.getShipped_from());
            statement.setDate(15, params.getShipped_to());
            statement.setDate(16, params.getShipped_to());
                        
            try(ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next()) {
                    Item item = new Item();
                    item.setPart_number(resultSet.getString("part_number"));
                    item.setPart_name(resultSet.getString("part_name"));
                    item.setVendor(resultSet.getString("vendor"));
                    item.setQty(resultSet.getInt("qty"));
                    item.setReceived(resultSet.getDate("received"));
                    item.setShipped(resultSet.getDate("shipped"));
                    result.add(item);
                }
            }
	} catch (SQLException e) {
            e.printStackTrace();
	}		
		
	return result;
    }    
}
