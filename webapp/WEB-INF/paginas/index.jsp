<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Primeira pagina com Spring</title>
	
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrap_css"/>
	<spring:url value="/resources/jquery/jquery.js" var="jquery_js"/>
	<spring:url value="/resources/bootstrap/js/bootstrap.js" var="bootstrap_js"/>
	
	<link rel="stylesheet" type="text/css" href="${bootstrap_css}"/>
	<script src="${bootstrap_js}"></script>
	<script src="${jquery_js}"></script>
		
	<spring:url value="produto/" var="produto"></spring:url>
	<spring:url value="cliente/" var="cliente"></spring:url>
		
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Comércio Online</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link" href="${produto}">Produto</a>
				<a class="nav-item nav-link"href="${cliente}">Cliente</a>
			</div>
		</div>
	</nav>
	<header class="container">
		<div class="jumbotron" style="margin-top:3%;">
			<h1 class="display-4">Olá Spring!</h1>
			<p class="lead">Esta é a index da minha primeira pagina utilizando Spring Framework</p>
		</div>
	</header>
	<footer style="margin-bottom:0; text-align:center;">
		<p>Lucas Marques Nogueira - &copy;Todos os direitos reservados, 2019.</p>
	</footer>
</body>
</html>