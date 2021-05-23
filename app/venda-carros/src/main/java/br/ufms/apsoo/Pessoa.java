package br.ufms.apsoo;

import java.util.Date;

/**
 * Pessoa é a classe base para representação de pessoas.
 * 
 * @author Alex
 * @author Guilherme Carvalho
 * @author José
 * @author Larissa
 */
public class Pessoa {
  private String cpf;
  private String rg;
  private String nome;
  private Date dataNascimento;
  private Endereco endereco;
  private String telResidencial;
  private String telCelular;
  private String email;

  /**
   * Construtor da classe Pessoa
   * 
   * @param cpf
   * @param rg
   * @param nome
   * @param dataNascimento
   * @param endereco
   * @param telResidencial
   * @param telCelular
   * @param email
   */
  public Pessoa(String cpf, String rg, String nome, Date dataNascimento, Endereco endereco, String telResidencial,
      String telCelular, String email) {
    this.cpf = cpf;
    this.rg = rg;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.endereco = endereco;
    this.telResidencial = telResidencial;
    this.telCelular = telCelular;
    this.email = email;
  }

  // Getters e Setters CPF
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  // Getters e Setters RG
  public String getRg() {
    return rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  // Getters e Setters Nome
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  // Getters e Setters Data de Nascimento

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  // Getters e Setters Endereco

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  // Getters e Setters Telefone Residencial

  public String getTelResidencial() {
    return telResidencial;
  }

  public void setTelResidencial(String telResidencial) {
    this.telResidencial = telResidencial;
  }

  // Getters e Setters Celular

  public String getTelCelular() {
    return telCelular;
  }

  public void setTelCelular(String telCelular) {
    this.telCelular = telCelular;
  }

  // Getters e Setters Email

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
