<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org">
  <head>
    <title>Please Log In</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="http://localhost:8080/Project/resources/css/login.css"
    />
  </head>
  <body>
    <%--
    <div th:if="${param.error}">Invalid username and password.</div>
    --%> <%--
    <div th:if="${param.logout}">You have been logged out.</div>
    --%>
    <form class="login-page-box" th:action="@{/login}" method="post">
      <label for="username">Email</label>
      <input type="text" name="username" placeholder="Email" />
      <label for="password">Password</label>
      <input type="password" name="password" placeholder="Password" />
      <div class="login-buttons">
        <input type="submit" value="Log in" />
        <input
          type="button"
          value="Register"
          onclick=" window.location.href = 'http://localhost:8080/Project/register/'"
        />
      </div>
    </form>
  </body>
</html>
