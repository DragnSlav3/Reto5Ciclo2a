package main.Inicialdata;


import java.util.*;
import main.accessDAL.AsesorComercialDAO;
import main.accessDAL.CampaniaDAO;
import main.accessDAL.CampaniasAppDAO;
import main.accessDAL.ConsumoDAO;
import main.accessDAL.LibranzaDAO;
import main.accessDAL.UsuarioDAO;
import main.modelBL.*;

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
    private ArrayList<UsuarioModelBL> usuarios = null;
    private UsuarioModelBL usuarioAgregar = null;
     private ArrayList<UsuarioModelBL> usuariobuscar = null;
     private ArrayList<CampaniaAplicada> consultaConsumo = null;
    
    public InitialData(){
        CampaniasAppDAO campaniasAppDAS = new CampaniasAppDAO();
        this.campaniasAplicadas = campaniasAppDAS.obtenerCampaniasApli("");
        //this.campaniasAplicadas.add(0, new CampaniaAplicada(-1, "Todos usuarios", "Descripciones", "Todas fechas", -1, "Alias usuarios"));
        //GENERAL
        this.consultaConsumo = campaniasAppDAS.obtenerCampaniasApli("consumo");
        
        
        CampaniaDAO campaniaDAS= new CampaniaDAO();
        this.campanias = campaniaDAS.obtenerCampania();
        
        UsuarioDAO usuarioDAS = new UsuarioDAO();
        this.usuarios = usuarioDAS.obteneUsuarios();
        
        ConsumoDAO consumoDAO = new ConsumoDAO();
        this.consumos = consumoDAO.obtenerConsumos();
        
        AsesorComercialDAO asesorComercialDAO = new AsesorComercialDAO();
        this.asesores= asesorComercialDAO.obteneAsesorComercial();
       
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

    public ArrayList<UsuarioModelBL> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<UsuarioModelBL> usuarios) {
        this.usuarios = usuarios;
    }
    public void setUsuarioAgregar(UsuarioModelBL usuario){
     UsuarioDAO usuarioDAS = new UsuarioDAO();
     usuarioDAS.AgregarUsuario(usuarioAgregar);
    
    }
    public ArrayList<UsuarioModelBL> getusuariobuscar(String usrAlias){
     UsuarioDAO usuarioDAS = new UsuarioDAO();
     int numero = 1;
       
    this.usuariobuscar=usuarioDAS.obtenerUsuarios(usrAlias, numero);
     return  usuariobuscar;
    
    }

    public ArrayList<CampaniaAplicada> getConsultaConsumo() {
        return consultaConsumo;
    }

    public void setConsultaConsumo(ArrayList<CampaniaAplicada> consultaConsumo) {
        this.consultaConsumo = consultaConsumo;
    }
    
    
    
}
