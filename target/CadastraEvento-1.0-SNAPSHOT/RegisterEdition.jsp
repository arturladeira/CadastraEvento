<%-- 
    Document   : RegisterEdition
    Created on : 3 de out. de 2020, 16:58:56
    Author     : arthur.andrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Edição</title>
    </head>
    <body>
        <h1>Preencha os campos com as informações da Edição do Evento:</h1>
        <form action="RegisterEditionServlet" method="post">
            Ano: <input type="text" name="year"/><br/>
            Data de Início: <input type="text" name="date_start"/><br/>
            Data de Término: <input type="text" name="date_end"/><br/>
            Cidade Sede: <input type="text" name="city_host"/><br/>
            País Sede: <input type="text" name="country_host"/><br/>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
