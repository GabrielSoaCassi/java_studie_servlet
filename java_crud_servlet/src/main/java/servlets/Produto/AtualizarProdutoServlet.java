package servlets.Produto;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.UUID;

import dao.ProdutoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Produto;

@WebServlet(urlPatterns ="/atualizarProduto")
public class AtualizarProdutoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String preco = req.getParameter("preco") != null ? req.getParameter("preco") : "0";
		String codigo = req.getParameter("codigo") != null ? req.getParameter("codigo"):"";
		Produto produto = new Produto(req.getParameter("nome"),codigo,new BigDecimal(preco));
		PrintWriter write = resp.getWriter();
		write.print(produto.toString());
		boolean resultado= false;
		try {
			resultado = ProdutoDAO.atualizarProdutoPorCodigo(produto);
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
