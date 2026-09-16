package guilda.model;

import guilda.contract.Especialista;

public class Mago extends Personagem implements Especialista {
    private int nivelInteligencia;
    private int mana;

    public Mago(String nome, int nivelInteligencia, int mana) {
        this(nome, "Iniciante", nivelInteligencia, mana);
    }

    public Mago(String nome, String nivel, int nivelInteligencia, int mana) {
        super(nome, nivel);
        setNivelInteligencia(nivelInteligencia);
        setMana(mana);
    }

    public int getNivelInteligencia() {
        return nivelInteligencia;
    }

    public final void setNivelInteligencia(int nivelInteligencia) {
        if (nivelInteligencia < 0) {
            System.err.println("A inteligência não pode ser negativa.");
        }
        this.nivelInteligencia = nivelInteligencia;
    }

    public int getMana() {
        return mana;
    }

    public final void setMana(int mana) {
        if (mana < 0) {
            System.err.println("A mana não pode ser negativa.");
        }
        this.mana = mana;
    }

    public void atirarMagia() {
        // TODO: definir custo de mana e efeito da magia antes de implementar.
    }

    @Override
    public int calcularPoder() {
        return nivelInteligencia * 2 + mana;
    }

    @Override
    public int danoAtaque() {
        return nivelInteligencia * 3;
    }

    @Override
    public int danoDefesa() {
        return nivelInteligencia + 10;
    }

    @Override
    public void usarHabilidadeEspecial() {

    }
}
