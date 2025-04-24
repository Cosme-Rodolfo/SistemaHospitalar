/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalar.backend;

/**
 *
 * @author caiod
 */
import sistemahospitalar.backend.Paciente;
import java.util.ArrayList;
import java.util.List;

public class GrupoPaciente {
    private static  List<Paciente> pacientes = new ArrayList<>();

    public static void adicionarAoGrupo(Paciente paciente) {
        pacientes.add(paciente);
    }

    public static void removerDoGrupo(int index) {
        pacientes.remove(index);
    }

    public static void editarOGrupo(int index, Paciente paciente) {
        pacientes.set(index, paciente);
    }

    public static List<Paciente> getGrupo() {
        return pacientes;
    }
}

