package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    /** Declara variaveis */
    private String nome;
    private long cpf, rg, telefone;

    List<Cliente> listCliente = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void cadastrarCliente() {
        System.out.println("/-------    Cadastrar Cliente --------/");
        System.out.print("Informe o nome: ");
        nome = scanner.nextLine();
        System.out.print("Informe o CPF: ");
        cpf = scanner.nextLong();
        System.out.print("Informe o RG: ");
        rg = scanner.nextLong();
        System.out.print("Informe o telefone: ");
        telefone = scanner.nextLong();
        scanner.nextLine();
        System.out.println("/-------------------------------------/");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public void adicionarList(Cliente cliente) {
        listCliente.add(cliente);
    }

    public void listarClientes() {
        for (Cliente cliente : listCliente) {
            System.out.println(cliente.getNome());
            System.out.println(cliente.getCpf());
        }
    }

    public Cliente pesquisarCliente(long cpf) {
        for (Cliente cliente : listCliente) {
            long cpfCliente = cliente.getCpf();

            if (cpfCliente == cpf) {
                return cliente;
            }
        }

        return null;
    }
}
