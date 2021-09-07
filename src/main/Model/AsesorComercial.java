package main.Model;

/**
 *
 * @author Germán García
 */
public class AsesorComercial {

    private int AsrId;
    private String AsrNombres;
    private String AsrApellidos;
    private String AsrSucursalBancaria;

    public AsesorComercial(int AsrId, String AsrNombres, String AsrApellidos, String AsrSucursalBancaria) {
        this.AsrId = AsrId;
        this.AsrNombres = AsrNombres;
        this.AsrApellidos = AsrApellidos;
        this.AsrSucursalBancaria = AsrSucursalBancaria;
    }

    public String getAsrSucursalBancaria() {
        return AsrSucursalBancaria;
    }

    public void setAsrSucursalBancaria(String AsrSucursalBancaria) {
        this.AsrSucursalBancaria = AsrSucursalBancaria;
    }

    public int getAsrId() {
        return AsrId;
    }

    public void setAsrId(int AsrId) {
        this.AsrId = AsrId;
    }

    public String getAsrNombres() {
        return AsrNombres;
    }

    public void setAsrNombres(String AsrNombres) {
        this.AsrNombres = AsrNombres;
    }

    public String getAsrApellidos() {
        return AsrApellidos;
    }

    public void setAsrApellidos(String AsrApellidos) {
        this.AsrApellidos = AsrApellidos;
    }

    public Object[] toArray() {
        Object[] data = {AsrId, AsrNombres, AsrApellidos, AsrSucursalBancaria};
        return data;
    }

}
