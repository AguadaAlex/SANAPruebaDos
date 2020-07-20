package com.example.sanapruebados.Utilidades;

public class utilidades {
    //CONSTANTES CAMPOS TABLA DE USUARIO
    public static final String TABLA_USUARIO="usuarios";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_ROL="rol";
    public static final String CAMPO_NOMBREUSUARIO="nombreUsuario";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_PASSWORD="password";
    public static final String CAMPO_MAIL="mail";


    public  static final String CREAR_TABLA_USUARIO="CREATE TABLE "+""+TABLA_USUARIO+"("+CAMPO_ID+""+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_ROL+" INTEGER,"+CAMPO_NOMBREUSUARIO+" TEXT,"+CAMPO_NOMBRE+" TEXT,"+CAMPO_APELLIDO+" TEXT,"+CAMPO_PASSWORD+" TEXT,"+CAMPO_MAIL+" TEXT)";

    //CONSTANTES CAMPOS TABLA DE ADICCION
    public static final String TABLA_ADICCION="adicciones";
    public static final String CAMPO_ID_ADICCION="id";
    public static final String CAMPO_NOMBRE_ADICCION="nombre";
    public static final String CAMPO_DESCRIPCION_ADICCION="descripcion";
    public static final String CAMPO_IMAGEN_ADICCION="image";



    public  static final String CREAR_TABLA_ADICCION="CREATE TABLE "+""+TABLA_ADICCION+"("+CAMPO_ID_ADICCION+""+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_NOMBRE_ADICCION+" TEXT,"+CAMPO_DESCRIPCION_ADICCION+" TEXT,"+CAMPO_IMAGEN_ADICCION+" BLOG)";

    //CONSTANTES CAMPOS TABLA DE CENTRO
    public static final String TABLA_CENTRO="centros";
    public static final String CAMPO_ID_CENTRO="id";
    public static final String CAMPO_NOMBRE_CENTRO="nombre";
    public static final String CAMPO_DESCRIPCION_CENTRO="descripcion";
    public static final String CAMPO_IMAGEN_CENTRO="image";
    public static final String CAMPO_DIRECCION_CENTRO="direccion";


    public  static final String CREAR_TABLA_CENTRO="CREATE TABLE "+""+TABLA_CENTRO+"("+CAMPO_ID_CENTRO+""+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_NOMBRE_CENTRO+" TEXT,"+CAMPO_DESCRIPCION_CENTRO+" TEXT,"+CAMPO_IMAGEN_CENTRO+" BLOG,"+CAMPO_DIRECCION_CENTRO+" TEXT)";

    //CONSTANTES CAMPOS TABLA DE MOMENTO
    public static final String TABLA_MOMENTO="momentos";
    public static final String CAMPO_ID_MOMENTO="id";
    public static final String CAMPO_USUARIO_MOMENTO="usuario";
    public static final String CAMPO_ESTADO_MOMENTO="estado";
    public static final String CAMPO_DIRECCION_MOMENTO="direccion";
    public static final String CAMPO_LATITUD_MOMENTO="latitud";
    public static final String CAMPO_LONGITUD_MOMENTO="longitud";
    public static final String CAMPO_IMAGEN_MOMENTO="image";
    public static final String CAMPO_FECHA_MOMENTO="fecha";


    public  static final String CREAR_TABLA_MOMENTO="CREATE TABLE "+""+TABLA_MOMENTO+"("+CAMPO_ID_MOMENTO+""+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_USUARIO_MOMENTO+" TEXT,"+CAMPO_ESTADO_MOMENTO+" TEXT,"+CAMPO_DIRECCION_MOMENTO+" TEXT,"+CAMPO_LATITUD_MOMENTO+" TEXT,"+CAMPO_LONGITUD_MOMENTO+" TEXT,"+CAMPO_IMAGEN_MOMENTO+" BLOG,"+CAMPO_FECHA_MOMENTO+" TEXT)";
}

