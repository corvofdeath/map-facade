package bussiness.administrativo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import builders.CompromissoBuilder;
import domain.entities.Compromisso;
import domain.enums.Compromissos;
import domain.enums.Setores;
import repositories.BaseRepository;

public class AgendaTest {

	private Agenda agenda;
	private BaseRepository<Compromisso> repositorio;
	private Compromisso compromisso;
	
	@Before
    public void setUp(){
		this.repositorio = new BaseRepository<Compromisso>(new ArrayList<Compromisso>());
		this.agenda = new Agenda(this.repositorio);
		this.compromisso = CompromissoBuilder.mockCompromisso().getCompromisso();
	}
	
	@Test
	public void testCriarCompromisso() {
		assertEquals(this.agenda.criarCompromisso(new Date(), Setores.Diretoria, Compromissos.ENTREVISTA).getSetor(), Setores.Diretoria);
	}
	
	@Test
	public void testRecuperarCompromissoPorSetor() {
		this.agenda.getRepository().save(this.compromisso);
		assertFalse(this.agenda.recuperarCompromissoPorSetor(Setores.Diretoria).isEmpty());
	}
	
	@Test
	public void testRecuperarCompromissoPorTipo() {
		this.agenda.getRepository().save(this.compromisso);
		assertFalse(this.agenda.recuperarCompromissoPorTipo(Compromissos.ENTREVISTA).isEmpty());
	}
}
