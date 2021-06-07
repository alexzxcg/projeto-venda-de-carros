package br.ufms.apsoo.controllers;

import javax.persistence.EntityManager;

import br.ufms.apsoo.dao.CarroDao;
import br.ufms.apsoo.dao.ClienteDao;
import br.ufms.apsoo.dao.FuncionarioDao;
import br.ufms.apsoo.dao.VendaDao;
import br.ufms.apsoo.model.Carro;
import br.ufms.apsoo.model.Funcionario;
import br.ufms.apsoo.model.Cliente;
import br.ufms.apsoo.model.Venda;
import br.ufms.apsoo.util.JpaUtil;

public class VendaController {
  private EntityManager em = JpaUtil.geEntityManagerFactory();
  private VendaDao vendaDao = new VendaDao(em);
  private FuncionarioDao funcionarioDao = new FuncionarioDao(em);
  private ClienteDao clienteDao = new ClienteDao(em);
  private CarroDao carroDao = new CarroDao(em);
  private CarroController carroController = new CarroController();

  public VendaController() {
  }

  public Venda iniciarNovaVenda(double valorEntrada, double valorTotal, String formaPagamento, int numParcelas,
      String cpfFuncionario, String cpfCliente, Integer codigoCarro) {
    Venda venda = new Venda(valorEntrada, valorTotal, formaPagamento, numParcelas);

    Funcionario funcionario = funcionarioDao.buscarPorCpf(cpfFuncionario);
    Cliente cliente = clienteDao.buscarPorCpf(cpfCliente);
    Carro carro = carroDao.buscarPorId(codigoCarro);
    
    carro.setStatus("vendido");
    carroController.atualizarCarro(carro);

    funcionario.addVenda(venda);
    cliente.addCompra(venda);
    venda.setCarro(carro);


    try {
      em.getTransaction().begin();
      vendaDao.cadastrar(venda);
      em.getTransaction().commit();
    } catch (Exception e) {
      System.err.println(e);
      return null;
    }

    return venda;
  }
}
