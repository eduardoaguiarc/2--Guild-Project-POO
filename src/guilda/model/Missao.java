package guilda.model;

import java.util.ArrayList;
import java.util.List;

public class Missao {

    private String nome;
    private int dificuldade;
    private int recompensaXP;
    private boolean concluida;
    private final List<Missao> submissoes;

    public Missao(
            String nome,
            int dificuldade,
            int recompensaXP
    ) {
        setNome(nome);
        setDificuldade(dificuldade);
        setRecompensaXP(recompensaXP);

        this.concluida = false;
        this.submissoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                    "O nome é obrigatório."
            );
        }

        this.nome = nome;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        if (dificuldade <= 0) {
            throw new IllegalArgumentException(
                    "A dificuldade deve ser maior que zero."
            );
        }

        this.dificuldade = dificuldade;
    }

    public int getRecompensaXP() {
        return recompensaXP;
    }

    public void setRecompensaXP(int recompensaXP) {
        if (recompensaXP < 0) {
            throw new IllegalArgumentException(
                    "A recompensa não pode ser negativa."
            );
        }

        this.recompensaXP = recompensaXP;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public List<Missao> getSubmissoes() {
        return List.copyOf(submissoes);
    }

    public void adicionarSubmissao(Missao submissao) {
        if (submissao == null) {
            throw new IllegalArgumentException(
                    "A submissão não pode ser nula."
            );
        }

        if (submissao == this) {
            throw new IllegalArgumentException(
                    "Uma missão não pode ser submissão dela mesma."
            );
        }

        submissoes.add(submissao);
    }

    public void concluir() {
        this.concluida = true;
    }

    public int contarEtapas() {
        int total = 1;

        for (Missao submissao : submissoes) {
            total += submissao.contarEtapas();
        }

        return total;
    }

    public int calcularRecompensaTotal() {
        int totalRecompensaXP = this.recompensaXP;

        for (Missao submissao : submissoes) {
            totalRecompensaXP +=
                    submissao.calcularRecompensaTotal();
        }

        return totalRecompensaXP;
    }

    public String exibirEstrutura() {
        return exibirEstrutura(0);
    }

    private String exibirEstrutura(int nivel) {
        String indentacao = "  ".repeat(nivel);
        String resultado =
                indentacao + "- " + nome + "\n";

        for (Missao submissao : submissoes) {
            resultado +=
                    submissao.exibirEstrutura(nivel + 1);
        }

        return resultado;
    }
}