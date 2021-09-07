/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.accessDAL;

import main.modelBL.UsuarioModelBL;
import java.util.ArrayList;
import utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author COMPUMAX
 */
public class UsuarioDAO {

    private Connection conn = null;
//obtener todos los usuarios

    public ArrayList<UsuarioModelBL> obteneUsuarios() {
        ArrayList<UsuarioModelBL> usuarios = new ArrayList<UsuarioModelBL>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "select usr_alias AS \"ALIAS\", usr_nombres AS \"NOMBRES\", usr_apellidos AS \"APELLIDOS\", usr_email AS \"CORREO ELECTRONICO\", usr_celular AS \"CELULAR\", usr_clave AS \"CLAVE\", usr_fecha_nto AS \"FECHA DE NACIMIENTO\" from usuario order by  usr_alias;;";
            Statement statdatosconsul = conn.createStatement();
            ResultSet resultado = statdatosconsul.executeQuery(sql);
            while (resultado.next()) {
                UsuarioModelBL usuario = new UsuarioModelBL(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5), resultado.getString(6), resultado.getString(7));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
        }
        return usuarios;
    }

    //obtener un usuario espesifico por el alias
    public UsuarioModelBL obtenerusUsuario(String usrAlias) {
        UsuarioModelBL usuario = null;
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "select usr_alias AS \"ALIAS\", usr_nombres AS \"NOMBRES\", usr_apellidos AS \"APELLIDOS\", usr_email AS \"CORREO ELECTRONICO\", usr_celular AS \"CELULAR\", usr_clave AS \"CLAVE\", usr_fecha_nto AS \"FECHA DE NACIMIENTO\" from usuario\n"
                    + "where usr_alias = ?;";
            PreparedStatement consultadatos = conn.prepareStatement(sql);
            consultadatos.setString(1, usrAlias);
            ResultSet resultado = consultadatos.executeQuery();
            usuario = new UsuarioModelBL(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5), resultado.getString(6), resultado.getString(7));

        } catch (SQLException ex) {
        }
        return usuario;
    }

    //obtener usuarios por Nombre o apellido  la variable 1 para nombre o 2 para apellido
    public ArrayList<UsuarioModelBL> obtenerUsuarios(String consulta, int tipNoA) {
        ArrayList<UsuarioModelBL> usuarios = new ArrayList<UsuarioModelBL>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            System.out.println(tipNoA);

            if (tipNoA == 1) {
                //busqueda por nombre
                //System.out.println("hola m");
                String sql = "select usr_alias AS \"ALIAS\", usr_nombres AS \"NOMBRES\", usr_apellidos AS \"APELLIDOS\", usr_email AS \"CORREO ELECTRONICO\", usr_celular AS \"CELULAR\", usr_clave AS \"CLAVE\", usr_fecha_nto AS \"FECHA DE NACIMIENTO\" from usuario\n"
                        + "where usuario.usr_nombres like \"%" + consulta + "%\"\n"
                        + ";";

                PreparedStatement consultadatos = conn.prepareStatement(sql);
                /*
                System.out.println(consultadatos + "hola datos");
                System.out.println(consulta +" tipo"); 
                
                consultadatos.setString(1, "b");
                 */
                ResultSet resultado = consultadatos.executeQuery();
                System.out.println(resultado);
                while (resultado.next()) {
                    UsuarioModelBL usuario = new UsuarioModelBL(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5), resultado.getString(6), resultado.getString(7));
                    usuarios.add(usuario);
                }

            } else {
                //busqueda por apelldo
                String sql = "select usr_alias AS \"ALIAS\", usr_nombres AS \"NOMBRES\", usr_apellidos AS \"APELLIDOS\", usr_email AS \"CORREO ELECTRONICO\", usr_celular AS \"CELULAR\", usr_clave AS \"CLAVE\", usr_fecha_nto AS \"FECHA DE NACIMIENTO\" from usuario\n"
                        + "where usuario.usr_apellidos like \"%" + consulta + "%\"\n"
                        + ";";
                PreparedStatement consultadatos = conn.prepareStatement(sql);
                //  consultadatos.setString(0, consulta);
                ResultSet resultado = consultadatos.executeQuery();
                while (resultado.next()) {
                    UsuarioModelBL usuario = new UsuarioModelBL(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5), resultado.getString(6), resultado.getString(7));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException ex) {
        }
        return usuarios;
    }

    public void AgregarUsuario(UsuarioModelBL usuarioAgregar) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "insert into usuario(usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_clave, usr_fecha_nto) values (?, ?, ?, ?, ?, ?, ?); ";
            PreparedStatement stadatos = conn.prepareStatement(sql);
            stadatos.setString(1, usuarioAgregar.getUsrAlias());
            stadatos.setString(2, usuarioAgregar.getUsrNombres());
            stadatos.setString(3, usuarioAgregar.getUsrApellidos());
            stadatos.setString(4, usuarioAgregar.getUsrEmail());
            stadatos.setString(5, usuarioAgregar.getUsrCelular());
            stadatos.setString(6, usuarioAgregar.getUsrClave());
            stadatos.setString(7, usuarioAgregar.getUsrFechaNto());

            int NumerosRowsInserted = stadatos.executeUpdate();
            //opcional
            if (NumerosRowsInserted > 0) {
                System.out.println("Insercion exitosa " + NumerosRowsInserted);
            } else {
                System.out.println("No se pudo Insertar los datos ");
            }
        } catch (SQLException ex) {

        }
    }

    public void ActualizarUsuario(UsuarioModelBL usuarioActualizar, String aliasActual) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = " UPDATE usuario SET usr_alias = ?, usr_nombres = ?, usr_apellidos = ?, usr_email = ? , usr_celular = ?, usr_clave = ? ,usr_fecha_nto = ? WHERE usr_alias = ?;";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
            stadatosActualiza.setString(1, usuarioActualizar.getUsrAlias());
            stadatosActualiza.setString(2, usuarioActualizar.getUsrNombres());
            stadatosActualiza.setString(3, usuarioActualizar.getUsrApellidos());
            stadatosActualiza.setString(4, usuarioActualizar.getUsrEmail());
            stadatosActualiza.setString(5, usuarioActualizar.getUsrCelular());
            stadatosActualiza.setString(6, usuarioActualizar.getUsrClave());
            stadatosActualiza.setString(7, usuarioActualizar.getUsrFechaNto());
            stadatosActualiza.setString(8, aliasActual);

            int resulconsul = stadatosActualiza.executeUpdate();
            //OPCIONAL 
            if (resulconsul > 0) {
                System.out.println("Actualizacion exitosa " + resulconsul);
            } else {
                System.out.println("No se pudo Actuaizar los datos ");
            }

        } catch (SQLException ex) {
        }

    }

    public void EliminarUsuario(String UsuarioAlias) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "delete from usuario where usr_alias = ?;";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
            System.out.println("Estoy ");
            stadatosActualiza.setString(1, UsuarioAlias);

            int resulconsul = stadatosActualiza.executeUpdate();
            if (resulconsul > 0) {
                System.out.println("Se elimino el registro exitosamente " + resulconsul);
            } else {
                System.out.println("No se pudo eliminar el registro");
            }

        } catch (SQLException ex) {
        }

    }

    public void AgregarGerman(String strAgregar) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            PreparedStatement prstmnt = conn.prepareStatement(strAgregar);
            int re = prstmnt.executeUpdate();
            System.out.println("Usuario Agregado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
