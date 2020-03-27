package com.codesquad.signup08.web;

import com.codesquad.signup08.domain.User;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {
    public static final String USER_SESSION_KEY = "sessionUser";

    public static boolean isNotLoginUser(HttpSession session) {
        Object sessionUser = session.getAttribute(USER_SESSION_KEY);
        return sessionUser == null;
    }

    public static User getUserFromSession(HttpSession session) {
        return (User)session.getAttribute(USER_SESSION_KEY);
    }
}
