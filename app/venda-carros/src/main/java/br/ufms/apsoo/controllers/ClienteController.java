package br.ufms.apsoo.controllers;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.ufms.apsoo.dao.ClienteDao;
import br.ufms.apsoo.dao.EnderecoDao;
import br.ufms.apsoo.model.Cliente;
import br.ufms.apsoo.model.Endereco;
import br.ufms.apsoo.util.JpaUtil;

public class ClienteController {
  private EntityManager em = JpaUtil.geEntityManagerFactory();
  private ClienteDao clienteDao = new ClienteDao(em);
  private EnderecoDao enderecoDao = new EnderecoDao(em);

  public boolean cadastrarCliente(String cpf, String rg, String nome, String email, LocalDate dataNascimento,
      String telResidencial, String telCelular, double renda, String cep, String rua, int numero, String bairro,
      String cidade, String estado, String complemento) {

    Endereco endereco = new Endereco(cep, rua, numero, bairro, cidade, estado, complemento);
    Cliente cliente = new Cliente(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, endereco, renda);

    try {  
      em.getTransaction().begin();
      enderecoDao.cadastrar(endereco);
      clienteDao.cadastrar(cliente);
      em.getTransaction().commit();
      em.close();
    } catch (Exception e) {
      System.err.println(e);
      return false;
    }

    return true;
  }

  public String buscar(String clienteCpf) {
    try {
      Cliente c = clienteDao.buscarPorCpf(clienteCpf);
      return c.getNome();
    } catch (Exception e) {
      System.err.println(e);
      return "Cliente não cadastrado";
    }
  }

  
}
