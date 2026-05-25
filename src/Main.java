import java.util.PriorityQueue;
import java.util.Queue;

import entidades.Paciente;
import heap.FilaComPrioridadeHeap;

public class Main {

    public static void main(String[] args) {
        FilaComPrioridadeHeap<Paciente> fila = new FilaComPrioridadeHeap<>(10);

        Paciente[] pacientes = {
                new Paciente("Carlos", 2, 45, false),
                new Paciente("Maria", 5, 5, false),
                new Paciente("João", 3, 20, false),
                new Paciente("Beatriz", 3, 35, true),
                new Paciente("Pedro", 5, 2, false),
                new Paciente("Helena", 2, 45, true)
        };

        System.out.println("=== CHEGADA DOS PACIENTES ===");

        for (Paciente paciente : pacientes) {
            fila.enfileirar(paciente);
            System.out.println("\nPaciente inserido: " + paciente);
            System.out.println("Estado interno do heap:");
            System.out.println(fila.estadoInternoHeap());
        }

        System.out.println("\n=== ORDEM DE ATENDIMENTO ===");

        int posicao = 1;
        while (!fila.estaVazia()) {
            System.out.println(posicao + ". " + fila.desenfileirar());
            posicao++;
        }
    }
}