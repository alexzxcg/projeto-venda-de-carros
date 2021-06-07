package br.ufms.apsoo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufms.apsoo.model.Venda;

public class VendaDao {
  private EntityManager em;

  public VendaDao(EntityManager em) {
    this.em = em;
  }

  public void cadastrar(Venda venda) {
    this.em.persist(venda);
  }

  public void atualizar(Venda venda) {
    this.em.merge(venda);
  }

  public void remover(Venda venda) {
    venda = em.merge(venda);
    this.em.remove(venda);
  }

  public Venda buscarPorId(Integer id) {
    return em.find(Venda.class, id);
  }

  public List<Venda> buscarPorTodos() {
    String jpql = "SELECT v FROM Venda v";
    return em.createQuery(jpql, Venda.class).getResultList();
  }

}