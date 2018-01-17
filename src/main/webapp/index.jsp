<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/<c:out value='${cookie.color.value}'/>">
</head>
<body>
	<div id="container">
		<header>
			<h1>
				<span>Web shop</span>
			</h1>
			<%@ include file="nav.jspf"%>
			<h2>Home</h2>

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
			<c:if test="${sessionScope.user == null}">
				<form action="ShopController?action=login" method="post">
					<p><label for="email">Email</label><input type="email" id="email" name="email" required value=""></p>
					<p><label for="password">Password</label><input type="password" id="password"  name="password"
																	required> </p>
					<input type="submit" value="login">
				</form>
			</c:if>
			<c:if test="${sessionScope.user != null}">
				<p> Hello, ${sessionScope.user.firstName}</p>
				<form action="ShopController?action=logout" method="post">
					<input type="submit" value="logout">
				</form>
			</c:if>
		</main>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>