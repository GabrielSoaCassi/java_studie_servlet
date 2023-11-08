<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Produto</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
    <div class="container mt-4">
        <h2>Cadastro de Produto</h2>
        <form action="/Desafio1/cadastrarProduto" method="POST">
            <div class="form-group">
                <label for="nome">Nome do Produto</label>
                <input type="text" class="form-control" id="nome" placeholder="Digite o nome do produto" name="nome" required>
            </div>
            <div class="form-group">
                <label for="preco">Preço do Produto</label>
                <input type="number" class="form-control" id="preco" placeholder="Digite o Preço do produto" name="preco" required>
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
