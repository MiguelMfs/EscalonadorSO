package model;

public class Processo {
    private int id;
    private int tempoChegada;
    private int tempoRestante;
    private int tempoTotal;
    private int tempoTermino;

    public Processo(int id, int tempoChegada, int tempoTotal) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.tempoTotal = tempoTotal;
        this.tempoRestante = tempoTotal;
    }

    public int getId() {
        return id;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(int tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public int getTempoTotal() {
        return tempoTotal;
    }

    public int getTempoTermino() {
        return tempoTermino;
    }

    public void setTempoTermino(int tempoTermino) {
        this.tempoTermino = tempoTermino;
    }

    public int getTurnaroundTime() {
        return tempoTermino - tempoChegada;
    }

    public int getWaitingTime() {
        return getTurnaroundTime() - tempoTotal;
    }
}
