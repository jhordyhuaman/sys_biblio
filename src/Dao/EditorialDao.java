/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.CRUDEditorial;
import Model.Editorial;
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
public class EditorialDao implements CRUDEditorial{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    public List listar() {
        List<Editorial> editorials = new ArrayList<>();
        
        try {
            con = cn.getConnection();
            pst = con.prepareStatement("SELECT * FROM `editorial` ORDER BY `editorial`.`nombre` ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Editorial editorial = new Editorial();
                editorial.setIdeditorial(rs.getInt("ideditorial"));
                editorial.setNombre(rs.getString("nombre"));
                editorial.setEstado(rs.getString("estado"));
                editorial.setCodigo(rs.getString("codigo"));
                editorial.setDireccion(rs.getString("direccion"));
                editorial.setUrl(rs.getString("url"));
                editorials.add(editorial);
            }
        } catch (Exception ex) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(ex.getMessage());
        }
        return editorials;
    }

    @Override
    public Editorial buscar(Editorial e) {
        Editorial bl = new Editorial();
        String consulta = " select *  "
                + " from editorial  "
                + " where ideditorial = " + e.getIdeditorial()+ " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                bl.setIdeditorial(rs.getInt("idbiblioteca"));
                bl.setNombre(rs.getString("nombre"));
                bl.setEstado(rs.getString("estado"));
                bl.setCodigo(rs.getString("codigo"));
                bl.setDireccion(rs.getString("direccion"));
                bl.setUrl(rs.getString("url"));
            }
        } catch (Exception ex) {
        }

        return bl;
    }

    @Override
    public boolean agregar(Editorial e) {
      String consulta = " insert into editorial(nombre estado codigo direccion url)  "
                + " values( "
                + "'"+ e.getNombre() +"', "
                + "'"+ e.getCodigo()+"', "
                + "'"+ e.getDireccion()+"', "
                + "'"+ e.getUrl()+"', "
                + "'"+ e.getEstado() +"') ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean editar(Editorial e) {
         String consulta = " update editorial "
                + " set "
                + " nombre = '"+ e.getNombre() +"', "
                 + " codigo = '"+ e.getCodigo()+"', "
                 + " direccion = '"+ e.getDireccion()+"', "
                 + " url = '"+ e.getUrl()+"', "
                + " estado = '"+ e.getEstado() +"' "
                + " where "
                + " ideditorial = " + e.getIdeditorial()+ "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        }catch(Exception ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(int id) {
         String consulta = " delete from editorial "
                + " where "
                + " ideditorial = " + id + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
}
