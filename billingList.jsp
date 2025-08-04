<%@ page import="java.util.*, model.Bill" %>
<%
    List<Bill> bills = (List<Bill>) request.getAttribute("bills");
%>
<!DOCTYPE html>
<html>
<head><title>Bills</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"></head>

<body>
<h1>Billing</h1>
<a href="${pageContext.request.contextPath}/jsp/billingForm.jsp">Generate New Bill</a>
 <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">Home</a>
<table border="1">
<tr><th>ID</th><th>Patient ID</th><th>Amount</th><th>Status</th></tr>
<%
    if (bills != null && !bills.isEmpty()) {
        for (Bill b : bills) {
%>
<tr>
    <td><%= b.getId() %></td>
    <td><%= b.getPatientId() %></td>
    <td><%= b.getAmount() %></td>
    <td><%= b.getStatus() %></td>
</tr>
<%
        }
    } else {
%>
<tr><td colspan="4">No bills found.</td></tr>
<%
    }
%>
</table>
</body>
</html>
