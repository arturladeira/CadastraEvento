/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cadastraevento;


import java.io.IOException;
import java.io.PrintWriter;
//import java.util.List;;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
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
@WebServlet(name = "RegisterEventServlet", urlPatterns = {"/RegisterEventServlet"})
public class RegisterEventServlet extends HttpServlet {

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
        JPAEntradaDAO dao = new JPAEntradaDAO();

        Entrada entrada = new Entrada();
        entrada.setName(request.getParameter("name"));
        entrada.setInitials(request.getParameter("initials"));
        entrada.setArea(request.getParameter("area"));
        entrada.setInstitution(request.getParameter("institution"));

        //EntityTransaction et = em.getTransaction();
        //et.begin();
        //em.persist(entrada);
        //et.commit();
        dao.salva(entrada);

        Long id = entrada.getId();

        request.setAttribute("id", id);

        ServletContext servcontext = request.getServletContext();

        if (dao.recupera(id) != null) {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/ShowEvent.jsp");
            dispatcher.include(request, response);
        } else {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/ShowErrorEvent.jsp");
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
        JPAEntradaDAO dao = new JPAEntradaDAO();

        Entrada entrada = dao.searchId(request.getParameter("id"));

        entrada.setName(request.getParameter("name"));
        entrada.setInitials(request.getParameter("initials"));
        entrada.setArea(request.getParameter("area"));
        entrada.setInstitution(request.getParameter("institution"));

        //EntityTransaction et = em.getTransaction();
        //et.begin();
        //em.persist(entrada);
        //et.commit();
        dao.salva(entrada);

        ServletContext servcontext = request.getServletContext();

        if (dao.recupera(entrada.getId()) != null) {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/ShowEvent.jsp");
            dispatcher.include(request, response);
        } else {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/ShowErrorEvent.jsp");
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
        JPAEntradaDAO dao = new JPAEntradaDAO();
        
        
        String resposta = dao.delete(request.getParameter("id"));
        Entrada entrada = dao.searchId(request.getParameter("id"));
        request.setAttribute("resposta", resposta);
        //EntityTransaction et = em.getTransaction();
        //et.begin();
        //em.persist(entrada);
        //et.commit();
        
        
        Long id = entrada.getId();

        request.setAttribute("id", id);
        ServletContext servcontext = request.getServletContext();
        
        if (dao.recupera(id) != null) {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/ShowErrorEvent.jsp");
            dispatcher.include(request, response);
        } else {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/DeleteEvent.jsp");
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
