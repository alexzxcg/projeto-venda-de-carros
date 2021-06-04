package br.ufms.apsoo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "gerentes")
public class Gerente extends Pessoa {
  @Column(columnDefinition = "serial")
  @Generated(GenerationTime.INSERT)
  private Integer codigo;

  private double salario;

  @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Funcionario> subordinados = new ArrayList<>();

  public Gerente() {
  }

  public Gerente(String cpf, String rg, String nome, String email, LocalDate dataNascimento, String telResidencial,
      String telCelular, Endereco endereco, double salario) {
    super(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, endereco);

    this.salario = salario;
  }

  public Integer getCodigo() {
    return this.codigo;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
    setAtualizadoEm(LocalDate.now());
  }

  public List<Funcionario> getSubordinados() {
    return this.subordinados;
  }

  public void setSubordinados(List<Funcionario> subordinados) {
    this.subordinados = subordinados;
  }

  public void addFuncionario(Funcionario funcionario) {
    subordinados.add(funcionario);
    funcionario.setSupervisor(this);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Gerente)) {
      return false;
    }
    Gerente gerente = (Gerente) o;
    return Objects.equals(codigo, gerente.codigo) && salario == gerente.salario
        && Objects.equals(subordinados, gerente.subordinados);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, salario, subordinados);
  }

  @Override
  public String toString() {
    return "{" + " codigo='" + getCodigo() + "'" + ", salario='" + getSalario() + "'" + ", subordinados='"
        + getSubordinados() + "'" + "}";
  }

}
