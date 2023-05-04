package com.project.servlets;

import com.project.utils.ThymeleafUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Inscription", value = "/inscription")
public class InscriptionServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        ThymeleafUtils.write(request, response, getServletContext(), "inscription");
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        request.getRequestDispatcher("/register.jsp").forward(request, response);

    }
}
