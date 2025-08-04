<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
    <title>Schedule Appointment</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h1>Schedule Appointment</h1>
<div class="container">

    <!-- Show error message if any -->
    <c:if test="${not empty errorMessage}">
        <div class="error">${errorMessage}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/appointment" method="post">

        <label for="patientId">Patient ID:</label>
        <input type="number" id="patientId" name="patientId" required>

        <label for="staffId">Staff ID:</label>
        <input type="number" id="staffId" name="staffId" required>

        <label for="dateTime">Date & Time:</label>
        <input type="datetime-local" id="dateTime" name="dateTime" 
               required min="<%= LocalDateTime.now().toString().substring(0,16) %>">

        <label for="status">Status:</label>
        <select id="status" name="status">
            <option value="Scheduled">Scheduled</option>
            <option value="Confirmed">Confirmed</option>
            <option value="Completed">Completed</option>
            <option value="Cancelled">Cancelled</option>
        </select>

        <input type="submit" value="Schedule">
    </form>

    <a class="btn" href="${pageContext.request.contextPath}/appointment">📋 View Appointments</a>
    <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">🏠 Home</a>
</div>
</body>
</html>
