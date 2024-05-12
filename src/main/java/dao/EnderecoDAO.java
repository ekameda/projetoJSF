package dao;

import model.Endereco;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EnderecoDAO {

    @PersistenceContext(unitName = "MinhaUnidadeDePersistencia")
    private EntityManager entityManager;

    public void salvar(Endereco endereco) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        try {
            entityManager.persist(endereco);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }
    
    public void atualizar(Endereco endereco) {
        entityManager.merge(endereco);
    }

    public void remover(Endereco endereco) {
        entityManager.remove(entityManager.merge(endereco));
    }

    public List<Endereco> buscarPorIdPessoa(int idPessoa) {
        return entityManager.createQuery("SELECT e FROM Endereco e WHERE e.pessoa.id = :idPessoa", Endereco.class)
                             .setParameter("idPessoa", idPessoa)
                             .getResultList();
    }
}
