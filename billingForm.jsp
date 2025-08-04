<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Generate Bill</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h1>Generate Bill</h1>
<div class="container">

    <!-- Error message if any -->
    <c:if test="${not empty errorMessage}">
        <div class="error">${errorMessage}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/billing" method="post">

        <label for="patientId">Patient ID:</label>
        <input type="number" id="patientId" name="patientId" required>

        <label for="amount">Amount (₹):</label>
        <input type="number" id="amount" name="amount" min="0" step="0.01" required>

        <label for="status">Status:</label>
        <select id="status" name="status">
            <option value="Unpaid" selected>Unpaid</option>
            <option value="Paid">Paid</option>
            <option value="Pending">Pending</option>
        </select>

        <input type="submit" value="Generate Bill">
    </form>

    <a class="btn" href="${pageContext.request.contextPath}/billing">💳 View Bills</a>
    <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">🏠 Back to Home</a>
</div>
</body>
</html>
