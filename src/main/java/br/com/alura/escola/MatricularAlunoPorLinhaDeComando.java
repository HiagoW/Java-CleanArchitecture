package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.gamificacao.aplicacao.GeraSeloAlunoNovato;
import br.com.alura.escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

public class MatricularAlunoPorLinhaDeComando {
    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.456.789-00";
        String email = "fulano@email.com";

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        RepositorioDeSelosEmMemoria repositorioDeSelosEmMemoria = new RepositorioDeSelosEmMemoria();
        publicador.adicionar(new GeraSeloAlunoNovato(repositorioDeSelosEmMemoria));

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);

        // Command design pattern
        matricularAluno.executa(
                new MatricularAlunoDto(nome, cpf, email)
        );

        CPF cpfObj = new CPF(cpf);

        System.out.println(repositorioDeSelosEmMemoria.selosDoAlunoDeCPF(cpfObj).get(0).getNome());

    }
}
