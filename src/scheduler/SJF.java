package scheduler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Processo;

public class SJF implements Escalonador {

    @Override
    public void executar(List<Processo> processos) {
        List<Processo> fila = new ArrayList<>(processos);
        fila.sort(Comparator.comparingInt(Processo::getTempoTotal));

        int tempoAtual = 0;
        for (Processo p : fila) {
            if (tempoAtual < p.getTempoChegada()) {
                tempoAtual = p.getTempoChegada();
            }
            tempoAtual += p.getTempoTotal();
            p.setTempoTermino(tempoAtual);
        }
    }
}
