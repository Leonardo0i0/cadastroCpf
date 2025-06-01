package org.example;

public class PessoaFisica extends Pessoa {
    protected String cpf;
    @Override
    public boolean cadastroCpf(String cpf) {
        if (cpf.length() != 11) {
            return false;
        }
        this.cpf = cpf;
        return true;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public boolean cadastroCNPJ(String cnpj) {
        // Pessoa física não tem CNPJ
        return false;
    }
}
