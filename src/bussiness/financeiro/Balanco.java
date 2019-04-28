package bussiness.financeiro;

import domain.entities.Pagamento;
import domain.entities.Pedido;
import domain.entities.Professor;
import domain.enums.Credor;
import domain.enums.TipoPagemento;
import repositories.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class Balanco {

    private BaseRepository<Pagamento> repository;

    public Balanco(BaseRepository<Pagamento> repository) {
        this.repository = repository;
    }

    public double gerarBalancoSemPedidos() {

        double total = 0;
        for (Pagamento pagamento : this.repository.getAll()) {
            if (pagamento.getTipo().equals(TipoPagemento.MATRICULA) || pagamento.getTipo().equals(TipoPagemento.DOACAO))
                total += pagamento.getValor();
            else
                total -= pagamento.getValor();
        }

        return total;
    }

    public double gerarBalnacoComPedidos(List<Pedido> pedidos) {
        double total = this.gerarBalancoSemPedidos();
        for (Pedido pedido : pedidos)
            total -= pedido.getValor();

        return total;
    }

    public Pagamento pagar(double valor, Credor credor, TipoPagemento tipo, String nome) {
        Pagamento pagamento = new Pagamento(tipo, credor, valor, nome);
        return this.repository.save(pagamento);
    }

    public List<Pagamento> gerarFolhaDePagamento(List<Professor> professores) {

        List<Pagamento> pagamentos = new ArrayList<>();

        for (Professor professor : professores) {
            Pagamento pagamento = new Pagamento(TipoPagemento.SALARIO, Credor.PROFESSOR, professor.getSalario(), professor.getNome());
            pagamentos.add(pagamento);
        }

        return pagamentos;
}

    public BaseRepository<Pagamento> getRepository() {
        return repository;
    }
}
