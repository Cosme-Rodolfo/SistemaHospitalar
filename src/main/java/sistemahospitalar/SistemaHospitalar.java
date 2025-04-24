package sistemahospitalar;

import sistemahospitalar.views.TelaPrincipal;

public class SistemaHospitalar {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
}
