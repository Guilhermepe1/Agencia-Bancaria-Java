package br.senai.sp.jandira.model;

import java.util.Random;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Cliente referenciaCliente = new Cliente();
    Conta referenciaConta = new Conta();
    Login login = new Login();

    public void executarMenu() {

        boolean exit = false;

        while (!exit) {

            Conta contaCliente = new Conta();

            System.out.println("----------------------------------");
            System.out.println("|           Banco SENAI          |");
            System.out.println("|    O seu dinheiro está aqui    |");
            System.out.println("----------------------------------");
            System.out.println("| 1- Login                       |");
            System.out.println("| 2- Criar conta                 |");
            System.out.println("| 3- Exit                        |");
            System.out.println("----------------------------------");

            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser) {
                case 1:
                    contaCliente = login.realizarLogin(referenciaConta, referenciaCliente);
                    if (contaCliente != null) {
                        contaCliente.exibirPerfil(contaCliente);
                        acessarConta(contaCliente);
                    }
                    break;
                case 2:
                    referenciaConta.criarConta(referenciaCliente);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    promoverIdeias();
            }
        }
    }

    public void acessarConta(Conta conta) {
        boolean continuarMenu = true;

        while (continuarMenu) {
            System.out.println("/**************-- Menu --************/");
            System.out.println("/ 1- Consultar saldo                 /");
            System.out.println("/ 2- Realizar saque                  /");
            System.out.println("/ 3- Realizar depósito               /");
            System.out.println("/ 4- Realizar tranferência           /");
            System.out.println("/ 5- Alterar senha");
            System.out.println("/ 6- Encerrar sessão                 /");
            System.out.println("/**************----------************/");

            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser) {

                case 1:
                    conta.consultarSaldo();
                    promoverIdeias();
                    break;
                case 2:
                    System.out.print("Informe o valor que deseja sacar: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();
                    conta.realizarSaque(valorSaque);
                    promoverIdeias();
                    break;
                case 3:
                    System.out.print("Informe o valor que deseja depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    conta.realizarDeposito(valorDeposito);
                    promoverIdeias();
                    break;
                case 4:
                    referenciaConta.transferir(referenciaCliente, conta);
                    promoverIdeias();
                    break;
                case 5:
                    conta.alterarSenha();
                    promoverIdeias();
                    break;
                case 6:
                    continuarMenu = false;
                    break;
                default:
                    promoverIdeias();
                    System.out.println("Obrigado por utilizar nosso banco SENAI!!!");
            }
        }
    }

    public void promoverIdeias() {
        Random random = new Random();

        int promocao = random.nextInt(4);

        switch (promocao) {
            case 1:
                System.out.println("As melhores taxas estão aqui!");
                break;
            case 2:
                System.out.println("Investir é mirar o sucesso!");
                break;
            case 3:
                System.out.println("O Banco SENAI é líder em boa reputação!");
                break;
            default:
                System.out.println("Serviços exclusivos para você! ;)");
        }
    }
}
