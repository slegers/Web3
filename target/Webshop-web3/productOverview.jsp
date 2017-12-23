<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Product Overview</title>
    <link rel="stylesheet" type="text/css" href="/css/style2.css">
    <link rel="stylesheet" type="text/css" href="/css/${color}.css">
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <%@ include file="layout/nav.jspf"%>

        <h2>
            Product Overview
        </h2>

    </header><main>
    <c:if test="${fouten != null}">
        <div class="alert-danger">
            <ul class="fout">
                <c:forEach var="fout" items="${fouten}">
                    <li>${fout}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <table>
        <tr>
            <th>Id</th>
            <th>Name </th>
            <th>Description</th>
            <th>Price</th>
            <th>Edit </th>
            <th>Delete</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.productId}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>&euro; ${product.price}</td>
                <td> <a href="/ShopController?controller=product&action=edit&id=${product.productId}">Edit</a> </td>
                <td> <a href="/ShopController?controller=product&action=confirmDelete&id=${product.productId}">Delete</a> </td>
            </tr>
        </c:forEach>
        <caption>Products Overview</caption>
    </table>
</main>
    <%@ include file="layout/footer.jspf"%>
</div>
</body>
</html>