package sistemahospitalar.backend;

import java.time.LocalDate;

public class AtendenteHospitalar extends DadoPessoal {
    private String setor;
    private int chSemanais;

    // Construtor padrão
    public AtendenteHospitalar() {
        super("", LocalDate.now(), new Endereco("", 0, "", "", "", 0), new ContatoTelEmail("", "", ""), Genero.M);
        this.setor = "";
        this.chSemanais = 0;
    }

    // Construtor com parâmetros
    public AtendenteHospitalar(String nomeCompleto, LocalDate dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero, String setor, int chSemanais) {
        super(nomeCompleto, dataNascimento, endereco, contato, genero);
        this.setor = setor;
        this.chSemanais = chSemanais;
    }

    // Getters e Setters
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getChSemanais() {
        return chSemanais;
    }

    public void setChSemanais(int chSemanais) {
        this.chSemanais = chSemanais;
    }
}
