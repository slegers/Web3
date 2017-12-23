<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Add product</title>
    <link rel="stylesheet" type="text/css" href="/css/style2.css">
    <link rel="stylesheet" type="text/css" href="/css/${color}.css">
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <%@ include file="layout/nav.jspf"%>

        <h2>
            Add product
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


        <!-- novalidate in order to be able to run tests correctly -->
<c:if test="${formAction == 'update'}">
    <form method="post" action="ShopController?product/update" novalidate="novalidate">
        <p><label for="id">Id</label>
            <input type="number" id="id" name="id"
                   required value="${product.productId}" readonly>
        </p>
</c:if>
        <c:if test="${formAction != 'update'}">
        <form method="post" action="ShopController?product/insert" novalidate="novalidate">
            </c:if>
        <p><label for="name">Name</label><input type="text" id="name" name="name"
                                                     required value="<c:out value="${product.name}"/>"> </p>
        <p><label for="description">Description</label><input type="text" id="description" name="description"
                                                           required value="<c:out value="${product.description}"/>"> </p>
        <p><label for="price">Price</label><input type="number" id="price" name="price"
                                                         required value="<c:out value="${product.price}"/>"></p>

        <p><input type="submit" id="addProduct" value="Add product"></p>

    </form>
</main>
    <%@ include file="layout/footer.jspf"%>

</div>
</body>
</html>
