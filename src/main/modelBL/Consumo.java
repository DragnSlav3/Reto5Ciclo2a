package main.modelBL;

/**
 *
 * @author Germán García
 */
public class Consumo {
    private  int CsmIdPrimary;
    private int CsmId;
    private int CsmCuotas;
    private float CsmTasaInteres;    
    private int CsmAsesor;
    
    //opconales
     private  String CmpDescripcion;
     private  String AsrNombre;
     
     //contructor basico

    public Consumo(int CsmIdPrimary, int CsmId, int CsmCuotas, float CsmTasaInteres, int CsmAsesor) {
        this.CsmIdPrimary = CsmIdPrimary;
        this.CsmId = CsmId;
        this.CsmCuotas = CsmCuotas;
        this.CsmTasaInteres = CsmTasaInteres;
        this.CsmAsesor = CsmAsesor;
    }
     
    //contrutor Armado que trae datos de la tabla usuario y campaña

    public Consumo(int CsmIdPrimary, int CsmId, int CsmCuotas, float CsmTasaInteres, int CsmAsesor, String CmpDescripcion, String AsrNombre) {
        this.CsmIdPrimary = CsmIdPrimary;
        this.CsmId = CsmId;
        this.CsmCuotas = CsmCuotas;
        this.CsmTasaInteres = CsmTasaInteres;
        this.CsmAsesor = CsmAsesor;
        this.CmpDescripcion = CmpDescripcion;
        this.AsrNombre = AsrNombre;
    }

    
    public int getCsmIdPrimary() {
        return CsmIdPrimary;
    }

    public void setCsmIdPrimary(int CsmIdPrimary) {
        this.CsmIdPrimary = CsmIdPrimary;
    }

    public int getCsmId() {
        return CsmId;
    }

    public void setCsmId(int CsmId) {
        this.CsmId = CsmId;
    }

    public int getCsmCuotas() {
        return CsmCuotas;
    }

    public void setCsmCuotas(int CsmCuotas) {
        this.CsmCuotas = CsmCuotas;
    }

    public float getCsmTasaInteres() {
        return CsmTasaInteres;
    }

    public void setCsmTasaInteres(float CsmTasaInteres) {
        this.CsmTasaInteres = CsmTasaInteres;
    }

    public int getCsmAsesor() {
        return CsmAsesor;
    }

    public void setCsmAsesor(int CsmAsesor) {
        this.CsmAsesor = CsmAsesor;
    }
    
    
             

  
}
