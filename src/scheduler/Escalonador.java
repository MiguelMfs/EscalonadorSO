package scheduler;

import java.util.List;
import model.Processo;

public interface Escalonador {
    void executar(List<Processo> processos);
}
