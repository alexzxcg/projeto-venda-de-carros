package br.ufms.apsoo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.ufms.apsoo.dao.ClienteDao;
import br.ufms.apsoo.dao.EnderecoDao;
import br.ufms.apsoo.model.Cliente;
import br.ufms.apsoo.model.Endereco;
import br.ufms.apsoo.model.Funcionario;
import br.ufms.apsoo.util.JpaUtil;

public class Test {
  public static void main(String[] args) {
    EntityManager em = JpaUtil.geEntityManagerFactory();
    ClienteDao clienteDao = new ClienteDao(em);
    EnderecoDao enderecoDao = new EnderecoDao(em);

    Endereco ec1 = new Endereco("14403344", "Rua 1", 123, "Qualquer", "Campo Grande - MS", "Mato Grosso do Sul", "");

    String c1cpf = "48838619298";
    String c1rg = "366597176";
    String c1nome = "Hugo Jorge Caio Figueiredo";
    String c1email = "hugojorgecaiofigueiredo__hugojorgecaiofigueiredo@gmalato.com.br";
    LocalDate c1dataNascimento = LocalDate.parse("1941-04-20");
    String c1telResidencial = "6826108038";
    String c1telCelular = "68997407310";
    double c1renda = 12312.342;

    // Funcionario f1 = new Funcionario(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, endereco, cargo, carteiraTrabalho, dataContratacao, dataExoneracao, supervisor)

    Cliente c1 = new Cliente(c1cpf, c1rg, c1nome, c1email, c1dataNascimento, c1telResidencial, c1telCelular, ec1, c1renda);

    List<Cliente> todos = clienteDao.buscarPorTodos();
    todos.forEach(c -> System.out.println(c.toString()));

    System.out.println("##################################################");
    System.out.println(c1);

    em.getTransaction().begin();
    enderecoDao.cadastrar(ec1);
    clienteDao.cadastrar(c1);
    em.getTransaction().commit();
    em.close();
  }

}
