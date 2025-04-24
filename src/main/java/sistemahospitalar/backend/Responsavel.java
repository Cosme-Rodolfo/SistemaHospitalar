/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalar.backend;

/**
 *
 * @author caiod
 */
import java.util.concurrent.atomic.AtomicLong;

public class Responsavel extends ContatoTelEmail {
    private static final AtomicLong proximoIdResponsavel = new AtomicLong(1);

    private int idResponsavel;
    private String nomeResponsavel;
    private String telefone;
    private String celular;
    private String email;
    
    public Responsavel(int id, String telefone, String celular, String email, String nomeResponsavel) {
        super(telefone, celular, email);
        this.idResponsavel = id;
        this.nomeResponsavel = nomeResponsavel;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    // Método para gerar o próximo idResponsavel de forma automática
    public static Long gerarProximoIdResponsavel() {
        return proximoIdResponsavel.getAndIncrement();
    }

    // Getters e Setters
    public int getIdResponsavel() {
        return idResponsavel;
    }

    public String getNomeResponsavel(){
        return nomeResponsavel;
    }
    
    public String getTelResponsavel(){
        return telefone;
    }
    public String getCelResponsavel(){
        return celular;
    }
    public String getEmailResponsavel(){
        return email;
    }

}
