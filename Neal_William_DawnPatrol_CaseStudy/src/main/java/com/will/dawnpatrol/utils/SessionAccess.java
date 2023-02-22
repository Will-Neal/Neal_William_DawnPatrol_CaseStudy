package com.will.dawnpatrol.utils;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author willw
 * A utility class that accesses the currently active session and returns the username of the User that is logged in to the session.
 */
public class SessionAccess {

    /**
     * @return
     * Accesses the session and returns the username of the active user. 
     */
    public static String getActiveUsername(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return username;
    }

}
