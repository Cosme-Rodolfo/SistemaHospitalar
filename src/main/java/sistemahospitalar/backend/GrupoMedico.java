/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalar.backend;

/**
 *
 * @author caiod
 */
import sistemahospitalar.backend.Medico;
import java.util.List;
import java.util.ArrayList;

public class GrupoMedico {
    private static  List<Medico> medicos = new ArrayList<>();

    public static void adicionarAoGrupo(Medico medico) {
        medicos.add(medico);
    }

    public static void removerDoGrupo(int index) {
        medicos.remove(index);
    }

    public static void editarOGrupo(int index, Medico medico) {
        medicos.set(index, medico);
    }

    public static List<Medico> getGrupo() {
        return medicos;
    }
}

