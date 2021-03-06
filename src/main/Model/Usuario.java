package main.Model;

/**
 *
 * @author Germán García
 */
public class Usuario {

    private String usrAlias;
    private String usrNombres;
    private String usrApellidos;
    private String usrEmail;
    private String usrCelular;
    private String usrClave;
    private String usrFechaNto;

    
    /*
    Constructor básico
    */
    public Usuario(String usrAlias, String usrNombres, String usrApellidos) {
        this.usrAlias = usrAlias;
        this.usrNombres = usrNombres;
        this.usrApellidos = usrApellidos;
    }
    
    /*
    Constructor completo
    */

    public Usuario(String usrAlias, String usrNombres, String usrApellidos, String usrEmail, String usrCelular, String usrClave, String usrFechaNto) {
        this.usrAlias = usrAlias;
        this.usrNombres = usrNombres;
        this.usrApellidos = usrApellidos;
        this.usrEmail = usrEmail;
        this.usrCelular = usrCelular;
        this.usrClave = usrClave;
        this.usrFechaNto = usrFechaNto;
    }

    
    
    public String getUsrAlias() {
        return usrAlias;
    }

 
    public void setUsrAlias(String usrAlias) {
        this.usrAlias = usrAlias;
    }

  
    public String getUsrNombres() {
        return usrNombres;
    }

 
    public void setUsrNombres(String usrNombres) {
        this.usrNombres = usrNombres;
    }


    public String getUsrApellidos() {
        return usrApellidos;
    }


    public void setUsrApellidos(String usrApellidos) {
        this.usrApellidos = usrApellidos;
    }

    public String getUsrEmail() {
        return usrEmail;
    }
    
    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrCelular() {
        return usrCelular;
    }

    public void setUsrCelular(String usrCelular) {
        this.usrCelular = usrCelular;
    }

   
    public String getUsrClave() {
        return usrClave;
    }

    public void setUsrClave(String usrClave) {
        this.usrClave = usrClave;
    }

    
    public String getUsrFechaNto() {
        return usrFechaNto;
    }

    public void setUsrFechaNto(String usrFechaNto) {
        this.usrFechaNto = usrFechaNto;
    }   
      public Object[] toArray(){
        Object[] data = {usrAlias, usrNombres, usrApellidos, usrEmail, usrCelular, usrClave, usrFechaNto};
        return data;
    }
}
