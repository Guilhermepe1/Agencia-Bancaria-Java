package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Login {

    Scanner scanner = new Scanner(System.in);

    public Conta realizarLogin(Conta referenciaConta, Cliente referenciaCliente) {

        System.out.print("CPF: ");
        long cpfUser = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Senha: ");
        String passwordUser = scanner.nextLine();

        Conta contaCliente = validarLogin(cpfUser, passwordUser, referenciaCliente, referenciaConta);

        if (contaCliente != null) {
            return contaCliente;
        } else {
            System.out.println("Dados incorretos! Verifique novamente ou abra uma conta.");
        }
        return null;
    }

    public Conta validarLogin(long cpfUser, String passwordUser, Cliente userCliente, Conta referenciaConta) {
        Cliente dadosCliente = userCliente.pesquisarCliente(cpfUser);
        if (dadosCliente != null) {
            Conta contaCliente = referenciaConta.pesquisarConta(dadosCliente);
            String password = contaCliente.getPassword();

            if (password.equals(passwordUser)) {
                return contaCliente;
            }
        }
        return null;
    }
}
