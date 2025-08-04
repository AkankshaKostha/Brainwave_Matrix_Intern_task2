<%@ page import="java.util.*, model.Staff" %>
<%
    List<Staff> staffList = (List<Staff>) request.getAttribute("staffList");
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<title>Staff List</title></head>
<body>
<h1>Staff Members</h1>
<a href="${pageContext.request.contextPath}/jsp/staffForm.jsp">Add New Staff</a>
 <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">Home</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Role</th><th>Phone</th></tr>
<%
    if (staffList != null && !staffList.isEmpty()) {
        for (Staff s : staffList) {
%>
<tr>
    <td><%= s.getId() %></td>
    <td><%= s.getName() %></td>
    <td><%= s.getRole() %></td>
    <td><%= s.getPhone() %></td>
</tr>
<%
        }
    } else {
%>
<tr><td colspan="4">No staff found.</td></tr>
<%
    }
%>
</table>
</body>
</html>
