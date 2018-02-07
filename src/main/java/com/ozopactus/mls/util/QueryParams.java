package com.ozopactus.mls.util;

import java.sql.Date;

/**
 *
 * @author Victor
 */
public class QueryParams {
    private String sortOrder;
    private String part_number;
    private String part_name;
    private String vendor;
    private int qty;
    private Date shipped_from;
    private Date shipped_to;
    private Date received_from;
    private Date received_to;

    // <editor-fold defaultstate="collapsed" desc="Getters/setters">
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getShipped_from() {
        return shipped_from;
    }

    public void setShipped_from(Date shipped_from) {
        this.shipped_from = shipped_from;
    }

    public Date getShipped_to() {
        return shipped_to;
    }

    public void setShipped_to(Date shipped_to) {
        this.shipped_to = shipped_to;
    }

    public Date getReceived_from() {
        return received_from;
    }

    public void setReceived_from(Date received_from) {
        this.received_from = received_from;
    }

    public Date getReceived_to() {
        return received_to;
    }

    public void setReceived_to(Date received_to) {
        this.received_to = received_to;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getPart_number() {
        return part_number;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_number(String part_number) {
        this.part_number = part_number;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }// </editor-fold>
    
    public String getSelectExpression() {
        StringBuilder builder = new StringBuilder();
        builder.append(" select * from itemlist ");
        builder.append(" where (? is null or upper(part_number) like '%'||upper(?)||'%') ");
        builder.append(" and (? is null or upper(part_name) like '%'||upper(?)||'%') ");
        builder.append(" and (? is null or upper(vendor) like '%'||upper(?)||'%') ");
        builder.append(" and (? is null or qty >= ?) ");
        builder.append(" and (cast(? as Date) is null or received >= ?) ");
        builder.append(" and (cast(? as Date) is null or received <= ?) ");
        builder.append(" and (cast(? as Date) is null or shipped >= ?) ");
        builder.append(" and (cast(? as Date) is null or shipped <= ?) ");
        builder.append(getOrderByClause());
        return builder.toString();
    }
    
    public String getOrderByClause() {
        String result;
        if (sortOrder == null || "".equals(sortOrder))
            result = "";
        else
            result = " order by " + sortOrder;
        return  result;
    }
}
