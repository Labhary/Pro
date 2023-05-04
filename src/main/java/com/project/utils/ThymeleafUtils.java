package com.project.utils;

import com.project.config.ThymeleafConfiguration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

public class ThymeleafUtils {

    public static void write(
            HttpServletRequest request,
            HttpServletResponse response,
            ServletContext servletContext,
            String template
    ) throws IOException {
        TemplateEngine templateEngine = (TemplateEngine) servletContext.getAttribute(
                ThymeleafConfiguration.TEMPLATE_ENGINE_ATTR);

        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(servletContext)
                .buildExchange(request, response);

        WebContext context = new WebContext(webExchange);

        context.setVariable("name", "Huong Dan Java");

        templateEngine.process(template, context, response.getWriter());
    }

}
