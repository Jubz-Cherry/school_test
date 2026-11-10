import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, double[]> alunos = new LinkedHashMap<>();

    static Scanner scanner = new Scanner(System.in);

    static {
        alunos.put("Anna", new double[]{8.5, 7.0, 4.5});
        alunos.put("Bob", new double[]{4.5, 2.5, 5.0});
        alunos.put("Joca", new double[]{9.5, 7.5, 8.0});
        alunos.put("Maria", new double[]{10.0, 9.5, 8.5});
    }

    static double sum(double[] notas) {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma;
    }

    static void calcular_media_sala() {
        double soma_total = 0;
        double media_sala = 0;

        for (double[] notas : alunos.values()) {
            soma_total += sum(notas);
        }

        media_sala = soma_total / alunos.size();
        System.out.printf("\n A média da sala é: %.2f%n", media_sala);
    }

    static void calcular_media_aluno() {
        for (Map.Entry<String, double[]> entrada : alunos.entrySet()) {
            String aluno = entrada.getKey();
            double[] notas = entrada.getValue();

            double media = sum(notas) / notas.length;

            System.out.printf("\n A média do aluno %s é: %.2f%n", aluno, media);
        }
    }

    static void calcular_quantidade_aprovados_reprovados() {
        int aprovados = 0;
        int reprovados = 0;

        for (double[] notas : alunos.values()) {
            double media = sum(notas) / notas.length;

            if (media >= 7.0) {
                aprovados += 1;
            } else {
                reprovados += 1;
            }
        }

        System.out.println("\n Quantidade de aprovados: " + aprovados);
        System.out.println("\n Quantidade de reprovados: " + reprovados);
    }

    static void gerar_relatorio() {
        for (Map.Entry<String, double[]> entrada : alunos.entrySet()) {
            String aluno = entrada.getKey();
            double[] notas = entrada.getValue();

            double media = sum(notas) / notas.length;
            String status = media >= 7.0 ? "Aprovado" : "Reprovado";

            System.out.printf("\n Aluno: %s | Média: %.2f | Status: %s%n",
                    aluno, media, status);
        }
    }

    static void exibir_menu() {
        while (true) {
            System.out.println("\n--- MENU DE OPÇÕES ---");
            System.out.println("\n 1 - Calcular média da sala");
            System.out.println("\n 2 - Calcular média de cada aluno");
            System.out.println("\n 3 - Mostrar quantidade de aprovados e reprovados");
            System.out.println("\n 4 - Geração de relatório da turma");
            System.out.println("\n 5 - Sair");

            try {
                System.out.print("\n Escolha uma opção: ");
                int opcao_escolhida = Integer.parseInt(scanner.nextLine());

                if (opcao_escolhida == 1) {
                    calcular_media_sala();

                } else if (opcao_escolhida == 2) {
                    calcular_media_aluno();

                } else if (opcao_escolhida == 3) {
                    calcular_quantidade_aprovados_reprovados();

                } else if (opcao_escolhida == 4) {
                    gerar_relatorio();

                } else if (opcao_escolhida == 5) {
                    System.out.println("\n Saindo...");
                    break;

                } else {
                    System.out.println("\n Opção inválida. Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("\n Digite uma opção válida.");
            }
        }
    }

    public static void main(String[] args) {
        exibir_menu();
    }
}
