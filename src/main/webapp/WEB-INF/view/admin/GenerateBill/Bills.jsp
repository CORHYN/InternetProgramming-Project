<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="model.ElectricityBIll"%>
<%@ page import="model.WaterBill"%>
<%@ page import="model.RecycleBill"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@500&family=Montserrat:ital@1&family=Roboto+Mono:ital@1&family=Roboto:ital,wght@1,900&family=Rubik+Burned&family=Sora:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://localhost:8080/Project/resources/css/approvebill.css" />
</head>
<body>
	<jsp:include page="../headerfooter/header.jsp" />
	<%
		List<ElectricityBIll> electricity_list = (List<ElectricityBIll>) request.getAttribute("electricity_list");
		List<WaterBill> water_list = (List<WaterBill>) request.getAttribute("water_list");
		List<RecycleBill> recycle_list = (List<RecycleBill>) request.getAttribute("recycle_list");
	%>




	<div class="report-container">
		<div class="report-search-container">
			<input type="text" id="electricity-search-input" class="search-input"
				oninput="filterTable('electricity')"
				placeholder="Search by ID or Status">
			<div class="report-box">
				<form action="http://localhost:8080/Project/admin/generateReport" method="post">
				<table id="electricity">
					<thead>
						<th colspan="5">Electricity</th>
					</thead>
					<tbody>
						<%
							for (ElectricityBIll electricitybill : electricity_list) {
						%>
						<tr>
							<td><%=electricitybill.getId()%></td>
							<td><%=electricitybill.getElectricity()%></td>
							<td>
								
									<input type="hidden" name="email" value="<%=electricitybill.getEmail()%>"> 
									<input type="hidden" name="id" value="<%=electricitybill.getId()%>">
									<input type="hidden" name="type" value="electricity">
									<button type="submit" value="approved" name="choice">Approve</button>
									<button type="submit" value="rejected" name="choice">Reject</button>
								
							</td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
				</form>
			</div>
		</div>
	</div>
	<script>
		function filterTable(tableId) {
			// Get input value and convert to lowercase for case-insensitive search
			var searchInput = document
					.getElementById(tableId + "-search-input").value
					.toLowerCase();

			// Get table rows
			var rows = document.querySelectorAll("#" + tableId + " tbody tr");

			// Loop through rows and hide those that don't match the search input
			rows.forEach(function(row) {
				var id = row.querySelector("td:first-child").textContent
						.toLowerCase();
				var status = row.querySelector("td:nth-child(3)").textContent
						.toLowerCase();

				if ((id.indexOf(searchInput) > -1)
						|| (status.indexOf(searchInput) > -1)) {
					row.style.display = "";
				} else {
					row.style.display = "none";
				}

			});
		}
	</script>
	<jsp:include page="../headerfooter/footer.jsp" />
</body>
</html>