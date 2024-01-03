<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/css/login.css' />">
</head>
<body>

<jsp:include page="header.jsp" />
	
    <div class="container">
        <div>
          <form id="FormBox" action="WaterMangment.html">

            <div class="leg">
              <legend>Log-in</legend>
            </div>

            <div class="form_data_box">
              <label for="email">Email</label>
              <input type="email"  name="email" required><br>
              <label class="password-field" for="password">Password</label>
              <input type="password" name="password" required><br>
            </div>

            <div class="login-btn">
                <button>Log-in</button>
                <p>dont have an account? <a href="register.html">signup</a></p>
            </div>

          </form>
        </div>
      </div>
      
      
 <jsp:include page="footer.jsp" />
      
      
</body>
</html>