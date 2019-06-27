<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cliente - crud</title>
	<spring:url value="/cliente/salvar" var="salvar"></spring:url>
</head>
<body>
	<h1>Cliente - Crud</h1><hr/>
	<form:form action="${salvar}" modelAttribute="cliente">
		
		<label>Nome:</label>
		<form:input path="nome"/><br/>
		
		<label>E-mail:</label>
		<form:input path="email"/><br/>
		
		<label>Senha:</label>
		<form:input path="senha"/><br/>
		
		<label>Data Nascimento:</label>
		<form:input path="dataNascimento" type="date"/><br/>
		
		<form:button>Cadastrar</form:button>
	</form:form>
</body>
</html>