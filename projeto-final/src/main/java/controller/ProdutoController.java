// -*- coding: utf-8 -*-
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProdutoDao;
import model.dto.Produto;

@WebServlet({ "/Produto/Cadastrar", "/Produto/Listar", "/Produto/Alterar", "/Produto/Excluir", "/Produto/Pesquisar" })
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProdutoController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		processarRequisicao(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		processarRequisicao(request, response);
	}

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rota = request.getServletPath();

		switch (rota) {

		case "/Produto/Cadastrar":
			cadastrar(request, response);
			break;
		case "/Produto/Listar":
			listar(request, response);
			break;
		case "/Produto/Alterar":
			alterar(request, response);
			break;
		case "/Produto/Excluir":
			excluir(request, response);
			break;
		case "/Produto/Pesquisar":
			pesquisar(request, response);
			break;

		}

	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		try {

			Produto produto = new Produto();
			produto.setNome(request.getParameter("nome"));
			produto.setDataCadastro(LocalDate.now());
			produto.setMarca(request.getParameter("marca"));
			produto.setDescricao(request.getParameter("descricao"));
			produto.setLote(request.getParameter("lote"));
			produto.setPreco(Double.parseDouble(request.getParameter("preco")));

			new ProdutoDao().cadastrar(produto);
			out.println("<div style=' display: flex; flex-direction: column; justify-content: center;"
					+ "align-content: center; align-items:center;'");
			out.println("<div><h1>Produto cadastrado com sucesso.</h1></div>");
			out.println("<h3><a href='../Produto/Listar'>Listar Produtos</a></h3>");
			out.println("<h3><a href='../view/home.jsp'>Página inicial</a></h3></div>");

		} catch (Exception e) {
			out.print(e.getMessage());
			out.println("<div style=' display: flex; flex-direction: column; justify-content: center;"
					+ "align-content: center; align-items:center;'");
			out.println("<h1>Erro ao tentar cadastrar produto.</h1>");
			out.println("<h3><a href='../view/home.jsp'>Página inicial</a></h3></div>");
		}

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String html = "";
		
		html += "<div style=' display: flex; flex-direction: column; justify-content: center;"
				+ "	align-content: center; align-items:center;'>"
				+ "<div><h1>LISTAGEM DE PRODUTOS</h1></div>";

		try {

			List<Produto> listaDeProdutos = new ProdutoDao().listar();
			
		
			html += "<div><table border='3' cellspacing='0' cellpadding='5'>";

			html += "<tr>";
			html += "<th>CÓDIGO</th>";
			html += "<th>NOME</th>";
			html += "<th>DATA DE CADASTRO</th>";
			html += "<th>MARCA</th>";
			html += "<th>LOTE</th>";
			html += "<th>PREÇO</th>";
			html += "<th></th>";
			html += "<th></th>";
			html += "<th></th>";
			html += "</tr>";

			for (Produto produto : listaDeProdutos) {

				html += "<tr>";

				html += "<td>" + produto.getCod() + "</td>";
				html += "<td>" + produto.getNome() + "</td>";
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
				String dataFormatada = produto.getDataCadastro().format(dtf);
				html += "<td>" + dataFormatada + "</td>";
				html += "<td>" + produto.getMarca() + "</td>";
				html += "<td>" + produto.getLote() + "</td>";
				html += "<td>" + produto.getPreco() + "</td>";

				html += "<td>";
				html += "<a href='../view/exclusaoProduto.jsp?cod=" + produto.getCod() + "'> Excluir </a>";
				html += "</td>";
				html += "<td>";
				html += "<a href='../view/alteracaoProduto.jsp?cod=" + produto.getCod() + "&nome="
						+ produto.getNome() + "&marca=" + produto.getMarca() + "&descricao=" + produto.getDescricao()
						+ "&lote=" + produto.getLote() + "&preco=" + produto.getPreco() + "'> Alterar </a>";
				html += "</td>";

				html += "<td>";
				html += "<a href='../view/pesquisaProduto.jsp?cod=" + produto.getCod() + "'> Pesquisar </a>";
				html += "</td>";

				html += "</tr>";

			}

				html += "</table>"
					+ "</div>";
			
			html += "<h3><a href='../view/home.jsp'>Página inicial</a></h3></div>";
		} catch (Exception ex) {
			
			html += "<div style=' display: flex; flex-direction: column; justify-content: center;"
					+ "align-content: center; align-items:center;'";
			html += "<div><h2>Erro ao tentar listar clientes!</h2></div>";
			html += "<h3><a href='../view/home.jsp'>Página inicial</a></h3></div>";

		} finally {

            request.setAttribute("html", html);

            RequestDispatcher rd = request.getRequestDispatcher("../view/listagemProduto.jsp");
            rd.forward(request, response);

        }

	}

	private void alterar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<h1>Alteração de Cliente</h1>");

		try {

			Produto produto = new Produto();

			produto.setCod(Integer.parseInt(request.getParameter("cod")));
			produto.setNome(request.getParameter("nome"));
			produto.setDataCadastro(LocalDate.now());
			produto.setMarca(request.getParameter("marca"));
			produto.setDescricao(request.getParameter("descricao"));
			produto.setLote(request.getParameter("lote"));
			produto.setPreco(Double.parseDouble(request.getParameter("preco")));

			new ProdutoDao().alterar(produto);

			out.println("<h2>Alteração realizada com sucesso!</h2>");

			out.println("<h3>");
			out.println("<a href='../Produto/Listar'>");
			out.println("Listagem de Produtos</a>");
			out.println("</h3>");

		} catch (Exception e) {
			out.println(e.getMessage());
			out.println("<div style=' display: flex; flex-direction: column; justify-content: center;"
					+ "align-content: center; align-items:center;'");
			out.println("<div><h2>Erro ao tentar alterar um Produto!</h2></div>");
			out.println("<h3><a href='../view/home.jsp'>Página inicial</a></h3></div>");
		}
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<div style=' display: flex; flex-direction: column; justify-content: center;"
				+ "align-content: center; align-items:center;'");
		out.println("<h1>Exclusão de Produto</h1>");

		try {

			Produto produto = new Produto();

			produto.setCod(Integer.parseInt(request.getParameter("cod")));
			produto = new ProdutoDao().pesquisar(produto);
			if (produto != null) {
				new ProdutoDao().excluir(produto);

				out.println("<div><h2>Exclusão realizada com sucesso!</h2></div>");
				out.println("<h3><a href='../Produto/Listar'>");
				out.println("Listagem de Produtos</a></h3></div>");
			} else {
				out.println("<div><h2>O produto não existe</h2></div>");
				out.println("<h2><a href='../view/home.jsp'>Página inicial</a></h2></div>");
			}

		} catch (Exception e) {
			out.println("<div style=' display: flex; flex-direction: column; justify-content: center;"
					+ "align-content: center; align-items:center;'");
			out.println("<h2>Erro ao tentar excluir um produto!</h2>");
			out.println("<h3><a href='../view/home.jsp'>Página inicial</a></h3></div>");

		}

	}

	private void pesquisar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<div style=' display: flex; flex-direction: column; justify-content: center;"
				+ "align-content: center; align-items:center;'");
		out.println("<h1>Pesquisa de Produto</h1>");

		try {

			Produto p = new Produto();

			p.setCod(Integer.parseInt(request.getParameter("cod")));

			p = new ProdutoDao().pesquisar(p);
			if (p != null) {

				out.println("<table border='3' cellspacing='0' cellpadding='5'");

				out.println("<tr>");
				out.println("<th>CÓDIGO</th>");
				out.println("<th>NOME</th>");
				out.println("<th>MARCA</th>");
				out.println("<th>DESCRIÇÃO</th>");
				out.println("<th>DATA DE CADASTRO</th>");
				out.println("<th>LOTE</th>");
				out.println("<th>PREÇO</th>");
				out.println("<th></th>");
				out.println("<th></th>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>" + p.getCod() + "</td>");
				out.println("<td>" + p.getNome() + "</td>");
				out.println("<td>" + p.getMarca() + "</td>");
				out.println("<td>" + p.getDescricao() + "</td>");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
				String dataFormatada = p.getDataCadastro().format(dtf);
				out.println("<td>" + dataFormatada + "</td>");
				out.println("<td>" + p.getLote() + "</td>");
				out.println("<td>" + p.getPreco() + "</td>");
				out.println("<td>");
				out.println("<a href='../view/exclusaoProduto.jsp?cod=" + p.getCod() + "'> Excluir </a>");
				out.println("</td>");
				out.println("<td>");
				out.println("<a href='../view/alteracaoProduto.jsp?cod=" + p.getCod() + "&nome=" + p.getNome()
						+ "&marca=" + p.getMarca() + "&descricao=" + p.getDescricao() + "&lote=" + p.getLote()
						+ "&preco=" + p.getPreco() + "'> Alterar </a>");
				out.println("</td>");

				out.println("</tr>");

				out.println("</table>");

			} else {
				out.println("<div style=' display: flex; flex-direction: column; justify-content: center;"
						+ "align-content: center; align-items:center;'");
				out.println("<div><h2>nenhum produto encontrado!</h2></div>");
				out.println("<h3><a href='../view/home.jsp'>Página inicial</a></h3><div>");
			}

			out.println("<h3><a href='../Produto/Listar'>");
			out.println("Listagem de Produtos</a></h3></div>");

		} catch (Exception e) {
			out.println(e.getMessage());
			out.println("<div style=' display: flex; flex-direction: column; justify-content: center;"
					+ "align-content: center; align-items:center;'");
			out.println("<div><h2>Erro ao tentar pesquisar um produto!</h2></div>");
			out.println("<h3><a href='../view/home.jsp'>Página inicial</a></h3></div>");

		}

	}
}
