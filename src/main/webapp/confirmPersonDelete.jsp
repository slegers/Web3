<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <%@ include file="nav.jspf"%>

        <h2>
            Confirm delete
        </h2>

    </header><main>
    <p>Are you sure to delete ${person.firstName}?</p>


    <form method="post" action="ShopController?action=deletePerson&id=${person.userid}" novalidate="novalidate">
        <p><input type="submit" id="Yes" value="Yes"></p>
    </form>
    <form method="post" action="ShopController?action=personOverview" novalidate="novalidate">
        <p><input type="submit" id="No" value="No"></p>
    </form>
</main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
