<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Electricity Consumption</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css' />" />
  </head>
  <body>
    <jsp:include page="header.jsp" />

<div class="container">
    <div>
      <form id="FormBox" action="http://localhost:8080/Project/form" enctype="multipart/form-data" method="post" >
        <div class="leg">
          <legend> Energy Consumption (1/5)</legend>
        </div>
        <div class="form_data_box">
          <label for="electricity">Value (kwh)</label>
          <div class="form_data_items">
            <input  type="number" id="electricity" name="electricity" required><br>
          </div>
          <label for="gas">Gas Usage*</label>
          <div class="form_data_items">
            <input type="number" id="gas" name="gas" required><span>m3</span><br>
          </div class="form_data_items">
          <label for="fuel-oil">Fuel Oil Usage*</label>
          <div class="form_data_items">
            <input type="number" id="fuel_oil" name="fuel_oil" required><span>liters</span><br>
          </div>
          <label for="other-energy-sources">Other energy sources</label>
          <div class="form_data_items">
            <input type="text" id="other_energy_sources" name="other_energy_sources"><br>
          </div>
          <label for="file">Provide Proof Of Bill</label>
          <div class="form_data_items">
            <input type="file" name="file"/><br>
          </div>
        </div>
        <div class="buttoms">
          <button type="submit" style="margin-right: 50px;">Next</button>
          <button type="reset">Cancel</button>
        </div>
      </form>
    </div>
  </div>
  

    <jsp:include page="footer.jsp" />

    <script>
      function handleDragOver(event) {
        event.preventDefault();
        document.getElementById("drop-area").classList.add("highlight");
      }

      function handleDragLeave(event) {
        event.preventDefault();
        document.getElementById("drop-area").classList.remove("highlight");
      }

      function handleDrop(event) {
        event.preventDefault();
        document.getElementById("drop-area").classList.remove("highlight");
        handleFiles(event.dataTransfer.files);
      }

      function handleFiles(files) {
        const fileList = document.getElementById("file-list");

        fileList.innerHTML = "";

        for (const file of files) {
          const listItem = document.createElement("li");
          listItem.className = "file-item";
          listItem.textContent = `${file.name} (${formatBytes(file.size)})`;
          fileList.appendChild(listItem);
        }
      }

      function formatBytes(bytes) {
        const k = 1024;
        const sizes = ["Bytes", "KB", "MB", "GB", "TB"];

        if (bytes === 0) return "0 Byte";
        const i = parseInt(Math.floor(Math.log(bytes) / Math.log(k)));
        return Math.round(bytes / Math.pow(k, i)) + " " + sizes[i];
      }
    </script>
  </body>
</html>
