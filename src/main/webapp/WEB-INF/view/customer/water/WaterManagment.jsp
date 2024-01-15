<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Water Managment</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css' />">
</head>
<body>

<jsp:include page="header.jsp" />

<div class="container">
    <div>
        <form id="FormBox"  action="http://localhost:8080/Project/waterbillform" method="post" enctype="multipart/form-data">
            <div class="leg">
                <legend>Water Consumption (2/5)</legend>
            </div>
            <div class="form_data_box">
                <label for="household_water_usage">Household Water Usage*</label>
            <input type="number" id="household_water_usage" name="household_water_usage" required><br>
            <label for="outdoor_water_usage">Outdoor Water Usage*</label>
            <input type="number" id="outdoor_water_usage" name="outdoor_water_usage" required><br>
            <label for="file">Provide Proof Of Bill</label>
            <input type="file" name="file"/><br>
            </div>
            <div class="buttoms">
                <button type="submit" style="margin-right: 50px;" onclick="">Next</button>
            <button type="button" onclick="window.history.back()">Back</button>
            </div>
            
            
        </form>
    </div>
</div>


<jsp:include page="footer.jsp" />

</body>
</html>