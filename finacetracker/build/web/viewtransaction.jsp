<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Transactions</title>
</head>
<body>
    <h1>Your Transactions</h1>
    <table border="1">
        <thead>
            <tr>
                <th>#</th>
                <th>Category</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Map<String, String>> transactions = (List<Map<String, String>>) session.getAttribute("transactions");
                if (transactions != null && !transactions.isEmpty()) {
                    int index = 1;
                    for (Map<String, String> transaction : transactions) {
            %>
            <tr>
                <td><%= index++ %></td>
                <td><%= transaction.get("category") %></td>
                <td><%= transaction.get("amount") %></td>
                <td><%= transaction.get("date") %></td>
                <td><%= transaction.get("description") != null ? transaction.get("description") : "N/A" %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No transactions found.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
