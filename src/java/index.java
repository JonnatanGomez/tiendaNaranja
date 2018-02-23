
/*
 ©2018 All Rights Reserved. Jonnatan Gomez. 

 Autor      : Austro
 Hora      : 21/02/2018 11:55:55 PM
 Email      : jonnatan.gomez1.6180@gmail.com
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Austro
 */
@WebServlet(urlPatterns = {"/index"})
public class index extends HttpServlet {

    String error = "";
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
        
        String act = request.getParameter("act");           
        Main m = new Main();
        if(act.equals("venta")){
            String data = request.getParameter("data");   
            m.newOperation(data);
            redirect(response, "index.html?success=Vendido");
        }
        if(act.equals("closeDay")){
            String data = m.getCloseDay();            
            redirect(response, "cierre.html?data="+data);
        }        
        if(act.equals("saldo")){
            String nit = request.getParameter("nit");           
            String data =m.getSaldo(nit);
            redirect(response, "saldo.html?data="+data);
        }
    }
    
    private void redirect(HttpServletResponse response, String url){
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", url);
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
