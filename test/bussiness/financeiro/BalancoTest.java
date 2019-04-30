package bussiness.financeiro;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import builders.PagamentoBuilder;
import domain.entities.Pagamento;
import repositories.BaseRepository;

public class BalancoTest {

	private Balanco balanco;
	private BaseRepository<Pagamento> repositorio;
	private Pagamento pagamento;
	
	@Before
    public void setUp(){
		this.repositorio = new BaseRepository<Pagamento>(new ArrayList<Pagamento>());
		this.balanco = new Balanco(this.repositorio);
		this.pagamento = PagamentoBuilder.mockPagamento().getPagamento();
	}
	

	@Test
	public void testGerarBalancoSemPedidos() {
		this.balanco.getRepository().save(this.pagamento);
		assertTrue(this.balanco.gerarBalancoSemPedidos() == new Double(10));
	}
	
}
