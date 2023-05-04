package com.project.utils;

import jakarta.servlet.http.HttpSession;

public class SessionManager {

    private static final String KEY = "USER";

    public static SessionUser getUser(HttpSession session) {
        return (SessionUser) session.getAttribute(KEY);
    }

}
