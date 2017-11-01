package com.sebastian.practica_6_sqlite.Entidades;

/**
 * Created by Usuario on 1/11/2017.
 */

public class Usuario {
    private Integer id;
    private String nombre_autor;
    private String telefono;
    private String  nombre_libro;
    private String noobre_usuario;

    public Usuario(Integer id, String nombre_autor, String telefono, String nombre_libro, String noobre_usuario) {
        this.id = id;
        this.nombre_autor = nombre_autor;
        this.telefono = telefono;
        this.nombre_libro = nombre_libro;
        this.noobre_usuario = noobre_usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public String getNoobre_usuario() {
        return noobre_usuario;
    }

    public void setNoobre_usuario(String noobre_usuario) {
        this.noobre_usuario = noobre_usuario;
    }
}
