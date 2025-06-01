package org.example;

import java.time.LocalDate;

public abstract class Pessoa {
    protected LocalDate dataNascimento;

    protected abstract boolean cadastroCpf(String cpf);
    protected abstract boolean cadastroCNPJ(String cnpj);

    public boolean cadastroNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return true;
    }
}
