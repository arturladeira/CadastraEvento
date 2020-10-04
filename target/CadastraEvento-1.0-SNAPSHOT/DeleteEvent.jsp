<%-- 
    Document   : DeleteEvent
    Created on : 4 de out. de 2020, 10:58:29
    Author     : arthur.andrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remoção de evento</title>
    </head>
    <body>            
            <p type="text" size="10" value="<%= request.getAttribute("resposta") %>"><br>
            <p><a href="http://localhost:8080/CadastraEvento/index.html">Página Inicial</a></p>
            <p><a href="http://localhost:8080/CadastraEvento/query.html">Nova Consulta</a></p>
            <p><a href="http://localhost:8080/CadastraEvento/RegisterEvent.jsp">Cadastrar Evento</a></p>
    </body>
</html>
