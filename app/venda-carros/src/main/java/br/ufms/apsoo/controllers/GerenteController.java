package br.ufms.apsoo.controllers;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.ufms.apsoo.dao.GerenteDao;
import br.ufms.apsoo.dao.EnderecoDao;
import br.ufms.apsoo.model.Gerente;
import br.ufms.apsoo.model.Endereco;
import br.ufms.apsoo.util.JpaUtil;

public class GerenteController {
  private EntityManager em = JpaUtil.geEntityManagerFactory();
  private GerenteDao gerenteDao = new GerenteDao(em);
  private EnderecoDao enderecoDao = new EnderecoDao(em);

  public Gerente cadastrarGerente(String cpf, String rg, String nome, String email, LocalDate dataNascimento,
      String telResidencial, String telCelular, double salario, String cep, String rua, int numero, String bairro,
      String cidade, String estado, String complemento) {

    Endereco endereco = new Endereco(cep, rua, numero, bairro, cidade, estado, complemento);
    Gerente gerente = new Gerente(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, endereco, salario);

    try {  
      em.getTransaction().begin();
      enderecoDao.cadastrar(endereco);
      gerenteDao.cadastrar(gerente);
      em.getTransaction().commit();
    } catch (Exception e) {
      System.err.println(e);
      return null;
    }

    return gerente;
  }

  
}
