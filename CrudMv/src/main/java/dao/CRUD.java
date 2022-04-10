package dao;

import java.util.List;

import model.Colaborador;

public interface CRUD {
	public static void inserir(Colaborador colaborador) {};
	public static void Deletar(int colaboradorId) {};
	public static void Alterar(Colaborador colaborador) {};
	public static List<Colaborador> Listar(String Pesquisa) {return null;};
	public static Colaborador buscarColaborador(int colaboradorId) {return null;};
	
	
}
