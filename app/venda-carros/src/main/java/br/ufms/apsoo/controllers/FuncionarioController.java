package br.ufms.apsoo.controllers;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.ufms.apsoo.dao.FuncionarioDao;
import br.ufms.apsoo.dao.GerenteDao;
import br.ufms.apsoo.dao.EnderecoDao;
import br.ufms.apsoo.model.Funcionario;
import br.ufms.apsoo.model.Gerente;
import br.ufms.apsoo.model.Endereco;
import br.ufms.apsoo.util.JpaUtil;

public class FuncionarioController {
  private EntityManager em = JpaUtil.geEntityManagerFactory();
  private FuncionarioDao funcionarioDao = new FuncionarioDao(em);
  private GerenteDao gerenteDao = new GerenteDao(em);
  private EnderecoDao enderecoDao = new EnderecoDao(em);

  public boolean cadastrarFuncionario(String cpf, String rg, String nome, String email, LocalDate dataNascimento,
      String telResidencial, String telCelular, String cargo, double salario, String carteiraTrabalho, String gerenteCpf,
      String cep, String rua, int numero, String bairro, String cidade, String estado, String complemento) {

    Endereco endereco = new Endereco(cep, rua, numero, bairro, cidade, estado, complemento);
    Funcionario funcionario = new Funcionario(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, endereco,
        cargo, salario, carteiraTrabalho);
    
    Gerente gerente = gerenteDao.buscarPorCpf(gerenteCpf);
    gerente.addFuncionario(funcionario);

    try {
      em.getTransaction().begin();
      enderecoDao.cadastrar(endereco);
      funcionarioDao.cadastrar(funcionario);
      em.getTransaction().commit();
    } catch (Exception e) {
      System.err.println(e);
      return false;
    }

    return true;
  }

}
