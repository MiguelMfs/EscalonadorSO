package scheduler;

import java.util.List;
import model.Processo;

public class FCFS implements Escalonador {

    @Override
    public void executar(List<Processo> processos) {
        int tempoAtual = 0;

        for (Processo p : processos) {
            if (tempoAtual < p.getTempoChegada()) {
                tempoAtual = p.getTempoChegada();
            }
            tempoAtual += p.getTempoTotal();
            p.setTempoTermino(tempoAtual);
        }
    }
}
