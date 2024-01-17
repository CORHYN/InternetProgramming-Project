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
<link rel="stylesheet"
	href="http://localhost:8080/Project/resources/css/approve.css" />
</head>
<body>
	<jsp:include page="../headerfooter/header.jsp" />
	<%
		List<ElectricityBIll> electricity_list = (List<ElectricityBIll>) request.getAttribute("electricity_list");
		List<WaterBill> water_list = (List<WaterBill>) request.getAttribute("water_list");
		List<RecycleBill> recycle_list = (List<RecycleBill>) request.getAttribute("recycle_list");
	%>
	<div class="report-container">
		<div class="report-box">
			<table>
				<thead>
					<th>FullName</th>
				</thead>
				<tbody>
					<%
						for (ElectricityBIll electricitybill : electricity_list) {
					%>
					<tr>
						<td><%=electricitybill.getElectricity()%></td>
						<td><%=electricitybill.getVstatus()%></td>
						<td><a href="<%=electricitybill.getBillFile()%>"
							download="electricity.pdf">Download</a></td>
						<td>
							<form
								action="http://localhost:8080/Project/admin/approveTheBills"  method="post">
								<input type="hidden" name="email" value="<%= electricitybill.getEmail()%>">
								<button type="submit" value="approved" name="choice">Approve</button>
								<button type="submit" value="rejected" name="choice">Reject</button>
							</form>
						</td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>

			<table>
				<thead>
					<th>Water</th>
				</thead>
				<tbody>
					<%
						for (WaterBill waterbill : water_list) {
					%>
					<tr>
						<td><%=waterbill.getWater()%></td>
						<td><a href="<%=waterbill.getBillFile()%>"
							download="water.pdf">Download</a></td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>

			<table>
				<thead>
					<th>Recycle</th>
				</thead>
				<tbody>
					<%
						for (RecycleBill recyclebill : recycle_list) {
					%>
					<tr>
						<td><%=recyclebill.getRecycle()%></td>
						<td><a href="<%=recyclebill.getBillFile()%>"
							download="electricity.pdf">Download</a></td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
		</div>
	</div>



	<jsp:include page="../headerfooter/footer.jsp" />
</body>
</html>