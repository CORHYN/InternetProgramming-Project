<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recycling Activity</title>
   <link rel="stylesheet" href="<c:url value='/resources/css/styles.css' />">
</head>
<body>

<jsp:include page="header.jsp" />

<div class="container">
    <div>
      <form id="FormBox"  action="http://localhost:8080/Project/recyclebillform" method="post" enctype="multipart/form-data">
        <div class="leg">
          <legend>Recycling Activity (3/5)</legend>
        </div>
        <div class="form_data_box">
          <label for="recycling_habits">Recycling Habits</label>
          <input type="text" id="recycling_habit" name="recycling_habit" required><br>
          <label for="composting_habits">Composting Habits</label>
          <input type="text" id="composting_habits" name="composting_habits" required><br>
          <label for="landfill_waste_generation">Landfill Waste Generation</label>
          <input type="text" id="landfill_waste_generation" name="landfill_waste_generation" required><br>
          <label for="file">Provide Proof Of Bill</label>
            <input type="file" name="file"/><br>
        </div>
        <div class="buttoms">
          <button type="submit" style="margin-right: 50px;">Submit</button>
          <button type="reset">Cancel</button>
        </div>
      </form>
    </div>
  </div>

<jsp:include page="footer.jsp" />

</body>
</html>
