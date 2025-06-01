package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Conexao.main();

        Scanner teclado = new Scanner(System.in);
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        boolean sucesso, opcao = false;
        int escolha;
        String documento;
        Pessoa pessoa = null;

    do {
        System.out.println("Seja bem-vindo ao cadastro de CPF/CNPJ");
        System.out.println("************************");
        System.out.println("*     1-Cadastrar      *");
        System.out.println("*     2-Consultar      *");
        System.out.println("*     3-Excluir        *");
        System.out.println("*     4-Sair           *");
        System.out.println("************************");
        escolha = teclado.nextInt();

        switch (escolha) {
            case 1:
                do {
                    System.out.print("Digite os números do seu CPF ou CNPJ: ");
                    teclado.nextLine();
                    documento = teclado.nextLine();

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
                    if (o.equals("s")) {
                        opcao = true;
                    } else {
                        opcao = false;
                    }
                } while (opcao);
                break;

            case 2:
                do {
                    System.out.println("************************");
                    System.out.println("*     1-CPF            *");
                    System.out.println("*     2-CNPJ           *");
                    System.out.println("*     3-Todos          *");
                    System.out.println("*     4-Sair           *");
                    System.out.println("************************");
                    escolha = teclado.nextInt();

                    switch (escolha) {
                        case 1:
                            do {
                                System.out.println("Digite o CPF");
                                teclado.nextLine();
                                documento = teclado.nextLine();

                                boolean encontrado = false;
                                for (Pessoa p : listaPessoas) {
                                    if (p instanceof PessoaFisica) {
                                        PessoaFisica pf = (PessoaFisica) p;
                                        if (pf.getCpf().equals(documento)) {
                                            System.out.println("Cpf encontrado");
                                            System.out.println(pf.getCpf());
                                            encontrado = true;
                                        }
                                    }
                                }

                                if (!encontrado) {
                                    System.out.println("CPF Não encontrado.");
                                }

                                System.out.println("Deseja consultar outro CPF? S/N");
                                String continuar = teclado.nextLine();
                                if (continuar.equals('s') || continuar.equals('S')) {
                                    opcao = true;
                                }


                            } while (opcao);
                            opcao = false;//retorna a falso para evitar saida indesejada de loop

                            break;
                        case 2:
                            do {
                                System.out.println("Digite o CNPJ");
                                teclado.nextLine();
                                documento = teclado.nextLine();

                                boolean encontrado = false;
                                for (Pessoa p : listaPessoas) {
                                    if (p instanceof PessoaJuridica) {
                                        PessoaJuridica pj = (PessoaJuridica) p;
                                        if (pj.getCnpj().equals(documento)) {
                                            System.out.println("Cpf encontrado");
                                            System.out.println(pj.getCnpj());
                                            encontrado = true;
                                        }
                                    }
                                }

                                if (!encontrado) {
                                    System.out.println("CNPJ Não encontrado.");
                                }

                                System.out.println("Deseja consultar outro CNPJ? S/N");
                                String continuar = teclado.nextLine();
                                if (continuar.equals('s') || continuar.equals('S')) {
                                    opcao = true;
                                }


                            } while (opcao);
                            opcao = false;//retorna a falso para evitar saida indesejada de loop
                            break;

                        case 3:
                            System.out.println("Lista de pessoas cadastradas:");

                            if (listaPessoas.isEmpty()) {
                                System.out.println("Nenhuma pessoa cadastrada.");
                            } else {
                                for (Pessoa p : listaPessoas) {
                                    if (p instanceof PessoaFisica) {
                                        PessoaFisica pf = (PessoaFisica) p;
                                        System.out.println("Pessoa Física:");
                                        System.out.println("CPF: " + pf.getCpf());

                                    } else if (p instanceof PessoaJuridica) {
                                        PessoaJuridica pj = (PessoaJuridica) p;
                                        System.out.println("Pessoa Jurídica:");
                                        System.out.println("CNPJ: " + pj.getCnpj());

                                    }
                                    System.out.println("---------------------------");
                                }
                            }

                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Opcção invalida");
                            break;
                    }

                } while (escolha != 4);

                break;
            case 3:
                break;

            default:
                System.out.println("Opcção invalida");
                break;
        }
    }while(escolha != 4);

        teclado.close();
    }
}
