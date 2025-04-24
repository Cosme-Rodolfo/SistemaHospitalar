
package sistemahospitalar.backend;

import java.time.LocalDate;

public class Enfermeiro extends AtendenteHospitalar {

    private int idEnfermeiro;
    private boolean treinadoOpRx;

    public Enfermeiro(String nomeCompleto, LocalDate dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero, boolean treinadoOpRx, String setor, int chSemanais) {
        super(nomeCompleto, dataNascimento, endereco, contato, genero, setor, chSemanais);
        this.idEnfermeiro = GrupoEnfermeiro.getGrupo().size();
        this.treinadoOpRx = treinadoOpRx;
    }


    // Getters e Setters
    public int getIdEnfermeiro() {
        return idEnfermeiro;
    }

    public void setIdEnfermeiro(int idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }

    public boolean isTreinadoOpRx() {
        return treinadoOpRx;
    }

    public void setTreinadoOpRx(boolean treinadoOpRx) {
        this.treinadoOpRx = treinadoOpRx;
    }
}

