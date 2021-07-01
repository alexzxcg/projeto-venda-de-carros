package br.ufms.apsoo.controllers;

import javax.persistence.EntityManager;

import br.ufms.apsoo.dao.CarroDao;
import br.ufms.apsoo.dao.ClienteDao;
import br.ufms.apsoo.dao.FuncionarioDao;
import br.ufms.apsoo.model.Carro;
import br.ufms.apsoo.model.Funcionario;
import br.ufms.apsoo.model.Cliente;
import br.ufms.apsoo.model.Orcamento;

import br.ufms.apsoo.util.JpaUtil;

public class OrcamentoController {
  private EntityManager em = JpaUtil.geEntityManagerFactory();
  private FuncionarioDao funcionarioDao = new FuncionarioDao(em);
  private ClienteDao clienteDao = new ClienteDao(em);
  private CarroDao carroDao = new CarroDao(em);

  public OrcamentoController() {
  }

  public Orcamento finalizarOrcamento(double valorEntrada, double valorTotal, String formaPagamento, int numParcelas,
      String cpfFuncionario, String cpfCliente, Integer codigoCarro) {
    Orcamento orcamento = new Orcamento(valorEntrada, valorTotal, formaPagamento, numParcelas);

    Funcionario funcionario = funcionarioDao.buscarPorCpf(cpfFuncionario);
    Cliente cliente = clienteDao.buscarPorCpf(cpfCliente);
    Carro carro = carroDao.buscarPorId(codigoCarro);
    
    orcamento.setFuncionario(funcionario);
    orcamento.setCliente(cliente);
    orcamento.setCarro(carro);

    return orcamento;
  }

}
