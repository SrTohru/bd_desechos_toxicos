/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.negocio.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class Validaciones {

    /**
     * Metodo utilizado para validar si una cadena esta vacia.
     *
     * @param texto Texto a validar
     * @return Regresa verdadero si el texto esta vacio o en blanco, regresa
     * falso si no esta vacio o en blanco.
     */
    public static boolean isEmpty(String texto) {
        if (texto == null || texto.isBlank()) {
            return true;
        }
        return false;
    }

    /**
     * Metodo utilizado para validar si una cadena excede el limite de
     * caracteres especificados.
     *
     * @param texto Texto a validar
     * @param limiteCaracteres Cantidad de caracteres maximos
     * @return Regresa verdaero si el texto esta vacio o excede el limite de
     * caracteres especificado, regresa falso si no esta vacio o no excede el
     * limite de caracteres.
     */
    public static boolean exceedsLimit(String texto, int limiteCaracteres) {
        if (texto == null || texto.length() > limiteCaracteres) {
            return true;
        }
        return false;
    }

    /**
     * Metodo utilizado para validar si una cadena se puede permitir como nombre
     * es decir, no acepta numeros o caracteres especiales.
     *
     * @param texto Texto a validar
     * @return Regresa verdadero si la cadena a validar tiene algun caracter no
     * aceptado, regresa falso si no tiene ningun otro caracter no aceptado.
     */
    public static boolean validateName(String texto) {
        CharSequence cadena = texto;
        String reCadena = "^[a-zA-Z\\s]+$";
        Pattern pattern = Pattern.compile(reCadena);
        Matcher matcher = pattern.matcher(cadena);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodo utilizado para validar si un numero solo tiene 6 digitos
     * @param numero Numero a validar
     * @return Regresa verdadero si la cadena a validar no es aceptado,
     * regresa falso si 
     */
    public static boolean validarNumero(String numero) {
        return numero.matches("^\\d{6}$");
    }
}
