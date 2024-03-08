<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Calculator</title>
</head>

<body>
    <h2>Calculator</h2>
    <form action="Serv" method="post"> <!-- Ensure your form action matches the URL pattern for the servlet -->
        Number 1: <input type="text" name="num1" value="${param.num1}"><br>
        Number 2: <input type="text" name="num2" value="${param.num2}"><br>
        <input type="submit" value="Calculate">
    </form>
    <h3>Result: ${sum}</h3>
</body>

</html>
