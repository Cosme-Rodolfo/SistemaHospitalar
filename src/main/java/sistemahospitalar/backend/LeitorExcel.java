
package sistemahospitalar.backend;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeitorExcel {
    
    String nomeArquivo = "dadosHospitalares.xlsx";
    /*
      Este método importa todos os dados do arquivo Excel para o sistema.
      Chama os métodos específicos para importar pacientes, médicos, enfermeiros e consultas.
     */
    
    public void importarDados(){
        importarPacientes();
        importarMedicos();
        importarEnfermeiros();
        importarConsultas();
    }
    /*
      Este método realiza a importação dos dados dos pacientes do arquivo Excel.
      Lê os dados da aba "Pacientes" e cria objetos Paciente com base nesses dados.
      Os pacientes são adicionados à lista de pacientes no GrupoPaciente.
     */
    public void importarPacientes() {

        try (FileInputStream excelFile = new FileInputStream(nomeArquivo)) {
            
            var workbook = new XSSFWorkbook(excelFile);
            var abaPacientes = workbook.getSheet("Pacientes");
            
            int contadorLinha = 0;
            for (Row linha : abaPacientes) {
                if (++contadorLinha == 1) continue;
                int ID = (int) linha.getCell(0).getNumericCellValue();
                String nome = linha.getCell(1).getStringCellValue();
                LocalDate dataNasc = LocalDate.parse(linha.getCell(2).getStringCellValue());
                
                // endereco
                String rua = linha.getCell(3).getStringCellValue();
                int numero = (int) linha.getCell(4).getNumericCellValue();
                String bairro = linha.getCell(5).getStringCellValue();
                String cidade = linha.getCell(6).getStringCellValue();
                String estado = linha.getCell(7).getStringCellValue();
                int cep = (int) linha.getCell(8).getNumericCellValue();
                
                Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
                
                // contato
                String telefone = linha.getCell(9).getStringCellValue();
                String celular = linha.getCell(10).getStringCellValue();
                String email = linha.getCell(11).getStringCellValue();
                
                ContatoTelEmail contato = new ContatoTelEmail(telefone, celular, email);
                
                //DateFormat df = new SimpleDateFormat("E/M/d/H:s/z/yyyy"); 
                Date dataCad = new Date();
                //int idade = (int) linha.getCell(13).getNumericCellValue();
                String obs = linha.getCell(14).getStringCellValue();
                
                Genero genero;
                
                if ("Masculino".equals(linha.getCell(15).getStringCellValue())){
                    genero = Genero.M;
                } else {
                    genero = Genero.F;
                }
                
                Paciente paciente = new Paciente(nome, dataNasc, endereco, contato, genero, dataCad, obs);
                paciente.setIdPaciente(ID);
                
                GrupoPaciente.adicionarAoGrupo(paciente);
            }
            System.out.println("Arquivo carregado com sucesso!");
        } catch (Exception e) {
            System.out.println("algo deu errado");
        }
    }
    /*
      Este método realiza a importação dos dados dos médicos do arquivo Excel.
      Lê os dados da aba "Medicos" e cria objetos Medico com base nesses dados.
      Os médicos são adicionados à lista de médicos no GrupoMedico.
     */
    public void importarMedicos() {
        //List<Paciente> pacientes = new ArrayList<>();

        try (FileInputStream excelFile = new FileInputStream(nomeArquivo)) {
            
            var workbook = new XSSFWorkbook(excelFile);
            var abaMedicos = workbook.getSheet("Medicos");
            
            int contadorLinha = 0;
            for (Row linha : abaMedicos) {
                if (++contadorLinha == 1) continue;
                int ID = (int) linha.getCell(0).getNumericCellValue();
                String nome = linha.getCell(1).getStringCellValue();
                LocalDate dataNasc = LocalDate.parse(linha.getCell(2).getStringCellValue());
                
                // endereco
                String rua = linha.getCell(3).getStringCellValue();
                int numero = (int) linha.getCell(4).getNumericCellValue();
                String bairro = linha.getCell(5).getStringCellValue();
                String cidade = linha.getCell(6).getStringCellValue();
                String estado = linha.getCell(7).getStringCellValue();
                int cep = (int) linha.getCell(8).getNumericCellValue();
                
                Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
                
                // contato
                String telefone = linha.getCell(9).getStringCellValue();
                String celular = linha.getCell(10).getStringCellValue();
                String email = linha.getCell(11).getStringCellValue();
                
                ContatoTelEmail contato = new ContatoTelEmail(telefone, celular, email);
                
                // Infos medicas
                int crm = (int) linha.getCell(12).getNumericCellValue();
                boolean isCirurgiao = linha.getCell(13).getBooleanCellValue();
                String setor = linha.getCell(14).getStringCellValue();
                int cargaH = (int) linha.getCell(15).getNumericCellValue();
                
                Genero genero;                
                if ("Masculino".equals(linha.getCell(16).getStringCellValue())){
                    genero = Genero.M;
                } else {
                    genero = Genero.F;
                }
                List<String> espec = Arrays.asList(linha.getCell(17).getStringCellValue().split(","));
                
                Medico medico = new Medico(nome, dataNasc, endereco, contato, genero, crm, espec, isCirurgiao, setor, cargaH);
                medico.setIdMedico(ID);
                
                GrupoMedico.adicionarAoGrupo(medico);
            }
            System.out.println("Arquivo carregado com sucesso!");
        } catch (Exception e) {
            System.out.println("algo deu errado");
        }
    }
    /*
      Este método realiza a importação dos dados dos enfermeiros do arquivo Excel.
      Lê os dados da aba "Enfermeiros" e cria objetos Enfermeiro com base nesses dados.
      Os enfermeiros são adicionados à lista de enfermeiros no GrupoEnfermeiro.
     */
    public void importarEnfermeiros() {
        //List<Paciente> pacientes = new ArrayList<>();

        try (FileInputStream excelFile = new FileInputStream(nomeArquivo)) {
            
            var workbook = new XSSFWorkbook(excelFile);
            var abaEnfermeiros = workbook.getSheet("Enfermeiros");
            
            int contadorLinha = 0;
            for (Row linha : abaEnfermeiros) {
                if (++contadorLinha == 1) continue;
                int ID = (int) linha.getCell(0).getNumericCellValue();
                String nome = linha.getCell(1).getStringCellValue();
                LocalDate dataNasc = LocalDate.parse(linha.getCell(2).getStringCellValue());
                
                // endereco
                String rua = linha.getCell(3).getStringCellValue();
                int numero = (int) linha.getCell(4).getNumericCellValue();
                String bairro = linha.getCell(5).getStringCellValue();
                String cidade = linha.getCell(6).getStringCellValue();
                String estado = linha.getCell(7).getStringCellValue();
                int cep = (int) linha.getCell(8).getNumericCellValue();
                
                Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
                
                // contato
                String telefone = linha.getCell(9).getStringCellValue();
                String celular = linha.getCell(10).getStringCellValue();
                String email = linha.getCell(11).getStringCellValue();
                
                ContatoTelEmail contato = new ContatoTelEmail(telefone, celular, email);
                
                // Infos enfer
                String setor = linha.getCell(12).getStringCellValue();
                int cargaH = (int) linha.getCell(13).getNumericCellValue();
                
                Genero genero;                
                if ("Masculino".equals(linha.getCell(14).getStringCellValue())){
                    genero = Genero.M;
                } else {
                    genero = Genero.F;
                }
                
                boolean isOpRx = linha.getCell(15).getBooleanCellValue();
                
                Enfermeiro enfermeiro = new Enfermeiro(nome, dataNasc, endereco, contato, genero, isOpRx, setor, cargaH);
                enfermeiro.setIdEnfermeiro(ID);
                
                GrupoEnfermeiro.adicionarAoGrupo(enfermeiro);
            }
            System.out.println("Arquivo carregado com sucesso!");
        } catch (Exception e) {
            System.out.println("algo deu errado");
        }
    }
    
    /*
      Este método realiza a importação dos dados das consultas do arquivo Excel.
      Lê os dados da aba "Consultas" e cria objetos ConsultaMedica com base nesses dados.
      As consultas são adicionadas à lista de consultas no GrupoConsulta e também são
      adicionadas ao histórico de consultas do paciente correspondente.
     */
    public void importarConsultas() {
        //List<Paciente> pacientes = new ArrayList<>();

        try (FileInputStream excelFile = new FileInputStream(nomeArquivo)) {
            
            var workbook = new XSSFWorkbook(excelFile);
            var abaConsultas = workbook.getSheet("Consultas");
            
            int contadorLinha = 0;
            for (Row linha : abaConsultas) {
                if (++contadorLinha == 1) continue;
                int ID = (int) linha.getCell(0).getNumericCellValue();
                int IdPac = (int) linha.getCell(1).getNumericCellValue();
                int IdMed = (int) linha.getCell(2).getNumericCellValue();
                String exameQueixa = linha.getCell(3).getStringCellValue();
                String diagnostico = linha.getCell(4).getStringCellValue();
                String prescricao = linha.getCell(5).getStringCellValue();
                boolean indicacao = linha.getCell(6).getBooleanCellValue();
                
                ConsultaMedica consulta = new ConsultaMedica(IdPac, IdMed, exameQueixa, diagnostico, prescricao, indicacao);
                consulta.setIdConsulta(ID);
                
                GrupoConsulta.adicionarAoGrupo(consulta);
                
                int idPaciente = consulta.getIdPaciente();
                GrupoPaciente.getGrupo().get(idPaciente).addAoHistoricoDeConsultas(consulta);
            }
            System.out.println("Arquivo carregado com sucesso!");
        } catch (Exception e) {
            System.out.println("algo deu errado");
        }
    }
}
