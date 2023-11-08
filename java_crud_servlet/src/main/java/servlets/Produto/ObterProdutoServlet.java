package servlets.Produto;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import dao.ProdutoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Produto;

@WebServlet(urlPatterns = "/obterProduto")
public class ObterProdutoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Produto> produtos = null;
		try {
			produtos = ProdutoDAO.obterTodosOsProdutos();
		} catch (Exception e) {
			
		} finally {
			req.setAttribute("produtos",produtos);
			req.getRequestDispatcher("/lista_produtos.jsp").forward(req, resp);
		}
	}
}
