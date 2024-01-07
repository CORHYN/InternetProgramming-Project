<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" href="<c:url value='/resources/css/login.css' />">
</head>
<body>
	<form class="form-signin" method="post" action="/Project/login">
		<h2 class="form-signin-heading">Please sign in</h2>
		<p>
			<label for="username" class="sr-only">Email</label> <input
				type="text" id="username" name="username" class="form-control"
				placeholder="Email" required="" autofocus="">
		</p>
		<p>
			<label for="password" class="sr-only">Password</label> <input
				type="password" id="password" name="password" class="form-control"
				placeholder="Password" required="">
		</p>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
	</form>
	<%-- <jsp:include page="header.jsp" /> --%>

	<!--     <div class="container"> -->
	<!--         <div> -->
	<!--           <form id="FormBox" action="/Project/login"> -->

	<!--             <div class="leg"> -->
	<!--               <legend>Log-in</legend> -->
	<!--             </div> -->

	<!--             <div class="form_data_box"> -->
	<!--               <label for="email">Email</label> -->
	<!--               <input type="email"  name="email" required><br> -->
	<!--               <label class="password-field" for="password">Password</label> -->
	<!--               <input type="password" name="password" required><br> -->
	<!--             </div> -->

	<!--             <div class="login-btn"> -->
	<!--                 <button>Log-in</button> -->
	<!--                 <p>dont have an account? <a href="http://localhost:8086/Project/register/">signup</a></p> -->
	<!--             </div> -->

	<!--           </form> -->
	<!--         </div> -->
	<!--       </div> -->


	<%--  <jsp:include page="footer.jsp" /> --%>


</body>
</html>