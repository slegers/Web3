<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="/css/style2.css">
    <link rel="stylesheet" type="text/css" href="/css/${color}.css">
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <%@ include file="layout/nav.jspf"%>
        <h2>
            Check password
        </h2>
    </header>
    <main>
        <c:if test="${fouten != null}">
            <div class="alert-danger">
                <ul class="fout">
                    <c:forEach var="fout" items="${fouten}">
                        <li>${fout}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <p>${message}</p>
        <form method="post" action="ShopController?controller=person&action=checkPass&dbUserId=${dbUserId}"
              novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->
            <p><label for="password">Fill in the <password></password></label>
                <input type="password" id="password" name="password"
                                                    required/> </p>
            <p><input type="submit" id="check" value="check"></p>
        </form>
    </main>
    <%@ include file="layout/footer.jspf"%>

</div>
</body>
</html>