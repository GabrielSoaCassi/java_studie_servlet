package servlets.Produto;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import dao.ProdutoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Produto;

@WebServlet(urlPatterns ="/cadastrarProduto")
public class CadastrarProdutoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String preco = req.getParameter("preco") != null ? req.getParameter("preco") : "0";
		Produto produto = new Produto(req.getParameter("nome"), new BigDecimal(preco));
		boolean resultado= false;
		try {
			resultado = ProdutoDAO.cadastrarProduto(produto);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (resultado)
				resp.sendRedirect("/Desafio1/sucesso.jsp");
			else
				resp.sendRedirect("/Desafio1/erro.jsp");
		}
	}
}
