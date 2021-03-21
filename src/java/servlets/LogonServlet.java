package servlets;

import business.ConnectionPool;
import business.Store;
import business.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class LogonServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        User user;
        ArrayList<Store> stores = new ArrayList<>();
        
        String URL ="/StoreSelection.jsp"; //Should be connection pool later
        String dbURL = "jdbc:mysql://localhost:3306/henrybooks_is288";
        String dbUser = "root";
        String dbPwd = "corsair";
        String sql = "";
        String msg = "";
        
        //final version authenticates and builds per club logon...
        user = new User();
        user.setUserID(1234);
        user.setUsername("John");
        user.setStoreID(2);
        user.setAdminLevel("Admn");
        request.getSession().setAttribute("user", user);
        
        if(user.isAuthenticated())
        {
            try {
                Class.forName("com.mysql.jdbc.Driver"); //Errors unless I included this
                
                ConnectionPool pool = ConnectionPool.getInstance();
                Connection conn = pool.getConnection();
                
//                Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
                Statement s = conn.createStatement();
                sql = "SELECT * FROM stores ORDER BY StoreName";
                ResultSet result = s.executeQuery(sql);
                while (result.next())
                {
                    Store store = new Store();
                    store.setStoreID(result.getInt("StoreID"));
                    store.setStoreName(result.getString("StoreName"));
                    store.setStoreAddr(result.getString("StoreAddr"));
                    store.setStoreEmp(result.getInt("StoreEmp"));
                    stores.add(store);

                }
                if(stores.size() > 0){
                    request.getSession().setAttribute("stores", stores);

                }else{
                    msg = "No stores read from stores table<br>";

                }
                result.close();
                pool.freeConnection(conn);
            } catch (SQLException e) {
                msg = "SQL Exception: " + e.getMessage() + "<br>";
            }
            catch(ClassNotFoundException e)
            {
                
            }
            
            RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
            disp.forward(request, response);
        }
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
