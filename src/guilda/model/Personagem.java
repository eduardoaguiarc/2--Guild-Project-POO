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

    // As subclasses usam super(nome) ou super(nome, nivel).
    // O ID deve ser atribuído na criação; apenas incrementar o contador não bastava.
    public Personagem(String nome, String nivel) {
        setNome(nome);
        setNivel(nivel);
        this.id = contador++;
    }

    public static int getContador() {
        return contador;
    }

    // Sem setter para o contador: reiniciá-lo poderia gerar IDs repetidos.

    public final int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    // final impede sobrescrita durante a inicialização feita pelo construtor.
    public final void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.err.println("O nome não pode estar vazio.");
        }
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public final void setNivel(String nivel) {
        if (nivel == null || nivel.isBlank()) {
            System.err.println("O nível não pode estar vazio.");
        }
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        if (experiencia < 0) {
            System.err.println("A experiência não pode ser negativa.");
        }
        this.experiencia = experiencia;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia < 0) {
            System.err.println("A energia não pode ser negativa.");
        }
        this.energia = energia;
    }

    public int receberExperiencia(int quantidade) {
        if (quantidade < 0) {
            System.err.println("A quantidade de experiência não pode ser negativa.");
        }
        // Antes o método apenas retornava o valor, sem conceder experiência.
        // addExact evita que um estouro de int transforme o total em negativo.
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
