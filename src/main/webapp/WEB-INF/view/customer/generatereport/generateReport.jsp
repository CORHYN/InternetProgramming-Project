<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="resources/css/generatereport.css" />
  </head>
  <body>
    <jsp:include page="../header/header.jsp" />

    <div class="report-container">
      <div class="report-box">
        <div class="generate-report-list">
          <form action="">
            <input type="submit" value="View Report" />
          </form>
        </div>
        <div class="approved-bills"></div>
        <div class="older-report"></div>
      </div>
    </div>

    <jsp:include page="../footer/footer.jsp" />
  </body>
</html>
