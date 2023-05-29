package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UsuarioDao;
import model.dto.Usuario;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Login() {
        super();

    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("../index.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("usuario");
		String senha = request.getParameter("senha");

		PrintWriter out = response.getWriter();

			try{
				Usuario usuario = new Usuario();
				usuario.setEmail(username);
				usuario.setUsuario(username);
				usuario = new UsuarioDao().pesquisar(usuario);
				if(usuario.getId() > 0 && usuario.getSenha().equals(senha)){
					HttpSession session = request.getSession(true);
					session.setAttribute("usuario", usuario);
					response.sendRedirect("view/home.jsp");
				}
				else{
					out.println("<div style=' display: flex; flex-direction: column; justify-content: center;"
							+ "align-content: center; align-items:center;'");
					out.println("<div><h2>usuario ou senha incorretos.</h2></div>");
					out.println("<h3><a href='index.jsp'>voltar</a></h3></div>");
				}
			}catch(Exception e){
				out.println("<div style=' display: flex; flex-direction: column; justify-content: center;"
						+ "align-content: center; align-items:center;'");
				out.print("<h1>erro ao tentar fazer login.</h1>");
				out.println("<h3><a href='index.jsp'>voltar</a></h3></div>");
			}
	}

}
