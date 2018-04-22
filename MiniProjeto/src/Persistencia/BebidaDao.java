package Persistencia;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import Dominio.Bebida;


public class BebidaDao {
	private EntityManager manager = JpaUtil.getEntityManager();
	private Query query;
	private EntityTransaction transaction = manager.getTransaction();

	
	public Bebida adicionarBebida(Bebida bebida){
		transaction.begin();
		manager.persist(bebida);
		transaction.commit();
		return bebida;
	}
	
	public List<Bebida> getAll(){
		query = manager.createQuery("from Bebida");
		List<Bebida> bebidas = query.getResultList();
		return bebidas;
	}
	
	public Bebida getOneById(Long id){
		return manager.getReference(Bebida.class, id);
	}
	
	public void atualizarValor(Bebida bebida, double quantidade){
		transaction.begin();
		bebida.setValor(bebida.getValor() + quantidade);
		transaction.commit();
	}
}
