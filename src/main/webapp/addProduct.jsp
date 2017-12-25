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
            Sign Up
        </h2>

    </header><main>
    <c:if test="${fouten != null}">
        <div class="alert-danger">
            <ul>
                <c:forEach items="${fouten}" var="fout">
                    <li>${fout}</li>
                </c:forEach>

            </ul>
        </div>
    </c:if>


    <form method="post" action="ShopController?action=registerProduct" novalidate="novalidate">
        <!-- novalidate in order to be able to run tests correctly -->
        <p><label for="name">Name</label><input type="text" id="name" name="name"
                                                           required value=""> </p>
        <p><label for="description">Description</label><input type="text" id="description" name="description"
                                                         required value=""> </p>
        <p><label for="price">Price</label><input type="number" id="price" name="price"
                                                              required value=""> </p>
        <p><input type="submit" id="signUp" value="Sign Up"></p>

    </form>
</main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
