package br.ufms.apsoo;

import java.util.Date;

public class Funcionario extends Pessoa {
  private String carteiraTrabalho;
  private Date dataContratacao;
  private Date dataExoneracao;
  private String cargo;
  private String codigo;
  private Gerente supervisor;

  public Funcionario(String cpf, String rg, String nome, Date dataNascimento, Endereco endereco, String telResidencial,
      String telCelular, String email, String carteiraTrabalho, Date dataContratacao, Date dataExoneracao, String cargo,
      String codigo, Gerente supervisor) {
    super(cpf, rg, nome, dataNascimento, endereco, telResidencial, telCelular, email);

    this.carteiraTrabalho = carteiraTrabalho;
    this.dataContratacao = dataContratacao;
    this.dataExoneracao = dataExoneracao;
    this.cargo = cargo;
    this.codigo = codigo;
    this.supervisor = supervisor;
  }

  // Getters e Setters Carteira de Trabalho
  public String getCarteiraTrabalho() {
    return this.carteiraTrabalho;
  }

  public void setCarteiraTrabalho(String carteiraTrabalho) {
    this.carteiraTrabalho = carteiraTrabalho;
  }

  // Getters e Setters Data de Contratacao
  public Date getDataContratacao() {
    return this.dataContratacao;
  }

  public void setDataContratacao(Date dataContratacao) {
    this.dataContratacao = dataContratacao;
  }

  // Getters e Setters Data de Exoneração
  public Date getDataExoneracao() {
    return this.dataExoneracao;
  }

  public void setDataExoneracao(Date dataExoneracao) {
    this.dataExoneracao = dataExoneracao;
  }

  // Getters e Setters Cargo
  public String getCargo() {
    return this.cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  // Getters e Setters Código
  public String getCodigo() {
    return this.codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  // Getters e Setters Supervisor
  public Gerente getSupervisor() {
    return this.supervisor;
  }

  public void setSupervisor(Gerente supervisor) {
    this.supervisor = supervisor;
  }
}
