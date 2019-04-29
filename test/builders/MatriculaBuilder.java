package builders;

import domain.entities.Aluno;
import domain.entities.Disciplina;
import domain.entities.Matricula;
import domain.entities.Sala;

public class MatriculaBuilder {
	
	private Matricula matricula;
	
	public static MatriculaBuilder mockMatricula() {
		Aluno aluno = AlunoBuilder.mockAluno().getAluno();
		Disciplina disciplina = DisciplinaBuilder.mockDisciplina().getDisciplina();
		Sala sala = SalaBuilder.mockSala().getSala();

		MatriculaBuilder builder = new MatriculaBuilder();
		builder.matricula = new Matricula(aluno, disciplina, sala, new Double(7.5));
		
		return builder;
	}
	
	public Matricula getMatricula() {
		return this.matricula;
	}
}
