<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/<c:out value='${cookie.color.value}'/>">
</head>
<body>
<div id="container">
    <header>
        <h1>
            <span>Web shop</span>
        </h1>
        <%@ include file="nav.jspf"%>
        <h2>Home</h2>

    </header>
    <main>
        <p>You have succesfully paid this order.</p>
            <form action="/ShopController?action=productOverview" method="post">
                <input type="submit" value="Product overview">
            </form>
    </main>
    <%@ include file="footer.jsp"%>
</div>
</body>
</html>