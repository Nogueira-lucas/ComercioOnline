<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro Produto</title>
	<spring:url value="/produto/salvar" var="salvar"></spring:url>
	<spring:url value="/produto/excluir/" var="excluir"></spring:url>
	<spring:url value="/produto/alterar/" var="alterar"></spring:url>
</head>
<body>
	<h1>Cadastro - Produto</h1><hr/>
	<br>
	<form:form action="${salvar}" modelAttribute="produto">
		<form:hidden path="id"/>
		<label>Nome:</label><br/>
		<form:input path="nome"/>
		<br/>
		<label>Valor:</label><br/>
		<form:input path="valor"/>
		<br/><br/>
		<form:button>Cadastrar</form:button>
	</form:form>
	<br/>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Valor Unitário</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach var="produto" items="${produtos}">
				<tr>
					<td>${produto.id}</td>
					<td>${produto.nome}</td>
					<td>${produto.valor}</td>
					<td><a href="${alterar}${produto.id}">Alterar</a></td>
					<td><a href="${excluir}${produto.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>