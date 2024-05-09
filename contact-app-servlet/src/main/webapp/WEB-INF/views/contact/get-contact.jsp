
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@include file="../components/header.jspf"%>

<main class="container main-height">


            <div class="row">
                <div class="col-md-5">
                    <img src="${pageContext.request.contextPath}/images/avatar.webp" class="img-thumbnail" alt="${requestScope.contact.firstName}">
                </div>
                <div class="col-md-7">
                    <table class="table">
                        <tr>
                            <th>First Name</th>
                            <td>${requestScope.contact.firstName}</td>
                        </tr>
                        <tr>
                            <th>Last Name</th>
                            <td>${requestScope.contact.lastName}</td>
                        </tr>
                        <tr>
                            <th>Email</th>
                            <td>${requestScope.contact.email}</td>
                        </tr>
                        <tr>
                            <th>Phone</th>
                            <td>${requestScope.contact.phone}</td>
                        </tr>
                        <tr>
                            <th>Address</th>
                            <td>${requestScope.contact.address}</td>
                        </tr>
                        <tr>
                            <th>City</th>
                            <td>${requestScope.contact.city}</td>
                        </tr>
                        <tr>
                            <th>country</th>
                            <td>${requestScope.contact.country}</td>
                        </tr>
                        <tr>
                            <th>Created At</th>
                            <td>${requestScope.contact.createdDate}</td>
                        </tr>
                        <tr>
                           <td >
                               <a href="./edit-contact?contactId=${requestScope.contact.contactId}" class="btn btn-info px-2 mr-2">
                                   Update
                               </a>
                           </td>
                            <td  class="btn btn-danger px-2 ml-2">
                                <a href="./delete-contact?contactId=${requestScope.contact.contactId}">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
    <p class="text-bg-danger">${requestScope.errorMessage}</p>
</main>
<%@include file="../components/footer.jspf"%>