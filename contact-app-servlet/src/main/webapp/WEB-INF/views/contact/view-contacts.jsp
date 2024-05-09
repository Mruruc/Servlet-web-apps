<%@ page import="com.mruruc.model.Contact" %>
<%@ page import="java.util.List" %>

<%@include file="../components/header.jspf" %>

<main class="container main-height">
    <%List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");%>
    <div class="row">
        <% if (contacts.isEmpty()) {%>
        <h3>Do not have contacts yet.</h3>
        <%} else {%>
        <%for (Contact contact : (List<Contact>) request.getAttribute("contacts")) {%>
        <div class="card col-md-4">
            <h5 class="card-title">
                <%=contact.getFirstName()%> <%=contact.getLastName()%>
            </h5>
            <p class="card-text">
                <%=contact.getEmail()%> <%=contact.getPhone()%>
            </p>
             <address class="card-footer">
                <%=contact.getAddress()%> <%=contact.getCity()%> <%=contact.getCountry()%>
             </address>
            <a href="${pageContext.request.contextPath}/get-contact?contactId=<%=contact.getContactId()%>"
                class="btn btn-info px-0">View</a>

        </div>
        <%
                }
            }
        %>

    </div>
    <p class="text-bg-danger">${requestScope.errorMessage}</p>
</main>

<%@include file="../components/footer.jspf" %>