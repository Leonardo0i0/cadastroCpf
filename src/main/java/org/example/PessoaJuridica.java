package org.example;

public class PessoaJuridica extends Pessoa {
    protected String cnpj;
    @Override
    public boolean cadastroCpf(String cpf) {
        // Empresa não tem CPF
        return false;
    }

    @Override
    public boolean cadastroCNPJ(String cnpj) {
        if (cnpj.length() != 14) {
            return false;
        }
        this.cnpj = cnpj;
        return true;
    }
}
