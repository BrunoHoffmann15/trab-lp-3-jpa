package Persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Dominio.EstoquePrato;

public class EstoquePratoDao {
	private EntityManager manager = JpaUtil.getEntityManager();
	private EntityTransaction transaction = manager.getTransaction();
	
	public EstoquePrato adicionarEstoque(EstoquePrato estoque){
		transaction.begin();
		manager.persist(estoque);
		transaction.commit();
		return estoque;
	}
	
	public EstoquePrato getOneById(Long id){
		return manager.getReference(EstoquePrato.class, id);
	}
	
	public void atualizarEstoque(EstoquePrato estoque, Long id){
		transaction.begin();
		EstoquePrato estoquePrato = manager.find(EstoquePrato.class, id);
		estoquePrato.setQuantidade(estoque.getQuantidade());
		transaction.commit();
	}
	public List<EstoquePrato> listarTodos(){
		Query query = manager.createQuery("from EstoquePrato");
		List<EstoquePrato> estoque = query.getResultList();
		return estoque;
	}
	public void atualizar(EstoquePrato estoque, int quantidade){
		transaction.begin();
		estoque.setQuantidade(estoque.getQuantidade() + quantidade);
		transaction.commit();
	}
}
