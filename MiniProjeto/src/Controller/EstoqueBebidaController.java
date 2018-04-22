package Controller;

import java.util.List;

import Dominio.EstoqueBebidas;
import Persistencia.BebidaEstoqueDao;

public class EstoqueBebidaController {
	private BebidaEstoqueDao estoqueBebidaDao = new BebidaEstoqueDao();
	
	public List<EstoqueBebidas> listarTodos(){
		return estoqueBebidaDao.listarTodos();
	}
	
	public EstoqueBebidas getOne(Long id){
		return estoqueBebidaDao.getOneById(id);
	}
	
	public void atualizar(EstoqueBebidas estoque, int quantidadeAumentar){
		estoqueBebidaDao.atualizar(estoque, quantidadeAumentar);
	}
	
	public double getInventarioBebida(List<EstoqueBebidas> bebidas){
		double total = 0;
		for(EstoqueBebidas estoque : bebidas){
			total += estoque.getQuantidade() * estoque.getBebida().getValor();
		}
		return total;
	}
}
