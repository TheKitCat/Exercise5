package servlets;

import beans.ITaxCalcRemote;
import beans.SingletonCounter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet calls a remote Bean to calculate the total amount
 *
 * @author katharina
 */
@WebServlet(name = "TaxCalcRemote", urlPatterns = {"/TaxCalcRemote"})
public class TaxCalcRemote extends HttpServlet {
    //5-3 singleton implementation
    @EJB
    private SingletonCounter singletonCounter;

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

        try (PrintWriter out = response.getWriter()) {
            
            singletonCounter.increment();
            
            float amount = Float.parseFloat(request.getParameter("amount"));
            float tax = Float.parseFloat(request.getParameter("tax"));
            String currency = request.getParameter("currency");

            try {
                //Create inital context
                InitialContext ctx = new InitialContext();
                //lookup for the local interface
                ITaxCalcRemote calc = (ITaxCalcRemote) ctx.lookup("java:global/Exercise5/TaxCalcRemoteBean!beans.ITaxCalcRemote");

                double result = calc.calcTax(amount, tax);
                out.println("Total amount: " + result + " " + currency);

            } catch (NamingException ex) {
                Logger.getLogger(TaxCalcLocal.class.getName()).log(Level.SEVERE, null, ex);
            }
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
