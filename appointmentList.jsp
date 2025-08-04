<%@ page import="java.util.*, model.Appointment" %>
<%
    List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
%>
<!DOCTYPE html>
<html>
<head><title>Appointment List</title></head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<body>
<h1>Appointments</h1>
<a href="${pageContext.request.contextPath}/jsp/appointmentForm.jsp">Schedule New Appointment</a>
 <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">Home</a><br>
<table border="1">
<tr><th>ID</th><th>Patient ID</th><th>Staff ID</th><th>Date & Time</th><th>Status</th></tr>
<%
    if (appointments != null && !appointments.isEmpty()) {
        for (Appointment a : appointments) {
%>
<tr>
    <td><%= a.getId() %></td>
    <td><%= a.getPatientId() %></td>
    <td><%= a.getStaffId() %></td>
    <td><%= a.getDateTime() %></td>
    <td><%= a.getStatus() %></td>

</tr>
<%
        }
    } else {
%>
<tr><td colspan="5">No appointments found.</td></tr>
<%
    }
%>
</table>
</body>
</html>
