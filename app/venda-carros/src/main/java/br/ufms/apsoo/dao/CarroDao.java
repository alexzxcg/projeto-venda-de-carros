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
  
  public List<String> buscaMarcas() {
    String jpql = "SELECT DISTINCT c.marca FROM Carro c";
    return em.createQuery(jpql, String.class).getResultList();
  }

  public List<Carro> buscarPorMarca(String marcaCarro) {
    String jpql = "SELECT c FROM Carro c WHERE c.marca = :marca AND c.status = 'disponivel'";
    return em.createQuery(jpql, Carro.class).setParameter("marca", marcaCarro).getResultList();
  }

  public List<Carro> buscarPorModelo(String marcaCarro, String modeloCarro) {
    String jpql = "SELECT c FROM Carro c WHERE c.marca = :marca AND c.modelo = :modelo AND c.status = 'disponivel'";
    return em.createQuery(jpql, Carro.class).setParameter("marca", marcaCarro).setParameter("modelo", modeloCarro).getResultList();
  }
}