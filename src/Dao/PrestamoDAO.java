/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.CRUDPrestamo;
import Model.Libro;
import Model.Prestamo;
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
public class PrestamoDAO implements CRUDPrestamo{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @Override
    public List listar(String type) {
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        String consulta = "SELECT * FROM prestamo p, usuario u, libro l WHERE p.idusuario = u.idusuario AND p.idlibro = l.idlibro AND p.estado = '"+type+"'";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Prestamo prest = new Prestamo();
                prest.setIdprestamo(rs.getInt("idprestamo"));
                prest.setFecha_prestamo(rs.getString("fecha_prestamo"));
                prest.setFecha_devolucion(rs.getString("fecha_devolucion"));
                prest.setUser_name(rs.getString("nombre")+" "+rs.getString("apellidos"));
                prest.setLibro_titulo(rs.getString("titulo"));
                prest.setEstado(rs.getString("p.estado"));
                prestamos.add(prest);
            }
        } catch (Exception e) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(e.getMessage());
        }
        return prestamos;
    }

    @Override
    public Prestamo buscar(Prestamo p) {
        Prestamo bl = new Prestamo();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement("select * from prestamo where idprestamo = "+p.getIdprestamo());
            rs = pst.executeQuery();
            while (rs.next()) {
                bl.setIdprestamo(rs.getInt("idprestamo"));
                bl.setIdlibro(rs.getInt("idlibro"));
                bl.setIdusuario(rs.getInt("idusuario"));
                bl.setEstado(rs.getString("estado"));
                bl.setFecha_prestamo(rs.getString("fecha_prestamo"));
                bl.setFecha_devolucion(rs.getString("fecha_devolucion"));

            }
        } catch (Exception e) {
        }

        return bl;
    }

    @Override
    public boolean agregar(Prestamo prestamo) {
              String consulta = " INSERT INTO `prestamo`(`fecha_prestamo`, `fecha_devolucion`, `estado`, `idusuario`, `idlibro`)  "
                + " values( "
                + "'"+ prestamo.getFecha_prestamo()+"', "
                + "'"+ prestamo.getFecha_devolucion()+"', "
                + "'"+ prestamo.getEstado()+"', "
                + "'"+ prestamo.getIdusuario()+"', "
                + "'"+ prestamo.getIdlibro()+"') ";
        
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
    public List ListByUser(int id) {
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        String consulta = "SELECT * FROM prestamo p, usuario u, libro l WHERE p.idusuario = u.idusuario AND p.idlibro = l.idlibro AND p.estado = 'P' AND p.idusuario = "+id+";";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Prestamo prest = new Prestamo();
                prest.setIdprestamo(rs.getInt("idprestamo"));
                prest.setFecha_prestamo(rs.getString("fecha_prestamo"));
                prest.setFecha_devolucion(rs.getString("fecha_devolucion"));
                prest.setUser_name(rs.getString("nombre")+" "+rs.getString("apellidos"));
                prest.setLibro_titulo(rs.getString("titulo"));
                prest.setEstado(rs.getString("p.estado"));
                prestamos.add(prest);
            }
        } catch (Exception e) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(e.getMessage());
        }
        return prestamos;
    }

    @Override
    public boolean editar(Prestamo p) {
       String consulta = " update prestamo "
                + " set "
                + " fecha_devolucion = '"+ p.getFecha_devolucion()+"', "
                + " estado = '"+ p.getEstado()+"'"
                + " where "
                + " idprestamo = " + p.getIdprestamo()+ "; ";
             
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
