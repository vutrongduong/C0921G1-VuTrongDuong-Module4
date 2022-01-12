<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Settings</h1>
<th:form modelAttribute="mail" action="/" method="post"> <br>
    <table>
        <tr>
            <td><b>Languages</b></td>
            <td><th:select path="language" items="${languageList}"/></td>
        </tr>
        <tr>
            <td><b>Page Size: </b></td>
            <td>Show <th:select path="pageSize" items="${pageSizeList}"/> email per page</td>
        </tr>
        <tr>
            <td><b>Spams filter :</b></td>
            <td><th:checkbox path="spamsFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td><b>Siganture:</b></td>
            <td><th:textarea path="signature"/></td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <button type="submit">Update</button>
                <button>Cancel</button>
            </td>
        </tr>


    </table>
</th:form>
</body>
</html>
