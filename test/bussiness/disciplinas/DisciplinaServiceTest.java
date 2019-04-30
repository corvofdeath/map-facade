package bussiness.disciplinas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import domain.entities.Disciplina;
import domain.enums.Proficiencias;
import repositories.BaseRepository;

public class DisciplinaServiceTest {

	private DisciplinaService disciplinaService;
	private BaseRepository<Disciplina> repositorio;
	
	@Before
    public void setUp(){
		this.repositorio = new BaseRepository<Disciplina>(new ArrayList<Disciplina>());
		this.disciplinaService = new DisciplinaService(this.repositorio);
	}
	
	@Test
	public void testRegistrarDisciplina() {
		assertEquals(this.disciplinaService.registrarDisciplina("Disciplina", Proficiencias.MATEMATICA).getNome(), "Disciplina");
	}
	
	@Test
	public void testGetRepository() {
		assertTrue(this.disciplinaService.getRepository().getAll().isEmpty());
	}
}
