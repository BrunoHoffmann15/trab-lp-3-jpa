package Controller;

import java.util.List;

import Dominio.EstoquePrato;
import Persistencia.EstoquePratoDao;

public class EstoquePratoController {
	private EstoquePratoDao estoquePratoDao = new EstoquePratoDao();
	
	public List<EstoquePrato> listarTodos(){
		return estoquePratoDao.listarTodos();
	}
	
	public EstoquePrato getOne(Long id){
		return estoquePratoDao.getOneById(id);
	}
	
	public void atualizar(EstoquePrato estoque, int quantidadeAumentar){
		estoquePratoDao.atualizar(estoque, quantidadeAumentar);
	}
	
	public double getInventarioPrato(List<EstoquePrato> pratos){
		double total = 0;
		for(EstoquePrato estoque : pratos){
			total += estoque.getQuantidade() * estoque.getPrato().getValor();
		}
		return total;
	}
}
