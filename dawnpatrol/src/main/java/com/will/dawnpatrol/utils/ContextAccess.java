package com.will.dawnpatrol.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class ContextAccess {

    public static String getActiveUsername(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return username;
    }

}
