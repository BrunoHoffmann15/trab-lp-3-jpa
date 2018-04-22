package Persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Dominio.Prato;

public class PratoDao {
	private EntityManager manager = JpaUtil.getEntityManager();
	private Query query;
	private EntityTransaction transaction = manager.getTransaction();

	public Prato adicionarPrato(Prato prato) {
		transaction.begin();
		manager.persist(prato);
		transaction.commit();
		return prato;
	}

	public List<Prato> getAll() {
		query = manager.createQuery("from Prato");
		List<Prato> pratos = query.getResultList();
		return pratos;
	}

	public Prato getOneById(Long id) {
		return manager.getReference(Prato.class, id);
	}

	public void atualizarValor(Prato prato, double quantidade) {
		transaction.begin();
		prato.setValor(prato.getValor() + quantidade);
		transaction.commit();
	}
}
