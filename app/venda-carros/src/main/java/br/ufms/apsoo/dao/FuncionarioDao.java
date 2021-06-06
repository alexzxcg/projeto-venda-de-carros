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

  public Funcionario buscarPorCpf(String cpf) {
    return em.find(Funcionario.class, cpf);
  }

  public List<Funcionario> buscarPorTodos() {
    String jpql = "SELECT f FROM Funcionario f";
    return em.createQuery(jpql, Funcionario.class).getResultList();
  }

  public List<Funcionario> buscarSubordinados(String gerenteCpf) {
    String jpql = "SELECT f from Funcionario f WHERE f.supervisor.cpf = :gerenteCpf";
    return em.createQuery(jpql, Funcionario.class).setParameter("gerenteCpf", gerenteCpf).getResultList();
  }
}