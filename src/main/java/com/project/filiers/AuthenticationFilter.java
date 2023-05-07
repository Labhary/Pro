package com.project.filiers;

import com.project.utils.SessionManager;
import com.project.utils.SessionUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(servletNames = { "" })
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        SessionUser user = SessionManager.getUser(request.getSession());

        if (user != null) {
            filterChain.doFilter(request,response);
        } else {
            response.sendRedirect("connexion");
        }
    }
}
