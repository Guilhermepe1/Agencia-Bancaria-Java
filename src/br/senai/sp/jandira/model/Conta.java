package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {
    private int numeroConta;
    private String agencia = "3606-XX";
    String password, confirmPassword;
    private double saldo = 0;
    private Cliente cliente;

    List<Conta> listCont = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);


    public void gerarConta(Cliente cliente) {
        System.out.println("/-------    Gerando Conta --------/");
        numeroConta = (int) (Math.random()*10000);
        System.out.print("Informe uma senha: ");
        password = scanner.nextLine();
        do {
            System.out.print("Confirme a senha: ");
            confirmPassword = scanner.nextLine();
            if (!password.equals(confirmPassword)) {
                System.out.println("Revise a senha!");
            }
        } while (!password.equals(confirmPassword));

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

    private boolean avaliarSaque(double valor) {
        if (this.saldo >= valor) {
            return true;
        } else {
            return false;
        }
    }

    public void adicionarList(Conta conta) {
        listCont.add(conta);
    }


    public Conta pesquisarConta(Cliente cliente) {
        for (Conta conta : listCont) {
            if (cliente == conta.cliente) {
                return conta;
            }
        }
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void criarConta(Cliente referenciaCliente) {

        Cliente cliente = new Cliente();
        long cpfCliente = cliente.cadastrarCliente();
        referenciaCliente.adicionarList(cliente);

        Conta conta = new Conta();

        Cliente clienteConta = referenciaCliente.pesquisarCliente(cpfCliente);

        conta.gerarConta(clienteConta);
        adicionarList(conta);
    }

    public void exibirPerfil(Conta conta) {

        System.out.println("----------------------------------");
        System.out.println("| Olá "+conta.cliente.getNome()+"!");
        System.out.println("| Agência: "+conta.getAgencia());
        System.out.println("| Conta: "+conta.getNumeroConta());

    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void transferir(Cliente referenciaCliente, Conta contaCliente) {

        System.out.print("Informe o CPF do destinatário: ");
        long cpf = scanner.nextLong();
        scanner.nextLine();

        Cliente clienteDestinatario = referenciaCliente.pesquisarCliente(cpf);
        Conta contaDestinatario = pesquisarConta(clienteDestinatario);

        if (contaDestinatario != null) {
            System.out.println("| - Transferência para: "+clienteDestinatario.getNome());
            System.out.print("Informe o valor: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            if (contaCliente.saldo >= valor) {
                System.out.println("Transferência realizada com sucesso!");
                System.out.println("---------> Comprovante de transferência");
                System.out.println("| - Agência: "+contaCliente.getAgencia());
                System.out.println("| - Conta: "+contaCliente.getNumeroConta());
                System.out.println("| - Remetente: "+contaCliente.cliente.getNome());
                System.out.println("| - CPF do remetente: "+contaCliente.cliente.getCpf());
                System.out.println("| - Valor: R$"+valor);
                System.out.println("| - Agência: "+contaDestinatario.getAgencia());
                System.out.println("| - Conta: "+contaDestinatario.getNumeroConta());
                System.out.println("| - Destinatário: "+contaDestinatario.cliente.getNome());
                System.out.println("| - CPF do destinatário: "+contaDestinatario.cliente.getCpf());
                System.out.println("-----------------------------------------------");

                contaCliente.saldo -= valor;
                contaDestinatario.saldo += valor;
            } else {
                System.out.println("Saldo para transferência indisponível!");
            }
        } else {
            System.out.println("CPF destinatário não encontrado!");
        }
    }

    public void alterarSenha() {
        String confirmNewPassword;

        System.out.print("Digite uma nova senha: ");
        String newPassword = scanner.nextLine();
        do {
            System.out.print("Confirme a senha: ");
            confirmNewPassword = scanner.nextLine();

            if (!newPassword.equals(confirmNewPassword)) {
                System.out.println("As senhas não coincidem! Verifique novamente.");
            }

        } while (!newPassword.equals(confirmNewPassword));

        setPassword(newPassword);
        System.out.println("Senha alterada com sucesso!");
    }
}
