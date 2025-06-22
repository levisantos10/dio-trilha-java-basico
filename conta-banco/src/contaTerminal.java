import java.util.ArrayList;
import java.util.Scanner;

public class contaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<conta> contas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar nova conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número da Conta: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o número da Agência: ");
                    String agencia = scanner.nextLine();

                    System.out.print("Digite o nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.print("Digite o saldo: ");
                    double saldo = scanner.nextDouble();
                    scanner.nextLine();

                    conta conta = new conta(numero, agencia, nomeCliente, saldo);
                    contas.add(conta);

                    System.out.println("\nConta cadastrada com sucesso!");
                    break;

                case 2:
                    if (contas.isEmpty()) {
                        System.out.println("\nNenhuma conta cadastrada.");
                    } else {
                        System.out.println("\n=== Lista de Contas ===");
                        for (conta c : contas) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}
