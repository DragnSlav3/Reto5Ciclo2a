package main.Model;

/**
 *
 * @author Germán García
 */
public class Campania {
    
    private int cmpId;
    private String cmpDescripcion;
 
    private String nombreAsesp;
    private String nombreEmpresa;
    
    //contructor para tener el nombre del asesor
    public Campania(int cmpId, String cmpDescripcion, String nombreAsesp) {
        this.cmpId = cmpId;
        this.cmpDescripcion = cmpDescripcion;
        this.nombreAsesp = nombreAsesp;
    }
    //contructor para tener el nombre de la empresa
    public Campania(String nombreEmpresa, int cmpId, String cmpDescripcion) {
        this.cmpId = cmpId;
        this.cmpDescripcion = cmpDescripcion;
        this.nombreEmpresa = nombreEmpresa;
    }
    
    /*
    Constructor completo
    */
    public Campania(int cmpId, String cmpDescripcion) {
        this.cmpId = cmpId;
        this.cmpDescripcion = cmpDescripcion;
    }
    
    /*
    Constructor con solamente ID de Campaña
    */

    public Campania(int cmpId) {
        this.cmpId = cmpId;
    }

    /**
     * @return the cmpId
     */
    public int getCmpId() {
        return cmpId;
    }

    /**
     * @param cmpId the cmpId to set
     */
    public void setCmpId(int cmpId) {
        this.cmpId = cmpId;
    }

    /**
     * @return the cmpDescripcion
     */
    public String getCmpDescripcion() {
        return cmpDescripcion;
    }

    /**
     * @param cmpDescripcion the cmpDescripcion to set
     */
    public void setCmpDescripcion(String cmpDescripcion) {
        this.cmpDescripcion = cmpDescripcion;
    }

    /**
     * @return the nombreAsesp
     */
    public String getNombreAsesp() {
        return nombreAsesp;
    }

    /**
     * @return the nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public Object[] toArray(){
        Object[] data = {cmpId,cmpDescripcion};
        return data;
    }
    
    

}
