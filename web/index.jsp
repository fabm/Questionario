<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questionario</title>
    </head>
    <body>
        <jsp:useBean id="questionarios" scope="session" class="questionario.Questionarios"/>
        <c:if test="${questionarios.temMaisQuestionarios}">
            ${questionarios.questionarioAtual.pergunta}
            <form action="resposta.jsp">
                <c:forEach items="${questionarios}">
                    <input type="radio" name="resposta" value="${questionarios.opcaoAtual.valor}" />
                    ${questionarios.opcaoAtual.nome}<br/>                    
                </c:forEach>
                    <input type="submit" />
            </form>
        </c:if>
    </body>
</html>
