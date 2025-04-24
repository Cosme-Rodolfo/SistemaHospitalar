/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalar.backend;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.logging.log4j.
/**
 *
 * @author caiod
 */
/**
 * Esta classe é responsável por gerar arquivos Excel contendo os dados do sistema de gerenciamento de saúde.
 */
public class GeradorExcel {
    
    String nomeArquivo = "dadosHospitalares.xlsx";
    //Este método registra os dados do sistema em um arquivo Excel.
    public void registrarDados() {

        try (var workbook = new XSSFWorkbook();
            var outputStream = new FileOutputStream(nomeArquivo)) {
            var planilhaPacientes = workbook.createSheet("Pacientes");
            
            int numeroDaLinha = 0;

            adicionarCabecalhoPac(planilhaPacientes, numeroDaLinha++);

            for (Paciente paciente : GrupoPaciente.getGrupo()) {
                var linha = planilhaPacientes.createRow(numeroDaLinha++);
                adicionarCelula(linha, 0, paciente.getIdPaciente());
                adicionarCelula(linha, 1, paciente.getNomeCompleto());
                adicionarCelula(linha, 2, paciente.getDataNascimento().toString());
                adicionarCelula(linha, 3, paciente.getEndereco().getRua());
                adicionarCelula(linha, 4, paciente.getEndereco().getNumero());
                adicionarCelula(linha, 5, paciente.getEndereco().getBairro());
                adicionarCelula(linha, 6, paciente.getEndereco().getCidade());
                adicionarCelula(linha, 7, paciente.getEndereco().getEstado());
                adicionarCelula(linha, 8, paciente.getEndereco().getCep());
                adicionarCelula(linha, 9, paciente.getContato().getTelefone());
                adicionarCelula(linha, 10, paciente.getContato().getCelular());
                adicionarCelula(linha, 11, paciente.getContato().getEmail());
                adicionarCelula(linha, 12, paciente.getDataCadastro().toString());
                adicionarCelula(linha, 13, paciente.getIdade());
                adicionarCelula(linha, 14, paciente.getObsGeral());
                adicionarCelula(linha, 15, paciente.getGenero().getDescricao());
                
            }
            var planilhaMedicos = workbook.createSheet("Medicos");
            
            numeroDaLinha = 0;
            adicionarCabecalhoMed(planilhaMedicos, numeroDaLinha++);

            for (Medico medico : GrupoMedico.getGrupo()) {
                var linha = planilhaMedicos.createRow(numeroDaLinha++);
                adicionarCelula(linha, 0, medico.getIdMedico());
                adicionarCelula(linha, 1, medico.getNomeCompleto());
                adicionarCelula(linha, 2, medico.getDataNascimento().toString());
                adicionarCelula(linha, 3, medico.getEndereco().getRua());
                adicionarCelula(linha, 4, medico.getEndereco().getNumero());
                adicionarCelula(linha, 5, medico.getEndereco().getBairro());
                adicionarCelula(linha, 6, medico.getEndereco().getCidade());
                adicionarCelula(linha, 7, medico.getEndereco().getEstado());
                adicionarCelula(linha, 8, medico.getEndereco().getCep());
                adicionarCelula(linha, 9, medico.getContato().getTelefone());
                adicionarCelula(linha, 10, medico.getContato().getCelular());
                adicionarCelula(linha, 11, medico.getContato().getEmail());
                adicionarCelula(linha, 12, medico.getNumeroCRM());
                adicionarCelula(linha, 13, medico.isCirurgiao());
                adicionarCelula(linha, 14, medico.getSetor());
                adicionarCelula(linha, 15, medico.getChSemanais());
                adicionarCelula(linha, 16, medico.getGenero().getDescricao());
                adicionarCelula(linha, 17, String.join(",", medico.getAreasEspecialidade()));
                
            }
         
            var planilhaEnfermeiros = workbook.createSheet("Enfermeiros");
            
            numeroDaLinha = 0;
            adicionarCabecalhoEnf(planilhaEnfermeiros, numeroDaLinha++);

            for (Enfermeiro enfermeiro : GrupoEnfermeiro.getGrupo()) {
                var linha = planilhaEnfermeiros.createRow(numeroDaLinha++);
                adicionarCelula(linha, 0, enfermeiro.getIdEnfermeiro());
                adicionarCelula(linha, 1, enfermeiro.getNomeCompleto());
                adicionarCelula(linha, 2, enfermeiro.getDataNascimento().toString());
                adicionarCelula(linha, 3, enfermeiro.getEndereco().getRua());
                adicionarCelula(linha, 4, enfermeiro.getEndereco().getNumero());
                adicionarCelula(linha, 5, enfermeiro.getEndereco().getBairro());
                adicionarCelula(linha, 6, enfermeiro.getEndereco().getCidade());
                adicionarCelula(linha, 7, enfermeiro.getEndereco().getEstado());
                adicionarCelula(linha, 8, enfermeiro.getEndereco().getCep());
                adicionarCelula(linha, 9, enfermeiro.getContato().getTelefone());
                adicionarCelula(linha, 10, enfermeiro.getContato().getCelular());
                adicionarCelula(linha, 11, enfermeiro.getContato().getEmail());
                adicionarCelula(linha, 12, enfermeiro.getSetor());
                adicionarCelula(linha, 13, enfermeiro.getChSemanais());
                adicionarCelula(linha, 14, enfermeiro.getGenero().getDescricao());
                adicionarCelula(linha, 15, enfermeiro.isTreinadoOpRx());
                
            }
            
            var planilhaConsultas = workbook.createSheet("Consultas");
            
            numeroDaLinha = 0;
            adicionarCabecalhoCons(planilhaConsultas, numeroDaLinha++);

            for (ConsultaMedica consulta : GrupoConsulta.getGrupo()) {
                var linha = planilhaConsultas.createRow(numeroDaLinha++);
                adicionarCelula(linha, 0, consulta.getIdConsulta());
                adicionarCelula(linha, 1, consulta.getIdPaciente());
                adicionarCelula(linha, 2, consulta.getIdMedico());
                adicionarCelula(linha, 3, consulta.getExameQueixa());
                adicionarCelula(linha, 4, consulta.getDiagnostico());
                adicionarCelula(linha, 5, consulta.getPrescricao());
                adicionarCelula(linha, 6, consulta.isIndicacaoCirurgia());
            }
            
            workbook.write(outputStream);
            System.out.println("arquivo criado com sucesso!");
        } catch (Exception e) {
        
        }
        
    }
    //Adiciona o cabeçalho à planilha 
    private void adicionarCabecalhoPac(XSSFSheet planilha, int numeroLinha) {
        var linha = planilha.createRow(numeroLinha);
        adicionarCelula(linha, 0, "Id");
        adicionarCelula(linha, 1, "Nome");
        adicionarCelula(linha, 2, "Data de nasc.");
        adicionarCelula(linha, 3, "Rua");
        adicionarCelula(linha, 4, "Num");
        adicionarCelula(linha, 5, "Bairro");
        adicionarCelula(linha, 6, "Cidade");
        adicionarCelula(linha, 7, "Estado");
        adicionarCelula(linha, 8, "Cep");
        adicionarCelula(linha, 9, "Tel");
        adicionarCelula(linha, 10, "Cel");
        adicionarCelula(linha, 11, "Email");
        adicionarCelula(linha, 12, "Data de Cad.");
        adicionarCelula(linha, 13, "Idade");
        adicionarCelula(linha, 14, "Obs");
        adicionarCelula(linha, 15, "Genero");
    }
    
