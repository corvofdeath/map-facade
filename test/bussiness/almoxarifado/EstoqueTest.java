package bussiness.almoxarifado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import builders.PedidoBuilder;
import domain.entities.Item;
import domain.entities.Pedido;
import repositories.BaseRepository;

public class EstoqueTest {

	private Estoque estoque;
	private BaseRepository<Pedido> repositorioPedido;
	private BaseRepository<Item> repositorioItem;
	
	@Before
    public void setUp(){
		this.repositorioItem = new BaseRepository<Item>(new ArrayList<Item>());
		this.repositorioPedido = new BaseRepository<Pedido>((List<Pedido>) PedidoBuilder.mockCollectionPedidos().getPedidos());
		this.estoque = new Estoque(repositorioItem, repositorioPedido);
	}
	
	@Test
	public void testAdicionarItemAoEstoque() {
		assertEquals(this.estoque.adicionarItemAoEstoque("maçã", 10).getNome(), "maçã");
	}
	
	@Test
	public void testGerarPedido() {
		assertEquals(this.estoque.gerarPedido("maça", 10, new Double(2)).getItem().getNome(), "maça");
	}
	
	@Test
	public void testRecuperarPedidosAbertos() {
		assertEquals(this.estoque.recuperarPedidosAbertos().size(), 10);
	}
}
