package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ColaboradorDao;
import model.Colaborador;

@WebServlet("/colabUpdate")
public class colabFindUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public colabFindUpdate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int colaboradorId = Integer.parseInt(request.getParameter("colaboradorId"));

		Colaborador colaborador = ColaboradorDao.buscarColaborador(colaboradorId);
		System.out.println(colaborador);

		request.setAttribute("colaborador", colaborador);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Colaborador colab = new Colaborador();
		
		colab.setId(Integer.parseInt(request.getParameter("colaboradorId")));
		colab.setNome(request.getParameter("nome"));
		colab.setCpf(request.getParameter("cpf"));
		colab.setAlimento(request.getParameter("alimento"));

		ColaboradorDao.Alterar(colab);
		
		colabInsertSelect colabs = new colabInsertSelect();
		colabs.doGet(request, response);
	}

}
