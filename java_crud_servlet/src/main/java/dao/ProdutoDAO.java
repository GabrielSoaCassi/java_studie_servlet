package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.Produto;

public class ProdutoDAO {

	public static boolean cadastrarProduto(Produto produto) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoDAO.obterConexao();
		int rowsAffected = 0;
		try (PreparedStatement preparedStatement = conexao
				.prepareStatement("INSERT INTO produtos (codigo, nome, preco) VALUES (?, ?, ?)")) {
			preparedStatement.setObject(1, produto.codigo);
			preparedStatement.setString(2, produto.nome);
			preparedStatement.setBigDecimal(3, produto.preco);

			rowsAffected = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		ConexaoDAO.fecharConexao(conexao);
		return rowsAffected > 0;

	}

	@SuppressWarnings("finally")
	public static Produto buscarProdutoPorId(String idDesejado) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoDAO.obterConexao();
		String sql = "SELECT nome, codigo, preco FROM produtos WHERE codigo = ? and datadelete IS NULL";
		Produto produto = null;
		try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
			preparedStatement.setObject(1, idDesejado);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String nome = resultSet.getString("nome");
				String codigo = resultSet.getString("codigo");
				BigDecimal preco = resultSet.getBigDecimal("preco");
				preparedStatement.close();
				produto = new Produto(nome, codigo, preco);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			ConexaoDAO.fecharConexao(conexao);
			return produto != null ? produto : null;
		}
	}

	public static List<Produto> obterTodosOsProdutos() throws SQLException, ClassNotFoundException {
		List<Produto> produtos = new ArrayList<Produto>();
		Connection conexao = ConexaoDAO.obterConexao();
		String sql = "SELECT nome, codigo, preco FROM produtos WHERE datadelete IS NULL";

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String nome = resultSet.getString("nome");
				String codigo = resultSet.getString("codigo");
				BigDecimal preco = resultSet.getBigDecimal("preco");

				Produto produto = new Produto(nome, codigo, preco);
				produtos.add(produto);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		ConexaoDAO.fecharConexao(conexao);
		return produtos;
	}

	@SuppressWarnings("finally")
	public static boolean atualizarProdutoPorCodigo(Produto produto) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoDAO.obterConexao();
		String sql = "UPDATE produtos SET nome = ?, preco = ? WHERE codigo = ?";
		int rowsAffected = 0;
		try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
			preparedStatement.setString(1, produto.nome);
			preparedStatement.setBigDecimal(2, produto.preco);
			preparedStatement.setString(3, produto.codigo);
			rowsAffected = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			ConexaoDAO.fecharConexao(conexao);
			return rowsAffected > 0;
		}
	}

	public static boolean deletarProdutoPorCodigo(String codigo) throws SQLException, ClassNotFoundException {
	    Connection conexao = ConexaoDAO.obterConexao();
	    String sql = "UPDATE produtos SET datadelete = ? WHERE codigo = ?";
	    Date dataHoraAtual = new Date();
	    int rowsAffected = 0;
	    
	    try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
	        java.sql.Date dataHoraAtualSQL = new java.sql.Date(dataHoraAtual.getTime());
	        preparedStatement.setDate(1, dataHoraAtualSQL);
	        preparedStatement.setString(2, codigo);
	        rowsAffected = preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    } finally {
	        ConexaoDAO.fecharConexao(conexao);
	    }
	    return rowsAffected > 0;
	}


}