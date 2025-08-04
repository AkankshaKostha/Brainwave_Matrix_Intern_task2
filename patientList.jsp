<%@ page import="java.util.*, model.Patient" %>
<%
    List<Patient> patients = (List<Patient>) request.getAttribute("patients");
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<title>Patient List</title></head>
<body>
<h1>Patient List</h1>
<a href="${pageContext.request.contextPath}/jsp/patientForm.jsp">Add New Patient</a>
 <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">Home</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Age</th><th>Gender</th><th>Phone</th><th>Address</th></tr>
<%
    if (patients != null && !patients.isEmpty()) {
        for (Patient p : patients) {
%>
<tr>
    <td><%= p.getId() %></td>
    <td><%= p.getName() %></td>
    <td><%= p.getAge() %></td>
    <td><%= p.getGender() %></td>
    <td><%= p.getPhone() %></td>
    <td><%= p.getAddress() %></td>
</tr>
<%
        }
    } else {
%>
<tr><td colspan="6">No patients found.</td></tr>
<%
    }
%>
</table>
</body>
</html>
