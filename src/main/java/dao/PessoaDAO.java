package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Pessoa;

@Stateless
public class PessoaDAO {

	@PersistenceContext(unitName = "MinhaUnidadeDePersistencia")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void salvar(Pessoa pessoa) {
		EntityManager em = getEntityManager(); // Obtém EntityManager aqui
		try {
			em.getTransaction().begin();
			em.persist(pessoa);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void atualizar(Pessoa pessoa) {
		EntityManager em = getEntityManager(); // Obtém EntityManager aqui
		try {
			em.getTransaction().begin();
			em.merge(pessoa);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void remover(Pessoa pessoa) {
		EntityManager em = getEntityManager(); // Obtém EntityManager aqui
		try {
			em.getTransaction().begin();
			em.remove(em.merge(pessoa));
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public Pessoa buscarPorId(int id) {
		EntityManager em = getEntityManager(); // Obtém EntityManager aqui
		try {
			return em.find(Pessoa.class, id);
		} finally {
			em.close();
		}
	}

	public List<Pessoa> listarTodos() {
		EntityManager em = getEntityManager(); // Obtém EntityManager aqui
		try {
			return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
		} finally {
			em.close();
		}
	}
}