
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="components/header.jspf"%>

<main class="container main-height">
    <h1>Hello ${sessionScope.user.userName}</h1>
    <h2>Email ${sessionScope.user.email}</h2>
</main>



<%@ include file="components/footer.jspf"%>