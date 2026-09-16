package guilda.model;

import guilda.contract.Combatente;

public class Arqueiro extends Personagem implements Combatente {
    private int destreza;
    private int qtdFlechas;

    public Arqueiro(String nome, int destreza, int qtdFlechas) {
        super(nome);
        this.destreza = destreza;
        this.qtdFlechas = qtdFlechas;
    }

    public Arqueiro(String nome, String nivel, int destreza, int qtdFlechas) {
        super(nome, nivel);
        this.destreza = destreza;
        this.qtdFlechas = qtdFlechas;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getQtdFlechas() {
        return qtdFlechas;
    }

    public void setQtdFlechas(int qtdFlechas) {
        this.qtdFlechas = qtdFlechas;
    }

    @Override
    public int calcularPoder() {
        return destreza * 2 + qtdFlechas;
    }

    @Override
    public int danoAtaque() {
        if (qtdFlechas == 0) {
            return 0;
        }

        return destreza * 3;
    }

    @Override
    public int danoDefesa() {
        return destreza + 5;
    }
}
