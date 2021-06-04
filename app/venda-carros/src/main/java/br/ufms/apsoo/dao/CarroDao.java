package br.ufms.apsoo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufms.apsoo.model.Carro;

public class CarroDao {
  private EntityManager em;

  public CarroDao(EntityManager em) {
    this.em = em;
  }

  public void cadastrar(Carro cliente) {
    this.em.persist(cliente);
  }

  public void atualizar(Carro cliente) {
    this.em.merge(cliente);
  }

  public void remover(Carro cliente) {
    cliente = em.merge(cliente);
    this.em.remove(cliente);
  }

  public Carro buscarPorId(Long id) {
    return em.find(Carro.class, id);
  }

  public List<Carro> buscarPorTodos() {
    String jpql = "SELECT c FROM Carro c";
    return em.createQuery(jpql, Carro.class).getResultList();
  }
}