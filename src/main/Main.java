package main;
import main.Inicialdata.*;

import main.modelBL.*;
import main.view.*;

/**
 *
 * @author Germán García
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TabbedPane InterfasPane = new TabbedPane();
        ControlerIntefazTabla controv = new ControlerIntefazTabla(InterfasPane);
        controv.iniciarVista();
        
        InterfasPane.setVisible(true);
    }
    
}
