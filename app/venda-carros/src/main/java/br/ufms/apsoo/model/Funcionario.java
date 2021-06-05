package br.ufms.apsoo.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {
  @Column(columnDefinition = "serial")
  @Generated(GenerationTime.INSERT)
  private Integer codigo;

  private String cargo;
  private double salario;

  @Column(name = "carteira_trabalho")
  private String carteiraTrabalho;

  @Column(name = "carteira_contratacao")
  private LocalDate dataContratacao = LocalDate.now();

  @Column(name = "data_exoneracao")
  private LocalDate dataExoneracao = null;

  @ManyToOne
  private Gerente supervisor;

  public Funcionario() {
  }

  public Funcionario(String cpf, String rg, String nome, String email, LocalDate dataNascimento, String telResidencial,
      String telCelular, Endereco endereco, String cargo, double salario, String carteiraTrabalho) {
    super(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, endereco);

    this.cargo = cargo;
    this.salario = salario;
    this.carteiraTrabalho = carteiraTrabalho;
  }

  public Integer getCodigo() {
    return this.codigo;
  }

  public String getCargo() {
    return this.cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
    setAtualizadoEm(LocalDate.now());
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
    setAtualizadoEm(LocalDate.now());
  }

  public String getCarteiraTrabalho() {
    return this.carteiraTrabalho;
  }

  public void setCarteiraTrabalho(String carteiraTrabalho) {
    this.carteiraTrabalho = carteiraTrabalho;
    setAtualizadoEm(LocalDate.now());
  }

  public LocalDate getDataContratacao() {
    return this.dataContratacao;
  }

  public void setDataContratacao(LocalDate dataContratacao) {
    this.dataContratacao = dataContratacao;
    setAtualizadoEm(LocalDate.now());
  }

  public LocalDate getDataExoneracao() {
    return this.dataExoneracao;
  }

  public void setDataExoneracao(LocalDate dataExoneracao) {
    this.dataExoneracao = dataExoneracao;
    setAtualizadoEm(LocalDate.now());
  }

  public Gerente getSupervisor() {
    return this.supervisor;
  }

  public void setSupervisor(Gerente supervisor) {
    this.supervisor = supervisor;
    setAtualizadoEm(LocalDate.now());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Funcionario)) {
      return false;
    }
    Funcionario funcionario = (Funcionario) o;
    return Objects.equals(codigo, funcionario.codigo) && Objects.equals(cargo, funcionario.cargo)
        && salario == funcionario.salario && Objects.equals(carteiraTrabalho, funcionario.carteiraTrabalho)
        && Objects.equals(dataContratacao, funcionario.dataContratacao)
        && Objects.equals(dataExoneracao, funcionario.dataExoneracao)
        && Objects.equals(supervisor, funcionario.supervisor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, cargo, salario, carteiraTrabalho, dataContratacao, dataExoneracao, supervisor);
  }

  @Override
  public String toString() {
    return "{" + " codigo='" + getCodigo() + "'" + ", cargo='" + getCargo() + "'" + ", salario='" + getSalario() + "'"
        + ", carteiraTrabalho='" + getCarteiraTrabalho() + "'" + ", dataContratacao='" + getDataContratacao() + "'"
        + ", dataExoneracao='" + getDataExoneracao() + "'" + ", supervisor='" + getSupervisor() + "'" + "}";
  }

}
