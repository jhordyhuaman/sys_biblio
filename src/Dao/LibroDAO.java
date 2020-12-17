package Dao;

import Interface.CRUDLibro;
import Model.Libro;
import config.bd.ConectaBd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO implements CRUDLibro {
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    public List listar() {
        ArrayList<Libro> libros = new ArrayList<>();
        String consulta = "select l.stock_disponibles, l.paginas, l.idlibro,l.titulo as nombre_libro,p.nombre as pais, a.apellidos as apellido_autor, a.nombre as nombre_autor, e.nombre as nombre_editorial, l.stock from libro l, autor a, editorial e, pais p where a.idautor = l.idautor and e.ideditorial = l.ideditorial and p.idpais = l.idpais";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setIdlibro(rs.getInt("idlibro"));
                libro.setNombre(rs.getString("nombre_libro"));
                libro.setPais(rs.getString("pais"));
                libro.setAutor(rs.getString("nombre_autor")+" "+rs.getString("apellido_autor"));
                libro.setEditorial(rs.getString("nombre_editorial"));
                libro.setStock(rs.getInt("stock"));
                libro.setCodigo(rs.getString("stock_disponibles"));
                libro.setEstado(rs.getString("paginas"));
                libros.add(libro);
            }
        } catch (Exception e) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(e.getMessage());
        }
        return libros;
    }

    @Override
    public Libro buscar(Libro libro) {
         Libro bl = new Libro();
         String consulta = "";
         if(libro.getIdlibro()== 0){
         consulta = "SELECT * FROM `libro` WHERE titulo LIKE '%"+libro.getNombre()+"%'";
         }else{
              consulta = " select *  "
                + " from libro  "
                + " where idlibro = " + libro.getIdlibro()+ " ;";
         }
        
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                bl.setIdlibro(rs.getInt("idlibro"));
                bl.setNombre(rs.getString("titulo"));
                bl.setCodigo(rs.getString("stock_disponibles"));
                bl.setISBN(rs.getString("isbn"));
                bl.setFecha_publicacion(rs.getString("paginas"));
                bl.setStock(rs.getInt("stock"));
                bl.setEstado(rs.getString("estado"));

            }
        } catch (Exception e) {
        }

        return bl;
    }

    @Override
    public boolean agregar(Libro libro) {
        String consulta = " INSERT INTO libro(nombre, codigo, ISBN, fecha_publicacion, stock, precio_compra, idautor, ideditorial, idpais, estado)  "
                + " values( "
                + "'"+ libro.getNombre() +"', "
                + "'"+ libro.getCodigo()+"', "
                + "'"+ libro.getISBN()+"', "
                + "'"+ libro.getFecha_publicacion()+"', "
                + "'"+ libro.getStock()+"', "
                + "'"+ libro.getPrecio_compra()+"', "
                + "'"+ libro.getIdautor()+"', "
                + "'"+ libro.getIdeditorial()+"', "
                + "'"+ libro.getPais()+"', "
                + "'"+ libro.getEstado() +"') ";
        
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean editar(Libro libro) {
        String consulta = " update libro "
                + " set "
                + " nombre = '"+ libro.getNombre() +"', "
                + " codigo = '"+ libro.getCodigo() +"', "
                + " ISBN = '"+ libro.getISBN()+"', "
                + " fecha_publicacion = '"+ libro.getFecha_publicacion()+"', "
                + " stock = '"+ libro.getStock()+"', "
                + " precio_compra = '"+ libro.getPrecio_compra()+"', "
                + " idautor = '"+ libro.getIdautor()+"', "
                + " ideditorial = '"+ libro.getIdeditorial()+"', "
                + " idpais = '"+ libro.getPais()+"', "
                + " estado = '"+ libro.getEstado() +"' "
                + " where "
                + " idlibro = " + libro.getIdlibro()+ "; ";
             

        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        String consulta = " delete from libro "
                + " where "
                + " idlibro = " + id + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

  

}
