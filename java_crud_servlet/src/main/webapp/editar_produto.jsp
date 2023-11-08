<%@page import="java.util.UUID"%>
<%@page import="dao.ProdutoDAO"%>
<%@page import="models.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String codigo = request.getParameter("codigo"); 
Produto produto = (Produto) ProdutoDAO.buscarProdutoPorId(codigo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edição de Produto</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Menu de Produtos</h1>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="obterProduto">Listagem de Produtos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cadastrar_produto.jsp">Cadastro de Produto</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
	<div class="container">
		<h2>Edição de Produto</h2>
				<form action="/Desafio1/atualizarProduto" method="POST">
			<div class="form-group">
				<label for="codigo">Código do Produto:</label> <input type="text"
					class="form-control" id="codigo" name="codigo" readonly
					value="<%=produto.getCodigo()%>">
			</div>
			<div class="form-group">
				<label for="nome">Nome do Produto:</label> <input type="text"
					class="form-control" id="nome" name="nome"
					value="<%=produto.getNome()%>">
			</div>
			<div class="form-group">
				<label for="preco">Preço do Produto:</label> <input type="number"
					class="form-control" id="preco" name="preco"
					value="<%=produto.getPreco()%>">
			</div>
			<button type="submit" class="btn btn-primary">Atualizar
				Produto</button>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
