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

    public boolean removerPersonagem(Personagem personagem) {
        if (personagem != null && personagem.equals(lider)) {
            lider = null;
        }

        return personagens.remove(personagem);
    }

    public void adicionarPersonagem(Personagem personagem) {
        if (personagem == null) {
            throw new IllegalArgumentException(
                    "O personagem não pode ser nulo."
            );
        }

        if (personagens.contains(personagem)) {
            throw new IllegalArgumentException(
                    "O personagem já está na equipe."
            );
        }

        personagens.add(personagem);
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

    public List<Personagem> getPersonagens() {
        return List.copyOf(personagens);
    }
}
