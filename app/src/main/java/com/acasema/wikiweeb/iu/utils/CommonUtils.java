package com.acasema.wikiweeb.iu.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CommonUtils {
    /**
     * metodo estatico qe se el String cumple lo sigiente
     * -tiene 8 caracteres
     * -tiene una mayuscula
     * -tiene un numero
     * @param password
     * @return
     */
    public static boolean isPasswordValid(String password){
        String patron = "^(?=\\w*\\d)(?=\\w*[a-z])\\S{8,16}$";
        return isStringValid(password, patron);
    }


    public static boolean isPositiveNumbreValid(String numbre){
        String patron = "^(\\d)+$";// patron para un numero mayor a 0
        return isStringValid(numbre, patron);
    }

    public static boolean isTitleArticleValid(String title){
        String patron = "^.{3,}$";// patron para un numero mayor a 0
        return isStringValid(title, patron);
    }

    private static boolean isStringValid(String string, String patron) {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
