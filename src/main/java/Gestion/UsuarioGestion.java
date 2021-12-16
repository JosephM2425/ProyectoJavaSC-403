package Gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.Conexion;
import Modelos.Usuario;
import java.util.ArrayList;

public class UsuarioGestion {

    private static final String SQL_VALIDA = "select nombreUsuario,correoUsuario,edadUsuario from usuario where idUsuario=? and pwUsuario=?";

    
    public static Usuario Valida(int idUsuario, String pw) {

        Usuario usuario = null;

        try {

            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_VALIDA);
            sentencia.setInt(1, idUsuario);
            sentencia.setString(2, pw);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(idUsuario, rs.getString(1), rs.getString(2), rs.getString(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);

        }

        return usuario;
    }

    private static final String SQL_INSERT_USUARIO = "insert into usuario (idUsuario,nombreUsuario,correoUsuario,pwUsuario,edadUsuario) values (?,?,?,?,?)";

    public static boolean registrar(Usuario usuario) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_INSERT_USUARIO);
            sentencia.setInt(1, usuario.getIdUsuario());
            sentencia.setString(2, usuario.getNombreUsuario());
            sentencia.setString(3, usuario.getCorreoUsuario());
            sentencia.setString(4, usuario.getPwUsuario());
            sentencia.setString(5, usuario.getEdadUsuario());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
}
