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
            ID: <p type="text" name="idEventoEditar" required /><br>
            Número: <p type="text" name="number" required /><br>
            Ano: <input type="text" name="year" required /><br/>
            Data de Início: <input type="text" name="date_start" required /><br/>
            Data de Término: <input type="text" name="date_end" required /><br/>
            Cidade Sede: <input type="text" name="city_host" required /><br/>
            País Sede: <input type="text" name="country_host" required /><br/>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
