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
	
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrap_css"/>
	<spring:url value="/resources/jquery/jquery.js" var="jquery_js"/>
	<spring:url value="/resources/bootstrap/js/bootstrap.js" var="bootstrap_js"/>
	<spring:url value="/resources/wow/wow.css" var="wow_animations"/>
	
	<link rel="stylesheet" type="text/css" href="${bootstrap_css}"/>
	<link rel="stylesheet" type="text/css" href="${wow_animations}">
	<script src="${bootstrap_js}"></script>
	<script src="${jquery_js}"></script>
	
	<spring:url value="/produto/salvar" var="salvar"></spring:url>
	<spring:url value="/produto/excluir/" var="excluir"></spring:url>
	<spring:url value="/produto/alterar/" var="alterar"></spring:url>
	<spring:url value="/produto/voltar" var="voltar"></spring:url>
	<spring:url value="/produto/cancelar" var="cancelar"></spring:url>
	
</head>
<body>
	<section class="container">
		<header>
			<h1>Cadastro - Produto</h1><hr/>
			<a href="${voltar}" class="btn btn-primary">Voltar</a>
		</header>
		<c:if test="${not empty mensagemErro}">
			<div class="alert alert-danger" role="alert">
 					<c:out value="${mensagemErro}"></c:out>
			</div>
		</c:if>
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success bounce" role="alert">
 					<c:out value="${mensagem}"></c:out>
			</div>
		</c:if>
		<div class="container" style="max-width:40%;">			
			<form:form action="${salvar}" modelAttribute="produto" enctype="multipart/form-data">
				<form:hidden path="id" />
				<form:hidden path="imagemProduto"/>
				
				<div class="form-group">
					<form:label path="nome">Nome:</form:label>
					<form:input path="nome" type="text" class="form-control"/>
				</div>
				
				<div class="form-group">
					<form:label path="valor">Valor Unitário:</form:label>
					<form:input path="valor" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label>Imagem:</label>
					<div class="custom-file">
						<input type="file" name="imagem" class="custom-file-input" value="${imagemProduto}">
						<label class="custom-file-label">Escolha uma imagem:</label>
					</div>
					<c:if test="${produto.id ne 0}"><!-- somente ao carregar /alterar/{x} -->
						<div class="mb-5">
							<img class="img-thumbnail" 
								 src="data:image/jpge;base64,${imagemProduto}"
								 alt="Imagem não encontrada">
						</div>
					</c:if>
					
				</div>
				
				<br/>
				<c:if test="${produto.getId()==0}">
					<form:button class="btn btn-primary btn-md btn-lg btn-block">Cadastrar</form:button>
				</c:if>
				<c:if test="${produto.getId()!=0}">
					<form:button class="btn btn-warning btn-md btn-lg btn-block">Editar</form:button>
					<a href="${cancelar}" class="btn btn-primary btn-md btn-lg btn-block">Cancelar</a>
				</c:if>
			</form:form>
		</div>
		<br/>
		<h3>Lista de Produtos</h3><br/>
		<div class="container">
			<c:if test="${not empty produtos}">
				<table class="table">
					<thead>
						<tr>
							<th class="col">Nome</th>
							<th class="col">Valor Unitário</th>
							<th class="col" colspan="2">Ações</th>
						</tr>
					</thead>
					<tbody>		
						<c:forEach var="produto" items="${produtos}">
							<tr>
								<td>${produto.nome}</td>
								<td>${produto.valor}</td>
								
								<td><a href="${alterar}${produto.id}">Alterar</a></td>
								<td><a href="${excluir}${produto.id}">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty produtos}">
				<c:out value="Lista está vazia"></c:out>
			</c:if>
		</div>
	</section>
</body>
</html>