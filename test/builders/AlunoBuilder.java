package builders;

import java.util.ArrayList;
import java.util.List;

import domain.entities.Aluno;
import domain.entities.Historico;
import domain.entities.Matricula;

public class AlunoBuilder {
	
	private Aluno aluno;
	
	public static AlunoBuilder mockAluno() {
		AlunoBuilder builder = new AlunoBuilder();
		builder.aluno = new Aluno("Thiago", new ArrayList<Matricula>() , new ArrayList<Historico>());
		
		return builder;
	}
	
	public Aluno getAluno() {
		return this.aluno;
	}
}
