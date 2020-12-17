/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.CRUDAutor;
import Model.Autor;
import Model.Pais;
import config.bd.ConectaBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author codsi
 */
public class AutorDao implements CRUDAutor{
 ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    public List listar() {
        List<Autor> autors = new ArrayList<>();
        
        try {
            con = cn.getConnection();
            pst = con.prepareStatement("SELECT * FROM autor");
            rs = pst.executeQuery();
            while (rs.next()) {
                Autor autor = new Autor();
                autor.setIdautor(rs.getInt("idautor"));
                autor.setNombre(rs.getString("nombre"));
                autor.setApellido(rs.getString("apellidos"));
                autors.add(autor);
            }
        } catch (Exception e) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(e.getMessage());
        }
        return autors;
    }

    @Override
    public Autor buscar(Autor a) {
        Autor bl = new Autor();
        String consulta = " select *  "
                + " from autor  "
                + " where idautor = " + a.getIdautor()+ " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                bl.setIdautor(rs.getInt("idautor"));
                bl.setNombre(rs.getString("nombre"));
                bl.setApellido(rs.getString("apellido"));
                bl.setNacionalidad(rs.getString("nacionalidad"));
                bl.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }

        return bl;
    }

    @Override
    public boolean agregar(Autor a) {
       String consulta = " INSERT INTO autor(nombre, apellido, nacionalidad, estado) "
                + " values( "
                + "'"+ a.getNombre() +"', "
                + "'"+ a.getApellido()+"', "
                + "'"+ a.getNacionalidad()+"', "
                + "'"+ a.getEstado() +"') ";
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
    public boolean editar(Autor a) {
         String consulta = " update autor "
                + " set "
                + " nombre = '"+ a.getNombre() +"', "
                + " apellido = '"+ a.getApellido()+"', "
                + " nacionalidad = '"+ a.getNacionalidad()+"', "
                + " estado = '"+ a.getEstado() +"' "
                + " where "
                + " idautor = " + a.getIdautor()+ "; ";
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
          String consulta = " delete from autor "
                + " where "
                + " idautor = " + id + "; ";
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
