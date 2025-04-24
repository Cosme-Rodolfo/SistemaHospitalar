/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalar.backend;

/**
 *
 * @author caiod
 */
import java.util.ArrayList;
import java.util.List;

public class GrupoConsulta {
    private static  List<ConsultaMedica> consultas = new ArrayList<>();

    public static void adicionarAoGrupo(ConsultaMedica consulta) {
        consultas.add(consulta);
    }

    public static void removerDoGrupo(int index) {
        consultas.remove(index);
    }

    public static void editarOGrupo(int index, ConsultaMedica consulta) {
        consultas.set(index, consulta);
    }

    public static List<ConsultaMedica> getGrupo() {
        return consultas;
    }
}
