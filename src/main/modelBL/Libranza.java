package main.modelBL;

/**
 *
 * @author Germán García
 */
public class Libranza {

    private int lbrIdPRIMARY;
    private int LbrIdCamapania;

    private String lbrCamapDescripcion;

    private String LbrEmpresa;
    private int LbrMesesPlazo;
    private float LbrTasaInteres;

    public Libranza(int lbrIdPRIMARY, int LbrIdCamapania, String lbrCamapDescripcion, String LbrEmpresa, int LbrMesesPlazo, float LbrTasaInteres) {
        this.lbrIdPRIMARY = lbrIdPRIMARY;
        this.LbrIdCamapania = LbrIdCamapania;
        this.lbrCamapDescripcion = lbrCamapDescripcion;
        this.LbrEmpresa = LbrEmpresa;
        this.LbrMesesPlazo = LbrMesesPlazo;
        this.LbrTasaInteres = LbrTasaInteres;
    }

    public int getLbrIdPRIMARY() {
        return lbrIdPRIMARY;
    }

    public void setLbrIdPRIMARY(int lbrIdPRIMARY) {
        this.lbrIdPRIMARY = lbrIdPRIMARY;
    }

    public int getLbrIdCamapania() {
        return LbrIdCamapania;
    }

    public void setLbrIdCamapania(int LbrIdCamapania) {
        this.LbrIdCamapania = LbrIdCamapania;
    }

    public String getLbrCamapDescripcion() {
        return lbrCamapDescripcion;
    }

    public String getLbrEmpresa() {
        return LbrEmpresa;
    }

    public void setLbrEmpresa(String LbrEmpresa) {
        this.LbrEmpresa = LbrEmpresa;
    }

    public int getLbrMesesPlazo() {
        return LbrMesesPlazo;
    }

    public void setLbrMesesPlazo(int LbrMesesPlazo) {
        this.LbrMesesPlazo = LbrMesesPlazo;
    }

    public float getLbrTasaInteres() {
        return LbrTasaInteres;
    }

    public void setLbrTasaInteres(float LbrTasaInteres) {
        this.LbrTasaInteres = LbrTasaInteres;
    }

    public Object[] toArray() {
        Object[] data = {LbrIdCamapania, LbrEmpresa, LbrMesesPlazo, LbrTasaInteres};
        return data;
    }

}
