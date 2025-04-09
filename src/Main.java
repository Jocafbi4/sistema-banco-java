import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);

        //Coleta de dados
        System.out.println("Dados iniciais do cliente");
        System.out.println("Digite seu nome: ");
        String nome = dados.nextLine();

        System.out.println("Digite seu CPF:");
        String cpf = dados.nextLine();

        System.out.println("Escolha o tipo da conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        int tipoEscolhido = dados.nextInt();

        TipoConta tipoConta;
        if (tipoEscolhido == 1) {
            tipoConta = TipoConta.CORRENTE;
        } else {
            tipoConta = TipoConta.POUPANCA;
        }

        System.out.println("Digite seu saldo inicial: ");
        double saldoInicial = dados.nextDouble();

        Cliente cliente = new Cliente(nome, cpf, saldoInicial, tipoConta);

        //Menu
        int opcao = 0;
        while (opcao != 4) {
        System.out.println("\n==============================");
        System.out.println("Cliente" + cliente.getNome());
        System.out.println("Saldo" + cliente.getSaldo());
        System.out.println("\n==============================");
        System.out.println("1 - Ver saldo");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
        opcao = dados.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Saldo atual: R$ " + cliente.getSaldo());
                break;
            case 2:
                System.out.println("Digite o valor para depósito: ");
                double deposito = dados.nextDouble();
                cliente.depositar(deposito);
                System.out.println("Deposito realizado com sucesso!");
                break;
            case 3:
                System.out.println("Digite o valor para saque:");
                double saque = dados.nextDouble();
                boolean sucesso = cliente.sacar(saque);
                if (sucesso) {
                    System.out.println("Saque realizado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente.");
                    break;
                }
            case 4:
                System.out.println("Obrigado por usar nosso sistema. Até logo!");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
            }
        }
        dados.close();
    }
}


