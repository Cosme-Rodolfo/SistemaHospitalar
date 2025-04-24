package sistemahospitalar.backend;

public class ConsultaMedica {
    private int idConsulta;
    private int idPaciente;
    private int idMedico;
    private String exameQueixa;
    private String diagnostico;
    private String prescricao;
    private boolean indicacaoCirurgia;

    public ConsultaMedica(int idPaciente, int idMedico, String exameQueixa, String diagnostico, String prescricao, boolean indicacaoCirurgia) {
        this.idConsulta = GrupoConsulta.getGrupo().size();
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.exameQueixa = exameQueixa;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.indicacaoCirurgia = indicacaoCirurgia;
    }

    // Getters e Setters
    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getExameQueixa() {
        return exameQueixa;
    }

    public void setExameQueixa(String exameQueixa) {
        this.exameQueixa = exameQueixa;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public boolean isIndicacaoCirurgia() {
        return indicacaoCirurgia;
    }

    public void setIndicacaoCirurgia(boolean indicacaoCirurgia) {
        this.indicacaoCirurgia = indicacaoCirurgia;
    }
}
