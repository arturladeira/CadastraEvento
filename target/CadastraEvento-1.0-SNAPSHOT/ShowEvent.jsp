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
        <p>Nome: <%= request.getParameter("name") %></p>
        <p>Sigla: <%= request.getParameter("initials") %></p>
        <p>Area de Concentração: <%= request.getParameter("area") %></p>
        <p>Instituição: <%= request.getParameter("institution") %></p></br>
        <p><a href="http://localhost:8080/CadastraEvento/EditEvent.jsp">Editar Evento</a></p>
        <form action="RegisterEventServlet" method="delete">
            <p><a href="http://localhost:8080/CadastraEvento/DeleteEvent.jsp">Deletar Evento</a></p>
        </form>
        <p><a href="http://localhost:8080/CadastraEvento/query.html">Nova Consulta</a></p>
        <p><a href="http://localhost:8080/CadastraEvento/RegisterEdition.jsp">Cadastrar edição</a></p>
    </body>
</html>
