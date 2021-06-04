package br.ufms.apsoo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufms.apsoo.model.Funcionario;
import br.ufms.apsoo.model.Gerente;

public class GerenteDao {
  private EntityManager em;

  public GerenteDao(EntityManager em) {
    this.em = em;
  }

  public void cadastrar(Gerente cliente) {
    this.em.persist(cliente);
  }

  public void atualizar(Gerente cliente) {
    this.em.merge(cliente);
  }

  public void remover(Gerente cliente) {
    cliente = em.merge(cliente);
    this.em.remove(cliente);
  }

  public Gerente buscarPorId(Long id) {
    return em.find(Gerente.class, id);
  }

  public List<Gerente> buscarPorTodos() {
    String jpql = "SELECT c FROM Gerente c";
    return em.createQuery(jpql, Gerente.class).getResultList();
  }

  public List<Gerente> buscarPorCpf(String cpf) {
    String jpql = "SELECT c FROM Gerente WHERE c.cpf = ?1";
    return em.createQuery(jpql, Gerente.class).setParameter(1, cpf).getResultList();
  }
}