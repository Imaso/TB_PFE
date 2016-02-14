package com.pixgame.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pixgame.beans.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * si l'utilisateur tape l'adresse de la servlet directement dans la barre d'adresse, il est renvoy� 
		 * sur la page d'accueil !
		 */
		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// on r�cup�re les valeurs des deux champs du formulaire de la page de login
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		// on v�rifie qu'ils ont bien �t� remplis
		if(!login.isEmpty() && !password.isEmpty()){
			// on cr�� un objet User pour conserver les informations de l'utilisateur...
			User currentUser = new User();
			currentUser.setLogin(login);
			currentUser.setPassword(password);
			
			//... et on le stocke dans la session courante.
			request.getSession().setAttribute("user", currentUser);
			
			// Enfin, on redirige les donn�es vers la page content.jsp
			request.getRequestDispatcher("content.jsp").forward(request, response);
			
		} else {
			// Si l'utilisateur n'a pas rempli les deux champs du formulaire, il est renvoy� sur home.jsp
			response.sendRedirect("home.jsp");
		}
	}

}
