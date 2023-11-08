package servlets.Produto;

import java.io.IOException;
import java.sql.SQLException;

import dao.ProdutoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/deletarProduto")
public class DeletarProdutoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codigo = req.getParameter("codigo") != null ? req.getParameter("codigo") : "";
		System.out.println("Código: " + codigo);
		boolean resultado = false;
		try {
			resultado = ProdutoDAO.deletarProdutoPorCodigo(codigo);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(resultado)
				resp.sendRedirect("/Desafio1/sucesso.jsp");
			else
				resp.sendRedirect("/Desafio1/erro.jsp");
		}
	}
}
