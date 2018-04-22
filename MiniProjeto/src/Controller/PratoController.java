package Controller;

import java.util.List;

import Dominio.EstoquePrato;
import Dominio.Prato;
import Persistencia.EstoquePratoDao;
import Persistencia.PratoDao;

public class PratoController {
	private PratoDao pratoDao = new PratoDao();
	private EstoquePratoDao estoquePratoDao = new EstoquePratoDao();
	
	public void adicionarBebida(Prato prato, EstoquePrato estoque){
		pratoDao.adicionarPrato(prato);
		estoque.setPrato(prato);
		estoquePratoDao.adicionarEstoque(estoque);
	}
	
	public List<Prato> listarTodos(){
		return pratoDao.getAll();
	}
	
	public Prato getOneById(Long id){
		return pratoDao.getOneById(id);
	}
	
	public void atualizar(Prato prato, double valor){
		pratoDao.atualizarValor(prato, valor);
	}
}
