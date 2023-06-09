package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UsuarioDao;
import model.dto.Usuario;


@WebServlet("/Cadastrar")
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public CadastroController() {
        super();

    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("../cadastrar.jsp");
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		try {

			Usuario usuario = new Usuario();
			usuario.setEmail(request.getParameter("email"));
			usuario.setUsuario(request.getParameter("usuario"));
			usuario.setSenha(request.getParameter("senha"));

			new UsuarioDao().salvar(usuario);

			out.print("Cadastro Realizado com sucesso!");

		}catch(Exception e) {
			
			out.print("Erro ao tentar cadastrar!");



		}
	}
}

