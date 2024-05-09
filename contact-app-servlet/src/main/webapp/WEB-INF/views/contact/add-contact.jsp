<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ include file="../components/header.jspf"%>

<main class="container main-height">
    <form  method="post" autocomplete="on" class="container ">
        <div class="mb-2">
            <label for="f_name" class="form-label">First Name</label>
            <input type="text" class="form-control" id="f_name" name="firstName" value="${requestScope.contact.firstName}">
        </div>

        <div class="mb-2">
            <label for="l_name" class="form-label">Last Name</label>
            <input type="text" class="form-control" id="l_name" name="lastName" value="${requestScope.contact.lastName}">
        </div>

        <div class="mb-2">
            <label for="phone" class="form-label">Phone Number</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${requestScope.contact.phone}">
        </div>

        <div class="mb-2">
            <label for="email" class="form-label">Email Address</label>
            <input type="email" class="form-control" id="email" name="email" value="${requestScope.contact.email}">
        </div>

        <div class="mb-2">
            <label for="address" class="form-label">Address</label>
            <input type="text" class="form-control" id="address" name="address" value="${requestScope.contact.address}">
        </div>

        <div class="mb-2">
            <label for="city" class="form-label">City</label>
            <input type="text" class="form-control" id="city" name="city" value="${requestScope.contact.city}">
        </div>

        <div class="mb-2">
            <label for="country" class="form-label">Country</label>
            <input type="text" class="form-control" id="country" name="country" value="${requestScope.contact.country}">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>

        <p class="text-bg-danger">${requestScope.errorMessage}</p>
    </form>
</main>

<%@ include file="../components/footer.jspf"%>


