import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exibe o cabeçalho
        Cabecalho.exibir();

        // Lista de questões
        List<Questao> questoes = new ArrayList<>();
        questoes.add(new Questao("Qual é a capital do Brasil?", "A) São Paulo", "B) Rio de Janeiro", "C) Brasília", "D) Salvador", "E) Belo Horizonte", "C"));
        questoes.add(new Questao("Quanto é 2 + 2?", "A) 3", "B) 4", "C) 5", "D) 6", "E) 7", "B"));
        questoes.add(new Questao("Qual o maior planeta do sistema solar?", "A) Terra", "B) Marte", "C) Júpiter", "D) Saturno", "E) Vênus", "C"));
        questoes.add(new Questao("Quem pintou a Mona Lisa?", "A) Van Gogh", "B) Michelangelo", "C) Leonardo da Vinci", "D) Pablo Picasso", "E) Salvador Dalí", "C"));
        questoes.add(new Questao("Qual o elemento químico de símbolo O?", "A) Ouro", "B) Oxigênio", "C) Prata", "D) Carbono", "E) Hidrogênio", "B"));
        questoes.add(new Questao("Quem descobriu o Brasil?", "A) Pedro Álvares Cabral", "B) Cristóvão Colombo", "C) Dom Pedro I", "D) Vasco da Gama", "E) Tiradentes", "A"));
        questoes.add(new Questao("Quantos estados tem o Brasil?", "A) 24", "B) 25", "C) 26", "D) 27", "E) 28", "C"));
        questoes.add(new Questao("Qual a montanha mais alta do mundo?", "A) Everest", "B) K2", "C) Kilimanjaro", "D) Aconcágua", "E) Makalu", "A"));
        questoes.add(new Questao("Quem escreveu 'Dom Quixote'?", "A) Machado de Assis", "B) William Shakespeare", "C) Miguel de Cervantes", "D) José Saramago", "E) Fernando Pessoa", "C"));
        questoes.add(new Questao("Qual o país do tango?", "A) Brasil", "B) Chile", "C) México", "D) Argentina", "E) Espanha", "D"));
        questoes.add(new Questao("Em que ano ocorreu a Proclamação da República no Brasil?", "A) 1808", "B) 1822", "C) 1889", "D) 1922", "E) 1964", "C"));
        questoes.add(new Questao("Qual o maior oceano do mundo?", "A) Atlântico", "B) Índico", "C) Ártico", "D) Pacífico", "E) Antártico", "D"));
        questoes.add(new Questao("Quem é conhecido como o pai da computação?", "A) Bill Gates", "B) Alan Turing", "C) Steve Jobs", "D) Charles Babbage", "E) Ada Lovelace", "B"));
        questoes.add(new Questao("Qual a fórmula química da água?", "A) CO2", "B) H2O", "C) O2", "D) H2SO4", "E) CH4", "B"));
        questoes.add(new Questao("Qual o time brasileiro com mais títulos da Libertadores?", "A) Flamengo", "B) São Paulo", "C) Grêmio", "D) Palmeiras", "E) Santos", "D"));

        int acertos = 0;

        for (Questao q : questoes) {
            q.escrevaQuestao();
            String resposta = q.leiaResposta();
            if (q.isCorreta(resposta)) {
                acertos++;
            }
        }

        int totalQuestoes = questoes.size();
        int erros = totalQuestoes - acertos;

        double percAcertos = ((double) acertos / totalQuestoes) * 100;
        double percErros = ((double) erros / totalQuestoes) * 100;

        System.out.println("Você acertou " + acertos + " de " + totalQuestoes + " questões!");
        System.out.printf("Porcentagem de acertos: %.2f%%\n", percAcertos);
        System.out.printf("Porcentagem de erros: %.2f%%\n", percErros);

        scanner.close();
    }
}

class Cabecalho {
    public static void exibir() {
        System.out.println("=======================================");
        System.out.println("FACULDADE UNIFAN");
        System.out.println("Aluno: Welington Filho");
        System.out.println("Professor: Brenno");
        System.out.println("Tema: Quiz de Conhecimentos Gerais");
        System.out.println("=======================================\n");
    }
}

class Questao {
    String pergunta;
    String opcaoA, opcaoB, opcaoC, opcaoD, opcaoE;
    String correta;

    public Questao(String pergunta, String opcaoA, String opcaoB, String opcaoC, String opcaoD, String opcaoE, String correta) {
        this.pergunta = pergunta;
        this.opcaoA = opcaoA;
        this.opcaoB = opcaoB;
        this.opcaoC = opcaoC;
        this.opcaoD = opcaoD;
        this.opcaoE = opcaoE;
        this.correta = correta;
    }

    public void escrevaQuestao() {
        System.out.println(pergunta);
        System.out.println(opcaoA);
        System.out.println(opcaoB);
        System.out.println(opcaoC);
        System.out.println(opcaoD);
        System.out.println(opcaoE);
        System.out.println();
    }

    public String leiaResposta() {
        Scanner scanner = new Scanner(System.in);
        String resposta;
        do {
            System.out.print("Digite a resposta: ");
            resposta = scanner.next().toUpperCase();
        } while (!respostaValida(resposta));
        return resposta;
    }

    private boolean respostaValida(String resposta) {
        if (resposta.matches("[ABCDE]")) {
            return true;
        }
        System.out.println("Resposta inválida! Digite A, B, C, D ou E.");
        return false;
    }

    public boolean isCorreta(String resposta) {
        if (resposta.equalsIgnoreCase(this.correta)) {
            System.out.println("Parabéns! Resposta correta.\n");
            return true;
        } else {
            System.out.println("Resposta errada! A opção correta era: " + this.correta + "\n");
            return false;
        }
    }
}
