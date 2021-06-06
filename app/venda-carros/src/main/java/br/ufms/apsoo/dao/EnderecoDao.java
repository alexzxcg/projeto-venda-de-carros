package br.ufms.apsoo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufms.apsoo.model.Endereco;

public class EnderecoDao {
  private EntityManager em;

  public EnderecoDao(EntityManager em) {
    this.em = em;
  }

  public void cadastrar(Endereco endereco) {
    this.em.persist(endereco);
  }

  public void atualizar(Endereco endereco) {
    this.em.merge(endereco);
  }

  public void remover(Endereco endereco) {
    endereco = em.merge(endereco);
    this.em.remove(endereco);
  }

  public Endereco buscarPorId(Integer id) {
    return em.find(Endereco.class, id);
  }

  public List<Endereco> buscarPorTodos() {
    String jpql = "SELECT e FROM Endereco e";
    return em.createQuery(jpql, Endereco.class).getResultList();
  }
}
