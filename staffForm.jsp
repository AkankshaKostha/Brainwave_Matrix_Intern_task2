<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Staff Member</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h1>Add Staff Member</h1>
<div class="container">

    <!-- Error message (if any) -->
    <c:if test="${not empty errorMessage}">
        <div class="error">${errorMessage}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/staff" method="post">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="role">Role:</label>
        <select id="role" name="role">
            <option value="">-- Select Role --</option>
            <option value="Doctor">Doctor</option>
            <option value="Nurse">Nurse</option>
            <option value="Receptionist">Receptionist</option>
            <option value="Lab Technician">Lab Technician</option>
            <option value="Pharmacist">Pharmacist</option>
            <option value="Other">Other</option>
        </select>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" pattern="[0-9]{10}" placeholder="10 digit number">

        <input type="submit" value="Add Staff">
    </form>

    <a class="btn" href="${pageContext.request.contextPath}/staff">👥 View Staff</a>
    <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">🏠 Back to Home</a>
</div>
</body>
</html>
