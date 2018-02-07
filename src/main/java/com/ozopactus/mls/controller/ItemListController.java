package com.ozopactus.mls.controller;

import com.ozopactus.mls.dao.ItemDao;
import com.ozopactus.mls.dao.impl.ItemDaoImpl;
import com.ozopactus.mls.model.Item;
import com.ozopactus.mls.util.QueryParams;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.function.Predicate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Victor
 */
public class ItemListController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Predicate<String> isDefined = p -> p != null && !p.isEmpty();
        ItemDao itemDao = new ItemDaoImpl();
        QueryParams qp = new QueryParams();
        HttpSession session = request.getSession();                       
        
        String session_column = (String)session.getAttribute("orderByColumn");
        String param_column = request.getParameter("orderByColumn");
        if (param_column != null && param_column.equals(session_column)) {
            qp.setSortOrder(param_column + " desc");
            session.setAttribute("orderByColumn", null);
            session.setAttribute("sortOrder", param_column + " desc");
        }
        else if (param_column != null) {
            qp.setSortOrder(param_column + " asc");
            session.setAttribute("orderByColumn", param_column);
            session.setAttribute("sortOrder", param_column + " asc");
        }
        else {
            qp.setSortOrder(null);
            session.setAttribute("orderByColumn", null);
            session.setAttribute("sortOrder", null);
        }
        
        String param_part_number = request.getParameter("part_number");
        String session_part_number = (String)session.getAttribute("part_number");
        if (isDefined.test(param_column) && isDefined.test(session_part_number))
            qp.setPart_number(session_part_number);
        else {
            qp.setPart_number(param_part_number);
            session.setAttribute("part_number", param_part_number);
        }
        
        String param_part_name = request.getParameter("part_name");
        String session_part_name = (String)session.getAttribute("part_name");
        if (isDefined.test(param_column) && isDefined.test(session_part_name))
            qp.setPart_name(session_part_name);
        else {
            qp.setPart_name(param_part_name);
            session.setAttribute("part_name", param_part_name);        
        }
        
        String param_vendor = request.getParameter("vendor");
        String session_vendor = (String)session.getAttribute("vendor");
        if (isDefined.test(param_column) && isDefined.test(session_vendor))
            qp.setVendor(session_vendor);
        else {
            qp.setVendor(param_vendor);
            session.setAttribute("vendor", param_vendor);
        }
        
        String param_qty = request.getParameter("qty");
        String session_qty = (String)session.getAttribute("qty");
        if (isDefined.test(param_qty)) {
            qp.setQty(Integer.parseInt(param_qty));
            session.setAttribute("qty", param_qty);
        }
        else if (isDefined.test(param_column) && isDefined.test(session_qty))
            qp.setQty(Integer.parseInt(session_qty));
        else
            session.setAttribute("qty", param_qty);        
        
        String param_shipped_from = request.getParameter("shipped_from");
        String param_altshipped_from = request.getParameter("altshipped_from");
        String session_altshipped_from = (String)session.getAttribute("altshipped_from");
        if (isDefined.test(param_shipped_from)) {
            qp.setShipped_from(Date.valueOf(param_altshipped_from));
            session.setAttribute("shipped_from", param_shipped_from);
            session.setAttribute("altshipped_from", param_altshipped_from);
        }
        else if (isDefined.test(param_column) && isDefined.test(session_altshipped_from))
            qp.setShipped_from(Date.valueOf(session_altshipped_from));
        else {
            session.setAttribute("shipped_from", param_shipped_from);
            session.setAttribute("altshipped_from", param_altshipped_from);
        }
        
        String param_shipped_to = request.getParameter("shipped_to");
        String param_altshipped_to = request.getParameter("altshipped_to");
        String session_altshipped_to = (String)session.getAttribute("altshipped_to");
        if (isDefined.test(param_shipped_to)) {
            qp.setShipped_to(Date.valueOf(param_altshipped_to));
            session.setAttribute("shipped_to", param_shipped_to);
            session.setAttribute("altshipped_to", param_altshipped_to);
        }
        else if (isDefined.test(param_column) && isDefined.test(session_altshipped_to))
            qp.setShipped_to(Date.valueOf(session_altshipped_to));
        else {
            session.setAttribute("shipped_to", param_shipped_to);
            session.setAttribute("altshipped_to", param_altshipped_to);
        }
        
        String param_received_from = request.getParameter("received_from");
        String param_altreceived_from = request.getParameter("altreceived_from");
        String session_altreceived_from = (String)session.getAttribute("altreceived_from");
        if (isDefined.test(param_received_from)) {
            qp.setReceived_from(Date.valueOf(param_altreceived_from));
            session.setAttribute("received_from", param_received_from);
            session.setAttribute("altreceived_from", param_altreceived_from);
        }
        else if (isDefined.test(param_column) && isDefined.test(session_altreceived_from))
            qp.setReceived_from(Date.valueOf(session_altreceived_from));
        else {
            session.setAttribute("received_from", param_received_from);
            session.setAttribute("altreceived_from", param_altreceived_from);
        }
        
        String param_received_to = request.getParameter("received_to");
        String param_altreceived_to = request.getParameter("altreceived_to");
        String session_altreceived_to = (String)session.getAttribute("altreceived_to");
        if (isDefined.test(param_received_to)) {
            qp.setReceived_to(Date.valueOf(param_altreceived_to));
            session.setAttribute("received_to", param_received_to);
            session.setAttribute("altreceived_to", param_altreceived_to);
        }
        else if (isDefined.test(param_column) && isDefined.test(session_altreceived_to))
            qp.setReceived_to(Date.valueOf(session_altreceived_to));
        else {
            session.setAttribute("received_to", param_received_to);
            session.setAttribute("altreceived_to", param_altreceived_to);
        }
        
        List<Item> items = itemDao.getItems(qp);
        request.setAttribute("items", items);

        getServletConfig()
            .getServletContext()
            .getRequestDispatcher("/showList.jsp")
            .forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Items list display with search engine";
    }// </editor-fold>

}
