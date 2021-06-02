package br.ufms.apsoo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufms.apsoo.model.Cliente;

public class ClienteDao {
  private EntityManager em;

  public ClienteDao(EntityManager em) {
    this.em = em;
  }

  public void cadastrar(Cliente cliente) {
    this.em.persist(cliente);
  }

  public void atualizar(Cliente cliente) {
    this.em.merge(cliente);
  }

  public void remover(Cliente cliente) {
    cliente = em.merge(cliente);
    this.em.remove(cliente);
  }

  public Cliente buscarPorId(Long id) {
    return em.find(Cliente.class, id);
  }

  public List<Cliente> buscarPorTodos() {
    String jpql = "SELECT c FROM Cliente c";
    return em.createQuery(jpql, Cliente.class).getResultList();
  }

  public List<Cliente> buscarPorCpf(String cpf) {
    String jpql = "SELECT c FROM Cliente WHERE c.cpf = ?1";
    return em.createQuery(jpql, Cliente.class).setParameter(1, cpf).getResultList();
  }
}