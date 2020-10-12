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
        <title>Edição - Página de Falha no Cadastro</title>
    </head>
    <body>
        <h1>A seguinte entrada não foi cadastrada:</h1>   
        <p>Id: <%= request.getAttribute("id") %></p>
        <p>Número <%= request.getAttribute("number") %></p>
        <p>Ano: <%= request.getParameter("year") %></p>
        <p>Data de Início: <%= request.getParameter("date_start") %></p>
        <p>Data de Término: <%= request.getParameter("date_end") %></p>
        <p>Cidade Sede: <%= request.getParameter("city_host") %></p></br>
        <p>País Sede: <%= request.getParameter("country_host") %></p></br>
        <p><a href="http://localhost:8080/CadastraEvento/RegisterEdition.html">Cadastrar outra</a></p>
    </body>
</html>
