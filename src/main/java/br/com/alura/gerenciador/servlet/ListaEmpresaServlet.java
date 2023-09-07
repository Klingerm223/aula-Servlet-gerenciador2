package br.com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ListaEmpresaServlet
 */

@WebServlet("/listaEmpresas")
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
        out.println("<ul>");
        
        for (Empresa empresa : lista) {
			out.println("<li>" + empresa.getNome() + "</li>");
		}
        out.println("</ul>");
        out.println("</body></html>");
        
        
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
