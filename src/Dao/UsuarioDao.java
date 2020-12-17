/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.CRUDUser;
import Model.Usuario;
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
public class UsuarioDao implements CRUDUser{
ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    public List listar() {
        ArrayList<Usuario> models = new ArrayList<>();
        String consulta = "SELECT * FROM `usuario` ORDER BY `usuario`.`nombre` ASC";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario model = new Usuario();
                model.setIdusuario(rs.getInt("idusuario"));
                model.setNombre(rs.getString("nombre"));
                model.setApellidos(rs.getString("apellidos"));
                model.setDni(rs.getString("dni"));
                model.setEstado(rs.getString("estado"));
                models.add(model);
            }
        } catch (Exception e) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(e.getMessage());
        }
        return models;
        
    }

    @Override
    public Usuario buscar(Usuario user) {
       Usuario bl = new Usuario();
       String consulta = "";
       if(user.getIdusuario()== 0){
        consulta = " select *  "
                + " from usuario  "
                + " where dni = " + user.getDni()+ " ;";    
       }else{
        consulta = " select *  "
                + " from usuario  "
                + " where idusuario = " + user.getIdusuario()+ " ;";
       }
            
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                bl.setIdusuario(rs.getInt("idusuario"));
                bl.setNombre(rs.getString("nombre"));
                bl.setApellidos(rs.getString("apellidos"));
                bl.setDni(rs.getString("dni"));
                bl.setEstado(rs.getString("estado"));
            }
        } catch (Exception ex) {
        }

        return bl;
    }

    @Override
    public boolean agregar(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
