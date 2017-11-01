package com.sebastian.practica_6_sqlite.Clases;

/**
 * Created by Usuario on 1/11/2017.
 */

public class UsuariosVo {
    private String id_libro;
    private String nombre_libro;
    private String nombre_autor;
    private String nombre_persona;
    private String telefono_persona;

    public UsuariosVo() {
    }

    public UsuariosVo(String id_libro, String nombre_libro, String nombre_autor, String nombre_persona, String telefono_persona) {
        this.id_libro = id_libro;
        this.nombre_libro = nombre_libro;
        this.nombre_autor = nombre_autor;
        this.nombre_persona = nombre_persona;
        this.telefono_persona = telefono_persona;
    }

    public String getId_libro() {
        return id_libro;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getTelefono_persona() {
        return telefono_persona;
    }

    public void setTelefono_persona(String telefono_persona) {
        this.telefono_persona = telefono_persona;
    }
}
