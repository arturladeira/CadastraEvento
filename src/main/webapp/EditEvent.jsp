<%-- 
    Document   : EditEvent
    Created on : 4 de out. de 2020, 11:19:39
    Author     : arthur.andrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edição de evento</title>
    </head>
    <body>
        <h1>Preencha os campos com as informações do Evento:</h1>
        <form action="RegisterEventServlet" method="put">
            ID: <p type="text" name="idEventoEditar" required /><br>
            Nome: <input type="text" name="name" required /><br/>
            Sigla: <input type="text" name="initials" required /><br/>
            Area de Concentração: <input type="text" name="area" required /><br/>
            Instituição: <input type="text" name="institution"required /><br/>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
