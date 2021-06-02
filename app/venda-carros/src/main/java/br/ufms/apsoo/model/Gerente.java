package br.ufms.apsoo.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "gerentes")
public class Gerente extends Pessoa {
  @Column(name = "codigoId", columnDefinition = "serial")
  @Generated(GenerationTime.INSERT)
  private Integer codigo;

  @OneToMany
  private List<Funcionario> subordinados = null;

  @Column(name = "criado_em")
  private LocalDate criadoEm = LocalDate.now();

  @Column(name = "atualizado_em")
  private LocalDate atualizadoEm = null;

  public Gerente() {
  }

  public Gerente(String cpf, String rg, String nome, String email, LocalDate dataNascimento, String telResidencial,
      String telCelular, Endereco endereco) {
    super(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, endereco);
  }

  public Integer getCodigo() {
    return this.codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public List<Funcionario> getSubordinados() {
    return this.subordinados;
  }

  public void setSubordinados(List<Funcionario> subordinados) {
    this.subordinados = subordinados;
  }

  public Gerente codigo(Integer codigo) {
    setCodigo(codigo);
    return this;
  }

  public Gerente subordinados(List<Funcionario> subordinados) {
    setSubordinados(subordinados);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Gerente)) {
      return false;
    }
    Gerente gerente = (Gerente) o;
    return Objects.equals(codigo, gerente.codigo) && Objects.equals(subordinados, gerente.subordinados);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, subordinados);
  }

  @Override
  public String toString() {
    return "{" + " codigo='" + getCodigo() + "'" + ", subordinados='" + getSubordinados() + "'" + "}";
  }

}
