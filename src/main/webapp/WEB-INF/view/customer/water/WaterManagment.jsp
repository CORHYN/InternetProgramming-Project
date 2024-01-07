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
        <form id="FormBox"  action="RecyclingActivity.html">
            <div class="leg">
                <legend>Water Consumption (2/5)</legend>
            </div>
            <div class="form_data_box">
                <label for="household-water-usage">Household Water Usage*</label>
            <input type="number" id="household-water-usage" name="household-water-usage" required><br>
            <label for="outdoor-water-usage">Outdoor Water Usage*</label>
            <input type="number" id="outdoor-water-usage" name="outdoor-water-usage" required><br>
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