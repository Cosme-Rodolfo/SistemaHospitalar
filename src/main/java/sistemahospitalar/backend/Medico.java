
package sistemahospitalar.backend;

import java.time.LocalDate;
import java.util.List;



public class Medico extends AtendenteHospitalar {

    private int idMedico;
    private int numeroCRM;
    private List<String> areasEspecialidade;
    private boolean cirurgiao;

    public Medico(String nomeCompleto, LocalDate dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero, int numeroCRM, List<String> areasEspecialidade, boolean cirurgiao, String setor, int chSemanais) {
        super(nomeCompleto, dataNascimento, endereco, contato, genero, setor, chSemanais);
        this.idMedico = GrupoMedico.getGrupo().size();
        this.numeroCRM = numeroCRM;
        this.areasEspecialidade = areasEspecialidade;
        this.cirurgiao = cirurgiao;
    }


    // Getters e Setters
    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getNumeroCRM() {
        return numeroCRM;
    }

    public void setNumeroCRM(int numeroCRM) {
        this.numeroCRM = numeroCRM;
    }

    public List<String> getAreasEspecialidade() {
        return areasEspecialidade;
    }

    public void setAreasEspecialidade(List<String> areasEspecialidade) {
        this.areasEspecialidade = areasEspecialidade;
    }

    public boolean isCirurgiao() {
        return cirurgiao;
    }

    public void setCirurgiao(boolean cirurgiao) {
        this.cirurgiao = cirurgiao;
    }
}
