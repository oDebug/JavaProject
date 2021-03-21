package servlets;

import business.BookRow;
import business.ConnectionPool;
import business.Store;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christopher
 */
public class ViewInventoryServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String sql = "";
        String msg = sql;
        String URL = "/ViewInventory.jsp";
        int storeID = 0;
        Store store = null;
        String dbURL = "jdbc:mysql://localhost:3306/henrybooks_is288";
        String dbUser = "root";
        String dbPwd = "corsair";
        
        ArrayList<Store> stores;
        ArrayList<BookRow> bookRows = new ArrayList<>();
        
        try {
            stores = (ArrayList<Store>)request.getSession().getAttribute("stores");
            storeID = Integer.parseInt(request.getParameter("storeID"));//Get selected store
            for(Store x : stores)
            {
                if(x.getStoreID() == storeID)
                {
                    request.getSession().setAttribute("store", x);
                    store = x;
                }
            }            
            //develop inventory container and fill with items
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection conn = pool.getConnection();
            Statement s = conn.createStatement();
            sql = "SELECT x.storeID, x.bookID, y.title, y.price, x.OnHand FROM bookinv x INNER JOIN Booklist y ON x.bookID = y.bookID WHERE x.storeID = " + store.getStoreID();
            ResultSet result = s.executeQuery(sql); //todo: stored procedure
            while (result.next())
            {
                BookRow book = new BookRow();
                book.setStoreID(result.getInt("StoreID"));
                book.setBookID(result.getString("BookID"));
                book.setTitle(result.getString("Title"));
                book.setPrice(result.getLong("Price"));
                book.setOnHand(result.getInt("OnHand"));
                bookRows.add(book);
            }
            request.setAttribute("bookRows", bookRows);            
            request.getSession().setAttribute("store", store);            
        } catch (Exception e) {
            msg = "Inventory error: " + e.getMessage() + "<br>";
            URL = "/StoreSelection.jsp";
        }
        request.setAttribute("msg", msg);
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        return "Short description";
    }// </editor-fold>

}
