<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Confirm delete </title>
    <link rel="stylesheet" type="text/css" href="/css/style2.css">
    <link rel="stylesheet" type="text/css" href="/css/${color}.css">
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <%@ include file="layout/nav.jspf"%>
        <h2>
            Confirm delete
        </h2>

    </header><main>

    <p>Are you sure to delete ${description}?</p>

    <form method="post" action="ShopController?controller=${controller}&action=delete&dbUserId=${dbUserId}" novalidate="novalidate">
        <!-- novalidate in order to be able to run tests correctly -->
        <p><input type="submit" value="Yes"></p>
    </form>
    <form method="post" action="ShopController?controller=${controller}&action=overview" novalidate="novalidate">
        <!-- novalidate in order to be able to run tests correctly -->
        <p><input type="submit" value="Cancel"></p>
    </form>
</main>
    <%@ include file="layout/footer.jspf"%>

</div>
</body>
</html>
