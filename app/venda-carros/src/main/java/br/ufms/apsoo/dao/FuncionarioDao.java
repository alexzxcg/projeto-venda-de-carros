package br.ufms.apsoo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufms.apsoo.model.Funcionario;

public class FuncionarioDao {
  private EntityManager em;

  public FuncionarioDao(EntityManager em) {
    this.em = em;
  }

  public void cadastrar(Funcionario cliente) {
    this.em.persist(cliente);
  }

  public void atualizar(Funcionario cliente) {
    this.em.merge(cliente);
  }

  public void remover(Funcionario cliente) {
    cliente = em.merge(cliente);
    this.em.remove(cliente);
  }

  public Funcionario buscarPorId(Long id) {
    return em.find(Funcionario.class, id);
  }

  public List<Funcionario> buscarPorTodos() {
    String jpql = "SELECT c FROM Funcionario c";
    return em.createQuery(jpql, Funcionario.class).getResultList();
  }

  public List<Funcionario> buscarPorCpf(String cpf) {
    String jpql = "SELECT c FROM Funcionario WHERE c.cpf = ?1";
    return em.createQuery(jpql, Funcionario.class).setParameter(1, cpf).getResultList();
  }
}