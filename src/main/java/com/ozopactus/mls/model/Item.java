package com.ozopactus.mls.model;

import java.util.Date;

/**
 *
 * @author Victor
 */
public class Item {
    private String part_name;
    private String part_number;
    private String vendor;
    private int qty;
    private Date received;
    private Date shipped;

    public String getPart_name() {
            return part_name;
    }
    public void setPart_name(String part_name) {
            this.part_name = part_name;
    }
    public String getPart_number() {
            return part_number;
    }
    public void setPart_number(String part_number) {
            this.part_number = part_number;
    }
    public String getVendor() {
            return vendor;
    }
    public void setVendor(String vendor) {
            this.vendor = vendor;
    }
    public int getQty() {
            return qty;
    }
    public void setQty(int qty) {
            this.qty = qty;
    }
    public Date getReceived() {
            return received;
    }
    public void setReceived(Date receive) {
            this.received = receive;
    }
    public Date getShipped() {
            return shipped;
    }
    public void setShipped(Date shipped) {
		this.shipped = shipped;
	}

    @Override
    public String toString() {
        return "Item{" + "part_number=" + part_number + ", part_name=" + 
                part_name + ", vendor=" + vendor + ", qty=" + 
                qty + ", received=" + received + ", shipped=" + shipped + '}';
    }
}