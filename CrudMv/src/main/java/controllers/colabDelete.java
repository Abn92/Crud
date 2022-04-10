package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ColaboradorDao;


@WebServlet("/colabDestroy")
public class colabDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public colabDelete() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int colaboradorId = Integer.parseInt(request.getParameter("colaboradorId"));
		
		ColaboradorDao.Deletar(colaboradorId);
		
		colabInsertSelect colab = new colabInsertSelect();
		colab.doGet(request, response);
	}

	
	

}
