package guilda.main;

import guilda.model.Arqueiro;
import guilda.model.Equipe;
import guilda.model.Guerreiro;
import guilda.model.Mago;
import guilda.model.Missao;
import guilda.model.Personagem;
import guilda.service.GerenciadorMissoes;

public class Main {

     static void main() {

        System.out.println("=== GUILDA DE AVENTUREIROS ===");

        Guerreiro guerreiro = new Guerreiro(
                "Aragorn",
                "Veterano",
                40,
                "Armadura de aço"
        );

        Mago mago = new Mago(
                "Gandalf",
                "Mestre",
                50,
                100
        );

        Arqueiro arqueiro = new Arqueiro(
                "Legolas",
                "Veterano",
                45,
                20
        );

        Equipe equipe = new Equipe(
                "Guardiões do Reino"
        );

        equipe.adicionarPersonagem(
                guerreiro,
                true
        );

        equipe.adicionarPersonagem(mago);
        equipe.adicionarPersonagem(arqueiro);

        System.out.println();
        System.out.println("=== PERSONAGENS ===");

        for (Personagem personagem :
                equipe.getPersonagens()) {

            System.out.println(personagem);
        }

        System.out.println();
        System.out.println("=== PODER DA EQUIPE ===");

        System.out.println(
                "Poder total: " +
                        equipe.calcularPoderTotal()
        );

        System.out.println();
        System.out.println("=== HABILIDADE ESPECIAL ===");

        mago.usarHabilidadeEspecial();

        System.out.println(
                "Poder após gastar mana: " +
                        equipe.calcularPoderTotal()
        );

        Missao missaoPrincipal = new Missao(
                "Derrotar o Dragão",
                400,
                300
        );

        Missao encontrarMapa = new Missao(
                "Encontrar o mapa antigo",
                50,
                100
        );

        Missao atravessarFloresta = new Missao(
                "Atravessar a floresta sombria",
                100,
                150
        );

        Missao derrotarLobos = new Missao(
                "Derrotar os lobos",
                60,
                75
        );

        Missao encontrarPonte = new Missao(
                "Encontrar a ponte",
                40,
                50
        );

        atravessarFloresta.adicionarSubmissao(
                derrotarLobos
        );

        atravessarFloresta.adicionarSubmissao(
                encontrarPonte
        );

        missaoPrincipal.adicionarSubmissao(
                encontrarMapa
        );

        missaoPrincipal.adicionarSubmissao(
                atravessarFloresta
        );

        System.out.println();
        System.out.println("=== ESTRUTURA DA MISSÃO ===");

        System.out.println(
                missaoPrincipal.exibirEstrutura()
        );

        System.out.println(
                "Quantidade de etapas: " +
                        missaoPrincipal.contarEtapas()
        );

        System.out.println(
                "Recompensa total: " +
                        missaoPrincipal.calcularRecompensaTotal() +
                        " XP"
        );

        GerenciadorMissoes gerenciador =
                new GerenciadorMissoes();

        System.out.println();
        System.out.println("=== EXECUÇÃO DA MISSÃO ===");

        boolean venceu = gerenciador.executarMissao(
                equipe,
                missaoPrincipal
        );

        if (venceu) {
            System.out.println(
                    "A equipe concluiu a missão!"
            );
        } else {
            System.out.println(
                    "A equipe não possui poder suficiente."
            );
        }

        System.out.println(
                "Missão concluída: " +
                        missaoPrincipal.isConcluida()
        );

        System.out.println();
        System.out.println("=== RESULTADO DOS PERSONAGENS ===");

        for (Personagem personagem :
                equipe.getPersonagens()) {

            System.out.println(
                    personagem.getNome() +
                            " — " +
                            personagem.getExperiencia() +
                            " XP"
            );
        }

        System.out.println();
        System.out.println("=== INFORMAÇÕES ESPECÍFICAS ===");

        for (Personagem personagem :
                equipe.getPersonagens()) {

            if (personagem instanceof Guerreiro g) {
                System.out.println(
                        g.getNome() +
                                " é um guerreiro e utiliza " +
                                g.getArmadura()
                );

            } else if (personagem instanceof Mago m) {
                System.out.println(
                        m.getNome() +
                                " é um mago e possui " +
                                m.getMana() +
                                " de mana"
                );

            } else if (personagem instanceof Arqueiro a) {
                System.out.println(
                        a.getNome() +
                                " é um arqueiro e possui " +
                                a.getQtdFlechas() +
                                " flechas"
                );
            }
        }
    }
}