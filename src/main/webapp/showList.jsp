<%-- 
    Document   : showList
    Created on : 05.02.2018, 3:07:28
    Author     : Victor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ozopactus.mls.model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="css/table.css" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <link rel="stylesheet" href="js/jquery-ui-1.12.1.custom/jquery-ui.css">
    <script src="js/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
    <script src="js/jquery-ui-1.12.1.custom/jquery-ui.js"></script>    
    <script type="text/javascript">
        $(function(){
            $("#received_from, #received_to, #shipped_from, #shipped_to")
                    .datepicker({dateFormat: 'M dd, yy', altFormat: "yy-mm-dd"});
            $( "#received_from" ).datepicker( "option", "altField", "#altreceived_from" );
            $( "#received_to" ).datepicker( "option", "altField", "#altreceived_to" );
            $( "#shipped_from" ).datepicker( "option", "altField", "#altshipped_from" );
            $( "#shipped_to" ).datepicker( "option", "altField", "#altshipped_to" );
        });
    </script>
    <style type="text/css">
	th a {text-decoration: none;}
    </style>
    <title>Items list</title>
  </head>
  <body> 
    <h1>List of items</h1>
    <form method="POST" action="showList">
      <table border="1" width="100%">
        <tr><th colspan="2" >Filter</th></tr>
        <tr><td><label for="part_number">Part Number</label></td>
            <td><input id="part_number" type="text" name="part_number" value="${part_number}"/></td></tr>
        <tr><td><label for="part_name">Part Name</label></td>
            <td><input id="part_name" type="text" name="part_name" value="${part_name}"/></td></tr>
        <tr><td><label for="vendor">Vendor</label></td>
            <td><input id="vendor" type="text" name="vendor" value="${vendor}"/></td></tr>
        <tr><td><label for="qty">Qty</label></td>
            <td><input id="qty" type="number" name="qty" value="${qty}"/></td></tr>
        <tr><td><label for="shipped_from">Shipped</label></td>
            <td>after <input id="shipped_from" type="text" name="shipped_from" value="${shipped_from}"/>
                <input type="text" id="altshipped_from" name="altshipped_from" hidden="true"/>
                before <input id="shipped_to" type="text" name="shipped_to" value="${shipped_to}"/>
                <input type="text" id="altshipped_to" name="altshipped_to" hidden="true"/>
            </td></tr>
        <tr><td><label for="received_from">Received</label></td>
            <td>after <input id="received_from" type="text" name="received_from" value="${received_from}"/>
                <input type="text" id="altreceived_from" name="altreceived_from" hidden="true"/>
                before <input id="received_to" type="text" name="received_to" value="${received_to}"/>
                <input type="text" id="altreceived_to" name="altreceived_to" hidden="true"/>
            </td></tr>
      </table>
      <div align="center"><input type="submit" value="Filter"/></div>
    </form>
    
    <table cellpadding="0" cellspacing="0">
        <tr>
            <th>
                <a href="?orderByColumn=part_number">
                    <c:if test="${sortOrder=='part_number desc'}">↑&nbsp;</c:if>
                    <c:if test="${sortOrder=='part_number asc'}">↓&nbsp;</c:if>
                    part_number
                </a>
            </th>
            <th>
                <a href="?orderByColumn=part_name">
                    <c:if test="${sortOrder=='part_name desc'}">↑&nbsp;</c:if>
                    <c:if test="${sortOrder=='part_name asc'}">↓&nbsp;</c:if>
                    part_name
                </a>
            </th>
            <th>
                <a href="?orderByColumn=vendor">
                    <c:if test="${sortOrder=='vendor desc'}">↑&nbsp;</c:if>
                    <c:if test="${sortOrder=='vendor asc'}">↓&nbsp;</c:if>
                    vendor
                </a>
            </th>
            <th>
                <a href="?orderByColumn=qty">
                    <c:if test="${sortOrder=='qty desc'}">↑&nbsp;</c:if>
                    <c:if test="${sortOrder=='qty asc'}">↓&nbsp;</c:if>
                    qty
                </a>
            </th>
            <th>
                <a href="?orderByColumn=shipped">
                    <c:if test="${sortOrder=='shipped desc'}">↑&nbsp;</c:if>
                    <c:if test="${sortOrder=='shipped asc'}">↓&nbsp;</c:if>
                    shipped
                </a>
            </th>
            <th>
                <a href="?orderByColumn=received">
                    <c:if test="${sortOrder=='received desc'}">↑&nbsp;</c:if>
                    <c:if test="${sortOrder=='received asc'}">↓&nbsp;</c:if>
                    received
                </a>
            </th>
        </tr>
    <%
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        List<Item> items = (List<Item>)request.getAttribute("items");
        for (Item i : items) {
    %>
        <tr>
            <td><%= i.getPart_number()%></td>
            <td><%= i.getPart_name()%></td>
            <td><%= i.getVendor()%></td>
            <td><%= i.getQty()%></td>
            <td><%= formatter.format(i.getShipped())%></td>
            <td><%= formatter.format(i.getReceived())%></td>
        </tr>
    <% } %>
    </table>

  </body>
</html>
