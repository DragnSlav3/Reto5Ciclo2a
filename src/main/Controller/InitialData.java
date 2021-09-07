package main.Controller;

import java.util.ArrayList;
import main.Model.AsesorComercial;
import main.Model.Campania;
import main.Model.Usuario;
import main.Model.Libranza;
import main.Model.Consumo;
import main.Model.CampaniaAplicada;
import main.Access.AsesorComercialDAO;
import main.Access.CampaniaDAO;
import main.Access.CampaniasAppDAO;
import main.Access.ConsumoDAO;
import main.Access.LibranzaDAO;
import main.Access.UsuarioDAO;

/**
 *
 * @author Germán García
 */
public class InitialData {

    private ArrayList<AsesorComercial> asesores = null;
    private ArrayList<Campania> campanias = null;
    private ArrayList<CampaniaAplicada> campaniasAplicadas = null;
    private ArrayList<Consumo> consumos = null;
    private ArrayList<Libranza> libranzas = null;
    private ArrayList<Usuario> usuarios = null;
    private Usuario usuarioAgregar = null;
    private ArrayList<Usuario> usuariobuscar = null;
    private ArrayList<CampaniaAplicada> consultaConsumo = null;
    private ArrayList<CampaniaAplicada> consultaLibranza = null;

    public InitialData() {
        CampaniasAppDAO campaniasAppDAS = new CampaniasAppDAO();
        this.campaniasAplicadas = campaniasAppDAS.obtenerCampaniasApli("");
        //this.campaniasAplicadas.add(0, new CampaniaAplicada(-1, "Todos usuarios", "Descripciones", "Todas fechas", -1, "Alias usuarios"));
        //GENERAL
        this.consultaConsumo = campaniasAppDAS.obtenerCampaniasApli("consumo");
        this.consultaLibranza = campaniasAppDAS.obtenerCampaniasApli("libranza");

        CampaniaDAO campaniaDAS = new CampaniaDAO();
        this.campanias = campaniaDAS.obtenerCampania();

        UsuarioDAO usuarioDAS = new UsuarioDAO();
        this.usuarios = usuarioDAS.obteneUsuarios();

        ConsumoDAO consumoDAO = new ConsumoDAO();
        this.consumos = consumoDAO.obtenerConsumos();

        AsesorComercialDAO asesorComercialDAO = new AsesorComercialDAO();
        this.asesores = asesorComercialDAO.obteneAsesorComercial();

        LibranzaDAO libranzaDAO = new LibranzaDAO();
        this.libranzas = libranzaDAO.obtenerlLibranza();

    }

    public ArrayList<AsesorComercial> getAsesores() {
        return asesores;
    }

    public void setAsesores(ArrayList<AsesorComercial> asesores) {
        this.asesores = asesores;
    }

    public ArrayList<Campania> getCampanias() {
        return campanias;
    }

    public void setCampanias(ArrayList<Campania> campanias) {
        this.campanias = campanias;
    }

    public ArrayList<CampaniaAplicada> getCampaniasAplicadas() {
        return campaniasAplicadas;
    }

    public void setCampaniasAplicadas(ArrayList<CampaniaAplicada> campaniasAplicadas) {
        this.campaniasAplicadas = campaniasAplicadas;
    }

    public ArrayList<Consumo> getConsumos() {
        return consumos;
    }

    public void setConsumos(ArrayList<Consumo> consumos) {
        this.consumos = consumos;
    }

    public ArrayList<Libranza> getLibranzas() {
        return libranzas;
    }

    public void setLibranzas(ArrayList<Libranza> libranzas) {
        this.libranzas = libranzas;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setUsuarioAgregar(Usuario usuario) {
        UsuarioDAO usuarioDAS = new UsuarioDAO();
        usuarioDAS.AgregarUsuario(usuarioAgregar);

    }

    public ArrayList<Usuario> getusuariobuscar(String usrAlias) {
        UsuarioDAO usuarioDAS = new UsuarioDAO();
        int numero = 1;

        this.usuariobuscar = usuarioDAS.obtenerUsuarios(usrAlias, numero);
        return usuariobuscar;

    }

    public ArrayList<CampaniaAplicada> getConsultaConsumo() {
        return consultaConsumo;
    }

    public void setConsultaConsumo(ArrayList<CampaniaAplicada> consultaConsumo) {
        this.consultaConsumo = consultaConsumo;
    }

    public ArrayList<CampaniaAplicada> getConsultaLibranza() {
        return consultaLibranza;
    }

    public void setConsultaLibranza(ArrayList<CampaniaAplicada> consultaLibranza) {
        this.consultaLibranza = consultaLibranza;
    }

}
