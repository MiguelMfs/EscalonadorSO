package scheduler;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import model.Processo;

public class RoundRobin implements Escalonador {
    private int quantum;

    public RoundRobin(int quantum) {
        this.quantum = quantum;
    }

    @Override
    public void executar(List<Processo> processos) {
        Queue<Processo> fila = new LinkedList<>(processos);
        int tempoAtual = 0;

        while (!fila.isEmpty()) {
            Processo p = fila.poll();

            int tempoExec = Math.min(quantum, p.getTempoRestante());
            tempoAtual += tempoExec;
            p.setTempoRestante(p.getTempoRestante() - tempoExec);

            if (p.getTempoRestante() == 0) {
                p.setTempoTermino(tempoAtual);
            } else {
                fila.add(p);
            }
        }
    }
}
