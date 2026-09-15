package guilda.model;

import guilda.contract.Combatente;

public class Guerreiro extends Personagem implements Combatente {
    private int forca;
    private String armadura;

    public Guerreiro(String nome, int forca, String armadura) {
        super(nome);
        this.forca = forca;
        this.armadura = armadura;
    }

    public Guerreiro(String nome, String nivel, int forca, String armadura) {
        super(nome, nivel);
        this.forca = forca;
        this.armadura = armadura;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public String getArmadura() {
        return armadura;
    }

    public void setArmadura(String armadura) {
        this.armadura = armadura;
    }

    public void atacarInimigo() {

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
