<%-- 
    Document   : resposta
    Created on : 11/Set/2013, 19:58:47
    Author     : francisco
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${!empty param.resposta}">
                <jsp:useBean id="questionarios" scope="session" class="questionario.Questionarios"/>
                <c:choose>
                    <c:when test="${questionarios.ultimoQuestionario}">
                        Última resposta ${questionarios.eRespostaCerta(param.resposta)?"certa":"errada"}<br/>
                        Acertou ${questionarios.numeroDeRespostasCertas} respostas de ${questionarios.totalDeRespostas}<br/>
                        Teve uma percentagem de ${questionarios.percentagem}%
                    </c:when>
                    <c:when test="${questionarios.eRespostaCerta(param.resposta)}">
                        Resposta certa
                    </c:when>
                    <c:otherwise>
                        Resposta errada
                    </c:otherwise>
                </c:choose>
                    <a href=".">voltar</a>                        
            </c:when>
            <c:otherwise>
                Não vale a pena chamar a página directamente
            </c:otherwise>
        </c:choose>
    </body>
</html>
