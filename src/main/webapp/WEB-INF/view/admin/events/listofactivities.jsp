<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Activity" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Activities</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h2 {
            text-align: center;
            color: #3498db;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color:  #75A241;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #e0f1e3; 
        }

        tr:nth-child(odd) {
            background-color: #a5d6a7; 
        }
    </style>
</head>
<body>

<h2>List of Activities</h2>

<% List<Activity> activityList = (List<Activity>) request.getAttribute("activityList"); %>

<!-- add pdf download feature here by adding another th for that applying that in model class of 
activity and than viewing it here  -->
<table>
    <thead>
        <tr>
            <th>Activity Name</th>
            <th>Activity Date</th>
            <th>Activity Location</th>
        </tr>
    </thead>
    <tbody>
        <% for (Activity activity : activityList) { %>
            <tr>
                <td><%= activity.getActivityName() %></td>
                <td><%= activity.getActivityDate() %></td>
                <td><%= activity.getActivityLocation() %></td>
            </tr>
        <% } %>
    </tbody>
</table>

</body>
</html>
