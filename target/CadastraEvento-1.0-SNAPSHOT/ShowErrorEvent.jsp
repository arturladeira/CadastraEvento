<%-- 
    Document   : ShowErrorEvent
    Created on : 3 de out. de 2020, 17:21:08
    Author     : arthur.andrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evento - Página de Falha no Cadastro</title>
    </head>
    <body>
        <h1>A seguinte entrada não foi cadastrada:</h1>        
        <p>Nome: <%= request.getParameter("name") %></p>
        <p>Sigla: <%= request.getParameter("initials") %></p>
        <p>Area de Concentração: <%= request.getParameter("area") %></p>
        <p>Instituição: <%= request.getParameter("institution") %></p></br>
        <p><a href="http://localhost:8080/CadastraEvento/RegisterEvent.html">Cadastrar outro</a></p>
    </body>
</html>
