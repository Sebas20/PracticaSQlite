package com.sebastian.practica_6_sqlite.Utilidades;

/**
 * Created by Usuario on 1/11/2017.
 */

public class Utilidades  {
    //Constantes
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE_AUTOR = "nombre_autor";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CAMPO_NOMBRE_LIBRO = "nombre_libro";
    public static final String CAMPO_NOMBRE_USUARIO = "nombre_usuario";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+"("+CAMPO_ID+" INTEGER,"+CAMPO_NOMBRE_AUTOR+" TEXT,"+CAMPO_NOMBRE_LIBRO+" TEXT,"+CAMPO_NOMBRE_USUARIO+" TEXT,"+CAMPO_TELEFONO+" TEXT)";

}
