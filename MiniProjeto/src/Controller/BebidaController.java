package Controller;

import java.util.List;

import Dominio.Bebida;
import Dominio.EstoqueBebidas;
import Persistencia.BebidaDao;
import Persistencia.BebidaEstoqueDao;

public class BebidaController {
	private BebidaDao bebidaDao = new BebidaDao();
	private BebidaEstoqueDao estoqueBebidaDao = new BebidaEstoqueDao();
	
	public void adicionarBebida(Bebida bebida, EstoqueBebidas estoque){
		bebidaDao.adicionarBebida(bebida);
		estoque.setBebida(bebida);
		estoqueBebidaDao.adicionarEstoque(estoque);
	}
	
	public List<Bebida> listarTodos(){
		return bebidaDao.getAll();
	}
	
	public Bebida getOneById(Long id){
		return bebidaDao.getOneById(id);
	}
	
	public void atualizar(Bebida bebida, double valor){
		bebidaDao.atualizarValor(bebida, valor);
	}
}
