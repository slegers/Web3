<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <h2>Prouct overview</h2>

    </header>
    <main>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td><a href="/ShopController?action=updateProductPage&id=${product.productId}"> ${product.name} </a></td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td><a href="ShopController?action=deleteProductPage&id=${product.productId}">delete</a> </td>
                </tr>
            </c:forEach>
            <caption>Users Overview</caption>
        </table>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
