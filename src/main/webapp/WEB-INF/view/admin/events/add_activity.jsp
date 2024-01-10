<%@ page import="java.sql.*" %>
<%@ page import="org.springframework.jdbc.core.JdbcTemplate" %>
<%@ page import="javax.sql.DataSource" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>


<html>
<head>
    <title>Add Activity</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/add_activity_admin.css' />">
</head>
<body>

    
    <jsp:include page="header.jsp" />

<div class="container">
    <div>
        <form id="FormBox"  action="http://localhost:8080/Project/add/activity" enctype="multipart/form-data" method="post">
            <div class="leg">
                <legend>Add Activity</legend>
            </div>
            
            <label for="activityName">Activity Name:</label>
        <input type="text" id="activityName" name="activityName" required>

        <label for="activityDate">Date:</label>
        <input type="date" id="activityDate" name="activityDate" required>
        
        <label for="activityDate">Location:</label>
        <input type="text" id="location" name="location" required>
        
        <!-- impliment this button feature so admin can uplaod poster to the database -->
    		<label for="file-input" class="custom-button">Upload Poster</label>
    		<input type="file" id="file-input" name="file">
		

        <button type="submit" onclick="addActivity()">Add Activity</button>
            
        </form>
    </div>
</div>


<jsp:include page="footer.jsp" />
    
    
    
    
    
    
    
    
    
    
    
    
    
 
   

</body>
</html>
