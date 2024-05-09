
<%@ include file="components/header.jspf"%>

 <main class="container main-height">
     <form action="${pageContext.request.contextPath}/register" method="post" autocomplete="on">

         <div class="mb-3">
             <label for="email" class="form-label">Email Address</label>
             <input type="email" class="form-control" id="email" name="email">
         </div>

         <div class="mb-3">
             <label for="password" class="form-label">Password</label>
             <input type="password" class="form-control" id="password" name="password">
         </div>

         <div class="mb-3">
             <label for="confirmPassword" class="form-label">Confirm Password</label>
             <input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
         </div>

         <button type="submit" class="btn btn-primary">Submit</button>

         <p class="text-bg-danger">${requestScope.errorMessage}</p>
     </form>
 </main>

<%@ include file="components/footer.jspf"%>



