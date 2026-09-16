# Guilda de Aventureiros

Aplicação de console em Java que modela uma guilda de RPG: personagens com habilidades distintas formam equipes, participam de missões e recebem experiência. Desenvolvida como projeto de estudo de **Programação Orientada a Objetos**, durante o curso de fundamentos de Java.

O projeto reúne modelagem de domínio, interfaces, herança, polimorfismo, coleções e recursão em um cenário executável, sem dependências externas.

## Funcionalidades

- Criação de guerreiros, magos e arqueiros com atributos e cálculos de poder próprios.
- Formação de equipes, definição de líder, remoção de integrantes e busca por ID.
- Cálculo do poder total da equipe por meio de polimorfismo.
- Habilidade especial do mago, com consumo de mana e exibição do dano calculado.
- Organização de missões e submissões em uma hierarquia.
- Contagem de etapas, soma de recompensas e exibição da hierarquia por recursão.
- Execução de missões com comparação entre poder da equipe e dificuldade.
- Distribuição de XP entre os participantes, incluindo o resto da divisão.

## Tecnologias e requisitos

- **JDK 25 ou superior**, com `java` e `javac` disponíveis no terminal.
- Java Collections Framework (`List` e `ArrayList`).
- Git para versionamento.
- IntelliJ IDEA como opção de ambiente de desenvolvimento.

A entrada da aplicação utiliza `static void main()` sem argumentos. Para executar esta versão conforme os comandos abaixo, utilize o JDK 25. Não é necessário instalar Maven, Gradle, bibliotecas externas ou banco de dados.

## Como executar

Clone o repositório e entre na pasta:

```sh
git clone https://github.com/eduardoaguiarc/2--Guild-Project-POO.git
cd 2--Guild-Project-POO
```

Confira a versão do JDK:

```sh
java -version
javac -version
```

### Windows — PowerShell

```powershell
$fontes = @(Get-ChildItem -Path src -Filter *.java -Recurse | ForEach-Object { $_.FullName })
javac -encoding UTF-8 -d out $fontes
java '-Dfile.encoding=UTF-8' -cp out guilda.main.Main
```

### Linux e macOS — Bash

```bash
find src -name '*.java' -print0 | xargs -0 javac -encoding UTF-8 -d out
java -Dfile.encoding=UTF-8 -cp out guilda.main.Main
```

### IntelliJ IDEA

1. Abra a pasta do projeto.
2. Configure o SDK e o nível de linguagem do projeto para Java 25.
3. Se necessário, marque `src` como **Sources Root**.
4. Execute o método `main` da classe `guilda.main.Main`.

A aplicação executa uma demonstração predefinida e encerra, sem solicitar entrada pelo teclado. Para experimentar outros cenários, altere os personagens e as missões em [`Main.java`](src/guilda/main/Main.java).

## Demonstração

O cenário principal cria a equipe **Guardiões do Reino**, formada por Aragorn, Gandalf e Legolas. O poder inicial é 490. Após Gandalf usar Explosão Arcana, sua mana cai de 100 para 70 e o poder da equipe passa a 460.

A missão possui a seguinte estrutura:

```text
- Derrotar o Dragão
  - Encontrar o mapa antigo
  - Atravessar a floresta sombria
    - Derrotar os lobos
    - Encontrar a ponte
```

Resultados observados na execução do cenário:

| Indicador | Resultado |
| --- | --- |
| Poder da equipe após a habilidade | 460 |
| Dificuldade da missão principal | 400 |
| Etapas, incluindo a missão principal | 5 |
| Recompensa total | 675 XP |
| Estado da missão principal | Concluída |
| Experiência recebida por personagem | 225 XP |

## Organização do projeto

```text
src/guilda/
├── contract/
│   ├── Combatente.java
│   └── Especialista.java
├── main/
│   └── Main.java
├── model/
│   ├── Arqueiro.java
│   ├── Equipe.java
│   ├── Guerreiro.java
│   ├── Mago.java
│   ├── Missao.java
│   └── Personagem.java
└── service/
    └── GerenciadorMissoes.java
```

| Pacote | Responsabilidade |
| --- | --- |
| `contract` | Define os contratos de combate e habilidade especial. |
| `model` | Representa personagens, equipes, missões e seus comportamentos. |
| `service` | Coordena a execução de missões e a distribuição de experiência. |
| `main` | Monta e executa o cenário demonstrativo. |

## Conceitos de POO aplicados

| Conceito | Aplicação no código |
| --- | --- |
| Abstração | `Personagem` concentra atributos comuns e declara `calcularPoder()` como método abstrato. |
| Herança | `Guerreiro`, `Mago` e `Arqueiro` especializam `Personagem`. |
| Polimorfismo | `Equipe` percorre uma lista de `Personagem` e utiliza o cálculo de poder de cada classe concreta. |
| Interfaces | `Combatente` define ataque e defesa; `Especialista` estende esse contrato com uma habilidade especial. |
| Encapsulamento | Métodos controlam alterações de estado; as listas de integrantes e submissões são expostas por cópias não modificáveis. |
| Sobrecarga | Construtores oferecem diferentes formas de criação; `adicionarPersonagem` permite indicar o líder. |
| Identidade de objetos | `Personagem` possui ID e sobrescreve `equals`, `hashCode` e `toString`. |
| Recursão | `Missao` percorre suas submissões para contar etapas, somar XP e exibir a estrutura. |
| Reconhecimento de tipos | `Main` utiliza pattern matching com `instanceof` para exibir atributos específicos. |

## Regras de execução das missões

1. A equipe e a missão devem existir, e a equipe precisa ter integrantes.
2. Se o poder total for menor que a dificuldade da missão recebida, a execução retorna `false`.
3. Caso contrário, essa missão é marcada como concluída.
4. A recompensa inclui o XP da missão e de todas as suas submissões.
5. O XP é dividido igualmente; eventuais pontos restantes são entregues aos primeiros integrantes da lista, um ponto por integrante.

Na implementação atual, as submissões participam da estrutura e do cálculo da recompensa. Suas dificuldades não são verificadas individualmente, e seus estados de conclusão não são alterados automaticamente ao concluir a missão principal.

## Validação e possibilidades de evolução

Esta versão foi compilada e teve o cenário de `Main` executado com JDK 25. O projeto ainda não possui uma suíte de testes automatizados.

Possíveis próximos passos de desenvolvimento:

- Adicionar testes com JUnit para personagens, equipes e distribuição de recompensas.
- Uniformizar as validações de atributos, valores negativos e campos obrigatórios.
- Impedir a concessão repetida de XP por uma missão já concluída.
- Detectar ciclos indiretos na hierarquia de submissões.
- Implementar um menu interativo e persistência dos dados.

Os dados atuais permanecem apenas em memória. O combate é representado por cálculos de poder e dano; não há simulação de turnos ou aplicação de dano a inimigos.

## Autor

Desenvolvido por **Eduardo Aguiar** como parte dos estudos em Java e Programação Orientada a Objetos.

[Perfil no GitHub](https://github.com/eduardoaguiarc)
