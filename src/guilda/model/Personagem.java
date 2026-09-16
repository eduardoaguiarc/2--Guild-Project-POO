package guilda.model;

import java.util.Objects;

public abstract class Personagem {

    private static int contador = 1;

    private final int id;
    protected String nome;
    protected String nivel;
    protected int experiencia;
    protected int energia;

    public Personagem(String nome) {
        this(nome, "Iniciante");
    }

    public Personagem(String nome, String nivel) {
        setNome(nome);
        setNivel(nivel);
        this.id = contador++;
        this.experiencia = 0;
        this.energia = 100;
    }

    public static int getContador() {
        return contador;
    }

    public final int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getEnergia() {
        return energia;
    }

    public final void setNivel(String nivel) {
        if ((nivel == null) && nivel.isBlank()) {
            throw new IllegalArgumentException("O nivel de um personagem não pode ser nulo.");
        }
        this.nivel = nivel;
    }

    public final void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("O personagem deve ter um nome.");
        }

        this.nome = nome;
    }

    public int setExperiencia(int quantidade) {
        if (experiencia < 0) {
            throw new IllegalArgumentException("A experiencia não pode ser negativo");
        }

        experiencia = Math.addExact(experiencia, quantidade);

        return experiencia;
    }

    public void setEnergia(int energia) {
        if (energia < 0) {
            throw new IllegalArgumentException(
                    "A energia não pode ser negativa."
            );
        }

        this.energia = energia;

    }

    public int receberExperiencia(int quantidade) {
        if (quantidade < 0) {
            System.err.println("A quantidade de experiência não pode ser negativa.");
        }
        experiencia = Math.addExact(experiencia, quantidade);
        return experiencia;
    }

    public abstract int calcularPoder();

    @Override
    public String toString() {
        return "Personagem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nivel='" + nivel + '\'' +
                ", experiencia=" + experiencia +
                ", energia=" + energia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Personagem that = (Personagem) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
