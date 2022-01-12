<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form method="post" action="/caculator">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td><input name="firstOperand" type="text"/></td>
            </tr>
            <tr>
                <td><input name="secondOperand" type="text"/></td>
            </tr>
            <tr>
                <td>
                    <button name="calculation" type="submit" value="+">Addition(+)</button>
                    <button name="calculation" type="submit" value="-">Subtraction(-)</button>
                    <button name="calculation" type="submit" value="*">Multiplication(X)</button>
                    <button name="calculation" type="submit" value="/">Division(/)</button>
                </td>
            </tr>
            <tr>
                <td>
                    <h3>Result Division : ${result}</h3>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
