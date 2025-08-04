<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hospital Management System</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>

<h1>🏥 Hospital Management System</h1>

    <div class="container">
        <a class="btn" href="${pageContext.request.contextPath}/patient">👤 Manage Patients</a>
        <a class="btn" href="${pageContext.request.contextPath}/appointment">📅 Manage Appointments</a>
        <a class="btn" href="${pageContext.request.contextPath}/ehr">🗂️ Manage EHR</a> 
        <a class="btn" href="${pageContext.request.contextPath}/staff">👨‍⚕️ Manage Staff</a>
        <a class="btn" href="${pageContext.request.contextPath}/inventory">📦 Manage Inventory</a>
        <a class="btn" href="${pageContext.request.contextPath}/billing">💰 Manage Billing</a>
    </div>

</body>
</html>
