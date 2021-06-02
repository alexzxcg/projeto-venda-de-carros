package br.ufms.apsoo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufms.apsoo.model.Administrador;

public class AdministradorDao {
  private EntityManager em;

  public AdministradorDao(EntityManager em) {
    this.em = em;
  }

  public void cadastrar(Administrador cliente) {
    this.em.persist(cliente);
  }

  public void atualizar(Administrador cliente) {
    this.em.merge(cliente);
  }

  public void remover(Administrador cliente) {
    cliente = em.merge(cliente);
    this.em.remove(cliente);
  }

  public Administrador buscarPorId(Long id) {
    return em.find(Administrador.class, id);
  }

  public List<Administrador> buscarPorTodos() {
    String jpql = "SELECT c FROM Administrador c";
    return em.createQuery(jpql, Administrador.class).getResultList();
  }

  public List<Administrador> buscarPorCpf(String cpf) {
    String jpql = "SELECT c FROM Administrador WHERE c.cpf = ?1";
    return em.createQuery(jpql, Administrador.class).setParameter(1, cpf).getResultList();
  }
}