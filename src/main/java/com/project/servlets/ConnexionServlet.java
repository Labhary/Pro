package com.project.servlets;

import com.project.dao.UtilisateurDAO;
import com.project.utils.ThymeleafUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Connexion", value = "/connexion")
public class ConnexionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ThymeleafUtils.write(request, response, getServletContext(), "connexion");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UtilisateurDAO user = new UtilisateurDAO();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean remember = request.getParameter("remember") != null;

        // vérifier l'authentification de l'utilisateur
        boolean authenticated = user.checkAuthentification(email, password);

        if (authenticated) {
            // connecter l'utilisateur
            request.getSession().setAttribute("userEmail", email);

            // rediriger l'utilisateur vers la page d'accueil
            response.sendRedirect(request.getContextPath() + "/accueil");
        } else {
            // afficher un message d'erreur et revenir à la page de connexion
            request.setAttribute("errorMessage", "Adresse e-mail ou mot de passe incorrect.");
            request.getRequestDispatcher("/WEB-INF/templates/connexion.html").forward(request, response);
        }
    }

}