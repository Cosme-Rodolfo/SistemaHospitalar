/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalar.backend;

/**
 *
 * @author caiod
 */
import sistemahospitalar.backend.Responsavel;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente extends DadoPessoal {

    private int idPaciente;
    private int idade;
    private Date dataCadastro;
    private String obsGeral;
    private List<ConsultaMedica> historicoConsultasMedica;
    public List<Responsavel> listaResponsaveis;

    public Paciente(String nomeCompleto, LocalDate dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero, Date dataCadastro, String obsGeral) {
        super(nomeCompleto, dataNascimento, endereco, contato, genero); 
        this.idPaciente = GrupoPaciente.getGrupo().size();
        this.dataCadastro = dataCadastro;
        this.obsGeral = obsGeral;
        this.historicoConsultasMedica =  new ArrayList<>();
        calcularIdade(dataNascimento); // Calcula a idade a partir da data de nascimento
        this.listaResponsaveis = new ArrayList<>();
    }


    // Método para calcular a idade a partir da data de nascimento
    private void calcularIdade(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataNascimento, hoje);
        this.idade = periodo.getYears();
    }

    // Getters e Setters
    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int id) {
        this.idPaciente=id;
    }
    
    public int getIdade() {
        return idade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObsGeral() {
        return obsGeral;
    }

    public void setObsGeral(String obsGeral) {
        this.obsGeral = obsGeral;
    }

    public List<ConsultaMedica> getHistoricoConsultasMedica() {
        return historicoConsultasMedica;
    }

    public void setHistoricoConsultasMedica(List<ConsultaMedica> historicoConsultasMedica) {
        this.historicoConsultasMedica = historicoConsultasMedica;
    }
    
    public void addAoHistoricoDeConsultas(ConsultaMedica consulta) {
        this.historicoConsultasMedica.add(consulta);
    }
    public void rmDoHistoricoDeConsultas(int i) {
        this.historicoConsultasMedica.remove(i);
    }
    
    public List<Responsavel> getResponsaveis(){
        return listaResponsaveis;
    }
     public void setResponsaveis(List<Responsavel> responsaveis){
        this.listaResponsaveis = responsaveis;
    }
    
    public void addResponsavel(Responsavel responsavel) {
        listaResponsaveis.add(responsavel);
    }
    
}
