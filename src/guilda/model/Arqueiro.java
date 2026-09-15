package guilda.model;

import guilda.contract.Combatente;

public class Arqueiro extends Personagem implements Combatente {
    private String destreza;
    private int qtdFlechas;

    public Arqueiro(String nome, String destreza, int qtdFlechas) {
        super(nome);
        this.destreza = destreza;
        this.qtdFlechas = qtdFlechas;
    }

    public Arqueiro(String nome, String nivel, String destreza, int qtdFlechas) {
        super(nome, nivel);
        this.destreza = destreza;
        this.qtdFlechas = qtdFlechas;
    }

    public String getDestreza() {
        return destreza;
    }

    public void setDestreza(String destreza) {
        this.destreza = destreza;
    }

    public int getQtdFlechas() {
        return qtdFlechas;
    }

    public void setQtdFlechas(int qtdFlechas) {
        this.qtdFlechas = qtdFlechas;
    }

    public void atirarFlechas() {

    }

    @Override
    public int calcularPoder() {
        return 0;
    }

    @Override
    public int danoAtaque() {
        return 0;
    }

    @Override
    public int danoDefesa() {
        return 0;
    }
}
