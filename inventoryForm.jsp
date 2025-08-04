<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Inventory Item</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h1>Add Inventory Item</h1>
<div class="container">

    <!-- Error message if any -->
    <c:if test="${not empty errorMessage}">
        <div class="error">${errorMessage}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/inventory" method="post">

        <label for="name">Item Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="category">Category:</label>
        <select id="category" name="category">
            <option value="">-- Select Category --</option>
            <option value="Medicine">Medicine</option>
            <option value="Equipment">Equipment</option>
            <option value="Supplies">Supplies</option>
            <option value="Other">Other</option>
        </select>

        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" min="1" required>

        <label for="price">Price (₹):</label>
        <input type="number" id="price" name="price" min="0" step="0.01" required>

        <input type="submit" value="Add Item">
    </form>

    <a class="btn" href="${pageContext.request.contextPath}/inventory">📦 View Inventory</a>
    <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">🏠 Back to Home</a>
</div>
</body>
</html>
