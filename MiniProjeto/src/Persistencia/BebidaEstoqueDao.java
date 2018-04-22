package Persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Dominio.EstoqueBebidas;

public class BebidaEstoqueDao {
	private EntityManager manager = JpaUtil.getEntityManager();
	private EntityTransaction transaction = manager.getTransaction();
	
	public EstoqueBebidas adicionarEstoque(EstoqueBebidas estoque){
		transaction.begin();
		manager.persist(estoque);
		transaction.commit();
		return estoque;
	}
	
	public EstoqueBebidas getOneById(Long id){
		return manager.getReference(EstoqueBebidas.class, id);
	}
	
	public void atualizarEstoque(EstoqueBebidas estoque, Long id){
		transaction.begin();
		EstoqueBebidas estoqueBebida = manager.find(EstoqueBebidas.class, id);
		estoqueBebida.setQuantidade(estoque.getQuantidade());
		transaction.commit();
	}
	public List<EstoqueBebidas> listarTodos(){
		Query query = manager.createQuery("from EstoqueBebidas");
		List<EstoqueBebidas> estoque = query.getResultList();
		return estoque;
	}
	public void atualizar(EstoqueBebidas estoque, int quantidade){
		transaction.begin();
		estoque.setQuantidade(estoque.getQuantidade() + quantidade);
		transaction.commit();
	}
	
}
