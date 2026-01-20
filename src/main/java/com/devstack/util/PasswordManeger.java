package com.devstack.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordManeger {
    public static String hash(String simpleText){
        return BCrypt.hashpw(simpleText, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hashedPassword){
        if (BCrypt.checkpw(password,hashedPassword))
            return true;
        else
            return  false;
    }
}
