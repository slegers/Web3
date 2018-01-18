<%--
  Created by IntelliJ IDEA.
  User: yanice
  Date: 18/01/2018
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
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

        <h2>Shopcatw</h2>

    </header>
    <main>
        <c:if test="${fouten != null}">
            <div class="alert-danger">
                <ul>
                    <c:forEach items="${fouten}" var="fout">
                        <li>${fout}</li>
                    </c:forEach>

                </ul>
            </div>
        </c:if>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>

            </tr>
            <c:forEach var="cartItem" items="${cartItems}">
                <tr>
                    <td>${cartItem.product.name}</td>
                    <td>${cartItem.product.description}</td>
                    <td>${cartItem.product.price}</td>
                    <form action="" method="post">
                        <td><input type="number" value="<c:out value="${cartItem.quantity}"/>" name="quantity"></td>
                    </form>
                </tr>
            </c:forEach>
            <caption>Product cart Overview</caption>
        </table>
    </main>
    <%@ include file="footer.jsp"%>
</div>
</body>
</html>
