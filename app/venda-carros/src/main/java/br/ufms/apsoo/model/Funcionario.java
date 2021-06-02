package br.ufms.apsoo.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String codigo;

  private String cargo;

  @Column(name = "carteira_trabalho")
  private String carteiraTrabalho;

  @Column(name = "carteira_contratacao")
  private Date dataContratacao;

  @Column(name = "data_exoneracao")
  private LocalDate dataExoneracao;

  @Column(name = "criado_em")
  private LocalDate criadoEm = LocalDate.now();

  @Column(name = "atualizado_em")
  private LocalDate atualizadoEm = null;

  @OneToOne
  private Gerente supervisor;

  public Funcionario() {
  }

  public Funcionario(String cpf, String rg, String nome, String email, LocalDate dataNascimento, String telResidencial,
      String telCelular, Endereco endereco, String cargo, String carteiraTrabalho, Date dataContratacao,
      LocalDate dataExoneracao, Gerente supervisor) {
    super(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, endereco);

    this.cargo = cargo;
    this.carteiraTrabalho = carteiraTrabalho;
    this.dataContratacao = dataContratacao;
    this.dataExoneracao = dataExoneracao;
    this.supervisor = supervisor;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getCargo() {
    return this.cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public String getCarteiraTrabalho() {
    return this.carteiraTrabalho;
  }

  public void setCarteiraTrabalho(String carteiraTrabalho) {
    this.carteiraTrabalho = carteiraTrabalho;
  }

  public Date getDataContratacao() {
    return this.dataContratacao;
  }

  public void setDataContratacao(Date dataContratacao) {
    this.dataContratacao = dataContratacao;
  }

  public LocalDate getDataExoneracao() {
    return this.dataExoneracao;
  }

  public void setDataExoneracao(LocalDate dataExoneracao) {
    this.dataExoneracao = dataExoneracao;
  }

  public Gerente getSupervisor() {
    return this.supervisor;
  }

  public void setSupervisor(Gerente supervisor) {
    this.supervisor = supervisor;
  }

  public LocalDate getCriadoEm() {
    return this.criadoEm;
  }

  public void setCriadoEm(LocalDate criadoEm) {
    this.criadoEm = criadoEm;
  }

  public LocalDate getAtualizadoEm() {
    return this.atualizadoEm;
  }

  public void setAtualizadoEm(LocalDate atualizadoEm) {
    this.atualizadoEm = atualizadoEm;
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
        && Objects.equals(carteiraTrabalho, funcionario.carteiraTrabalho)
        && Objects.equals(dataContratacao, funcionario.dataContratacao)
        && Objects.equals(dataExoneracao, funcionario.dataExoneracao)
        && Objects.equals(supervisor, funcionario.supervisor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, cargo, carteiraTrabalho, dataContratacao, dataExoneracao, supervisor);
  }

  @Override
  public String toString() {
    return "{" + " codigo='" + getCodigo() + "'" + ", cargo='" + getCargo() + "'" + ", carteiraTrabalho='"
        + getCarteiraTrabalho() + "'" + ", dataContratacao='" + getDataContratacao() + "'" + ", dataExoneracao='"
        + getDataExoneracao() + "'" + ", criadoEm='" + getCriadoEm() + "'" + ", atualizadoEm='" + getAtualizadoEm()
        + "'" + ", supervisor='" + getSupervisor() + "'" + "}";
  }

}
