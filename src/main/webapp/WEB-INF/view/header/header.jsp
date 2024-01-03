<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/css/header.css' />">
</head>
<body>

	<nav>
    <div class="dropdown">
        <button class="dropbtn">Our Services</button>
        <div class="dropdown-content">
            <a class="drop" href="homepage.html">Home</a>
            <a class="drop" href="register.html">Registration</a>
            <a class="drop" href="carbonFootprint.html">Carbon Footprint</a>
            <a class="drop" href="#service3">Generate Report</a>
        </div>
    </div>
    <div class="mbip-icon">
        <a> <img src="<c:url value='/resources/images/mbip-icon.png' />"></a>
    </div>
    <h4>MBIP</h4>
    <div class="user-button">
        <a> <img src="<c:url value='/resources/images/user-icon.png' />">USER</a>
    </div>
</nav>





</body>
</html>