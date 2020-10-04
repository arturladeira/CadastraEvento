<%-- 
    Document   : EditEdition
    Created on : 4 de out. de 2020, 11:19:51
    Author     : arthur.andrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edição de edição</title>
    </head>
    <body>
        <h1>Preencha os campos com as informações da Edição do Evento:</h1>
        <form action="RegisterEditionServlet" method="put">
            ID: <p type="text" block size="10" value="<%= request.getAttribute("id") %>"><br>
            Ano: <input type="text" name="year"/><br/>
            Data de Início: <input type="text" name="date_start"/><br/>
            Data de Término: <input type="text" name="date_end"/><br/>
            Cidade Sede: <input type="text" name="city_host"/><br/>
            País Sede: <input type="text" name="country_host"/><br/>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
