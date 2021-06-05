package br.ufms.apsoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.ufms.apsoo.controllers.CarroController;
import br.ufms.apsoo.controllers.FuncionarioController;
import br.ufms.apsoo.controllers.GerenteController;
import br.ufms.apsoo.dao.AdministradorDao;
import br.ufms.apsoo.dao.ClienteDao;
import br.ufms.apsoo.dao.EnderecoDao;
import br.ufms.apsoo.dao.FuncionarioDao;
import br.ufms.apsoo.dao.GerenteDao;
import br.ufms.apsoo.model.Administrador;
import br.ufms.apsoo.model.Carro;
import br.ufms.apsoo.model.Cliente;
import br.ufms.apsoo.model.Endereco;
import br.ufms.apsoo.model.Funcionario;
import br.ufms.apsoo.model.Gerente;
import br.ufms.apsoo.util.JpaUtil;

public class Test {
  public static void main(String[] args) {
    GerenteController gerenteController = new GerenteController();
    FuncionarioController funcionarioContoller = new FuncionarioController();
    CarroController carroController = new CarroController();
    // Endereco
    Endereco ec1 = new Endereco("14403344", "Rua 1", 123, "Qualquer", "Campo Grande - MS", "Mato Grosso do Sul", "");

    // Cliente
    String c1cpf = "48838619298";
    String c1rg = "366597176";
    String c1nome = "Hugo Jorge Caio Figueiredo";
    String c1email = "hugojorgecaiofigueiredo__hugojorgecaiofigueiredo@gmalato.com.br";
    LocalDate c1dataNascimento = LocalDate.parse("1941-04-20");
    String c1telResidencial = "6826108038";
    String c1telCelular = "68997407310";
    double c1renda = 12312.342;

    // Funcionario
    String f1cpf = "48838619298";
    String f1rg = "366597176";
    String f1nome = "Hugo Jorge Caio Figueiredo";
    String f1email = "hugojorgecaiofigueiredo__hugojorgecaiofigueiredo@gmalato.com.br";
    LocalDate f1dataNascimento = LocalDate.parse("1941-04-20");
    String f1telResidencial = "6826108038";
    String f1telCelular = "68997407310";
    String f1cargo = "vendedor";
    double f1salario = 12312.342;
    String f1carteiraTrabalho = "381748363897462376";
    LocalDate f1dataContratacao = LocalDate.parse("2008-01-01");
    LocalDate f1dataExoneracao = LocalDate.parse("2018-01-01");

    // Gerente
    String g1cpf = "48834619298";
    String g1rg = "366597176";
    String g1nome = "Hugo Jorge Caio Figueiredo";
    String g1email = "hugojorgecaiofigueiredo__hugojorgecaiofigueiredo@gmalato.com.br";
    LocalDate g1dataNascimento = LocalDate.parse("1941-04-20");
    String g1telResidencial = "6826108038";
    String g1telCelular = "68997407310";
    double g1salario = 12312.342;

    // Admin
    String a1cpf = "48838619298";
    String a1rg = "366597176";
    String a1nome = "Hugo Jorge Caio Figueiredo";
    String a1email = "hugojorgecaiofigueiredo__hugojorgecaiofigueiredo@gmalato.com.br";
    LocalDate a1dataNascimento = LocalDate.parse("1941-04-20");
    String a1telResidencial = "6826108038";
    String a1telCelular = "68997407310";

    // Carro
    String c1marca = "volkswagen";
    String c1modelo = "polo";
    int c1ano = 2002;
    String c1cor = "prata";
    double c1valor = 98490.99;
    String c1status = "indisponivel";

    String c2marca = "volkswagen";
    String c2modelo = "jetta";
    int c2ano = 2005;
    String c2cor = "preto";
    double c2valor = 100390.99;
    String c2status = "indisponivel";

    String c3marca = "hyundai";
    String c3modelo = "cerato";
    int c3ano = 2012;
    String c3cor = "vermelho";
    double c3valor = 83390.99;

    // Instancia Gerente
    gerenteController.cadastrarGerente(g1cpf, g1rg, g1nome, g1email, g1dataNascimento, g1telResidencial, g1telCelular,
        g1salario, "14403344", "Rua 1", 123, "Qualquer", "Campo Grande - MS", "Mato Grosso do Sul", "");

    // Instancia Funcionario
    funcionarioContoller.cadastrarFuncionario(f1cpf, f1rg, f1nome, f1email, f1dataNascimento, f1telResidencial,
        f1telCelular, f1cargo, f1salario, f1carteiraTrabalho, g1cpf, "14403344", "Rua 1", 123, "Qualquer",
        "Campo Grande - MS", "Mato Grosso do Sul", "");

    // Instancia Carros

    Carro c1 = carroController.cadastrarCarro(c1modelo, c1ano, c1marca, c1cor, c1valor);
    c1.setStatus(c1status);
    carroController.atualizarCarro(c1);

    Carro c2 = carroController.cadastrarCarro(c2modelo, c2ano, c2marca, c2cor, c2valor);
    c2.setStatus(c2status);
    carroController.atualizarCarro(c2);
    carroController.cadastrarCarro(c3modelo, c3ano, c3marca, c3cor, c3valor);

    // Lista Carros
    List<String> marcas = carroController.buscaMarcas();
    List<Carro> marcasCarro = carroController.buscaMarcaCarro(c1marca);
    List<Carro> modeloCarro = carroController.buscaModeloCarro(c1marca, c1modelo);

    System.out.println("##########################################");
    marcas.forEach((car) -> {
      System.out.println(car);
    });

    System.out.println("##########################################");
    marcasCarro.forEach((car) -> {
      System.out.println(car.getModelo());
    });

    System.out.println("##########################################");
    modeloCarro.forEach((car) -> {
      System.out.println(car);
    });

  }

}
