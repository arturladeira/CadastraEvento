/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cadastraevento;


import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author artur.andrade
 */
@WebServlet(name = "RegisterEditionServlet", urlPatterns = {"/RegisterEditionServlet"})
public class RegisterEditionServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterEventServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterEventServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        
        // Obtain a database connection:
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventPU");
        //EntityManager em = JPAUtil.getEM();
        JPAEntradaEditionDAO dao = new JPAEntradaEditionDAO();

        EntradaEdition entrada = new EntradaEdition();
        entrada.setYear(request.getParameter("year"));
        entrada.setDateStart(request.getParameter("date_start"));
        entrada.setDateEnd(request.getParameter("date_end"));
        entrada.setCityHost(request.getParameter("city_host"));
        entrada.setCountryHost(request.getParameter("country_host"));

        //EntityTransaction et = em.getTransaction();
        //et.begin();
        //em.persist(entrada);
        //et.commit();
        dao.salva(entrada);

        Long id = entrada.getId();

        request.setAttribute("id", id);

        ServletContext servcontext = request.getServletContext();

        if (dao.recupera(id) != null) {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/ShowEdition.jsp");
            dispatcher.include(request, response);
        } else {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/ShowErrorEdition.jsp");
            dispatcher.include(request, response);
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Obtain a database connection:
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventPU");
        //EntityManager em = JPAUtil.getEM();
        JPAEntradaEditionDAO dao = new JPAEntradaEditionDAO();

        EntradaEdition entrada = dao.searchId(request.getParameter("id"));

        entrada.setYear(request.getParameter("year"));
        entrada.setDateStart(request.getParameter("date_start"));
        entrada.setDateEnd(request.getParameter("date_end"));
        entrada.setCityHost(request.getParameter("city_host"));
        entrada.setCountryHost(request.getParameter("country_host"));

        //EntityTransaction et = em.getTransaction();
        //et.begin();
        //em.persist(entrada);
        //et.commit();
        //dao.salva(entrada);

        ServletContext servcontext = request.getServletContext();

        if (dao.recupera(entrada.getId()) != null) {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/ShowEdition.jsp");
            dispatcher.include(request, response);
        } else {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/ShowErrorEdition.jsp");
            dispatcher.include(request, response);
        }
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Obtain a database connection:
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventPU");
        //EntityManager em = JPAUtil.getEM();
        JPAEntradaEditionDAO dao = new JPAEntradaEditionDAO();
        
        
        String resposta = dao.delete(request.getParameter("id"));
        EntradaEdition entrada = dao.searchId(request.getParameter("id"));
        request.setAttribute("resposta", resposta);
        //EntityTransaction et = em.getTransaction();
        //et.begin();
        //em.persist(entrada);
        //et.commit();
        
        
        Long id = entrada.getId();

        request.setAttribute("id", id);
        ServletContext servcontext = request.getServletContext();
        
        if (dao.recupera(id) != null) {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/ShowErrorEdition.jsp");
            dispatcher.include(request, response);
        } else {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/DeleteEdition.jsp");
            dispatcher.include(request, response);
        }
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
