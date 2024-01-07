<%@ page import="java.sql.*" %>
<%@ page import="org.springframework.jdbc.core.JdbcTemplate" %>
<%@ page import="javax.sql.DataSource" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Activity</title>
    <style>
        /* Styles remain unchanged */
    </style>
</head>
<body>

    <h2>Add Activity</h2>

    <form id="activityForm">
        <label for="activityName">Activity Name:</label>
        <input type="text" id="activityName" name="activityName" required>

        <label for="activityDate">Date:</label>
        <input type="date" id="activityDate" name="activityDate" required>

        <button type="button" onclick="addActivity()">Add Activity</button>
    </form>

    <h3>Activities List</h3>
    <ul id="activityList">
        <%-- Activities will be displayed here --%>
        <c:forEach var="activity" items="${activities}">
            <li>${activity.activity_name} - ${activity.activity_date}</li>
        </c:forEach>
    </ul>

    <%
        // Fetch activities using JDBC template
        try {
            // Assuming you have a DataSource configured in your application
            DataSource dataSource = (DataSource) application.getAttribute("dataSource");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            // Fetch activities from the database
            String query = "SELECT * FROM activities";
            List<Map<String, Object>> activities = jdbcTemplate.queryForList(query);

            // Set activities as a request attribute
            request.setAttribute("activities", activities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

</body>
</html>