    private void adicionarCabecalhoMed(XSSFSheet planilha, int numeroLinha) {
        var linha = planilha.createRow(numeroLinha);
        adicionarCelula(linha, 0, "Id");
        adicionarCelula(linha, 1, "Nome");
        adicionarCelula(linha, 2, "Data de nasc.");
        adicionarCelula(linha, 3, "Rua");
        adicionarCelula(linha, 4, "Num");
        adicionarCelula(linha, 5, "Bairro");
        adicionarCelula(linha, 6, "Cidade");
        adicionarCelula(linha, 7, "Estado");
        adicionarCelula(linha, 8, "Cep");
        adicionarCelula(linha, 9, "Tel");
        adicionarCelula(linha, 10, "Cel");
        adicionarCelula(linha, 11, "Email");
        adicionarCelula(linha, 12, "CRM");
        adicionarCelula(linha, 13, "Cirurgiao");
        adicionarCelula(linha, 14, "Setor");
        adicionarCelula(linha, 15, "Carga H.");
        adicionarCelula(linha, 16, "Genero");
        adicionarCelula(linha, 17, "Espec.");
    }
    
    private void adicionarCabecalhoEnf(XSSFSheet planilha, int numeroLinha) {
        var linha = planilha.createRow(numeroLinha);
        adicionarCelula(linha, 0, "Id");
        adicionarCelula(linha, 1, "Nome");
        adicionarCelula(linha, 2, "Data de nasc.");
        adicionarCelula(linha, 3, "Rua");
        adicionarCelula(linha, 4, "Num");
        adicionarCelula(linha, 5, "Bairro");
        adicionarCelula(linha, 6, "Cidade");
        adicionarCelula(linha, 7, "Estado");
        adicionarCelula(linha, 8, "Cep");
        adicionarCelula(linha, 9, "Tel");
        adicionarCelula(linha, 10, "Cel");
        adicionarCelula(linha, 11, "Email");
        adicionarCelula(linha, 12, "Setor");
        adicionarCelula(linha, 13, "Carga H.");
        adicionarCelula(linha, 14, "Genero");
        adicionarCelula(linha, 15, "Opera RX");
    }

    private void adicionarCabecalhoCons(XSSFSheet planilha, int numeroLinha) {
        var linha = planilha.createRow(numeroLinha);
        adicionarCelula(linha, 0, "Id cons.");
        adicionarCelula(linha, 1, "Id pac.");
        adicionarCelula(linha, 2, "Id med.");
        adicionarCelula(linha, 3, "Exame queixa");
        adicionarCelula(linha, 4, "Diagnostico");
        adicionarCelula(linha, 5, "Prescricao");
        adicionarCelula(linha, 6, "Indicacao cirurgica");
    }
    //Adiciona o celulas à planilha 
    private void adicionarCelula(Row linha, int coluna, String valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }

    private void adicionarCelula(Row linha, int coluna, int valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }
    private void adicionarCelula(Row linha, int coluna, boolean valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }
}
