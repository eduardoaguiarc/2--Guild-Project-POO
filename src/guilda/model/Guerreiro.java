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

    @Override
    public int calcularPoder() {
        return forca * 2 + energia;
    }

    @Override
    public int danoAtaque() {
        return forca * 3;
    }

    @Override
    public int danoDefesa() {
        return forca + 20;
    }
}
