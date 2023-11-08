<%@ page import="models.Produto,java.util.*"%>
<%
List<Produto> products = (List<Produto>) request.getAttribute("produtos");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Produtos</title>
<!-- Incluindo Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>Menu de Produtos</h1>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="obterProduto">Listagem
							de Produtos</a></li>
					<li class="nav-item"><a class="nav-link"
						href="cadastrar_produto.jsp">Cadastro de Produto</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">
		<h2>Listagem de Produtos</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Preço</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (products.size() > 0) {
					for (Produto product : products) {
				%>
				<tr>
					<td><%=product.getCodigo()%></td>
					<td><%=product.getNome()%></td>
					<td>R$ <%=product.getPreco()%></td>
					<td><a class="btn btn-success"
						href="<%=String.format("editar_produto.jsp?codigo=%s", product.getCodigo())%>">EDITAR</a>
						<a class="btn btn-danger"
						href="<%=String.format("/Desafio1/deletarProduto?codigo=%s", product.getCodigo())%>">Deletar</a></td>
					</td>

				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
