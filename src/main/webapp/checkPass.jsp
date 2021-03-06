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
    <link rel="stylesheet" type="text/css" href="css/<c:out value='${cookie.color.value}'/>">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <%@ include file="nav.jspf"%>

        <h2>
            Password Checker
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
    <p>${tekst}</p>


    <form method="post" action="ShopController?action=checkPassword&id=${person.userid}" novalidate="novalidate">
        <!-- novalidate in order to be able to run tests correctly -->
        <p><label for="password">Password</label><input type="password" id="password"  name="password"
                                                        required> </p>
        <p><input type="submit" id="signUp" value="Sign Up"></p>

    </form>
</main>
    <%@ include file="footer.jsp"%>
</div>
</body>
</html>
