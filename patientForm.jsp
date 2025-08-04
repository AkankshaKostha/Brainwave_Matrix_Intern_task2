<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register Patient</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h1>Register Patient</h1>
<div class="container">

    <form action="${pageContext.request.contextPath}/patient" method="post">

        <label>Name:</label>
        <input type="text" name="name" required>

        <label>Age:</label>
        <input type="number" name="age" min="0" max="120">

        <label>Gender:</label>
        <select name="gender">
            <option value="">--Select--</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select>

        <label>Phone:</label>
        <input type="text" name="phone" pattern="[0-9]{10}" placeholder="10 digit number">

        <label>Address:</label>
        <textarea name="address"></textarea>

        <input type="submit" value="Register ">
    </form>

    <a class="btn" href="${pageContext.request.contextPath}/patient">View Patients</a>
    <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">Back to Home</a>

</div>
</body>
</html>
