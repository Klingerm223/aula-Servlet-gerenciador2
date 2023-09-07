package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresaServlet
 */

@WebServlet("/listaEmpresas")
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
//		PrintWriter out = resp.getWriter();
//		out.println("<html><body>");
//        out.println("<ul>");
//        
//        for (Empresa empresa : lista) {
//			out.println("<li>" + empresa.getNome() + "</li>");
//		}
//        out.println("</ul>");
//        out.println("</body></html>");
        
		request.setAttribute("empresas", lista);

	    RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
	    rd.forward(request,response);
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
