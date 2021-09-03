package main.accessDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.ConnectionDB;
import main.modelBL.*;

/**
 *
 * @author Gabo
 */
public class ConsumoDAO {

    private Connection conn = null;
//obtener todos los creditos de consumo 

    public ArrayList<Consumo> obtenerConsumos() {
        ArrayList<Consumo> creditoconsumo = new ArrayList<Consumo>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT csm_idprimary as \"LLAVE PRINCIPAL\",campania.cmp_descripcion as \"DESCRPCION DE CAMPAÑA \",concat(asesor_comercial.asr_nombres , concat(\" \", asesor_comercial.asr_apellidos) ) as \"NOMBRE ASESOR\",csm_cuotas AS \"NUMERO DE CUOTAS \",csm_tasa_interes AS \"TASA DE INTERES\" ,\n"
                    + "csm_id as \"ID CAMPAÑA\",csm_asesor as \"ID ASESOR\"FROM consumo\n"
                    + "join campania on consumo.csm_id = campania.cmp_id\n"
                    + "join asesor_comercial on  consumo.csm_asesor = asesor_comercial.asr_id\n"
                    + ";";
            Statement statdatosconsul = conn.createStatement();
            ResultSet resultado = statdatosconsul.executeQuery(sql);
            while (resultado.next()) {
                Consumo consumocre = new Consumo(resultado.getInt(1), resultado.getInt(2), resultado.getInt(4), resultado.getFloat(5), resultado.getInt(7), resultado.getString(2), resultado.getString(3));
                creditoconsumo.add(consumocre);
            }

        } catch (SQLException ex) {
        }
        return creditoconsumo;
    }

    //obtener un consumpo espesifico por la llave principal
    public Consumo obtenerusconsumo(int CsmIdPrimary) {
        Consumo consumocre = null;
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT csm_idprimary as \"LLAVE PRINCIPAL\",campania.cmp_descripcion as \"DESCRPCION DE CAMPAÑA \",concat(asesor_comercial.asr_nombres , concat(\" \", asesor_comercial.asr_apellidos) ) as \"NOMBRE ASESOR\",csm_cuotas AS \"NUMERO DE CUOTAS \",csm_tasa_interes AS \"TASA DE INTERES\" ,\n"
                    + "csm_id as \"ID CAMPAÑA\",csm_asesor as \"ID ASESOR\"FROM consumo\n"
                    + "join campania on consumo.csm_id = campania.cmp_id\n"
                    + "join asesor_comercial on  consumo.csm_asesor = asesor_comercial.asr_id where csm_idprimary = ?;\n"
                    + ";";
            PreparedStatement consultadatos = conn.prepareStatement(sql);
            consultadatos.setInt(0, CsmIdPrimary);
            ResultSet resultado = consultadatos.executeQuery();
            consumocre = new Consumo(resultado.getInt(1), resultado.getInt(2), resultado.getInt(4), resultado.getFloat(5), resultado.getInt(7), resultado.getString(2), resultado.getString(3));

        } catch (SQLException ex) {
        }
        return consumocre;
    }

    public void AgregarConsumo(Consumo Agregarconsu) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "insert into consumo(csm_id , csm_asesor, csm_cuotas, csm_tasa_interes) values (?,?,?,?); ";
            PreparedStatement stadatos = conn.prepareStatement(sql);
            stadatos.setInt(0, Agregarconsu.getCsmId());
            stadatos.setInt(1, Agregarconsu.getCsmAsesor());
            stadatos.setInt(2, Agregarconsu.getCsmCuotas());
            stadatos.setFloat(0, Agregarconsu.getCsmTasaInteres());

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

    public void ActualizarConsumo(Consumo Actualizarconsumo) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "UPDATE consumo SET csm_idprimary = ? , csm_id = ?, csm_asesor = ?, csm_cuotas = ?, csm_tasa_interes = ? where csm_idprimary = ?;";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
            stadatosActualiza.setInt(0, Actualizarconsumo.getCsmIdPrimary());
            stadatosActualiza.setInt(1, Actualizarconsumo.getCsmId());
            stadatosActualiza.setInt(2, Actualizarconsumo.getCsmAsesor());
            stadatosActualiza.setInt(3, Actualizarconsumo.getCsmCuotas());
            stadatosActualiza.setFloat(4, Actualizarconsumo.getCsmTasaInteres());
            stadatosActualiza.setInt(5, Actualizarconsumo.getCsmIdPrimary());

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

    public void EliminarConsumo(Consumo eliminarcons) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "DELETE FROM consumo WHERE csm_idprimary = ?;";
            PreparedStatement stadatosActualiza = conn.prepareStatement(sql);
            stadatosActualiza.setInt(0,eliminarcons.getCsmIdPrimary());

            int resulconsul = stadatosActualiza.executeUpdate();
            if (resulconsul > 0) {
                System.out.println("Se elimino el registro exitosamente " + resulconsul);
            } else {
                System.out.println("No se pudo eliminar el registro");
            }

        } catch (SQLException ex) {
        }

    }

}
