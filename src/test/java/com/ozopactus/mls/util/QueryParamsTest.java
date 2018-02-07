package com.ozopactus.mls.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Victor
 */
public class QueryParamsTest {
    @Test
    public void testGetSortByClause() {
        QueryParams qp = new QueryParams();
        
        qp.setSortOrder("");
        assertEquals("", qp.getOrderByClause());
        
        qp.setSortOrder(null);
        assertEquals("", qp.getOrderByClause());
        
        qp.setSortOrder("some_column desc");
        assertEquals(" order by some_column desc", qp.getOrderByClause());
    }
}
