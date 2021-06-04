package br.ufms.apsoo.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * Pessoa é a classe base para representação de pessoas.
 * 
 * @author Alex
 * @author Guilherme Carvalho
 * @author José
 * @author Larissa
 */
@MappedSuperclass
public class Pessoa {
  @Id
  private String cpf;
  private String rg;
  private String nome;
  private String email;

  @Column(name = "data_nascimento")
  private LocalDate dataNascimento;

  @Column(name = "tel_residencial")
  private String telResidencial;

  @Column(name = "tel_celular")
  private String telCelular;

  @Column(name = "criado_em")
  private LocalDate criadoEm = LocalDate.now();

  @Column(name = "atualizado_em")
  private LocalDate atualizadoEm = null;

  @OneToOne(cascade = CascadeType.ALL)
  private Endereco endereco;

  public Pessoa() {
  }

  public Pessoa(String cpf, String rg, String nome, String email, LocalDate dataNascimento, String telResidencial,
      String telCelular, Endereco endereco) {
    this.cpf = cpf;
    this.rg = rg;
    this.nome = nome;
    this.email = email;
    this.dataNascimento = dataNascimento;
    this.telResidencial = telResidencial;
    this.telCelular = telCelular;
    this.endereco = endereco;
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getRg() {
    return this.rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
    setAtualizadoEm(LocalDate.now());
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
    setAtualizadoEm(LocalDate.now());
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
    setAtualizadoEm(LocalDate.now());
  }

  public LocalDate getDataNascimento() {
    return this.dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
    setAtualizadoEm(LocalDate.now());
  }

  public String getTelResidencial() {
    return this.telResidencial;
  }

  public void setTelResidencial(String telResidencial) {
    this.telResidencial = telResidencial;
    setAtualizadoEm(LocalDate.now());
  }

  public String getTelCelular() {
    return this.telCelular;
  }

  public void setTelCelular(String telCelular) {
    this.telCelular = telCelular;
    setAtualizadoEm(LocalDate.now());
  }

  public LocalDate getCriadoEm() {
    return this.criadoEm;
  }

  public LocalDate getAtualizadoEm() {
    return this.atualizadoEm;
  }

  public void setAtualizadoEm(LocalDate atualizadoEm) {
    this.atualizadoEm = atualizadoEm;
  }

  public Endereco getEndereco() {
    return this.endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
    setAtualizadoEm(LocalDate.now());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Pessoa)) {
      return false;
    }
    Pessoa pessoa = (Pessoa) o;
    return Objects.equals(cpf, pessoa.cpf) && Objects.equals(rg, pessoa.rg) && Objects.equals(nome, pessoa.nome)
        && Objects.equals(email, pessoa.email) && Objects.equals(dataNascimento, pessoa.dataNascimento)
        && Objects.equals(telResidencial, pessoa.telResidencial) && Objects.equals(telCelular, pessoa.telCelular)
        && Objects.equals(criadoEm, pessoa.criadoEm) && Objects.equals(atualizadoEm, pessoa.atualizadoEm)
        && Objects.equals(endereco, pessoa.endereco);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, criadoEm, atualizadoEm,
        endereco);
  }

  @Override
  public String toString() {
    return "{" + " cpf='" + getCpf() + "'" + ", rg='" + getRg() + "'" + ", nome='" + getNome() + "'" + ", email='"
        + getEmail() + "'" + ", dataNascimento='" + getDataNascimento() + "'" + ", telResidencial='"
        + getTelResidencial() + "'" + ", telCelular='" + getTelCelular() + "'" + ", criadoEm='" + getCriadoEm() + "'"
        + ", atualizadoEm='" + getAtualizadoEm() + "'" + ", endereco='" + getEndereco() + "'" + "}";
  }

}
