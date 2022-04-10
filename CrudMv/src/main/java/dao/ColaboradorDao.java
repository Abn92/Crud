package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConexaoSql;
import model.Colaborador;

public class ColaboradorDao implements CRUD {

	private static Connection conexao = ConexaoSql.createConnection();
	private static String sql;

	public static void inserir(Colaborador colaborador) {
		sql = "INSERT INTO COLABORADORES VALUES(null, ?, ?, ?)";

		try {
			PreparedStatement preparedStatment = conexao.prepareStatement(sql);
			preparedStatment.setString(1, colaborador.getNome());
			preparedStatment.setString(2, colaborador.getCpf());
			preparedStatment.setString(3, colaborador.getAlimento());

			preparedStatment.executeUpdate();

			System.out.println("Colaborador inserido com sucesso.");
		} catch (SQLException e) {
			System.out.println("Falha ao inserir colaborador. " + e.getMessage());
		}

	};

	public static void Deletar(int colaboradorId) {
		sql = "DELETE FROM COLABORADORES WHERE ID = ?";
		
		try {
			PreparedStatement preparedStatment = conexao.prepareStatement(sql);
			preparedStatment.setInt(1, colaboradorId);
			
			System.out.println(colaboradorId);
			System.out.println(sql);
			
			preparedStatment.executeUpdate();

			System.out.println("Colaborador deletado com sucesso.");

		} catch (SQLException e) {
			System.out.println("Falha ao deletar. " + e.getMessage());

		}
	};

	public static void Alterar(Colaborador colaborador) {
		sql = "UPDATE COLABORADORES SET NOME=?, CPF=?, ALIMENTO=? WHERE ID = ?";

		try {
			PreparedStatement preparedStatment = conexao.prepareStatement(sql);
			preparedStatment.setString(1, colaborador.getNome());
			preparedStatment.setString(2, colaborador.getCpf());
			preparedStatment.setString(3, colaborador.getAlimento());
			preparedStatment.setInt(4, colaborador.getId());
			
			preparedStatment.executeUpdate();
			
			System.out.println("Colaborador alterado com sucesso.");
			//ColaboradorDao.Listar("");
		
		} catch (SQLException e) {
			System.out.println("Falha ao alterar colaborador. " + e.getMessage());
		}
	};

	public static List<Colaborador> Listar(String pesquisa) {
		sql = String.format("SELECT * FROM COLABORADORES WHERE NOME LIKE '%S%%' OR CPF LIKE '%S%%'", pesquisa,
				pesquisa);

		try {
			List<Colaborador> listaColaboradores = new ArrayList<Colaborador>();

			Statement statement = conexao.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Colaborador colaborador = new Colaborador();
				colaborador.setId(result.getInt("id"));
				colaborador.setNome(result.getString("nome"));
				colaborador.setCpf(result.getString("cpf"));
				colaborador.setAlimento(result.getString("alimento"));

				listaColaboradores.add(colaborador);
			}

			System.out.println("Busca executada com sucesso.");
			return listaColaboradores;
		} catch (SQLException e) {
			System.out.println("Falha ao buscar. " + e.getMessage());
			return null;
		}
	};

	public static Colaborador buscarColaborador(int colaboradorId) {
		
		sql = String.format("SELECT * FROM COLABORADORES WHERE ID = %d", colaboradorId);

		try {
			Colaborador colaborador = new Colaborador();

			Statement statement = conexao.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				colaborador.setId(result.getInt("id"));
				colaborador.setNome(result.getString("nome"));
				colaborador.setCpf(result.getString("cpf"));
				colaborador.setAlimento(result.getString("alimento"));
			}
			

			System.out.println("Busca executada com sucesso.");
			return colaborador;
		} catch (SQLException e) {
			System.out.println("Falha ao buscar. " + e.getMessage());
			return null;
		}
	};

}
