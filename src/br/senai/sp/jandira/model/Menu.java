package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Cliente referenciaCliente = new Cliente();
    Conta referenciaConta = new Conta();

    public void executarMenu() {

        boolean continuarMenu = true;

        while (continuarMenu) {
            System.out.println("/**************-- Menu --************/");
            System.out.println("/ 1- Cadastrar cliente               /");
            System.out.println("/ 2- Cadastrar conta                 /");
            System.out.println("/ 3- Consultar saldo                 /");
            System.out.println("/ 4- Realizar saque                  /");
            System.out.println("/ 5- Realizar depósito               /");
            System.out.println("/ 6- Sair                            /");
            System.out.println("/**************----------************/");

            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser) {

                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    break;
                case 2:
                    Conta conta = new Conta();

                    System.out.print("Informe o CPF do cliente: ");
                    Long cpfCliente = scanner.nextLong();
                    scanner.nextLine();

                    Cliente clienteConta = referenciaCliente.pesquisarCliente(cpfCliente);

                    conta.cadastrarConta(clienteConta);
                    break;
                case 3:
//                    conta.consultarSaldo();
//                    break;
                case 4:
//                    System.out.print("Informe o valor que deseja sacar: ");
//                    double valorSaque = scanner.nextDouble();
//                    scanner.nextLine();
//                    referenciaConta.realizarSaque(valorSaque);
                    break;
                case 5:
//                    System.out.print("Informe o valor que deseja depositar: ");
//                    double valorDeposito = scanner.nextDouble();
//                    scanner.nextLine();
//                    referenciaConta.realizarDeposito(valorDeposito);
                    break;
                case 6:
                    continuarMenu = false;
                    break;
                default:
                    System.out.println("Obrigado por utilizar nosso banco SENAI!!!");
            }
        }
    }
}
