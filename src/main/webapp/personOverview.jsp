<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/<c:out value='${cookie.color.value}'/>">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <%@ include file="nav.jspf"%>

        <h2>Person overview</h2>

    </header>
<main>
    <table>
        <tr>
            <th>E-mail</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Delete</th>
            <th>Check</th>
        </tr>
        <c:forEach var="person" items="${persons}">
            <tr>
                <td>${person.email}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td><a href="/ShopController?action=deletePersonPage&id=${person.userid}">Delete</a></td>
                <td><a href="/ShopController?action=checkPasswordHandlerPage&id=${person.userid}">Check</a></td>
            </tr>
        </c:forEach>
        <caption>Users Overview</caption>
    </table>
</main>
    <%@ include file="footer.jsp"%>
</div>
</body>
</html>
