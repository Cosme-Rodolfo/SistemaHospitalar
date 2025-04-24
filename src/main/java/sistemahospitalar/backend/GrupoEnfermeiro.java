/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalar.backend;

/**
 *
 * @author caiod
 */
import java.util.List;
import java.util.ArrayList;

public class GrupoEnfermeiro {
    private static  List<Enfermeiro> enfermeiros = new ArrayList<>();

    public static void adicionarAoGrupo(Enfermeiro enfermeiro) {
        enfermeiros.add(enfermeiro);
    }

    public static void removerDoGrupo(int index) {
        enfermeiros.remove(index);
    }

    public static void editarOGrupo(int index, Enfermeiro enfermeiro) {
        enfermeiros.set(index, enfermeiro);
    }

    public static List<Enfermeiro> getGrupo() {
        return enfermeiros;
    }
}
