package guilda.model;

import guilda.contract.Especialista;

public class Mago extends Personagem implements Especialista {
    private int nivelInteligencia;
    private int mana;
    private static final int CUSTO_EXPLOSAO_ARCANA = 30;
    private static final int MULTIPLICADOR_EXPLOSAO_ARCANA = 5;

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
            throw new IllegalArgumentException(
                    "A mana não pode ser negativa."
            );
        }

        this.mana = mana;
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
        if (mana < CUSTO_EXPLOSAO_ARCANA) {
            System.out.println(
                    nome + " não possui mana suficiente " +
                            "para usar Explosão Arcana."
            );

            return;
        }

        mana -= CUSTO_EXPLOSAO_ARCANA;

        int danoEspecial =
                nivelInteligencia *
                        MULTIPLICADOR_EXPLOSAO_ARCANA;

        System.out.println(
                nome + " utilizou Explosão Arcana!"
        );

        System.out.println(
                "Dano causado: " + danoEspecial
        );

        System.out.println(
                "Mana restante: " + mana
        );
    }
}
