/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alvar
 */
@WebServlet(urlPatterns = {"/checkuser"})
public class checkuser extends HttpServlet {

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
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /* out.println("<!DOCTYPE html>");*/
            /*out.println("<html>"); 
            /*out.println("<head>");
            /*out.println("<title>Servlet checkuser</title>");            
            /*out.println("</head>");
            /*out.println("<body>");*/
            
            Persistencia base = new Persistencia();
            
            ResultSet rs = base.consultaSQL("SELECT * FROM usuarios WHERE usuario="
                    + "'" + request.getParameter("inputEmail") + "'" + "AND clave= "
                    + "'" + request.getParameter("inputPassword") + "'");
            
            
           
                while(rs.next()){
                out.println("<br>");
                out.println("<div style='text-align: center; border: 3px solid green;'>");
                out.println("<h2> Datos del Usuario </h2>");  
                out.println("<br>");
                out.println("<h3>Usuario: "+ rs.getString("usuario")+ "<h3>");
                //out.println(rs.getString("clave"));
                out.println("<h3>Nombre y Apellido: "+rs.getString("nombreyapellido")+ "<h3>");
                out.println("</div>");
                }            
            
               if(rs.first() == false){
               out.println("<br>");
               out.println("<h2 style='text-align: center; border: 3px solid green;'>  No hay usuarios que coincidan con la búsqueda </h2>");
               }
            
            
            

            
            

                
           /* out.println("<h1>Servlet checkuser at " + request.getContextPath() + "</h1>");
           out.println("<h1>El Usuario es: " + request.getParameter("inputEmail") + "</h1>"); */
        

            /*out.println("</body>");*/
            /*out.println("</html>");*/
        } catch (SQLException ex) {
            Logger.getLogger(checkuser.class.getName()).log(Level.SEVERE, null, ex);        
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

