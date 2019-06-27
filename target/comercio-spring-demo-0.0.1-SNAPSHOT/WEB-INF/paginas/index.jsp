<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Primeira pagina com Spring</title>
	<spring:url value="produto/" var="produto"></spring:url>
	<spring:url value="cliente/" var="cliente"></spring:url>
</head>
<body>
	<h1>Index do Site de Comercio Online!</h1>
	<hr/>
	<a href="${produto}">Crud Produto</a>
	<a href="${cliente}">Crud Cliente</a>
</body>
</html>