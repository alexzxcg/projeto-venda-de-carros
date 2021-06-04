/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.apsoo;

import java.time.LocalDate;

import br.ufms.apsoo.controllers.ClienteController;
import br.ufms.apsoo.model.Cliente;
import br.ufms.apsoo.screens.Telas.Tela;

/**
 *
 * @author alexlinux
 */
public class Screen {
  public static void main(String[] args) {
    ClienteController cc = new ClienteController();

    String cpf = "48838619298";
    String rg = "366597176";
    String nome = "Guilherme Jorge Caio Figueiredo";
    String email = "hugojorgecaiofigueiredo__hugojorgecaiofigueiredo@gmalato.com.br";
    LocalDate dataNascimento = LocalDate.parse("1941-04-20");
    String telResidencial = "6826108038";
    String telCelular = "68997407310";
    double renda = 12312.342;

    boolean c1 = cc.cadastrarCliente(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, renda,
        "14403344", "Rua 1", 123, "Qualquer", "Campo Grande - MS", "Mato Grosso do Sul", "");

    Cliente cliente1 = cc.buscar(cpf);

    System.out.println(cliente1.getNome());
    Tela tela = new Tela();
    tela.setVisible(true);
  }

}
