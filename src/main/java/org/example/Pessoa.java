package org.example;

import java.time.LocalDate;

public abstract class Pessoa {
    protected LocalDate dataNascimento;

    public abstract boolean cadastroCpf(String cpf);
    public abstract boolean cadastroCNPJ(String cnpj);

    public boolean cadastroNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return true;
    }
}
