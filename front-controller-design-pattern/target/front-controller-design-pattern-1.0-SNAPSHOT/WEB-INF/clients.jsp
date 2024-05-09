<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients</title>
</head>
    <body>
        <%for(String client: (List<String>) request.getAttribute("clients")){%>
            <h1><%=client%></h1>
        <%}%>
    </body>
</html>
