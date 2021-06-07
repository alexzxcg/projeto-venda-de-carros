/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.apsoo;

import java.time.LocalDate;

import br.ufms.apsoo.controllers.CarroController;
import br.ufms.apsoo.controllers.ClienteController;
import br.ufms.apsoo.controllers.FuncionarioController;
import br.ufms.apsoo.controllers.GerenteController;
import br.ufms.apsoo.controllers.VendaController;
import br.ufms.apsoo.model.Cliente;
import br.ufms.apsoo.model.Carro;
import br.ufms.apsoo.model.Venda;
// import br.ufms.apsoo.screens.Telas.Tela;
import br.ufms.apsoo.screens.Telas.ComprovanteDePagamento;

/**
 *
 * @author alexlinux
 */
public class Screen {
  public static void main(String[] args) {
    ClienteController cc = new ClienteController();
    CarroController carroController = new CarroController();
    GerenteController gerenteController = new GerenteController();
    FuncionarioController funcionarioController = new FuncionarioController();
    VendaController vendaController = new VendaController();
    // Gerente
    String g1cpf = "48834619298";
    String g1rg = "366597176";
    String g1nome = "Hugo Jorge Caio Figueiredo";
    String g1email = "hugojorgecaiofigueiredo__hugojorgecaiofigueiredo@gmalato.com.br";
    LocalDate g1dataNascimento = LocalDate.parse("1941-04-20");
    String g1telResidencial = "6826108038";
    String g1telCelular = "68997407310";
    double g1salario = 12312.342;

    gerenteController.cadastrarGerente(g1cpf, g1rg, g1nome, g1email, g1dataNascimento, g1telResidencial, g1telCelular,
        g1salario, "14403344", "Rua 1", 123, "Qualquer", "Campo Grande - MS", "Mato Grosso do Sul", "");
    // Funcionario
    String f1cpf = "77777777777";
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

    // Instancia Funcionario
    funcionarioController.cadastrarFuncionario(f1cpf, f1rg, f1nome, f1email, f1dataNascimento, f1telResidencial,
        f1telCelular, f1cargo, f1salario, f1carteiraTrabalho, g1cpf, "14403344", "Rua 1", 123, "Qualquer",
        "Campo Grande - MS", "Mato Grosso do Sul", "");
    String cpf = "48838619298";
    String rg = "366597176";
    String nome = "Guilherme Jorge Caio Figueiredo";
    String email = "hugojorgecaiofigueiredo__hugojorgecaiofigueiredo@gmalato.com.br";
    LocalDate dataNascimento = LocalDate.parse("1941-04-20");
    String telResidencial = "6826108038";
    String telCelular = "68997407310";
    double renda = 12312.342;

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

    Carro c1 = carroController.cadastrarCarro(c1modelo, c1ano, c1marca, c1cor, c1valor);
    c1.setStatus(c1status);
    carroController.atualizarCarro(c1);

    Carro c2 = carroController.cadastrarCarro(c2modelo, c2ano, c2marca, c2cor, c2valor);
    c2.setStatus(c2status);
    carroController.atualizarCarro(c2);
    carroController.cadastrarCarro(c3modelo, c3ano, c3marca, c3cor, c3valor);

    Cliente cliente = cc.cadastrarCliente(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, renda,
        "14403344", "Rua 1", 123, "Qualquer", "Campo Grande - MS", "Mato Grosso do Sul", "");

    Cliente cliente1 = cc.buscar(cpf);

    System.out.println(cliente1.getNome());

    Venda venda = vendaController.iniciarNovaVenda(111.11, 222.22, "Dinheiro",1,"77777777777","48838619298",5);
    System.out.println(venda.toString());
    ComprovanteDePagamento telaComprovante = new ComprovanteDePagamento();
    telaComprovante.setVenda(venda);
    telaComprovante.setVisible(true);
    // telaComprovante.setVisible(true);
    // Tela tela = new Tela();
    // tela.setVisible(true);
  }

}
