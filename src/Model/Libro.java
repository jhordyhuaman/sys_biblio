/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author codsi
 */
public class Libro {
  private int idlibro;
  private String nombre;
  private String codigo;
  private String ISBN;
  private String fecha_publicacion;
  private int stock;
  private double precio_compra;
  private int idautor;
  private int ideditorial;	
  private String estado;
  private String pais;
  private String autor;
  private String editorial;

    public Libro() {
    }

    public Libro(String nombre) {
        this.nombre = nombre;
    }
    
    

    public Libro(int idlibro, String nombre, String codigo, String ISBN, String fecha_publicacion, int stock, double precio_compra, int idautor, int ideditorial, String estado, String autor, String editorial,String pais) {
        this.idlibro = idlibro;
        this.nombre = nombre;
        this.codigo = codigo;
        this.ISBN = ISBN;
        this.fecha_publicacion = fecha_publicacion;
        this.stock = stock;
        this.precio_compra = precio_compra;
        this.idautor = idautor;
        this.ideditorial = ideditorial;
        this.estado = estado;
        this.autor = autor;
        this.editorial = editorial;
        this.pais = pais;
    }
    public Libro(String nombre, String codigo, String ISBN, String fecha_publicacion, String stock,String  precio_compra,String  idautor, String ideditorial, String estado,String pais) {
        this.idlibro = idlibro;
        this.nombre = nombre;
        this.codigo = codigo;
        this.ISBN = ISBN;
        this.fecha_publicacion = fecha_publicacion;
        this.stock = Integer.parseInt(stock);
        this.precio_compra = Double.parseDouble(precio_compra);
        this.idautor = Integer.parseInt(idautor);
        this.ideditorial = Integer.parseInt(ideditorial);
        this.estado = estado;
        this.pais = pais;
    }
    
        public Libro(int id_libro,String nombre, String codigo, String ISBN, String fecha_publicacion, String stock,String  precio_compra,String  idautor, String ideditorial, String estado,String pais) {
        this.idlibro = id_libro;
        this.nombre = nombre;
        this.codigo = codigo;
        this.ISBN = ISBN;
        this.fecha_publicacion = fecha_publicacion;
        this.stock = Integer.parseInt(stock);
        this.precio_compra = Double.parseDouble(precio_compra);
        this.idautor = Integer.parseInt(idautor);
        this.ideditorial = Integer.parseInt(ideditorial);
        this.estado = estado;
        this.pais = pais;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    public int getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(int ideditorial) {
        this.ideditorial = ideditorial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
  
    
}
