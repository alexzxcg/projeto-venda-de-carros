package br.ufms.apsoo.controllers;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufms.apsoo.dao.CarroDao;
import br.ufms.apsoo.model.Carro;
import br.ufms.apsoo.util.JpaUtil;

public class CarroController {
  private EntityManager em = JpaUtil.geEntityManagerFactory();
  private CarroDao carroDao = new CarroDao(em);

  public CarroController() {
  }

  public Carro cadastrarCarro(String modelo, int ano, String marca, String cor, double valor) {

    Carro carro = new Carro(modelo, ano, marca, cor, valor);

    try {
      em.getTransaction().begin();
      carroDao.cadastrar(carro);
      em.getTransaction().commit();
    } catch (Exception e) {
      System.err.println(e);
      return null;
    }

    return carro;
  }

  public void atualizarCarro(Carro carro) {
    try {
      em.getTransaction().begin();
      carroDao.atualizar(carro);
      em.getTransaction().commit();
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public List<String> buscaMarcas() {
    try {
      return carroDao.buscaMarcas();
    } catch (Exception e) {
      System.err.println(e);
      return null;
    }
  }

  public List<Carro> buscaMarcaCarro(String marcaCarro) {
    try {
      return carroDao.buscarPorMarca(marcaCarro);
    } catch (Exception e) {
      System.err.println(e);
      return null;
    }
  }

  public List<Carro> buscaModeloCarro(String marcaCarro, String modeloCarro) {
    try {
      return carroDao.buscarPorModelo(marcaCarro, modeloCarro);
    } catch (Exception e) {
      System.err.println(e);
      return null;
    }
  }

  public Carro buscarCarro(Long id) {
    try {
      return carroDao.buscarPorId(id);
    } catch (Exception e) {
      System.err.println(e);
      return null;
    }
  }

}
