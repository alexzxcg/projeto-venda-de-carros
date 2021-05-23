package br.ufms.apsoo;

import java.util.Date;

public class Administrador extends Pessoa {

  public Administrador(String cpf, String rg, String nome, Date dataNascimento, Endereco endereco,
      String telResidencial, String telCelular, String email) {
    super(cpf, rg, nome, dataNascimento, endereco, telResidencial, telCelular, email);
  }

}
