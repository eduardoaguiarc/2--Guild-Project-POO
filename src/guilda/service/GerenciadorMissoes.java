package guilda.service;

import guilda.model.Equipe;
import guilda.model.Missao;
import guilda.model.Personagem;

import java.util.List;

public class GerenciadorMissoes {
    public boolean executarMissao(Equipe equipe, Missao missao) {

        if (equipe == null) {
            throw new IllegalArgumentException(
                    "A equipe é obrigatória."
            );
        }

        if (missao == null) {
            throw new IllegalArgumentException(
                    "A missão é obrigatória."
            );
        }

        List<Personagem> participantes =
                equipe.getPersonagens();

        if (participantes.isEmpty()) {
            throw new IllegalStateException(
                    "A equipe não possui personagens."
            );
        }

        int poderDaEquipe =
                equipe.calcularPoderTotal();

        if (poderDaEquipe < missao.getDificuldade()) {
            return false;
        }

        missao.concluir();

        int recompensaTotal =
                missao.calcularRecompensaTotal();

        int experienciaPorPersonagem =
                recompensaTotal / participantes.size();

        int experienciaRestante =
                recompensaTotal % participantes.size();

        for (int i = 0; i < participantes.size(); i++) {
            Personagem personagem = participantes.get(i);

            int experienciaRecebida =
                    experienciaPorPersonagem;

            if (i < experienciaRestante) {
                experienciaRecebida++;
            }

            personagem.receberExperiencia(
                    experienciaRecebida
            );
        }

        return true;
    }
}
