package com.project.servlets;

import com.project.utils.ThymeleafUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Contact", value = "/contact")
public class ContactServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ThymeleafUtils.write(request, response, getServletContext(), "contact");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupérer les données du formulaire contact
        String objet = request.getParameter("Objet");
        String message = request.getParameter("Message");

    }

}

