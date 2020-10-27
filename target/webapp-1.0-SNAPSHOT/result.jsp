<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="storage" class="beans.Storage" scope= "session"/>
<jsp:useBean id="dataviewer" class="beans.DataView" scope= "session"/>
<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="UTF-8"/>
        <title>Result</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/result-style.css"/>
    </head>
    <body>
        <div class="header">
            <div class="content">
                <h2 class="head-label"><a href="${pageContext.request.contextPath}/index">Назад</a></h2>
            </div>
        </div>
        <div>
            <div class="content">
                <h3>Результат</h3>
            </div>
        </div>
        <div class="result-table">
            <div class="content">
                   <%
                        out.print(dataviewer.getAsHtmlTable(storage.getLastAttempt()));
                   %>
            </div>
        </div>
    </body>
</html>