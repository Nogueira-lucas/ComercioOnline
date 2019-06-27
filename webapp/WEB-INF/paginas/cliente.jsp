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
	
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrap_css"/>
	<spring:url value="/resources/jquery/jquery.js" var="jquery_js"/>
	<spring:url value="/resources/bootstrap/js/bootstrap.js" var="bootstrap_js"/>
	
	<link rel="stylesheet" type="text/css" href="${bootstrap_css}"/>
	<script src="${bootstrap_js}"></script>
	<script src="${jquery_js}"></script>
	
	<spring:url value="/cliente/salvar" var="salvar"></spring:url>
	<spring:url value="/cliente/alterar/" var="alterar"></spring:url>
	<spring:url value="/cliente/excluir/" var="excluir"></spring:url>
	<spring:url value="/cliente/cancelar" var="cancelar"></spring:url>
	<spring:url value="/cliente/voltar" var="voltar"></spring:url>
</head>
<body>
	<section class="container">
		<header>
			<h1>Cliente - Crud</h1><hr/>
			<a href="${voltar}" class="btn btn-primary">Voltar</a>
		</header>
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success" id="success-alert">
				<c:out value="${mensagem}"></c:out>
			</div>
		</c:if>
		<c:if test="${not empty mensagemErro}">
			<div class="alert alert-danger" id="danger-alert">
				<c:out value="${mensagemErro}"></c:out>
			</div>
		</c:if>
		<div class="container" style="max-width:40%;">
			<form:form action="${salvar}" modelAttribute="cliente">
				<form:hidden path="id"/>
				
				<form:label path="nome">Nome:</form:label>
				<form:input path="nome" type="text" class="form-control"/><br/>
				
				<form:label path="email">E-mail:</form:label>
				<form:input path="email" type="text" class="form-control"/><br/>
				
				<form:label path="senha">Senha:</form:label>
				<form:input path="senha" type="password" class="form-control"/><br/>
				
				
				
				<form:label path="dataNascimento">Data de Nascimento:</form:label>
				<form:input path="dataNascimento" type="date" class="form-group"/><br/>
				
				<c:if test="${cliente.getId()==0}">
					<form:button class="btn btn-primary btn-md btn-lg btn-block">Cadastrar</form:button>
				</c:if>
				
				<c:if test="${cliente.getId()!=0}">
					<form:button class="btn btn-warning btn-md btn-lg btn-block">Editar</form:button>
					<a href="${cancelar}" class="btn btn-primary btn-md btn-lg btn-block">Cancelar</a>
				</c:if>
				
			</form:form>
		</div>
		<div class="container-fluid">
			<c:if test="${not empty clientes}">
			<table class="table">
				<thead>
					<tr>
						<th>Nome:</th>
						<th>E-mail:</th>
						<th>Senha:</th>
						<th>Data Nascimento:</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cliente" items="${clientes}">
						<tr>
							<td>${cliente.nome}</td>
							<td>${cliente.email}</td>
							<td>${cliente.senha}</td>
							<td>${cliente.dataNascimento}</td>
							<td><a href="${alterar}${cliente.id}">Alterar</a></td>
							<td><a href="${excluir}${cliente.id}">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</c:if>
			<c:if test="${empty clientes}">
				<c:out value="Lista está vazia"></c:out>
			</c:if>
		</div>
	</section>
		
	
</body>
</html>