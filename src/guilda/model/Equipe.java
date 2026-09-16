package guilda.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private final List<Personagem> personagens;
    private Personagem lider;

    public Equipe(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                    "O nome da equipe é obrigatório."
            );
        }

        this.nome = nome;
        this.personagens = new ArrayList<>();
    }

    public void removerPersonagem(Personagem personagem) {
        if (personagem != null && personagens.contains(personagem)) {
            personagens.remove(personagem);
        } else {
            throw new IllegalArgumentException("A lista já esta vazia.");
        }
    }

    public void adicionarPersonagem(Personagem personagem) {
        if (personagem == null && !personagens.contains(personagem)) {
            personagens.add(personagem);
        } else {
            throw new IllegalArgumentException("Não foi possivel adicionar o personagem");
        }
    }

    public void adicionarPersonagem(Personagem personagem, boolean tornarLider) {
        adicionarPersonagem(personagem);

        if (tornarLider) {
            this.lider = personagem;
        }
    }

    public int calcularPoderTotal() {
        int total = 0;

        for (Personagem personagem : personagens) {
            total += personagem.calcularPoder();
        }

        return total;
    }

    public Personagem localizarPersonagemId(int id) {
        for (Personagem personagem : personagens) {
            if (personagem.getId() == id) {
                return personagem;
            }
        }
        return null;
    }

}
