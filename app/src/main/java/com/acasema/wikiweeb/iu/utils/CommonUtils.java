package com.acasema.wikiweeb.iu.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * clase de utilidasdes comunes de la aplicacion
 */
public final class CommonUtils {
    /**
     * metodo estatico qe se el String cumple lo sigiente
     * -tiene 8 caracteres
     * -tiene una mayuscula
     * -tiene un numero
     * @param password contraseña para comprobar
     * @return respuesta de la comprobacion
     */
    public static boolean isPasswordValid(String password){
        String patron = "^(?=\\w*\\d)(?=\\w*[a-z])\\S{8,16}$";
        return isStringValid(password, patron);
    }

    /**
     * metodo estatico qe se el String cumple lo sigiente
     * -tiene que ser un numero
     * -tiene que ser positivo
     * @param numbre numero a comprobar
     * @return respuesta de la comprobacion
     */
    public static boolean isPositiveNumbreValid(String numbre){
        String patron = "^(\\d)+$";// patron para un numero mayor a 0
        return isStringValid(numbre, patron);
    }

    /**
     * metodo estatico qe se el String cumple lo sigiente
     * -cualquer texto
     * -un minimo de 3 caracteres
     * @param title titulo a comprobar
     * @return respuesta de la comprobacion
     */
    public static boolean isTitleArticleValid(String title){
        String patron = "^.{3,}$";
        return isStringValid(title, patron);
    }

    /**
     * metodo privado para comprobar con reglas con lo patrones
     * @param string String a comprobar
     * @param patron dicho patron
     * @return respuesta de la comprobacion
     */
    private static boolean isStringValid(String string, String patron) {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
