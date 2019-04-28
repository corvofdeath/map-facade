package bussiness.alunos;

import domain.entities.Aluno;
import domain.entities.Historico;
import domain.entities.Matricula;
import domain.entities.Sala;
import repositories.BaseRepository;

import java.util.ArrayList;

public class AlunoService {

    private BaseRepository<Aluno> repository;

    public AlunoService(BaseRepository<Aluno> repository) {
        this.repository = repository;
    }

    public Aluno registrarAluno(String nome) {
        Aluno aluno = new Aluno(nome, new ArrayList<Matricula>(), new ArrayList<Historico>());
        return this.repository.save(aluno);
    }

    public Aluno finalizarSemestre(Aluno aluno) {
        for (Matricula matricula : aluno.getMatriculas()) {
            Historico historico = new Historico(
                    aluno.getNome(),
                    matricula.getSala().getDisciplina().getNome(),
                    matricula.getNota(),
                    matricula.getSala().getProfessor().getNome()
            );

            aluno.getHistoricos().add(historico);
        }

        return aluno;
    }

    public Matricula matricularAlunoNaDisciplina(Sala sala, Aluno aluno) {
        Matricula matricula = new Matricula(aluno, sala.getDisciplina(), sala, 0);
        sala.getAlunos().add(aluno);
        aluno.getMatriculas().add(matricula);

        return matricula;
    }

    public BaseRepository<Aluno> getRepository() {
        return repository;
    }
}
