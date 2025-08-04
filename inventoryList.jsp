<%@ page import="java.util.*, model.InventoryItem" %>
<%
    List<InventoryItem> items = (List<InventoryItem>) request.getAttribute("items");
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    
<title>Inventory</title></head>
<body>
<h1>Inventory Items</h1>
<a href="${pageContext.request.contextPath}/jsp/inventoryForm.jsp">Add New Item</a>
 <a class="btn" href="${pageContext.request.contextPath}/jsp/index.jsp">Home</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Quantity</th><th>Price</th></tr>
<%
    if (items != null && !items.isEmpty()) {
        for (InventoryItem i : items) {
%>
<tr>
    <td><%= i.getId() %></td>
    <td><%= i.getName() %></td>
    <td><%= i.getQuantity() %></td>
    <td><%= i.getPrice() %></td>
</tr>
<%
        }
    } else {
%>
<tr><td colspan="4">No inventory items found.</td></tr>
<%
    }
%>
</table>
</body>
</html>
