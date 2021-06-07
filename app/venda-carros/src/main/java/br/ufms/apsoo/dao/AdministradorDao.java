package br.ufms.apsoo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufms.apsoo.model.Administrador;

public class AdministradorDao {
  private EntityManager em;

  public AdministradorDao(EntityManager em) {
    this.em = em;
  }

  public void cadastrar(Administrador admin) {
    this.em.persist(admin);
  }

  public void atualizar(Administrador admin) {
    this.em.merge(admin);
  }

  public void remover(Administrador admin) {
    admin = em.merge(admin);
    this.em.remove(admin);
  }

  public Administrador buscarPorCpf(String cpf) {
    return em.find(Administrador.class, cpf);
  }

  public List<Administrador> buscarPorTodos() {
    String jpql = "SELECT a FROM Administrador a";
    return em.createQuery(jpql, Administrador.class).getResultList();
  }

  // public List<Administrador> buscarPorCpf(String cpf) {
  //   String jpql = "SELECT a FROM Administrador WHERE a.cpf = ?1";
  //   return em.createQuery(jpql, Administrador.class).setParameter(1, cpf).getResultList();
  // }
}