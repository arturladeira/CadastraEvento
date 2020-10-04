/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cadastraevento;

import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arthur.andrade
 */
@WebServlet(name = "SearchEventServet", urlPatterns = {"/SearchEventServet"})
public class SearchEventServet extends HttpServlet {

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
            out.println("<title>Servlet SearchEventServet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchEventServet at " + request.getContextPath() + "</h1>");
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
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaPU");
        //EntityManager em = JPAUtil.getEM();
        JPAEntradaDAO dao = new JPAEntradaDAO();

        List<Entrada> entradas = dao.searchNameEvent(request.getParameter("name"));
        
        int k = entradas.size();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Evento - Resultado de Consulta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado da consulta para eventos com nome \"" + request.getParameter("name") + "\"</h1>");
            out.println("<p>Foram encontrados "+ k +" registros de eventos com nome \"" + request.getParameter("name") + "\":<p>");

            Iterator<Entrada> entradasAsIterator = entradas.iterator();
            while (entradasAsIterator.hasNext()) {
                Entrada ent = entradasAsIterator.next();
                out.println("<p> *Nome: " + ent.getName() + "\"</p>");
                out.println("<p> *Sigla: " + ent.getInitials() + "\"</p>");
                out.println("<p> *Área de Concentração: " + ent.getArea() + "\"</p>");
                out.println("<p> *Instituição: " + ent.getInstitution() + "\"</p>");
                
            }
            out.println("<p><a href=\"http://localhost:8080/CadastraEvento/query.html\">Nova consulta</a></p>");
            out.println("<p><a href=\"http://localhost:8080/CadastraEvento/index.html\">Página Inicial</a></p>");
            out.println("</body>");
            out.println("</html>");
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
