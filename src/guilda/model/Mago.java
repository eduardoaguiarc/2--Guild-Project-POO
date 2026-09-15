package guilda.model;

import guilda.contract.Especialista;

// Especialista já estende Combatente; o mago também assume esse contrato.
public class Mago extends Personagem implements Especialista {
    private int nivelInteligencia;
    private int mana;

    public Mago(String nome, int nivelInteligencia, int mana) {
        // Centraliza a inicialização e as validações no construtor completo.
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

    // final mantém a validação segura mesmo quando chamada pelo construtor.
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
        // TODO: definir a fórmula de poder. Zero é provisório, não um cálculo.
        return 0;
    }

    @Override
    public void usarHabilidadeEspecial() {
        // TODO: definir a habilidade especial, seu efeito e seu custo de mana.
    }

    @Override
    public int danoAtaque() {
        // TODO: definir o dano do ataque; consultar o dano não deve gastar mana.
        return 0;
    }

    @Override
    public int danoDefesa() {
        // TODO: esclarecer se este valor representa redução de dano ou contra-ataque.
        return 0;
    }
}
