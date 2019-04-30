package builders;

import domain.entities.Pagamento;
import domain.enums.Credor;
import domain.enums.TipoPagemento;

public class PagamentoBuilder {

	private Pagamento pagamento;
	
	public static PagamentoBuilder mockPagamento() {
		PagamentoBuilder builder = new PagamentoBuilder();
		builder.pagamento = new Pagamento(TipoPagemento.DOACAO, Credor.ALUNO, new Double(10), "pagamento");
		
		return builder;
	}
	
	public Pagamento getPagamento() {
		return this.pagamento;
	}
}
