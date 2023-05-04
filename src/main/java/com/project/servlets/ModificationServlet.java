package com.project.servlets;

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
        // Traiter la requête POST (récupérer les données du formulaire et les afficher dans la console)
        String nom = request.getParameter("yourName");
        String prenom = request.getParameter("yourLastName");
        String email = request.getParameter("yourEmail");

        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Email: " + email);

        response.sendRedirect("modification.html");
    }
}
