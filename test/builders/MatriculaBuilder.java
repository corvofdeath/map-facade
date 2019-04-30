package builders;

import java.util.ArrayList;
import java.util.Collection;

import domain.entities.Aluno;
import domain.entities.Disciplina;
import domain.entities.Matricula;
import domain.entities.Sala;

public class MatriculaBuilder {
	
	private Matricula matricula;
	private Collection<Matricula> matriculas;
	
	public static MatriculaBuilder mockMatricula() {
		Aluno aluno = AlunoBuilder.mockAluno().getAluno();
		Disciplina disciplina = DisciplinaBuilder.mockDisciplina().getDisciplina();
		Sala sala = SalaBuilder.mockSala().getSala();

		MatriculaBuilder builder = new MatriculaBuilder();
		builder.matricula = new Matricula(aluno, disciplina, sala, new Double(7.5));
		
		return builder;
	}
	
	public static MatriculaBuilder mockCollectionMatriculas() {
		Aluno aluno = AlunoBuilder.mockAluno().getAluno();
		Disciplina disciplina = DisciplinaBuilder.mockDisciplina().getDisciplina();
		Sala sala = SalaBuilder.mockSala().getSala();
		MatriculaBuilder builder = new MatriculaBuilder();
		builder.matriculas = new ArrayList<Matricula>();
		
		for(int i=0; i<10; i++) {
			Matricula matricula = new Matricula(aluno, disciplina, sala, new Double(i));
			
			builder.matriculas.add(matricula);
			
		}
		
		return builder;
	}
	
	public Matricula getMatricula() {
		return this.matricula;
	}
	
	public Collection<Matricula> getMatriculas(){
		return this.matriculas;
	}
}
