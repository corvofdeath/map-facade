package bussiness.alunos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import builders.AlunoBuilder;
import builders.MatriculaBuilder;
import builders.SalaBuilder;
import bussiness.alunos.AlunoService;
import domain.entities.Aluno;
import domain.entities.Matricula;
import domain.entities.Sala;
import repositories.BaseRepository;

public class AlunoServiceTest {
	
	private AlunoService alunoService;
	private BaseRepository<Aluno> repositorio;
	private Aluno aluno;
	private Sala sala;

	@Before
    public void setUp(){
		this.repositorio = new BaseRepository<Aluno>(new ArrayList<Aluno>());
		this.alunoService = new AlunoService(this.repositorio);
		this.aluno = AlunoBuilder.mockAluno().getAluno();
		this.sala = SalaBuilder.mockSala().getSala();
	}
	
	@Test
	public void testRegistrarAluno() {
		assertEquals(this.alunoService.registrarAluno(this.aluno.getNome()).getNome(), this.aluno.getNome());
		assertFalse(this.alunoService.getRepository().getAll().isEmpty());
	}
	
	@Test
	public void testFinalizarSemestre() {
		this.aluno.setMatriculas((List<Matricula>)MatriculaBuilder.mockCollectionMatriculas().getMatriculas());
		assertFalse(this.alunoService.finalizarSemestre(this.aluno).getHistoricos().isEmpty());
	}
	
	@Test
	public void testMatricularAlunoNaDisciplina() {
		assertEquals(this.alunoService.matricularAlunoNaDisciplina(this.sala, this.aluno).getAluno(), this.aluno);
	}
	
}
