<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.EHR" %>
<!DOCTYPE html>
<html>
<head>
    <title>EHR Records</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>All EHR Records</h1>
    <a href="jsp/ehrForm.jsp">Add New Record</a>
      <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">🏠 Back to Home</a>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Patient ID</th>
            <th>Diagnosis</th>
            <th>Treatment</th>
            <th>Doctor</th>
            <th>Date</th>
            <th>Notes</th>
            <th>Action</th>
        </tr>
        <%
            List<EHR> ehrList = (List<EHR>) request.getAttribute("ehrList");
            if (ehrList != null && !ehrList.isEmpty()) {
                for (EHR ehr : ehrList) {
        %>
        <tr>
            <td><%= ehr.getId() %></td>
            <td><%= ehr.getPatientId() %></td>
            <td><%= ehr.getDiagnosis() %></td>
            <td><%= ehr.getTreatment() %></td>
            <td><%= ehr.getDoctorName() %></td>
            <td><%= ehr.getDate() %></td>
            <td><%= ehr.getNotes() %></td>
            <td><a class="button" href="${pageContext.request.contextPath}/ehr?deleteId=<%= ehr.getId() %>">Delete</a></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="8">No records found</td></tr>
        <% } %>
    </table>
</body>
</html>
