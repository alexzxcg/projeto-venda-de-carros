package br.ufms.apsoo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="administradores")
public abstract class Administrador extends Pessoa {

  public Administrador() {
  }
 
  public Administrador(String cpf, String rg, String nome, String email, LocalDate dataNascimento, String telResidencial,
  String telCelular, Endereco endereco) {
    super(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, endereco);
  }

}
