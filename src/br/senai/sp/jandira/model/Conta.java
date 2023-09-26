package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {
    private int numeroConta;
    private String agencia;
    private double saldo = 0;
    private Cliente cliente;

    List<Conta> listCont = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);


    public void cadastrarConta(Cliente cliente) {
        System.out.println("/-------    Cadastrar Conta --------/");
        System.out.print("Informe o número da conta: ");
        numeroConta = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Informe a agência: ");
        agencia = scanner.nextLine();

        System.out.println("/-----------------------------------/");

        this.cliente = cliente;

    }

    public void realizarSaque(double valor) {
        boolean validaSaque = avaliarSaque(valor);

        if (validaSaque) {
            this.saldo -= valor;
        } else {
            System.out.println("Impossível realizar saque!!!");
        }
        System.out.println("O saldo disponível na conta é de: R$"+this.saldo);
    }

    public void realizarDeposito(double valor) {
        this.saldo += valor;
        System.out.println("O saldo disponível na conta é de: R$"+this.saldo);
    }

    public void consultarSaldo() {
        System.out.println("O saldo disponível na conta é de: R$"+this.saldo);
    }

    public boolean avaliarSaque(double valor) {
        if (this.saldo >= valor) {
            return true;
        } else {
            return false;
        }
    }
}
