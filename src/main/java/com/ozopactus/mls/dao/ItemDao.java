package com.ozopactus.mls.dao;

import java.util.List;
import com.ozopactus.mls.model.Item;
import com.ozopactus.mls.util.QueryParams;

/**
 *
 * @author Victor
 */
public interface ItemDao {
    List<Item> getItems(QueryParams params);
}
