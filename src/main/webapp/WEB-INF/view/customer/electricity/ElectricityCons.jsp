<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electricity Consumption</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css' />">
</head>
<body>


<jsp:include page="header.jsp" />

<div class="container">
    <div>
      <form id="FormBox" action="http://localhost:8080/Project/form" enctype="multipart/form-data" method="post" >
        <div class="leg">
          <legend>Energy Consumption (1/5)</legend>
        </div>
        <div class="form_data_box">
          <label for="electricity">Electricity Usage*</label>
          <input type="number" id="electricity" name="electricity" required><span>kWh</span><br>
          <label for="gas">Gas Usage*</label>
          <input type="number" id="gas" name="gas" required><span>m3</span><br>
          <label for="fuel-oil">Fuel Oil Usage*</label>
          <input type="number" id="fuel_oil" name="fuel_oil" required><span>liters</span><br>
          <label for="other-energy-sources">Other energy sources</label>
          <input type="text" id="other_energy_sources" name="other_energy_sources"><br>
          <input type="file" name="file"/><br>
        </div>
        <div class="buttoms">
          <button type="submit" style="margin-right: 50px;">Next</button>
          <button type="reset">Cancel</button>
        </div>
      </form>
    </div>
  </div>

<jsp:include page="footer.jsp" />


</body>
</html>
    