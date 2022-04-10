package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ColaboradorDao;
import model.Colaborador;

@WebServlet("/InsertSelect")
public class colabInsertSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public colabInsertSelect() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");
		if (pesquisa == null) {
			pesquisa = "";
		}

		List<Colaborador> listaColaboradores = ColaboradorDao.Listar(pesquisa);

		request.setAttribute("listaColaboradores", listaColaboradores);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Colaborador colab = new Colaborador();

		colab.setNome(request.getParameter("nome"));
		colab.setCpf(request.getParameter("cpf"));
		colab.setAlimento(request.getParameter("alimento"));

		String pesquisa = request.getParameter("pesquisa");
		if (pesquisa == null) {
			pesquisa = "";
		}
		List<Colaborador> listaColaboradores = ColaboradorDao.Listar(pesquisa);

		request.setAttribute("listaColaboradores", listaColaboradores);

		// colab.setCpf(request.getParameter("cpf"));
		var cpf = request.getParameter("cpf");
		var alimento = request.getParameter("alimento");

		List<String> listaAux = new ArrayList<String>();
		
		for (Colaborador colaborador : listaColaboradores) {
			if (Integer.parseInt(colaborador.getCpf()) == Integer.parseInt(cpf) || alimento.equalsIgnoreCase(colaborador.getAlimento())) {
				listaAux.add("Existe");
			}
		}
		
		if(!listaAux.isEmpty()){
			System.out.println("Não é permitido repetir o cpf ou seleção de alimento. Por favor, escolha outra opção ou delete uma existente.");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
			requestDispatcher.forward(request, response);
		}
		else {
			ColaboradorDao.inserir(colab);
			doGet(request, response);
		}
		
	}

}
