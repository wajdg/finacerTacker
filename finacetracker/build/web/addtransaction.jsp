<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Transaction</title>
</head>
<body>  
    <h1>Add a New Transaction</h1>
    <form action="" method="post">
        <label for="category">Category:</label>
        <input type="text" name="category" id="category" required><br>

        <label for="amount">Amount:</label>
        <input type="number" name="amount" id="amount" step="0.01" required><br>

        <label for="date">Date:</label>
        <input type="date" name="date" id="date" required><br>

        <label for="description">Description:</label>
        <input type="text" name="description" id="description"><br>

        <button type="submit">Add Transaction</button>
    </form>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
