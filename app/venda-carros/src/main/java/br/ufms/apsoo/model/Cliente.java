package br.ufms.apsoo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.Generated;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa {

  @Column(columnDefinition = "serial")
  @Generated(GenerationTime.INSERT)
  private Integer codigo;
  private double renda;

  @OneToMany(targetEntity = Venda.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<Venda> compras = new ArrayList<>();

  public Cliente() {
  }

  public Cliente(String cpf, String rg, String nome, String email, LocalDate dataNascimento, String telResidencial,
      String telCelular, Endereco endereco, double renda) {
    super(cpf, rg, nome, email, dataNascimento, telResidencial, telCelular, endereco);
    this.renda = renda;
  }

  public Integer getCodigo() {
    return this.codigo;
  }

  public double getRenda() {
    return this.renda;
  }

  public void setRenda(double renda) {
    this.renda = renda;
    setAtualizadoEm(LocalDate.now());
  }

  public List<Venda> getCompras() {
    return compras;
  }

  public void setCompras(List<Venda> compras) {
    this.compras = compras;
    setAtualizadoEm(LocalDate.now());
  }

  public void addCompra(Venda compra) {
    compra.setCliente(this);
    this.compras.add(compra);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Cliente)) {
      return false;
    }
    Cliente cliente = (Cliente) o;
    return Objects.equals(codigo, cliente.codigo) && renda == cliente.renda && Objects.equals(compras, cliente.compras);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, renda, compras);
  }

  @Override
  public String toString() {
    return "{" + " codigo='" + getCodigo() + "'" + ", renda='" + getRenda() + "'" + ", compras='" + getCompras() + "'"
        + "}";
  }

}
