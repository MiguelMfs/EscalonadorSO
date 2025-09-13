import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Processo;
import scheduler.FCFS;
import scheduler.SJF;
import scheduler.RoundRobin;

public class Main {

    public static void main(String[] args) {
        int numProcessos = 100;
        List<Processo> processos;

        // Simulações
        executarSimulacao("FCFS", new FCFS(), gerarProcessos(numProcessos));
        executarSimulacao("SJF", new SJF(), gerarProcessos(numProcessos));
        executarSimulacao("RoundRobin (q=5)", new RoundRobin(5), gerarProcessos(numProcessos));
        executarSimulacao("RoundRobin (q=10)", new RoundRobin(10), gerarProcessos(numProcessos));
        executarSimulacao("RoundRobin (q=20)", new RoundRobin(20), gerarProcessos(numProcessos));
    }

    private static List<Processo> gerarProcessos(int n) {
        List<Processo> processos = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= n; i++) {
            int tempoTotal = 50 + rand.nextInt(51); // entre 50 e 100
            processos.add(new Processo(i, 0, tempoTotal));
        }
        return processos;
    }

    private static void executarSimulacao(String nome, scheduler.Escalonador escalonador, List<Processo> processos) {
        escalonador.executar(processos);

        double turnaroundMedio = processos.stream().mapToInt(Processo::getTurnaroundTime).average().orElse(0);
        double waitingMedio = processos.stream().mapToInt(Processo::getWaitingTime).average().orElse(0);

        System.out.println("=== " + nome + " ===");
        System.out.println("Turnaround médio: " + turnaroundMedio);
        System.out.println("Waiting time médio: " + waitingMedio);
        System.out.println();
    }
}

