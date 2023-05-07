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

@WebServlet(name = "Inscription", value = "/inscription")
public class InscriptionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ThymeleafUtils.write(request, response, getServletContext(), "inscription");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres du formulaire
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Valider les paramètres du formulaire
        boolean valid = true;
        if (FirstName == null || FirstName.trim().isEmpty()) {
            request.setAttribute("firstNameError", "S'il vous plaît entrez votre nom!");
            valid = false;
        }
        if (LastName == null || LastName.trim().isEmpty()) {
            request.setAttribute("lastNameError", "S'il vous plaît entrez votre prénom!");
            valid = false;
        }
        if (email == null || !email.matches("\\w+@\\w+\\.\\w+")) {
            request.setAttribute("emailError", "S'il vous plaît, mettez une adresse e-mail valide!");
            valid = false;
        }
        if (password == null || password.trim().isEmpty()) {
            request.setAttribute("passwordError", "S'il vous plaît entrez votre mot de passe!");
            valid = false;
        }

        // Si le formulaire est valide, enregistrer l'utilisateur
        if (valid) {
            Utilisateur utilisateur = new Utilisateur(FirstName, LastName, email, password);
            UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
            try {
                utilisateurDAO.ajouterUtilisateur(utilisateur);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("connexion");
        } else {
            ThymeleafUtils.write(request, response, getServletContext(), "inscription");
        }
    }
}
