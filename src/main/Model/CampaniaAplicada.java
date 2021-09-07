package main.Model;

/**
 *
 * @author COMPUMAX
 */
public class CampaniaAplicada {

    private int cpaAppId;
    private String cpaUsuario;
    private String CpaCampania;
    private String cpaAppFecha;

    private int IdcpaCampania;
    private String nombreAsesor;
    private String NombreEmpresa;
    private String cpaUsuari_ID;


    /*
    Constructor básico
     */
    public CampaniaAplicada(int cpaAppId, String cpaUsuario, String CpaCampania, String cpaAppFecha, int IdcpaCampania, String cpaUsuari_ID) {
        this.cpaAppId = cpaAppId;
        this.cpaUsuario = cpaUsuario;
        this.CpaCampania = CpaCampania;
        this.cpaAppFecha = cpaAppFecha;
        this.IdcpaCampania = IdcpaCampania;
        this.cpaUsuari_ID = cpaUsuari_ID;
    }


    /*
    Constructor para Créditos de consumo
     */
    public CampaniaAplicada(int cpaAppId, String cpaUsuario, String CpaCampania, String cpaAppFecha, int IdcpaCampania, String nombreAsesor, String cpaUsuari_ID) {
        this.cpaAppId = cpaAppId;
        this.cpaUsuario = cpaUsuario;
        this.CpaCampania = CpaCampania;
        this.cpaAppFecha = cpaAppFecha;
        this.IdcpaCampania = IdcpaCampania;
        this.nombreAsesor = nombreAsesor;
        this.cpaUsuari_ID = cpaUsuari_ID;
    }

    public Object[] toArrayconsumo() {
        Object[] data = {cpaAppId, cpaUsuario, CpaCampania, nombreAsesor, cpaAppFecha, cpaUsuari_ID, IdcpaCampania};
        return data;
    }

    /*
    Constructor para Créditos de Libranza
     */
    public CampaniaAplicada(int cpaAppId, String cpaUsuario, String CpaCampania, String cpaAppFecha, String NombreEmpresa, int IdcpaCampania, String cpaUsuari_ID) {
        this.cpaAppId = cpaAppId;
        this.cpaUsuario = cpaUsuario;
        this.CpaCampania = CpaCampania;
        this.cpaAppFecha = cpaAppFecha;
        this.NombreEmpresa = NombreEmpresa;
        this.IdcpaCampania = IdcpaCampania;
        this.cpaUsuari_ID = cpaUsuari_ID;
    }

    public Object[] toArraylibranza() {
        Object[] data = {cpaAppId, cpaUsuario, CpaCampania, NombreEmpresa, cpaAppFecha, cpaUsuari_ID, IdcpaCampania};
        return data;
    }

    /**
     * @return the cpaAppId
     */
    public int getCpaAppId() {
        return cpaAppId;
    }

    /**
     * @param cpaAppId the cpaAppId to set
     */
    public void setCpaAppId(int cpaAppId) {
        this.cpaAppId = cpaAppId;
    }

    /**
     * @return the cpaUsuario
     */
    public String getCpaUsuario() {
        return cpaUsuario;
    }

    /**
     * @return the CpaCampania
     */
    public String getCpaCampania() {
        return CpaCampania;
    }

    /**
     * @return the cpaAppFecha
     */
    public String getCpaAppFecha() {
        return cpaAppFecha;
    }

    /**
     * @param cpaAppFecha the cpaAppFecha to set
     */
    public void setCpaAppFecha(String cpaAppFecha) {
        this.cpaAppFecha = cpaAppFecha;
    }

    /**
     * @return the IdcpaCampania
     */
    public int getIdcpaCampania() {
        return IdcpaCampania;
    }

    /**
     * @param IdcpaCampania the IdcpaCampania to set
     */
    public void setIdcpaCampania(int IdcpaCampania) {
        this.IdcpaCampania = IdcpaCampania;
    }

    /**
     * @return the nombreAsesor
     */
    public String getNombreAsesor() {
        return nombreAsesor;
    }

    /**
     * @return the NombreEmpresa
     */
    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    /**
     * @return the cpaUsuari_ID
     */
    public String getCpaUsuari_ID() {
        return cpaUsuari_ID;
    }

    /**
     * @param cpaUsuari_ID the cpaUsuari_ID to set
     */
    public void setCpaUsuari_ID(String cpaUsuari_ID) {
        this.cpaUsuari_ID = cpaUsuari_ID;
    }

    public Object[] toArray() {
        Object[] data = {cpaAppId, cpaUsuario, CpaCampania, cpaAppFecha, IdcpaCampania, cpaUsuari_ID};
        return data;
    }

}
