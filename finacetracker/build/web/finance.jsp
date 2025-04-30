<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    // Database credentials
    String url = "jdbc:mysql://localhost:3306/finance-tracker";
    String username = "root";
    String password = "admin";

    String currentUser = (String) session.getAttribute("username"); // Simulate user session
    if (currentUser == null) {
        response.sendRedirect("finace.jsp"); // Redirect user to login if not logged in
    }

    String userFullName = "";
    try {
        // Establish connection
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        // Query user information
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, currentUser);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            userFullName = rs.getString("full_name");
        }

        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: #f4f4f4;
        }

        header {
            background-color: #007bff;
            color: white;
            padding: 10px 0;
            text-align: center;
        }

        h1 {
            margin: 0;
            font-size: 24px;
        }

        .container {
            padding: 20px;
            max-width: 800px;
            margin: 20px auto;
            background-color: white;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        .welcome-section {
            margin: 10px 0;
            font-size: 18px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        footer {
            margin: 20px 0;
            text-align: center;
            color: gray;
        }

        .logout {
            margin: 10px 0;
            padding: 10px 15px;
            background-color: red;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            display: block;
            width: 100px;
            text-decoration: none;
        }

        .logout:hover {
            background-color: darkred;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to the User Dashboard</h1>
    </header>

    <div class="container">
        <div class="welcome-section">
            <p>Hello, <strong><%= userFullName %></strong>. Welcome back!</p>
        </div>

        <div class="user-data">
            <h3>Your Account Information</h3>
            <table>
                <tr>
                    <th>Username</th>
                    <td><%= currentUser %></td>
                </tr>
                <tr>
                    <th>Full Name</th>
                    <td><%= userFullName %></td>
                </tr>
            </table>
        </div>

        <div class="user-transactions">
            <h3>Your Recent Transactions</h3>
            <%
                // Fetch transactions related to the user
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, username, password);

                    String transactionQuery = "SELECT * FROM transactions WHERE username = ?";
                    PreparedStatement stmtTrans = connection.prepareStatement(transactionQuery);
                    stmtTrans.setString(1, currentUser);
                    ResultSet rsTrans = stmtTrans.executeQuery();
            %>
            <table>
                <tr>
                    <th>Date</th>
                    <th>Category</th>
                    <th>Amount</th>
                    <th>Description</th>
                </tr>
                <%
                    while (rsTrans.next()) {
                %>
                <tr>
                    <td><%= rsTrans.getDate("date") %></td>
                    <td><%= rsTrans.getString("category") %></td>
                    <td><%= rsTrans.getDouble("amount") %></td>
                    <td><%= rsTrans.getString("description") %></td>
                </tr>
                <%
                    }
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
            </table>
        </div>

        <a href="logout.jsp" class="logout">Logout</a>
    </div>

    <footer>
        <p>&copy; Finance Tracker 2023</p>
    </footer>
</body>
</html>
