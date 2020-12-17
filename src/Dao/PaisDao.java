/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.CRUDPais;
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
public class PaisDao implements CRUDPais{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    public List listar() {
        List<Pais> paises = new ArrayList<>();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement("SELECT * FROM pais");
            rs = pst.executeQuery();
            while (rs.next()) {
                Pais pais = new Pais();
                pais.setIdpais(rs.getInt("idpais"));
                pais.setNombre(rs.getString("nombre"));
                pais.setEstado(rs.getString("estado"));
                paises.add(pais);
            }
        } catch (Exception e) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(e.getMessage());
        }
        return paises;
    }

    @Override
    public Pais buscar(Pais p) {
       Pais bl = new Pais();
        String consulta = " select *  "
                + " from pais  "
                + " where idpais = " + p.getIdpais()+ " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                bl.setIdpais(rs.getInt("idpais"));
                bl.setNombre(rs.getString("nombre"));
                bl.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }

        return bl;
    }

    @Override
    public boolean agregar(Pais p) {
        String consulta = " INSERT INTO pais(nombre, estado)  "
                + " values( "
                + "'"+ p.getNombre() +"', "
                + "'"+ p.getEstado() +"') ";
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
    public boolean editar(Pais p) {
        String consulta = " update pais "
                + " set "
                + " nombre = '"+ p.getNombre() +"', "
                + " estado = '"+ p.getEstado() +"' "
                + " where "
                + " idpais = " + p.getIdpais()+ "; ";
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
         String consulta = " delete from pais "
                + " where "
                + " idpais = " + id + "; ";
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
