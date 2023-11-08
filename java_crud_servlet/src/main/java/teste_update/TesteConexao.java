package teste_update;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Produto;

public class TesteConexao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Produto produto = new Produto("NomeTeste","37f77de7-420e-4cfc-9f14-3dfe7529fa28",new BigDecimal(1234));
		atualizarProdutoPorCodigo(produto);
	}

	public static boolean atualizarProdutoPorCodigo(Produto produto) throws SQLException, ClassNotFoundException {
		Connection conexao = obterConexao();
		String sql = "UPDATE produtos SET nome = ?, preco = ? WHERE codigo = ?";
		int rowsAffected = 0;
		try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
			preparedStatement.setString(1, produto.nome);
			preparedStatement.setBigDecimal(2, produto.preco);
			preparedStatement.setString(3, produto.codigo);
			rowsAffected = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new SQLException("Erro ao atualizar produto");
		} finally {
			fecharConexao(conexao);
			return rowsAffected > 0;
		}
	}
	public static Connection obterConexao() throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		String URL = "jdbc:postgresql://localhost:5432/produtos";
		String USUARIO = "postgres";
		String SENHA = "password";
		try{
			Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			return conexao;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// Método para fechar uma conexão
	public static void fecharConexao(Connection conexao) {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
