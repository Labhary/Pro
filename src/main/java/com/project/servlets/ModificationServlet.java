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

@WebServlet(name = "Modification", value = "/modification")
public class ModificationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ThymeleafUtils.write(request, response, getServletContext(), "modification");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les valeurs des champs de formulaire soumis
        String nom = request.getParameter("FirstName");
        String prenom = request.getParameter("LastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UtilisateurDAO userDao = new UtilisateurDAO();
        try {
            userDao.mettreAJourUtilisateur(new Utilisateur(nom,prenom,email,password));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // Enregistrer les modifications dans la base de données ou un fichier, etc.

        // Rediriger l'utilisateur vers la page de profil mise à jour
        response.sendRedirect("profil");
    }
}
