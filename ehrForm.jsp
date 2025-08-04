<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add EHR Record</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h1>Add EHR Record</h1>
<div class="container">

    <!-- Show error message if any -->
    <c:if test="${not empty errorMessage}">
        <div class="error">${errorMessage}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/ehr" method="post">
        <label for="patientId">Patient ID:</label>
        <input type="number" id="patientId" name="patientId" required>

        <label for="diagnosis">Diagnosis:</label>
        <input type="text" id="diagnosis" name="diagnosis" required>

        <label for="treatment">Treatment:</label>
        <input type="text" id="treatment" name="treatment" required>

        <label for="doctorName">Doctor Name:</label>
        <input type="text" id="doctorName" name="doctorName" required>

        <label for="notes">Notes:</label>
        <textarea id="notes" name="notes"></textarea>

        <input type="submit" value="Save Record">
    </form>

    <a class="btn" href="${pageContext.request.contextPath}/ehr">📋 View All EHR Records</a>
    <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">🏠 Home</a>
</div>
</body>
</html>
