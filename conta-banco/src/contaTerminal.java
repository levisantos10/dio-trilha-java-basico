import java.util.ArrayList;
import java.util.Scanner;

public class contaTerminal {

    static ArrayList<conta> contas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
              case 1:
                   cadastrarConta();
                   break;
              case 2:
                   listarContas();
                   break;
              case 3:
                   realizarSaque();
                   break;
              case 4:
                   System.out.println("Saindo do sistema...");
                   break;
             default:
                   System.out.println("Opção inválida. Tente novamente.");
            }
        } 
        while (opcao != 3);

        scanner.close();
    }

    public static void exibirMenu() {
    System.out.println("\n===== MENU =====");
    System.out.println("1 - Cadastrar nova conta");
    System.out.println("2 - Listar contas");
    System.out.println("3 - Realizar saque");
    System.out.println("4 - Sair");
}


    public static void cadastrarConta() {
    int numero = lerInteiro("Digite o número da Conta: ");
    String agencia = lerTexto("Digite o número da Agência: ");
    String nomeCliente = lerTexto("Digite o nome do Cliente: ");
    double saldo = lerDouble("Digite o saldo: ");

    conta conta = new conta(numero, agencia, nomeCliente, saldo);
    contas.add(conta);
    
    System.out.println("\nOlá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " 
        + agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.");
}


    public static void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            System.out.println("\n=== Lista de Contas ===");
            for (conta c : contas) {
                System.out.println(c);
            }
        }
    }

    public static void realizarSaque() {
    int numeroConta = lerInteiro("Digite o número da conta para saque: ");
    conta conta = buscarConta(numeroConta);
    
    if (conta == null) {
        System.out.println("Conta não encontrada.");
        return;
    }
    
    double valorSaque = lerDouble("Digite o valor do saque: ");
    
    if (valorSaque > conta.getSaldo()) {
        System.out.println("Saldo insuficiente para realizar o saque.");
    } else {
        conta.setSaldo(conta.getSaldo() - valorSaque);
        System.out.println("Saque realizado com sucesso. Novo saldo: " + conta.getSaldo());
    }
}


    public static conta buscarConta(int numeroConta) {
    for (conta c : contas) {
        if (c.getNumero() == numeroConta) {
            return c;
        }
    }
    return null;
}


    // Métodos auxiliares para entrada de dados
    public static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        int valor = scanner.nextInt();
        scanner.nextLine(); 
        return valor;
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        double valor = scanner.nextDouble();
        scanner.nextLine(); 
        return valor;
    }

    public static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}
