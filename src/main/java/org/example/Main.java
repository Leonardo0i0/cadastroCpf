package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Conexao.conectar();

        Scanner teclado = new Scanner(System.in);
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        boolean sucesso = false, opcao = false;
        Pessoa pessoa = null; // Inicializa null

        System.out.println("Seja bem-vindo ao cadastro de CPF/CNPJ");

        do {
            System.out.print("Digite os números do seu CPF ou CNPJ: ");
            String documento = teclado.nextLine();

            if (documento.length() == 11) {
                pessoa = new PessoaFisica();
                sucesso = pessoa.cadastroCpf(documento);
            } else if (documento.length() == 14) {
                pessoa = new PessoaJuridica();
                sucesso = pessoa.cadastroCNPJ(documento);
            } else {
                System.out.println("Documento inválido. Deve ter 11 (CPF) ou 14 (CNPJ) números.");
                sucesso = false;
            }

            if (sucesso && pessoa != null) {
                listaPessoas.add(pessoa);
                System.out.println("Cadastro realizado com sucesso!");
            } else if (!sucesso) {
                System.out.println("Falha no cadastro. Verifique os dados.");
            }

            System.out.println("Realizar novo cadastro? S/N");
            String o = teclado.nextLine();
            if(o.equals("s")){
                opcao = true;
            }else {
                opcao = false;
            }
        } while (!opcao);

        teclado.close();
    }
}
