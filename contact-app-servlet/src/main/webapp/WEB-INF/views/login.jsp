
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="components/header.jspf"%>

<main class="container main-height">
    <form action="${pageContext.request.contextPath}/login" method="post" autocomplete="on">
        <div class="mb-3">
            <label for="email" class="form-label">Email Address</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>

        <p class="text-bg-danger">${requestScope.errorMessage}</p>
    </form>
</main>
<%@ include file="components/footer.jspf"%>
