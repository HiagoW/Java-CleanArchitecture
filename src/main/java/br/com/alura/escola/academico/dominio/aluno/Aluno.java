package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();

    private String senha;

    public void adicionarTelefone(String ddd, String numero) {
        if (telefones.size() == 2) {
            throw new IllegalArgumentException("Numero maximo de telefones ja atingido!");
        }
        this.telefones.add(new Telefone(ddd, numero));
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
