package com.project.servlets;

import com.project.db.UtilisateurDAO;
import com.project.models.Utilisateur;
import com.project.utils.ThymeleafUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/connexion", "/"} )
public class ConnexionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ThymeleafUtils.write(request, response, getServletContext(), "connexion");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        UtilisateurDAO userdao = new UtilisateurDAO();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Utilisateur user = null;
        try {
            user = userdao.recupererUtilisateurParEmail(email);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // vérifier l'authentification de l'utilisateur
        boolean authenticated = userdao.checkAuthentification(email, password);
        System.out.println(authenticated);

        if (authenticated) {
            // connecter l'utilisateur
            request.getSession().setAttribute("user", user);

            // rediriger l'utilisateur vers la page d'accueil
            ThymeleafUtils.write(request, response, getServletContext(), "accueil");
        } else {
            // afficher un message d'erreur et revenir à la page de connexion
            request.setAttribute("errorMessage", "Adresse e-mail ou mot de passe incorrect.");
            ThymeleafUtils.write(request, response, getServletContext(), "connexion");
        }
    }
}