<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
    <link
      rel="stylesheet"
      href="http://localhost:8080/Project/resources/css/approve.css"
    />
  </head>
  <body>
    <jsp:include page="../headerfooter/header.jsp" />
	<% List<User> list = (List<User>) request.getAttribute("list"); %>
    <div class="report-container">
      <div class="report-box">
      <table>
      	<thead>
      	<th>FullName</th>
      	</thead>
      	<tbody>
      		<% for(User user : list){ %>
      		<tr>
      			<td><%= user.getFullname() %></td>
      			<td>
      				<form action="http://localhost:8080/Project/admin/approveTheBills" method="post">
      					<input type="hidden" name="email" value="<%= user.getEmail() %>">
                		<input type="submit" value="View Bills">
      				</form>
      			</td>
      		</tr>
      	<% }
      	%>
      	</tbody>
      </table>
      </div>
    </div>

    <jsp:include page="../headerfooter/footer.jsp" />
  </body>
</html>
