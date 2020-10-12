<%-- 
    Document   : ShowEvent
    Created on : 3 de out. de 2020, 17:28:41
    Author     : arthur.andrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evento - Página de Confirmação de Cadastro</title>
    </head>
    <body>
        <h1>As seguintes entradas foram cadastradas:</h1>        
        <p>Id: <%= request.getAttribute("id") %></p>
        <p>Número <%= request.getAttribute("number") %></p>
        <p>Ano: <%= request.getParameter("year") %></p>
        <p>Data de Início: <%= request.getParameter("date_start") %></p>
        <p>Data de Término: <%= request.getParameter("date_end") %></p>
        <p>Cidade Sede: <%= request.getParameter("city_host") %></p></br>
        <p>País Sede: <%= request.getParameter("country_host") %></p></br>
        <p><a href="http://localhost:8080/CadastraEvento/EditEdition.jsp">Editar Edição</a></p>
        <form action="RegisterEditionServlet" method="delete">
            <p><a href="http://localhost:8080/CadastraEvento/DeleteEdition.jsp">Deletar Edição</a></p>
        </form>
        <p><a href="http://localhost:8080/CadastraEvento/RegisterEvent.html">Cadastrar outro Evento</a></p>
        <p><a href="http://localhost:8080/CadastraEvento/RegisterEdition.jsp">Cadastrar edição</a></p>
    </body>
</html>
