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

        <h2>Prouct overview</h2>

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
                <c:if test="${sessionScope.user.role == 'admin'}">
                    <th>Delete Product</th>
                </c:if>
                <th>Quantity</th>
                <th>Buy?</th>

            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td><a href="/ShopController?action=updateProductPage&id=${product.productId}"> ${product.name} </a></td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <c:if test="${sessionScope.user.role == 'admin'}">
                    <td><a href="ShopController?action=deleteProductPage&id=${product.productId}">delete</a> </td>
                    </c:if>
                    <form action="ShopController?action=addToCart&id=${product.productId}" method="post">
                        <td></ts><input type="number" value="1" name="quantity"></td>
                        <td></ts><input type="submit" value="Add to cart"></td>
                    </form>
                </tr>
            </c:forEach>
            <caption>Users Overview</caption>
        </table>
        <p> The number of <a href="/ShopController?action=showCart">cart </a> items is: ${cartItems}</p>
    </main>
    <%@ include file="footer.jsp"%>
</div>
</body>
</html>
